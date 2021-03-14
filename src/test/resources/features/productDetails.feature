Feature: Product Detail

  Background: Çarsı Vendors Listing
    Given I am an authorized  user "Login"
    And  I select city "TR_ISTANBUL"
    When My addresses list should be available
    Then I select pinned available address
    And  A list of Vendor are available

  @SmokeTest @Carsi
  Scenario: Product detail controls
    When I navigate a vendor
    Then I list the products
    When I navigate a product
    Then I should get product base information

