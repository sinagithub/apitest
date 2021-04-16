@Vendor @Smoke
Feature: Vendor detail Controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id

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
    And I check vendor category name is valid
    And I check vendor logo url is valid
    And I check vendor logo url is 200

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
    And I check vendor category name is valid
    And I check vendor logo url is valid
    And I check vendor logo url is 200
