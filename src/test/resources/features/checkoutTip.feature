@SmokeTest @Checkout @Tip
Feature: Checkout User Tip controls

  Background: Login user
    Given I select city "TR_ISTANBUL"

  Scenario Outline: User can list tip options on checkout
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "111fb8a2-45a4-4e09-8a10-4d7d94d70be3"
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product with price upper than is 5.0
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check tip info is "true" on basket checkout response
    And I check tip <TypeId> <Rank> on get basket checkout
    And I check tip "<ValueText>" <Rank> on get basket checkout
    And I check tip status "<IsSelected>" <Rank> on get basket checkout
    And I check tip value is valid <TypeId>

    Examples: Expected Tip details
      | Rank | TypeId | ValueText                | IsSelected |
      | 0    | 2      | 3 TL                     | false      |
      | 1    | 1      | %10                      | false      |
      | 2    | 3      | TipInfoCustomPaymentText | false      |


  Scenario: User can select custom tip on checkout with Mahalle vendor
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "111fb8a2-45a4-4e09-8a10-4d7d94d70be3"
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product with price upper than is 5.0
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check tip info is "true" on basket checkout response
    When I set paymentMethodId is "111fb8a2-45a4-4e09-8a10-4d7d94d70be3", PaymentType : 1 , BinNumber: 0 , IsApproved : "true"
    Then I set tip to 500 tl option type is 3
    And I set ContactlessDelivery is "true"
    And I put basket to checkout LastChangedProperty is 3
    And I check Tip is selected with 500 on put basket checkout response
    And I check tip isEnabled is "true" tip type is 3 on put basket checkout response
    And I check total is valid for tip amount 500 on put basket checkout response

  Scenario: User can select predefined tip on checkout with Mahalle vendor
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "111fb8a2-45a4-4e09-8a10-4d7d94d70be3"
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product with price upper than is 5.0
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check tip info is "true" on basket checkout response
    When I set paymentMethodId is "111fb8a2-45a4-4e09-8a10-4d7d94d70be3", PaymentType : 1 , BinNumber: 0 , IsApproved : "true"
    Then I set tip to 3 tl option type is 2
    And I set ContactlessDelivery is "true"
    And I put basket to checkout LastChangedProperty is 3
    And I check Tip is selected with 3 on put basket checkout response
    And I check tip isEnabled is "true" tip type is 2 on put basket checkout response
    And I check total is valid for tip amount 3 on put basket checkout response


  Scenario: User can't select tip if vendor has not online payment option with Mahalle vendor
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 0
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor payment method
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product with price upper than is 5.0
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check tip info is "false" on basket checkout response
    And Staff update vendor payment method
      | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 |
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |



