@SmokeTest @OrderNote @AllTest
Feature: Order note controls

  Background:
    Given I select city "TR_ISTANBUL"
    * I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address

  Scenario: New User can save order note and can get with get checkout
    And I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultSecondVendor" on home page
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I get order notes on checkout
    When I can write order note with character count 300 on checkout
    Then I get checkout options
    And I get order notes on checkout
    And I validate order note title is saved with first 20 character on checkout
    And I validate order note desc listed in checkout saved notes


  Scenario: New User can't save order note upper max character size - 300
    When  A list of Carşı Vendor are available on home page
    And I get unique basket id
    * I get basket line counts with lite basket
    * I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I get order notes on checkout
    When I can write order note with character count 401 on checkout
    Then I validate order note response status code is 400


    Scenario: User can not save order note with 0 character
      When  A list of Carşı Vendor are available on home page
      And I get unique basket id
      * I get basket line counts with lite basket
      * I delete basket
      Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
      When I navigate selected vendor
      Then I choose a category with more than 10 products
      Then I choose a sub category with more than 11 products
      When I list the products from selected sub category
      Then I select a random available product from selected category
      And I can add the selected product to basket quantity is 1
      When I get checkout options
      Then I get order notes on checkout
      When I can write order note with character count 0 on checkout
      Then I validate order note response status code is 400





