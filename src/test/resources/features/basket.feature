@Basket
Feature: Basket Controls

  Scenario: User can get basket id : every time same id
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned address with id "{81cfbad7-36f9-455b-9204-0ea674b2406a}"
    Then I get unique basket id
    And I check basket id is same than old basket id

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
    Then I can add the selected product to basket quantity is 2
    And  I check TotalLinesItemCount is 2 on add basket response
    When I get the basket
    Then I can check product exists in basket
    And I can check ProductDescription is valid on basket lines
    And I can check ProductName is valid on basket lines
    And I can check ListPrice is valid on basket lines
    #And I can check DiscountedPrice is valid on basket lines
    And I can check Product Quantity is 2 on basket lines
    And I can check basket subTotal is valid on basket
    And I can check basket total is valid

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
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    Then I select mahalle vendor from defined vendors type is "defaultSecondVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    Then I check added product "VendorsNotMatchedInBasket" error message and status is 400

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
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product with order 1
    And I can add the selected product to basket quantity is 2
    Then I select a random product with order 2
    And I can add the selected product to basket quantity is 1
    When I get basket line counts with lite basket
    Then I can see the product quantity is 2 product index 0 in lite basket
    Then I can see the product quantity is 1 product index 1 in lite basket
    And  I check TotalLinesItemCount is 2 on lite basket response
    And I check line products is valid on lite basket response

  Scenario: User can clear all products from basket with clear basket service
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select "Beşiktaş BanabiAddress Dev" mahalle vendor name on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 2
    When I get the basket
    Then I can check product exists in basket
    When I delete basket
    Then I get the basket
    And I can validate basket is empty
    And I can validate basket sub total is 0.0

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
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 2
    When I get alternate product options
    Then I can validate alternate product text "Alternatif ürün için beni arayın" is exist and rank is 2 type is 2
    And I can validate alternate product text "Alternatif ürün gönderin" is exist and rank is 1 type is 1
    * I can validate alternate product text "Ürün yoksa siparişten çıkarın" is exist and rank is 3 type is 3
    * I can validate alternate product text "Ürün yoksa siparişi iptal edin" is exist and rank is 4 type is 4

  Scenario: User can't see alternate product options on banabi basket
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then Banabi Vendor is available
    And I get unique basket id
    * I delete basket
    Then I select banabi vendor
    When I navigate selected vendor
    When I get alternate product options
    Then I can validate alternate product option list is null

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
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I navigate selected product
    When I want add product more than stock
    Then I can see "MaximumSaleAmountExceeded" warning on add basket response
    Then I can valid add basket response is 400
    Then I get the basket
    And I can validate basket is empty
    When I add products as many as the max stock quantity
    Then I get the basket
    And I can check Quantity is valid on basket lines
    When I can add the selected product to basket quantity is 1
    Then I can see "MaximumSaleAmountExceeded" warning on add basket response
    And I delete basket

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
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 2
    Then I get the basket
    And I can check Product Quantity is 2 on basket lines
    When I delete the selected product from basket quantity is 2
    Then I get the basket
    And I can validate basket is empty

  Scenario: User can get add/delete product without options to basket for banabi
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  Banabi Vendor is available
    Then I select banabi vendor
    * I delete basket
    * I navigate selected vendor
    * I choose "İçecek" product category from category list
    * I choose "Gazlı İçecek" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    * I check added product exists on add basket response
    *  I check TotalLinesItemCount is 1 on add basket response
    * I can add the selected product to basket quantity is 1
    *  I check TotalLinesItemCount is 1 on add basket response
    When I select a random product
    Then I can add the selected product to basket quantity is 1
    And  I check TotalLinesItemCount is 2 on add basket response
    When I get the basket
    Then I can check product exists in basket
    And I can check ProductName is valid on basket lines
    * I can check ListPrice is valid on basket lines
    #* I can check DiscountedPrice is valid on basket lines
    * I can check Product Quantity is 1 on basket lines
    * I can check basket subTotal is valid on basket
    * I can check basket total is valid


  Scenario: User can see basket items count on the vendor detail with lite basket service for banabi vendors
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  Banabi Vendor is available
    Then I select banabi vendor
    Then I navigate selected vendor
    Then I choose "İçecek" product category from category list
    And I choose "Gazlı İçecek" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 2
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get basket line counts with lite basket
    Then I can see the product quantity is 2 product index 0 in lite basket
    Then I can see the product quantity is 1 product index 1 in lite basket
    And  I check TotalLinesItemCount is 2 on lite basket response
    And I check line products is valid on lite basket response

  Scenario: User can clear all products from basket with clear basket service for banabi vendors
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  Banabi Vendor is available
    Then I select banabi vendor
    * I navigate selected vendor
    * I choose "İçecek" product category from category list
    And I choose "Gazlı İçecek" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 2
    When I get the basket
    Then I can check product exists in basket
    When I delete basket
    Then I get the basket
    And I can validate basket is empty
    And I can validate basket sub total is 0.0

  Scenario: User can see max stock error when add more than stock quantity for banabi vendors
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  Banabi Vendor is available
    Then I select banabi vendor
    And I delete basket
    Then I navigate selected vendor
    * I choose "Su" product category from category list
    * I choose "Damacana" sub category from sub category
    When I list the products from selected sub category
    Then I select product with name "İadeli Damla Damacana Su"
    And I navigate selected product
    When I want add product more than stock
    Then I can see "Sepetinize eklemek istediğiniz üründen şu anda stoklarımızda" warning on add basket response
    * I can valid add basket response is 200
    * I get the basket
    And I can validate basket is empty
    When I add products as many as the max stock quantity
    Then I get the basket
    And I can check Quantity is valid on basket lines
    When I can add the selected product to basket quantity is 2
    Then I can see "Sepetinize eklemek istediğiniz üründen şu anda stoklarımızda" warning on add basket response
    And I delete basket

  Scenario: User can delete line item from basket for banabi vendors
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  Banabi Vendor is available
    Then I select banabi vendor
    Then I navigate selected vendor
    And I delete basket
    Then I choose "İçecek" product category from category list
    And I choose "Gazlı İçecek" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 2
    Then I get the basket
    And I can check Product Quantity is 2 on basket lines
    When I delete the selected product from basket quantity is 2
    Then I get the basket
    And I can validate basket is empty


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
    * I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 2
    When I get the basket
    Then I validate VendorName is valid in basket info
    * I validate VendorId is valid in basket info
    * I validate IsFreeOrder is "false" in basket info
    * I validate MinimumDeliveryTotal is valid in basket info
    #And I can check basket total is valid
    * I validate VendorCategory is valid in basket info
    * I validate VendorLogo is valid in basket info
    * I validate VendorCategory is valid in basket info
    * I validate BasketStatus is 1 in basket info
    * I validate BasketId is valid in basket info

  Scenario: User can get basket info smoothly - Banabi
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  Banabi Vendor is available
    Then I select banabi vendor
    Then I navigate selected vendor
    And I delete basket
    Then I choose "İçecek" product category from category list
    And I choose "Gazlı İçecek" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 2
    When I get the basket
    Then I validate VendorName is valid in basket info
    And I validate VendorId is valid in basket info
    And I validate IsFreeOrder is "false" in basket info
    And I validate MinimumDeliveryTotal is valid in basket info
    #And I can check basket total is valid
    And I validate VendorCategory is valid in basket info
    * I validate VendorLogo is valid in basket info
    * I validate VendorCategory is valid in basket info
    * I validate BasketStatus is 1 in basket info
    * I validate BasketId is valid in basket info

