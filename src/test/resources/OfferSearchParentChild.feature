Feature: OfferSearch "Parent & Child Parameters" Test Scenarios with "NO AUTH"
  Background: Set up Environment for Testing
    Given The Test Environment is Defined
      |currentTestEnvironment|dev  |
      |apiGroupName|offerSearchRunners|
      |apiName|get_offersByParams|
    And Parameters are intialized

  Scenario: Search offers using offerStatus
    When Business User searches offers using offerStatus
      |testGetOfferSearchByOfferStatus|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts


#  Scenario: Search offers using ExternalOfferID
#    When Business User searches offers using ExternalOfferID
#      |testGetOfferSearchByExternalOfferId|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for counts
#      |counts|1|
#
#  Scenario: Search offers using StoreID
#    When Business User searches offers using StoreID
#      |testGetOfferSearchByStoreId|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for counts
#      |counts|9|
#
#  Scenario: Search offers using PostalCode
#    When Business User searches offers using PostalCode
#      |testGetOfferSearchByPostalCode|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for counts
#      |counts|9|
#
#  Scenario: Search offers using Start Date
#    When Business User searches offers using Start Date
#      |testGetOfferSearchByStartDate|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for counts
#      |counts|2|
#
#  Scenario: Search offers using End Date
#    When Business User searches offers using End Date
#      |testGetOfferSearchByEndDate|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for counts
#      |counts|10|
#
#  Scenario: Search offers using Offer Program Code
#    When Business User searches offers using Offer Program Code
#      |testGetOfferSearchByOfferProgramCode|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for counts
#      |counts|10|
#
##     child Parameters
#
#  Scenario: Search offers using StartDate and PostalCode
#    When Business User searches offers using StartDate & PostalCode
#      |testGetOfferSearchByStartDateandPostalCode|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for counts
#      |counts|4|
#
#  Scenario: Search offers using OfferStatus and EndDate
#    When Business User searches offers using OfferStatus & EndDate
#      |testGetOfferSearchByOfferStatusandEnddate|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for counts
#      |counts|4|
#
#  Scenario: Search offers using EndDate and StartDate
#    When Business User searches offers using EndDate & StartDate
#      |testGetOfferSearchByEndDateandStartDate|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for counts
#      |counts|4|
#
#  Scenario: Search offers using StoreId and ProgramCode
#    When Business User searches offers using StoreId & ProgramCode
#      |testGetOfferSearchByStoreIdandProgramCode|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for counts
#      |counts|1|
