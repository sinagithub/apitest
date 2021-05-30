@SmokeTest @Upsell
Feature: Basket upsell Api controls

  Background: Login user
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket

  Scenario: User can not list upsell products for Carsi Vendor
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    Then I get the basket
    And I can check Product Quantity is 1 on basket lines
    Then I get upsell products
    And I validate upsell type is 0