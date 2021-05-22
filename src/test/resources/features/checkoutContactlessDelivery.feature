@SmokeTest @Checkout
Feature: Checkout ContactlessDelivery delivery control

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket

  Scenario: ContactlessDelivery auto selection with offline payment
    When  A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check Contactless Delivery Option is showed "true" on basket checkout response
    When I set ContactlessDelivery is "true"
    Then I set paymentMethodId is "da037061-192e-42fd-996f-74fe47444344", PaymentTypeId : "2" , BinNumber: 0 , IsApproved : "true"
    And I put basket to checkout LastChangedProperty is 1
    And I check ContactlessDelivery is "true" on put basket checkout response
    And I check selected payment MethodId is "111fb8a2-45a4-4e09-8a10-4d7d94d70be3" on put basket checkout response

    When I put basket to checkout LastChangedProperty is 4
    Then I check ContactlessDelivery is "false" on put basket checkout response
    And I check selected payment MethodId is "da037061-192e-42fd-996f-74fe47444344" on put basket checkout response

    When I set paymentMethodId is "111fb8a2-45a4-4e09-8a10-4d7d94d70be3", PaymentTypeId : "062" , BinNumber: 554960 , IsApproved : "true"
    Then I put basket to checkout LastChangedProperty is 4
    When I set ContactlessDelivery is "true"
    Then I put basket to checkout LastChangedProperty is 1
    And I check ContactlessDelivery is "true" on put basket checkout response

    When I set ContactlessDelivery is "false"
    Then I put basket to checkout LastChangedProperty is 1
    And I check ContactlessDelivery is "false" on put basket checkout response
    And I check selected payment MethodId is "111fb8a2-45a4-4e09-8a10-4d7d94d70be3" on put basket checkout response


