@Vendor @Smoke
Feature: Vendor detail Controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address

  Scenario: User should see vendor correctly
    When  A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 0
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
    And I check vendor category name is not empty
    And I check vendor logo url is 200

  Scenario: User can't list vendor detail with wrong platformType
    When  A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 0
    And Set platform type to "Banabi"
    When  I navigate selected vendor
    Then I should get 404 error on vendor detail

  Scenario: User can't list deleted vendor detail
    When  I navigate vendor with "38909e64-96d8-11eb-b45d-69fdc0b8ba21"
    Then I should get 404 error on vendor detail

  Scenario: User can list closed carsi vendor
    When  A list of Carşı Vendor are available on home page
    Then I select closed Carsı vendor
    When  I navigate selected vendor
    Then I check vendor status should be false

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
    And I check banner url is valid
    And I check banner seo urls are valid
    And I check vendor name is valid
    And I check vendor category name is not empty
    And I check vendor logo url is 200