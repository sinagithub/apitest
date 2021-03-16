Feature: Product Api controls

  Background: Login and Address Listing
    Given I am an authorized  user "Login"
    And I select city "TR_ISTANBUL"
    And  My addresses list should be available
    When  I select pinned available address

  @SmokeTest @Product
  Scenario: Product Detail  listing
    When  A list of Vendor are available
    Then I navigate a vendor
    When Product list available
    And I select a random product
    And I navigate selected product
    Then Validate product information is valid