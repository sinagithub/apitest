@Basket @AllTest
Feature: Basket Controls

  Background: Staff update active campaigns
    * Staff update active campaigns status to passive

  @TestRail(33537)
  Scenario: User can get basket id : every time same id
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned address with id "{7becad18-c2f6-4b98-b77b-b043c96cc37e}"
    Then I get unique basket id
    And I check basket id is same than old basket id

  @TestRail(33334)
  Scenario: User can get add product without options to basket
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    And I check added product exists on add basket response
    Then I check added vendorId on the basket on add basket response
    And  I check TotalLinesItemCount is 1 on add basket response
    And I can add the selected product to basket quantity is 1
    And  I check TotalLinesItemCount is 1 on add basket response
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    And I choose "Kedi Maması" sub category from sub category
    * I list the products from selected sub category
    When I select a random available product from selected category
    Then I can add the selected product to basket quantity is 1
    And  I check TotalLinesItemCount is 2 on add basket response
    When I get the basket
    Then I can check product exists in basket
    And I can check ProductDescription is valid on basket lines
    And I can check ProductName is valid on basket lines
    And I can check ListPrice is valid on basket lines
    And I can check DiscountedPrice is valid on basket lines
    And I can check Product Quantity is 1 on basket lines
    And I can check basket subTotal is valid on basket
    And I can check basket total is valid

  @TestRail(33335)
  Scenario: User can not add product while basket not empty
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    Then I select mahalle vendor from defined vendors type is "defaultSecondVendor" on home page
    When I navigate selected vendor
    Then I choose "Meyve" product category from category list
    Then I choose "Yerli Meyve" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    Then I check added product "Sepetinizde başka bir mağazadan ürün(ler) bulunmaktadır. Sepetinize bu mağazanın ürününü eklemek için sepetinizi boşaltmak ister misiniz?" error message and status is 400

  @TestRail(33336)
  Scenario: User can see basket items count on the vendor detail with lite basket service
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select product with order 1
    And I can add the selected product to basket quantity is 2
    Then I choose "Köpek" product category from category list
    Then I choose "Kuru Köpek Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select product with order 1
    And I can add the selected product to basket quantity is 1
    When I get basket line counts with lite basket
    Then I can see the product quantity is 2 product index 0 in lite basket
    Then I can see the product quantity is 1 product index 1 in lite basket
    And  I check TotalLinesItemCount is 2 on lite basket response
    And I check line products is valid on lite basket response

  @TestRail(33337)
  Scenario: User can clear all products from basket with clear basket service
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 2
    When I get the basket
    Then I can check product exists in basket
    When I delete basket
    Then I get the basket
    And I can validate basket is empty
    And I can validate basket sub total is 0.0

  @TestRail(33338)
  Scenario: User can see alternate product options
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 2
    When I get alternate product options
    Then I can validate alternate product text "Alternatif ürün için beni arayın" is exist and rank is 2 type is 2
    And I can validate alternate product text "Alternatif ürün gönderin" is exist and rank is 1 type is 1
    * I can validate alternate product text "Ürün yoksa siparişten çıkarın" is exist and rank is 3 type is 3
    * I can validate alternate product text "Ürün yoksa siparişi iptal edin" is exist and rank is 4 type is 4

  @TestRail(33340)
  Scenario: User can see max stock error when add more than stock quantity
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select random available product for max stock
    And I navigate selected product
    When I want add product more than stock
    Then I can see "dilerseniz diğer ürünlere göz atabilirsiniz." warning on add basket response
    Then I can valid add basket response is 400
    Then I get the basket
    And I can validate basket is empty
    When I add products as many as the max stock quantity
    Then I get the basket
    And I can check Quantity is valid on basket lines
    When I can add the selected product to basket quantity is 1
    Then I can see "adet ekleyebilirsiniz, dilerseniz diğer ürünlere göz atabilirsiniz." warning on add basket response
    And I delete basket

  @TestRail(33341)
  Scenario: User can update line items quantity
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 2
    * I navigate selected product
    * I update quantity to 3 from selected product with update product service
    Then I get the basket
    When I can check Product Quantity is 3 on basket lines

  @TestRail(33342)
  Scenario: User can delete line item from basket
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 2
    Then I get the basket
    And I can check Product Quantity is 2 on basket lines
    When I delete the selected product from basket quantity is 2
    Then I get the basket
    And I can validate basket is empty

  @TestRail(33350)
  Scenario: User can get basket info smoothly
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I delete basket
    * I choose "Kedi" product category from category list
    * I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 2
    When I get the basket
    Then I validate VendorName is valid in basket info
    * I validate VendorId is valid in basket info
    * I validate IsFreeOrder is "false" in basket info
    * I validate MinimumDeliveryTotal is valid in basket info
    And I can check basket total is valid
    * I validate VendorCategory is valid in basket info
    * I validate VendorLogo is valid in basket info
    * I validate VendorCategory is valid in basket info
    * I validate BasketStatus is 1 in basket info
    * I validate BasketId is valid in basket info

