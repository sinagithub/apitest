Feature: Homepage Api controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address

  @SmokeTest @HomePage
  Scenario: HomePage Vendor listing
    And  A list of Vendor are available
    Then Check vendor properties are valid


  @SmokeTest @HomePage
  Scenario: HomePage Banabi listing
    And  Banabi Vendor is available
    Then Check Banabi vendor properties are valid

  @SmokeTest @HomePage
  Scenario: HomePage Banner listing
    And  HomePage banners are available
    Then HomePage banners are valid

  @SmokeTest @HomePage
  Scenario: HomePage Platform listing
    And  HomePage platform is available
    Then HomePage platform is valid
      | Carsi  |
      | Banabi |
      | Yemeksepeti|

