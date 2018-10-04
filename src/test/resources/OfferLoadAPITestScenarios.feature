Feature: Offer Load API Positive Test Scenarios
  Background: Set up Environment for Testing Offer Load API
    Given The Test Environment is Defined for POST call
      |currentTestEnvironment|dev|
      |apiGroupName|OfferSearchRunners|
      |apiName|OfferLoadAPI|
    And Parameters are intialized


  Scenario: Load Min Offer with offerstatus A
    When Business User loads data with offerstatus A
      |MinOfferTest_OffStatusA.json|
    Then API Response is extracted
    Then API Response is asserted for Success Status Code

  Scenario: Load Min Offer with offerstatus A with future dates
    When Business User loads data with offerstatus A with Future dates
      |MinOfferTest_OffStatusAwithFuturedates.json|
    Then API Response is extracted
    Then API Response is asserted for Success Status Code

  Scenario: Load Min Offer with offerstatus D
    When Business User loads data with offerstatus D
      |MinOfferTest_OffStatusD.json|
    Then API Response is extracted
    Then API Response is asserted for Success Status Code

  Scenario: Load Min Offer with offerstatus E
    When Business User loads data with offerstatus E
      |MinOfferTest_OffStatusE.json|
    Then API Response is extracted
    Then API Response is asserted for Success Status Code

  Scenario: Load Min Offer with offerstatus L
    When Business User loads data with offerstatus L
      |MinOfferTest_OffStatusL.json|
    Then API Response is extracted
    Then API Response is asserted for Success Status Code

#  Scenario: Load Maximum Offer
#    When User loads maximum no of offers using the Offer Load API
#      |MaxOfferTest.json|
#    Then API Response is extracted
#    Then API Response is asserted for Success Status Code
