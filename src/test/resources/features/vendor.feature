Feature: Vendor Listing

  Scenario: Vendor detail listing
    Given I am an authorized  user "Login"
    And  I have pinned available address on "TR_ISTANBUL"
    And  A list of Vendor are available
    When I navigate a vendor