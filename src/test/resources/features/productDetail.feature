@SmokeTest @Product @AllTest
Feature: Product Api controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id

  Scenario: User should see all product info correctly
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And  I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I check product list not empty
    Then I select a random available product from selected category
    And I navigate selected product
    Then I validate product name is valid on product detail
    And I validate product desc is valid on product detail
    And  I validate product Badge is valid on product detail
    And I validate product price is valid on product detail
    And I validate product is "true" on product detail
    And I validate image urls is valid on product detail
    And I validate PriceText is valid on product detail


  @Favorite
  Scenario: User can see the product favorite status
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And  I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    And I get all favorite vendor list
    And I delete all added favorite products
    When I list the products from selected sub category
    Then I select a random available product from selected category
    When I navigate selected product
    Then I can check product favorite status "false"
    And I can add the selected product to favorites
    When I navigate selected product
    Then I can check product favorite status "true"
    When I get all favorite vendor list
    And I delete all added favorite products
    When I navigate selected product
    Then I can check product favorite status "false"






