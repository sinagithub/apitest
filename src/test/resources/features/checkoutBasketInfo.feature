@SmokeTest @Checkout @BasketInfo
Feature: Checkout Basket Info Controls

  Background: Login user
    Given I select city "TR_ISTANBUL"

  Scenario: User can list basket info smoothly in checkout
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    * I get the basket
    When I get checkout options
    Then I check BasketId is valid on get checkout response
    And I check BasketStatus should be 1 on get checkout response
    * I check IsFreeOrder should be "false" on get checkout response
    * I check DonationTotal should be 0.0 on get checkout response
    * I check DeliveryFree is valid on get checkout response

    And I check Total is valid on get checkout response
    * I check DiscountTotal is valid on get checkout response
    * I check LineItemsTotal is valid on get checkout response
    * I check BagQuantity should be 1 on get checkout response

  Scenario: User can list basket info smoothly in checkout for banabi
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  Banabi Vendor is available
    Then I select banabi vendor
    And I get unique basket id
    * I get basket line counts with lite basket
    And I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random available product from selected category with price upper than is 5.0
    And I can add the selected product to basket quantity is 1
    And I get the basket
    When I get checkout options
    Then I check BasketId is valid on get checkout response
    And I check BasketStatus should be 1 on get checkout response
    * I check IsFreeOrder should be "false" on get checkout response
    * I check DonationTotal should be 0.0 on get checkout response
    * I check DeliveryFree is valid on get checkout response
    * I check Total is valid on get checkout response
    * I check DiscountTotal is valid on get checkout response
    * I check LineItemsTotal is valid on get checkout response
    * I check BagQuantity should be 1 on get checkout response