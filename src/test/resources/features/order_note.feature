@SmokeTest @OrderNote @AllTest
Feature: Order note controls

  Scenario: New User can save order note and can get with get checkout
    Given I select city "TR_ISTANBUL"
    And I am an authorized user with "mahalletestuser" "123456"
    When  My addresses list should be available
    Then  I select pinned available address
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


  Scenario: New User can save order note and can get with get checkout - Banabi
    Given I select city "TR_ISTANBUL"
    And I am an authorized user with "mahalletestuser" "123456"
    When  My addresses list should be available
    Then  I select pinned available address
    When  Banabi Vendor is available
    And I get unique basket id
    * I get basket line counts with lite basket
    Then I select banabi vendor
    Then I navigate selected vendor
    And I delete basket
    Then I choose "İçecek" product category from category list
    And I choose "Gazlı İçecek" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I get order notes on checkout
    When I can write order note with character count 400 on checkout
    Then I get checkout options
    And I get order notes on checkout
    And I validate order note title is saved with first 20 character on checkout
    And I validate order note desc listed in checkout saved notes



  Scenario: New User can't save order note upper max character size - 300
    Given I select city "TR_ISTANBUL"
    And I am an authorized user with "mahalletestuser" "123456"
    When  My addresses list should be available
    Then  I select pinned available address
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
      Given I select city "TR_ISTANBUL"
      And I am an authorized user with "mahalletestuser" "123456"
      When  My addresses list should be available
      Then  I select pinned available address
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





