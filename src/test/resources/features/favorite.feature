@SmokeTest @Favorite
Feature: Favorite Api controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address

  Scenario: I can add/delete vendor to empty favorite list
    And I get all favorite vendor list
    And I delete all added favorite products
    Given Set platform type to "Carsi"
    When I get Favorite list
    ##Then I can see the favorite list is empty
    When A list of Carşı Vendor are available on home page
    And I select first vendor from "Super Market" category on home page
    Then I add selected vendor to favorite list
    When I get Favorite list
    Then I can see the added vendor on the favorite list
    When I remove the added vendor from favorite list
    And I get Favorite list
    Then I can validate the vendor is removed on the favorite list

  Scenario: I can add/delete product to favorite list
    Given Set platform type to "Carsi"
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
    And I can validate favorite vendor  size is 1 on favorite list
    And I can validate vendor favorite product size is 0 on vendor vendor favorites list


  Scenario: I validate vendor favorite products and favorite list product size
    When A list of Carşı Vendor are available on home page
    And I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    And I get all favorite vendor list
    And I delete all added favorite products
    Given Set platform type to "Carsi"
    Then I select random 5 products
    And I can add all selected product to favorites
    And I get vendor favorite list
    And I can validate vendor favorite product size is 5 on vendor vendor favorites list
    And I get all favorite vendor list
    And I delete all added favorite products
    And I can validate vendor favorite product size is 0 on vendor vendor favorites list
    When I get Favorite list
    And I delete all vendor
    When I get Favorite list
    Then I can see the favorite list is empty