Feature: OfferSearch "GrandChild Parameters" Test Scenarios with "NO AUTH"
  Background: Set up Environment for Testing
    Given The Test Environment is Defined
      |currentTestEnvironment|dev  |
      |apiGroupName|offerSearchRunners|
      |apiName|get_offersByParams|
    And Parameters are intialized

  Scenario: Search offers using Startdate and OfferProgramcode and offerStatus
    When Business User searches offers using Startdate & OfferProgramcode & offerStatus
      |testGetOfferSearchByStartdateAndOfferProgramCodeAndOfferStatus|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for ALL attributes
        |responseOne|

  Scenario: Search offers using PostalCode and StoreId  and Enddate
    When Business User searches offers using PostalCode and StoreId and Enddate
      |testGetOfferSearchByPostalCodeAndStoreIdAndEnddate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for ALL attributes
      |responseTwo|

  Scenario: Search offers using StartDate and EndDate and PostalCd and OfferStatus and StoreId and OfferProgramcode
    When Business User searches offers using StartDate and EndDate and PostalCd and OfferStatus and StoreId and OfferProgramcode
      |testGetOfferSearchByStartDateAndEndDateAndPostalCodeAndOfferStatusAndStoreIdAndOfferProgramcode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for ALL attributes
      |responseTwo|
