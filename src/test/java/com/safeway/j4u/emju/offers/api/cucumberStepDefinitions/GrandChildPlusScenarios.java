package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices.OfferSearch;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import java.io.File;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GrandChildPlusScenarios extends BaseApiTest {
    private String testCaseName;
    private OfferSearch offerSearchExpected;
    private OfferSearch offerSearchActual;
    public Response response;
    private Map<String, String> env;

    /** Initialize before each test. */
    @BeforeClass
    @Given("^The Test Environment is Defined for GrandChildPlus Parameters$")
    public void theTestEnvironmentIsDefinedForGrandChildPlusParameters(Map<String, String> env) throws Exception {
        this.env = env;
        String currentTestEnv = env.get("currentTestEnvironemnt");
        String apiGroupName = env.get("apiGroupName");
        String apiName = env.get("apiName");
        setupSuite(currentTestEnv,apiGroupName,apiName);
    }

    /** Initialize before each test. */
    @BeforeMethod(alwaysRun = true)
    @And("^Parameters are intialized for GrandChildPlus Parameters$")
    public void parametersAreIntializedForGrandChildPlusParameters()  {
        queryParams = new HashMap<String, Object>();
        headerParams = new HashMap<String, Object>();
        authenticatedGalleryEndpoint =
                dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment);
    }

    @Test()
    @Then("^API Response is extracted for GrandChildPlus Parameters$")
    public void apiResponseIsExtractedForGrandChildPlusParameters() {
        // Need to set Proxy if connected to Safeway Network
        setProxy();
        setSslConfig();
        // Invoke the service
        response =
                invokeService(
                        HTTPMethod.GET,
                        authenticatedGalleryEndpoint,
                        null,
                        null,
                        headerParams,
                        null,
                        GlobalConstants.GetCallArgs.HEADERPARAM.toString(),
                        null,
                        null);
        // int count =1;
        // System.out.println(response.getBody().asString());
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

    @When("^Business User searches offers ExternalOfferID, OfferStatus, EndDate & StoreId$")
    public void businessUserSearchesOffersExternalOfferIDOfferStatusEndDateStoreId(List<String> methodName) throws UnsupportedEncodingException {
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }

    @When("^Business User searches offers using OfferStatus, PriceCode & StoreID & ExternalOfferID$")
    public void businessUserSearchesOffersUsingOfferStatusPriceCodeStoreIDExternalOfferID(List<String> methodName) throws UnsupportedEncodingException {
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }
    @And("^API Response is asserted for Success Status Code for GrandChildPlus Parameters$")
    public void apiResponseIsAssertedForSuccessStatusCodeForGrandChildPlusParameters(){
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);
    }
}
