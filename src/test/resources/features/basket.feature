@Basket
Feature: Basket Controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket

  Scenario: User can get basket id : every time same id
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned address with id "{81cfbad7-36f9-455b-9204-0ea674b2406a}"
    Then I get unique basket id
    And I check basket id is same than old basket id

  Scenario: User can get add/delete product without options to basket
    When  A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    And I check added product exists on add basket response
    Then I check added vendorId on the basket on add basket response
    And  I check TotalLinesItemCount is 1 on add basket response
    And I can add the selected product to basket quantity is 1
    And  I check TotalLinesItemCount is 1 on add basket response
    When I select a random product
    Then I can add the selected product to basket quantity is 1
    And  I check TotalLinesItemCount is 2 on add basket response
    When I get the basket
    Then I can check product exists in basket
    And I can check ProductDescription is valid on basket lines
    And I can check ProductName is valid on basket lines
    And I can check ListPrice is valid on basket lines
    And I can check DiscountedPrice is valid on basket lines
    And I can check Quantity is 1 on basket lines

  Scenario: User can not add add product while basket not empty
    When  A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I select Carsı vendor with order - 3
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    Then I check added product "VendorsNotMatchedInBasket" error message and status is 400