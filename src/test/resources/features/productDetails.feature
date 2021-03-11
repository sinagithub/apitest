Feature: Product Detail

  Background: Product Listing
    Given I am an authorized  user "Login"
    And  I have pinned available address on "TR_ISTANBUL"
    And  A list of Vendor are available
    When I navigate a vendor
    Then I should get Vendor information (product tree, category, sub category, vendor main info)
    When I navigate a product
    Then I should get product base information


  Scenario: Product detail favorite controls
    When I add favorite the product
    Then I should see product added  message
    And I should see the product on my favorites

  Scenario: Product campaigns controls
    When I add favorite the product
    Then I should see product added  message
    And I should see the product on my favorites
