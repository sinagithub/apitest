@Vendor @SmokeTest @AllTest
Feature: Vendor detail and listings Controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address

  Scenario: User should list products on the vendor detail
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When  I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I check product list not empty
    When I select a random available product from selected category
    Then I should see selected product's id is not empty on vendor detail
    And I  check selected product's Price is valid on vendor detail
    And I check selected product's MaximumSaleAmount is valid on vendor detail
    And I check selected product's IsActive is "true"
    And I check selected product's HasOptions should be "false" on vendor detail
    And I check selected product's image url is 200 on vendor detail

  Scenario: User can't list deleted vendor detail
    When  I navigate vendor with "38909e64-96d8-11eb-b45d-69fdcw0b8ba1"
    Then I should get 400 error on vendor detail

  Scenario: User can list closed carsi vendor
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And Vendor staff close the selected shop
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When  I navigate selected vendor
    And Vendor staff open the selected shop

  Scenario: User can search product on vendor detail
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And  I navigate selected vendor
    And I search "asdedasdsTEST" on vendor product search pageIndex 1
    And I validate product search result is empty
    And I validate HasNext is "false"
    And I validate HasPrev is "false"
    When I search an existing product and validate search results
    And I validate HasNext is "false"
    And I validate HasPrev is "false"
    And I validate search result Total count is valid
    And I select a random available product from selected category on product search results
    Then I should see selected product's id is not empty on vendor product search
    And I  check selected product's Price is valid on vendor product search
    And I check selected product's MaximumSaleAmount is valid on vendor product search
    And I check selected product's HasOptions should be "false" on vendor product search
