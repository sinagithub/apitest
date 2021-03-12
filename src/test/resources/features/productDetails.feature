Feature: Product Detail

  Background: Çarsı Vendors Listing
    Given I am an authorized  user "Login"
    And  I have pinned available address on "TR_ISTANBUL"
    And  A list of Vendor are available

  Scenario: Product detail controls
    When I navigate a vendor
    Then I list the products
    When I navigate a product
    Then I should get product base information

