@SmokeTest @Checkout @Tip
Feature: Checkout User Tip controls

  Background: Login user
    Given I select city "TR_ISTANBUL"

  Scenario Outline: User can list tip options on checkout
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
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

    Examples: Expected Card details
      | Rank | TypeId | ValueText                | IsSelected |
      | 0    | 2      | 3 TL                     | false      |
      | 1    | 1      | %10                      | false      |
      | 2    | 3      | TipInfoCustomPaymentText | false      |


  Scenario: User can select tip on checkout with Mahalle vendor
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
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
    When I set paymentMethodId is "111fb8a2-45a4-4e09-8a10-4d7d94d70be3", PaymentTypeId : "1" , BinNumber: 0 , IsApproved : "true"
    Then I set tip to 5 tl option type is 3
    Then I set ContactlessDelivery is "false"
    And I put basket to checkout LastChangedProperty is 2
    And I check Tip is selected with 5 on put basket checkout response
    And I check tip isEnabled is "true" on put basket checkout response