package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

public class FacetCountParentChildParams extends BaseApiTest {

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

//@Test()
//@And("^API Response is asserted for counts$")
//public void assertCount(){
//System.out.println(response.getBody());
//int countofOffers = response.jsonPath().getList("offers").size();
//int facetcount = response.jsonPath().get("totalCount");
//Assert.assertTrue(countofOffers>=facetcount);
//}
//

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
            ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
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
    authenticatedGalleryEndpoint +=
            ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
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
            ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
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
    authenticatedGalleryEndpoint +=
            ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
}

@When("^Business User searches offers using End Date$")
public void testGetOfferSearchByEndDate(List<String> methodName) throws UnsupportedEncodingException {
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
    authenticatedGalleryEndpoint +=
            ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
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
    authenticatedGalleryEndpoint +=
            ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
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
    authenticatedGalleryEndpoint +=
            ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
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
    authenticatedGalleryEndpoint +=
            ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
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
    authenticatedGalleryEndpoint +=
            ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
}
}
