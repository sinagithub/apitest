@Vendor @SmokeTest
Feature: Vendor detail and listings Controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address

  Scenario: User should see vendor correctly
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When  I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I check product list not empty
    Then I check vendor DeliveryTimeInfo is valid
    And I check vendor MinBasketPriceInfo is valid
    And I check vendor DeliveryFeeInfo is valid
    And I check vendor category list is valid
    And I check category names  are valid
    And I check banner url is valid
    And I check banner seo urls are valid
    And I check vendor name is valid
    And I check vendor category name should be valid
    And I check vendor logo url is 200

  Scenario: User should list products on the vendor detail
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When  I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I check product list not empty
    When I select a random available product from selected category
    Then I should see selected product's id is not empty on vendor detail
    And I  check selected product's Price is valid on vendor detail
    And I check selected product's MaximumSaleAmount is valid on vendor detail
    And I check selected product's IsActive is "true"
    And I check selected product's HasOptions should be "false" on vendor detail
    And I check selected product's image url is 200 on vendor detail

  Scenario: User can list category product pages on Çarşı
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultSecondVendor" on home page
    When  I navigate selected vendor
    Then I choose a category with more than 50 products
    Then I choose a sub category with more than 50 products
    When I list the products from selected sub category
    Then I check product list not empty
    Then I validate category product is listed with 21 products
    And I validate category HasNextPage is "true"
    And I can validate CurrentOffset is 0
    And I validate category HasPrevPage "false"
    And I validate category NextOffset is 21
    When I list sub category products with offset 21
    Then I can validate PrevOffset is 0
    Then I can validate CurrentOffset is 21
    And I validate category NextOffset is 42
    And I check product list not empty
    When I list sub category products with offset 42
    Then I validate category product is listed with 21 products
    And I check product list not empty
    Then I can validate PrevOffset is 21
    Then I can validate CurrentOffset is 42
    And I validate category HasPrevPage "true"
    When I list sub category products with offset 21
    Then I check product list not empty
    And I can validate CurrentOffset is 21
    Then I select a random available product from selected category
    Then I should see selected product's id is not empty on vendor detail
    And I  check selected product's Price is valid on vendor detail
    And I check selected product's MaximumSaleAmount is valid on vendor detail
    And I check selected product's IsActive is "true"
    And I check selected product's HasOptions should be "false" on vendor detail
    And I check selected product's image url is 200 on vendor detail

  Scenario: User can list category product pages on Banabi
    When  Banabi Vendor is available
    Then I select banabi vendor
    Then I navigate selected vendor
    Then I choose a category with more than 30 products
    Then I choose a sub category with more than 21 products
    When I list the products from selected sub category
    Then I check product list not empty
    Then I validate category product is listed with 21 products
    And I validate category HasNextPage is "true"
    And I can validate CurrentOffset is 0
    And I validate category HasPrevPage "false"
    And I validate category NextOffset is 21
    When I list sub category products with offset 21
    Then I check product list not empty
    Then I can validate PrevOffset is 0
    Then I can validate CurrentOffset is 21
    Then I select a random available product from selected category
    And I check selected product's image url is 200 on vendor detail
    And I  check selected product's Price is valid on vendor detail
    And I check selected product's MaximumSaleAmount is valid on vendor detail

  Scenario: User can't list deleted vendor detail
    When  I navigate vendor with "38909e64-96d8-11eb-b45d-69fdcw0b8ba1"
    Then I should get 400 error on vendor detail

  Scenario: User can list closed carsi vendor
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultSecondVendor" on home page
    And Vendor staff close the selected shop
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultSecondVendor" on home page
    When  I navigate selected vendor
    And Vendor staff open the selected shop

  Scenario: User should see banabi vendor correctly
    When  Banabi Vendor is available
    Then I select banabi vendor
    Then I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I check vendor DeliveryTimeInfo is valid
    And I check vendor MinBasketPriceInfo is valid
    And I check vendor DeliveryFeeInfo is valid
    And I check vendor category list is valid
    And I check category names  are valid
    And I check banner seo urls are valid
    And I check vendor name is valid
    And I check vendor category name should be "Online Market"
    And I check vendor logo url is 200

  Scenario: User should list products on Banabi vendor detail
    When  Banabi Vendor is available
    Then I select banabi vendor
    Then I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I check product list not empty
    When I select product with name "Ülker"
    Then I should see selected product's id is not empty on vendor detail
    And I  check selected product's Price is valid on vendor detail
    And I check selected product's MaximumSaleAmount is valid on vendor detail
    And I check selected product's IsActive is "true"
    And I check selected product's HasOptions should be "false" on vendor detail
    And I check selected product's image url is 200 on vendor detail

  Scenario Outline: User can search product on vendor detail
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "<VendorCategory>" on home page
    And  I navigate selected vendor
    And I search "asdedasdsTEST" on vendor product search pageIndex 1
    And I validate product search result is empty
    And I validate HasNext is "false"
    And I validate HasPrev is "false"
    When I search "<SearchText>" on vendor product search pageIndex 1
    Then I validate related search result is valid  on the product list  searchText is "<SearchText>"
    And I validate HasNext is "false"
    And I validate HasPrev is "false"
    And I validate search result  Total count is not empty
    And I select a random available product from selected category on product search results
    Then I should see selected product's id is not empty on vendor product search
    And I  check selected product's Price is valid on vendor product search
    And I check selected product's MaximumSaleAmount is valid on vendor product search
    And I check selected product's HasOptions should be "false" on vendor product search
    Examples:
      | VendorCategory     | SearchText |
      | defaultFirstVendor | Ülker      |

  Scenario: User can search product on Banabi vendor detail
    When  Banabi Vendor is available
    And Set platform type to "Banabi"
    Then I select banabi vendor
    Then I navigate selected vendor
    And I search "asdedasdsTEST" on vendor product search pageIndex 1
    And I validate product search result is empty
    And I validate HasNext is "false"
    And I validate HasPrev is "false"
    And I validate Total count is 0
    When I search "Damla Su" on vendor product search pageIndex 1
    Then I validate related search result is valid  on the product list  searchText is "Damla"
    And I validate HasNext is "false"
    And I validate HasPrev is "false"
    And I validate search result  Total count is not empty
    And I select a random available product from selected category on product search results
    Then I should see selected product's id is not empty on vendor product search
    And I  check selected product's Price is valid on vendor product search
    And I check selected product's MaximumSaleAmount is valid on vendor product search
    And I check selected product's HasOptions should be "false" on vendor product search