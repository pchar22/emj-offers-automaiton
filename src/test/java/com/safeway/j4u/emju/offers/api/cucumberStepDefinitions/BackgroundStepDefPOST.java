package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices.OfferSearch;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java8.En;
import io.restassured.response.Response;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;


public class BackgroundStepDefPOST extends BaseApiTest {
    private Map<String, String> env = new HashMap<>();
    String testCaseName;
    OfferSearch offerSearchExpected, offerSearchActual;

    /** Initialize before each test. */
  @BeforeClass(alwaysRun = true)
  @Given("^The Test Environment is Defined$")
  public void beforeMethod(Map<String, String> env) throws Exception {
    this.env = env;
    String currentTestEnv = env.get("currentTestEnvironment");
    String apiGroupName = env.get("apiGroupName");
    String apiName = env.get("apiName");
    setupSuite(currentTestEnv, apiGroupName, apiName);
  }
  /** Initialize before each test. */
  @BeforeMethod(alwaysRun = true)
  @And("^Parameters are intialized$")
  public void parametersAreIntialized() {
    headerParams = new HashMap<String, Object>();
    queryParams = new HashMap<>();
    authenticatedGalleryEndpoint =
        dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment);
    headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
  }

  @Then("^API Response is extracted for POST call$")
  public void apiResponseIsExtractedPOST() {
    File bodyFile = new File(JSON_BODYDATA_PATH + getTestCaseName());
    response =
            invokeService(
                    HTTPMethod.POST,
                    authenticatedGalleryEndpoint,null,
                    null,headerParams,null,
                    GlobalConstants.GetCallArgs.HEADERPARAM.toString(),
                    null,
                    bodyFile);
  }

  @And("^API Response is asserted for Created Status Code$")
  public void assertStatusCode() {
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
  }

  @Then("^API Response is extracted$")
  public void apiResponseIsExtracted() throws UnsupportedEncodingException{
    // Need to set Proxy if connected to Safeway Network
    setProxy();
    setSslConfig();
    // Invoke the service

      URLEncoder.encode(authenticatedGalleryEndpoint, "UTF-8");
    response =
            invokeService(
                    HTTPMethod.GET,
                    authenticatedGalleryEndpoint,null,null,headerParams,null,
                    GlobalConstants.GetCallArgs.HEADERPARAM.toString(),
                    null,
                    null);

  }

  @And("^API Response is asserted for Success Status Code$")
  public void assertStatusCodeGet(){
    Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);
  }

  @And("^Sum of all facet counts should not exceed total count$")

    public void assertfacetCounts() {
        System.out.println(response.getBody());

        HashMap<String, String> facetcount = response.jsonPath().get("facetCounts.categories");
        int categoryCountinfacet = 0;

        Iterator entries = facetcount.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();

            if(!key.equals("Test 1"))
            {
                int value = (int)entry.getValue();
                categoryCountinfacet += value;
            }
        }
        System.out.println(categoryCountinfacet);


        int totalcount = response.jsonPath().get("totalCount");
        Assert.assertTrue(categoryCountinfacet<=totalcount);

    }

    @And("^facetcount for each Category is  asserted against the API response$")
    public void facetcountforeachcategoryisassertedagainstAPIResponse() {
        System.out.println(response.getBody());

        ArrayList<HashMap<String, String>>  categoriesinoffers =  response.jsonPath().get("offers.info.categories");

        MultiValuedMap<String, String> category = new ArrayListValuedHashMap<>();

        for(HashMap<String, String> categoryValue:categoriesinoffers){
            categoryValue.remove("9", "Test 1");
            if (categoryValue.size() > 0) {
               category.put(categoryValue.entrySet().iterator().next().getValue(), categoryValue.entrySet().iterator().next().getKey());
            }
        }

        Map<String, String> facetCount = response.jsonPath().get("facetCounts.categories");
        facetCount.remove("Test 1");

        int categoryCount = 0;
        String categoryValue = null;
        boolean result = true;

        Iterator facetentries = facetCount.entrySet().iterator();
      while (facetentries.hasNext()) {
          categoryCount = 0;
          Map.Entry entry = (Map.Entry) facetentries.next();
          String fentriesKey = (String) entry.getKey();
          int fentriesValue = (int) entry.getValue();

          if (fentriesValue == 0) {
            continue;
          }

          Collection<Entry<String, String>> collectionEntries = category.entries();

          Iterator<Entry<String, String>> iterator = collectionEntries.iterator();


          while(iterator.hasNext()) {
              Entry<String, String> entry1 = iterator.next();
              categoryValue = (String) entry1.getKey();
              if(categoryValue.equalsIgnoreCase(fentriesKey)){
                  categoryCount++;
              }
          }


          if(categoryCount==fentriesValue){
              result &= true;
          }else{
              result &= false;
          }
      }

      Assert.assertTrue(result, "Facet categories are matched in the categories");
  }


    @And("^Category with null count should not be displayed$")
    public void categoryWithNullcountshouldNotbedisplayed(){
        HashMap<String, String> count = response.jsonPath().get("facetCounts.categories");
        boolean result = true;

        Iterator entries = count.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            int Value = (int) entry.getValue();

            if(Value == 0){
                result &= false;
            }else{
                result &=true;
            }
        }
        Assert.assertTrue(result, "Category with null value is not displayed");
    }




  @And("^API Response is asserted for ALL attributes$")
  public void apiResponseIsAssertedForALLAttributes(List<String> fileName){
    String resourcePath = fileName.get(0);
    String filePath1 = JSON_RESPONSE_PATH + "offerSearch/"+resourcePath+".json";
    String filePath2 = null;
    String expectedJsonString =
            getComplexJsonAsString(filePath1);
    offerSearchExpected = stringToPojo(expectedJsonString, OfferSearch.class);
    String toWrite = response.getBody().asString();
    try{
      File tmpFile = File.createTempFile("test", ".json", new File(JSON_RESPONSE_PATH+"offerSearch/"));
      FileWriter writer = new FileWriter(tmpFile);
      writer.write(toWrite);
      writer.close();
      filePath2 = tmpFile.getAbsolutePath();
    }catch(Exception e){
      e.printStackTrace();
    }
    String actualJsonString = getComplexJsonAsString(filePath2);
    offerSearchActual = stringToPojo(actualJsonString,OfferSearch.class);
    Assert.assertTrue(offerSearchActual.equals(offerSearchExpected));
  }
}
