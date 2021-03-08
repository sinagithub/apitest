Feature: Sample Oauth Control

  Scenario: Product detail listing
    Given I am an authorized  user "Login"
    And  I have pinned address
    And  A list of Vendor are available
    When I navigate a vendor
    Then I should get Vendor information (product tree, category, sub category, vendor main info)
    When I navigate a product
    Then I should get product base information


  Scenario: Product detail favorite controls
    Given I am an authorized  user "Login"
    And  I have pinned address
    And  A list of Vendor are available
    When I navigate a vendor
    Then I should get Vendor information (product tree, category, sub category, vendor main info)
    When I navigate a product
    Then I should get product base information
    When I add favorite the product
    Then I should see product added  message
    And I should see the product on my favorites
