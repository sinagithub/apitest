@SmokeTest @HomePage
Feature: Homepage Api controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address

  Scenario: HomePage Vendor listing
    And A list of Carşı Vendor are available on home page
    Then I check all carsı vendor image url status is 200
    Then I check all carsı vendor names is not empty

  Scenario: HomePage closed Vendor listing
    When A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    # And I set isOpen parameter as false for selected vendor in internal vendor close service
    Then I should see closed vendor on home vendor list
    When I select closed Carsı vendor
    Then I check all carsı vendor image url status is 200
    Then I check all carsı vendor names is not empty
   #Then And I set isOpen parameter as true for selected vendor in internal vendor open service

  Scenario: HomePage Banabi listing
    And  Banabi Vendor is available
    Then Check Banabi vendor id is valid
    And Check Banabi vendor name is not empty
    And Check Banabi vendor DeliveryTimeInfo is not empty
    And Check Banabi vendor MinBasketPriceInfo is not empty
    And Check Banabi vendor DeliveryFeeInfo is not empty
    And Check Banabi vendor IsOpen should be "true"

  Scenario: HomePage Banner listing
    And  HomePage banners are available
    Then HomePage banners urls are valid
