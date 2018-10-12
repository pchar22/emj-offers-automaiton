Feature: OfferSearch "Parent & Child Parameters" Test Scenarios with "NO AUTH"
  Background: Set up Environment for Testing
    Given The Test Environment is Defined
      |currentTestEnvironment|dev  |
      |apiGroupName|offerSearchRunners|
      |apiName|get_offersByParamsFacetCount|
    And Parameters are intialized

  Scenario: Search offers using offerStatus
    When Business User searches offers using offerStatus
      |testGetOfferSearchByOfferStatus|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And Sum of all facet counts should not exceed total count
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed


  Scenario: Search offers using ExternalOfferID
    When Business User searches offers using ExternalOfferID
      |testGetOfferSearchByExternalOfferId|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And Sum of all facet counts should not exceed total count
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed

  Scenario: Search offers using StoreID
    When Business User searches offers using StoreID
      |testGetOfferSearchByStoreId|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And Sum of all facet counts should not exceed total count
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed

  Scenario: Search offers using PostalCode
    When Business User searches offers using PostalCode
      |testGetOfferSearchByPostalCode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And Sum of all facet counts should not exceed total count
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed


  Scenario: Search offers using Start Date
    When Business User searches offers using Start Date
      |testGetOfferSearchByStartDate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And Sum of all facet counts should not exceed total count
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed


  Scenario: Search offers using End Date
    When Business User searches offers using End Date
      |testGetOfferSearchByEndDate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And Sum of all facet counts should not exceed total count
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed


  Scenario: Search offers using Offer Program Code
    When Business User searches offers using Offer Program Code
      |testGetOfferSearchByOfferProgramCode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And Sum of all facet counts should not exceed total count
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed


##     child Parameters
#
  Scenario: Search offers using StartDate and PostalCode
    When Business User searches offers using StartDate & PostalCode
      |testGetOfferSearchByStartDateandPostalCode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And Sum of all facet counts should not exceed total count
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed

  Scenario: Search offers using OfferStatus and EndDate
    When Business User searches offers using OfferStatus & EndDate
      |testGetOfferSearchByOfferStatusandEnddate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And Sum of all facet counts should not exceed total count
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed


  Scenario: Search offers using EndDate and StartDate
    When Business User searches offers using EndDate & StartDate
      |testGetOfferSearchByEndDateandStartDate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And Sum of all facet counts should not exceed total count
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed



  Scenario: Search offers using StoreId and ProgramCode
    When Business User searches offers using StoreId & ProgramCode
      |testGetOfferSearchByStoreIdandProgramCode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And Sum of all facet counts should not exceed total count
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed
