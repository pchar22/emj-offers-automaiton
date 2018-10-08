package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.gson.JsonArray;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import com.safeway.j4u.emju.offers.api.framework.support.constants.TestDataFileNames;
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
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;
import javax.xml.crypto.Data;
import org.apache.http.HttpStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

        /**AUTHOR :: PUSHPAVALLI CHAR **/

public class ParentChildParams extends BaseApiTest {

    @When("^Business User searches offers using offerStatus$")
    public void testGetOfferSearchByOfferStatus(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
    }

    @Test()
    @And("^API Response is asserted for counts$")
    public void assertCount(){
        System.out.println(response.getBody());
        int countofOffers = response.jsonPath().getList("offers").size();
        int facetcount = response.jsonPath().get("totalCount");
        Assert.assertTrue(countofOffers>=facetcount);
    }
    @Test()
    @When("^Business User searches offers using ExternalOfferID$")
    public void testGetOfferSearchByExternalOfferId(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        authenticatedGalleryEndpoint +=
                 ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using StoreID$")
        public void testGetOfferSearchByStoreId(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CONTENTTYPE, "application/vnd.safeway.v1+json");
        authenticatedGalleryEndpoint +=
                 ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using PostalCode$")
        public void testGetOfferSearchByPostalCode(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        authenticatedGalleryEndpoint +=
                 ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using Start Date$")
    public void testGetOfferSearchByStartDate(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                 ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }

  @When("^Business User searches offers using End Date$")
  public void testGetOfferSearchByEndDate(List<String> methodName)
      throws UnsupportedEncodingException {
    setTestCaseName(methodName.get(0));
    currentTsDataRowsJsonArray =
        dataExtractor.getJSONParseTestData(
            GlobalConstants.testEnvironment,
            GlobalConstants.currentTestAPIGroupName,
            GlobalConstants.currentTestAPI,
            getTestCaseName());
    currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
    queryParams.put("q", currentTsJsonObject.get("q"));
    headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
    authenticatedGalleryEndpoint +=
        ResourceEndpointUri.QUERY_DELIMITER
            + URLEncoder.encode(currentTsJsonObject.get("q").toString(), "UTF-8");
            }
    @When("^Business User searches offers using Offer Program Code$")
    public void testGetOfferSearchByOfferProgramCode(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                 ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

//    /*Child Param Test Scenarios*/
    @When("^Business User searches offers using StartDate & PostalCode$")
    public void testGetOfferSearchByStartDateandPostalCode(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                 ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }


    @When("^Business User searches offers using EndDate & StartDate$")
    public void testGetOfferSearchByEndDateandStartDate(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                 ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using OfferStatus & EndDate$")
    public void testGetOfferSearchByOfferStatusandEnddate(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }

    @When("^Business User searches offers using StoreId & ProgramCode$")
    public void businessUserSearchesOffersUsingStoreIdProgramCode(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                 ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }
}
