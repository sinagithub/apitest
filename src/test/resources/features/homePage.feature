@SmokeTest @HomePage
Feature: Homepage Api controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address

  Scenario: HomePage Vendor listing
    And A list of Carşı Vendor are available on home page
    Then Check vendor properties are valid

  Scenario: HomePage Banabi listing
    And  Banabi Vendor is available
    Then Check Banabi vendor id is valid
    And Check Banabi vendor name is not empty
    And Check Banabi vendor DeliveryTimeInfo is not empty
    And Check Banabi vendor MinBasketPriceInfo is not empty
    And Check Banabi vendor DeliveryFeeInfo is not empty
    And Check Banabi vendor IsOpen should be "false"

  Scenario: HomePage Banner listing
    And  HomePage banners are available
    Then HomePage banners are valid

  Scenario: HomePage Platform listing
    And  HomePage platform is available
    Then HomePage platform is valid
      | Carsi       |
      | Banabi      |
      | Yemeksepeti |

