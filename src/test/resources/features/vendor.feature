Feature: Vendor Listing

  Scenario: Vendor detail listing
    Given I am an authorized  user "Login"
    And  I have pinned address
    And  A list of Vendor are available
    When I navigate a vendor
    Then I should get Vendor information (product tree, category, sub category, vendor main info)