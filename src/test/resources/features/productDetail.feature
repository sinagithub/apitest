@SmokeTest @Product
Feature: Product Api controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id

  Scenario: User should see all product info correctly
    When  A list of Carşı Vendor are available on home page
    Then Select first vendor from "Market" category from home page
    And  I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I navigate selected product
    Then I validate product name is valid
    And  I validate product Badge and unit mass is valid
    And I validate product price is valid
    And I validate product is "false"
    And I validate image urls is valid