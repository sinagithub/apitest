@SmokeTest @Favorite
Feature: Favorite Api controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    And I get Favorite list
    And I delete all vendor
    And I get all favorite vendor list
    And I delete all added favorite products


  Scenario: I can add/delete vendor to empty favorite list
    When I get Favorite list
    Then I can see the favorite list is empty
    Given Set platform type to "Carsi"
    When A list of Carşı Vendor are available on home page
    And I select first vendor from "Super Market" category on home page
    Then I add selected vendor to favorite list
    When I get Favorite list
    Then I can see the added vendor on the favorite list
    When I remove the added vendor from favorite list
    And I get Favorite list
    Then I can validate the vendor is removed on the favorite list

  Scenario: I can add/delete product to favorite list
    When A list of Carşı Vendor are available on home page
    And I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to favorites
    When I get Favorite list
    Then I can see the product on the favorite list
    And I can see the product is favorite on vendor detail
    And I get all favorite vendor list
    And I delete all added favorite products
    Then I can validate product is deleted vendor detail favorite
    When I get Favorite list
    And I can validate favorite vendor  size is 0 on favorite list

  Scenario: I validate vendor favorite products and favorite list product size
    When A list of Carşı Vendor are available on home page
    And I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select random 5 products
    And I can add all selected product to favorites
    And I get vendor favorite list
    And I validate vendor favorite product size is 5 on vendor favorites list
    When I get Favorite list
    Then I can validate favorite vendor  size is 1 on favorite list
    And I can validate favorite vendor product size is 3 on favorite list
    When I get all favorite vendor list
    Then I delete all added favorite products
    And I validate vendor favorite product size is 0 on vendor favorites list
    When I get Favorite list
    And I delete all vendor
    When I get Favorite list
    Then I can see the favorite list is empty

  Scenario: Favorite parameter validations
    When A list of Carşı Vendor are available on home page
    And I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to favorites
    When I get Favorite list
    Then I check added favorite vendor id is valid on favorite list
    And I check added favorite vendor name is valid on favorite list
    And I check added favorite vendor LogoUrl status is 200 on favorite list
    And I check added favorite vendor DeliveryTimeInfo is valid on favorite list
    And I check added favorite vendor  MinBasketPriceInfo is valid on favorite list
    And I check added favorite vendor  DeliveryFeeInfo is valid on favorite list
    And I check added favorite vendor  IsOpen is valid on favorite list
    And I check added favorite vendor  Products is valid on favorite list
    When I get vendor favorite list
    Then I check added product id is valid on favorite product list
    And I check added product Name is valid on favorite product list
    And I check added product UnitMass is valid on favorite product list
    And I check added product Price is valid on favorite product list
    And I check added product ImageUrl status is 200 on favorite product list
    And I get all favorite vendor list
    And I delete all added favorite products

  Scenario: User should add banabi vendor to favorite list
    When  Banabi Vendor is available
    Then I select banabi vendor
    Then I navigate selected vendor
    Then I add selected vendor to favorite list
    When I get Favorite list
    Then I can see the added vendor on the favorite list
    When I remove the added vendor from favorite list
    And I get Favorite list
    Then I can validate the vendor is removed on the favorite list

  Scenario: I validate Banabi vendor favorite products and favorite list product size
    When  Banabi Vendor is available
    Then I select banabi vendor
    Then I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select random 5 products
    And I can add all selected product to favorites
    And I get vendor favorite list
    And I validate vendor favorite product size is 5 on vendor favorites list
    And I get all favorite vendor list
    And I delete all added favorite products
    And I validate vendor favorite product size is 0 on vendor favorites list
    When I get Favorite list
    And I delete all vendor
    When I get Favorite list
    Then I can see the favorite list is empty

  Scenario: Vendor sorting validation when both banabi & carsi vendors exist in favorite list
    When A list of Carşı Vendor are available on home page
    And I select first vendor from "Super Market" category on home page
    Then I add selected vendor to favorite list
    When I get Favorite list
    And I can see the added vendor on the favorite list
    When Banabi Vendor is available
    Then I select banabi vendor
    Then I add selected vendor to favorite list
    When I get Favorite list
    And I check first vendor is "banabi" on favorite vendor list