@Vendor @Smoke
Feature: Vendor detail and listings Controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address

  Scenario: User should see vendor correctly
    When  A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When  I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I check product list not empty
    #Dummy data ile vendor detaydaki datalar uyusmuyor
    #Then I check vendor DeliveryTimeInfo is valid
    #And I check vendor MinBasketPriceInfo is valid
    #And I check vendor DeliveryFeeInfo is valid
    And I check vendor category list is valid
    And I check category names  are valid
    And I check banner url is valid
    And I check banner seo urls are valid
    #And I check vendor name is valid
    #And I check vendor category name should be valid
    And I check vendor logo url is 200

  Scenario: User should list products on the vendor detail
    When  A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When  I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I check product list not empty
    When I select product with name "Nestlé Classic Sütlü Kare Çikolata - 60 g"
    Then I should see selected product's id is not empty on vendor detail
    And I  check selected product's Price is valid on vendor detail
    And I check selected product's MaximumSaleAmount is valid on vendor detail
    # Dummy data product IsActive default false dönmekte
    # And I check selected product's IsActive is "false"
    And I check selected product's HasOptions should be "false" on vendor detail
    And  I check selected product's CategoryId is valid on vendor detail
    # Dummy data image url göndermiyor
    And I check selected product's image url is 200 on vendor detail

  Scenario: User can list category product pages on Çarşı
    When  A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
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
    Then I select a random product
    Then I should see selected product's id is not empty on vendor detail
    And I  check selected product's Price is valid on vendor detail
    And I check selected product's MaximumSaleAmount is valid on vendor detail
    # Dummy data product IsActive default false dönmekte
    # And I check selected product's IsActive is "false"
    And I check selected product's HasOptions should be "false" on vendor detail
    And  I check selected product's CategoryId is valid on vendor detail
    # Dummy data image url göndermiyor
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
    #And I validate category HasPrevPage "false"
    And I validate category NextOffset is 21
    When I list sub category products with offset 21
    Then I check product list not empty
    Then I can validate PrevOffset is 0
    Then I can validate CurrentOffset is 21
    Then I select a random product
    And I check selected product's image url is 200 on vendor detail
    And I  check selected product's Price is valid on vendor detail
    And I check selected product's MaximumSaleAmount is valid on vendor detail

  Scenario: User can't list vendor detail with wrong platformType
    When  A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 0
    And Set platform type to "Banabi"
    When  I navigate selected vendor
    Then I should get 404 error on vendor detail

  Scenario: User can't list deleted vendor detail
    When  I navigate vendor with "38909e64-96d8-11eb-b45d-69fdcw0b8ba1"
    Then I should get 400 error on vendor detail

  Scenario: User can list closed carsi vendor
    When  A list of Carşı Vendor are available on home page
    Then I select random vendor from "Super Market" category on home page
    And Vendor staff close the selected shop
    When  A list of Carşı Vendor are available on home page
    And I select vendor with payment method "111fb8a2-45a4-4e09-8a10-4d7d94d70be3"
   # And I select closed Carsı vendor
    When  I navigate selected vendor
   # Then I check vendor status should be false
    And Vendor staff open the selected shop


  Scenario: User should see banabi vendor correctly
    When  Banabi Vendor is available
    And Set platform type to "Banabi"
    Then I select banabi vendor
    Then I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
     # Dummy data product IsActive default false dönmekte
    #Then I check vendor DeliveryTimeInfo is valid
    #And I check vendor MinBasketPriceInfo is valid
    #And I check vendor DeliveryFeeInfo is valid
    And I check vendor category list is valid
    And I check category names  are valid
    And I check banner url is valid
    And I check banner seo urls are valid
    And I check vendor name is valid
    And I check vendor category name should be "OnlineMarket"
    And I check vendor logo url is 200

  Scenario: User should list products on Banabi vendor detail
    When  Banabi Vendor is available
    And Set platform type to "Banabi"
    Then I select banabi vendor
    Then I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I check product list not empty
    When I select product with name "Ülker Napoliten"
    Then I should see selected product's id is not empty on vendor detail
    And I  check selected product's Price is valid on vendor detail
    And I check selected product's MaximumSaleAmount is valid on vendor detail
    And I check selected product's IsActive is "true"
    And I check selected product's HasOptions should be "false" on vendor detail
    And  I check selected product's CategoryId is valid on vendor detail
    And I check selected product's image url is 200 on vendor detail

  Scenario Outline: User can search product on vendor detail
    When  A list of Carşı Vendor are available on home page
    Then I select first vendor from "<VendorCategory>" category on home page
    And  I navigate selected vendor
    And I search "asdedasdsTEST" on vendor product search pageIndex 1
    And I validate product search result is empty
    And I validate HasNext is "false"
    And I validate HasPrev is "false"
    And I validate Total count is 0
    When I search "<SearchText>" on vendor product search pageIndex 1
    Then I validate related search result is valid  on the product list  searchText is "<SearchText>"
    And I validate HasNext is "false"
    And I validate HasPrev is "false"
    And I validate Total count is 2
    And I select a random product on product search results
    Then I should see selected product's id is not empty on vendor detail
    And I  check selected product's Price is valid on vendor detail
    And I check selected product's MaximumSaleAmount is valid on vendor detail
    And I check selected product's HasOptions should be "false" on vendor detail
    And  I check selected product's CategoryId is valid on vendor detail
    And I check selected product's image url is 200 on vendor detail

    Examples:
      | VendorCategory | SearchText |
      | Super Market   | Calve      |

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
    When I search "Calve" on vendor product search pageIndex 1
    Then I validate related search result is valid  on the product list  searchText is "Calve"
    And I validate HasNext is "false"
    And I validate HasPrev is "false"
    And I validate Total count is 2
    And I select a random product on product search results
    Then I should see selected product's id is not empty on vendor detail
    And I  check selected product's Price is valid on vendor detail
    And I check selected product's MaximumSaleAmount is valid on vendor detail
    And I check selected product's HasOptions should be "false" on vendor detail
    And  I check selected product's CategoryId is valid on vendor detail
    And I check selected product's image url is 200 on vendor detail