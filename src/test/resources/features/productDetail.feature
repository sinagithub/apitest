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
    Then I select first vendor from "Super Market" category on home page
    And  I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I check product list not empty
    Then I select a random product
    And I navigate selected product
    Then I validate product name is valid on product detail
    Then I validate product desc is valid on product detail
    And  I validate product Badge is valid on product detail
    And I validate product price is valid on product detail
    And I validate product is "false" on product detail
    And I validate image urls is valid on product detail
