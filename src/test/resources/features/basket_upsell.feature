@SmokeTest @Upsell @AllTest
Feature: Basket upsell Api controls

  Background: Login user
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket

  @TestRail(33336)
  Scenario: User can not list upsell products for Carsi Vendor
    When A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    And I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    Then I get the basket
    And I can check Product Quantity is 1 on basket lines
    Then I get upsell products
    And I validate upsell type is 0
    * I validate upsell product count 0

