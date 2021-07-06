@SmokeTest @Checkout
Feature: Checkout ContactlessDelivery delivery control

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"

  Scenario: ContactlessDelivery auto selection for payment selections - Carşı vendors
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check Contactless Delivery Option is showed "true" on basket checkout response
    When I set ContactlessDelivery is "true"
    Then I set paymentMethodId is "da037061-192e-42f4d-996f-7fe47444344", PaymentType : 2 , BinNumber: 0 , IsApproved : "true"
    And I put basket to checkout LastChangedProperty is 1
    And I check ContactlessDelivery is "true" on put basket checkout response
    And I check selected payment MethodId is "062" on put basket checkout response

    When I put basket to checkout LastChangedProperty is 4
    Then I check ContactlessDelivery is "false" on put basket checkout response
    And I check selected payment MethodId is "da037061-192e-42f4d-996f-7fe47444344" on put basket checkout response

    When I set paymentMethodId is "062", PaymentType : 1 , BinNumber: 554960 , IsApproved : "true"
    Then I put basket to checkout LastChangedProperty is 4
    When I set ContactlessDelivery is "true"
    Then I put basket to checkout LastChangedProperty is 1
    And I check ContactlessDelivery is "true" on put basket checkout response

    When I set ContactlessDelivery is "false"
    Then I put basket to checkout LastChangedProperty is 1
    And I check ContactlessDelivery is "false" on put basket checkout response
    And I check selected payment MethodId is "062" on put basket checkout response

  Scenario: ContactlessDelivery selectable control with no saved cards
    And I am an authorized user with "yahya.kara@yemeksepeti.com" "test11"
    And  My addresses list should be available
    When  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check Contactless Delivery Option is showed "true" on basket checkout response

    When I set ContactlessDelivery is "true"
    Then I set paymentMethodId is "111fb8a2-45a4-4e09-8a10-4d7d94d70be3", PaymentType : 1 , BinNumber: 0 , IsApproved : "true"
    And I put basket to checkout LastChangedProperty is 1
    And I check ContactlessDelivery is "true" on put basket checkout response
    And I check selected payment MethodId is "111fb8a2-45a4-4e09-8a10-4d7d94d70be3" on put basket checkout response

    When I set ContactlessDelivery is "true"
    Then I set paymentMethodId is "f825f3b8-9545-45f1-bc1e-38b34e369592", PaymentType : 2 , BinNumber: 0 , IsApproved : "true"
    And I put basket to checkout LastChangedProperty is 4
    And I check ContactlessDelivery is "false" on put basket checkout response
    And I check selected payment MethodId is "f825f3b8-9545-45f1-bc1e-38b34e369592" on put basket checkout response


  Scenario: ContactlessDelivery auto selection for payment selections - Banabi Vendors
    When I am an authorized  user "Login"
    Then  My addresses list should be available
    When  I select pinned available address
    When I get unique basket id
    Then I delete basket
    When  Banabi Vendor is available
    Then I select banabi vendor
    Then I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check Contactless Delivery Option is showed "true" on basket checkout response
    When I set ContactlessDelivery is "true"
    Then I set paymentMethodId is "da037061-192e-42f4d-996f-7fe47444344", PaymentType : 2 , BinNumber: 0 , IsApproved : "true"
    And I put basket to checkout LastChangedProperty is 1
    And I check ContactlessDelivery is "true" on put basket checkout response
    And I check selected payment MethodId is "103" on put basket checkout response

    When I put basket to checkout LastChangedProperty is 4
    Then I check ContactlessDelivery is "false" on put basket checkout response
    And I check selected payment MethodId is "da037061-192e-42f4d-996f-7fe47444344" on put basket checkout response

    When I set paymentMethodId is "103", PaymentType : 1 , BinNumber: 554960 , IsApproved : "true"
    Then I put basket to checkout LastChangedProperty is 4
    When I set ContactlessDelivery is "true"
    Then I put basket to checkout LastChangedProperty is 1
    And I check ContactlessDelivery is "true" on put basket checkout response

    When I set ContactlessDelivery is "false"
    Then I put basket to checkout LastChangedProperty is 1
    And I check ContactlessDelivery is "false" on put basket checkout response
    And I check selected payment MethodId is "103" on put basket checkout response

  Scenario: ContactlessDelivery auto selection with no saved cards for banabi
    And I am an authorized user with "yahya.kara@yemeksepeti.com" "123456"
    And  My addresses list should be available
    When  I select pinned available address
    When  Banabi Vendor is available
    Then I select banabi vendor
    Then I navigate selected vendor
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check Contactless Delivery Option is showed "true" on basket checkout response

    When I set ContactlessDelivery is "true"
    Then I set paymentMethodId is "2", PaymentType : 1, IsApproved : "true" without binNumber
    And I put basket to checkout LastChangedProperty is 1
    And I check ContactlessDelivery is "true" on put basket checkout response
    And I check selected payment MethodId is "2" on put basket checkout response

    When I set ContactlessDelivery is "true"
    Then I set paymentMethodId is "f825f3b8-9545-45f1-bc1e-38b34e369592", PaymentType : 2 , BinNumber: 0 , IsApproved : "true"
    And I put basket to checkout LastChangedProperty is 4
    And I check ContactlessDelivery is "false" on put basket checkout response
    And I check selected payment MethodId is "f825f3b8-9545-45f1-bc1e-38b34e369592" on put basket checkout response


  Scenario: Contactless Delivery selectable status should be false when vendor has not online payment method
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor payment method
      | 163c9493-8178-4765-a146-c35da4e98b3a |
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check Contactless Delivery Option is showed "false" on basket checkout response
    And Staff update vendor payment method
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
      | 43be6d4b-fc9e-4ab3-ad99-365ee3229664 |
      | 163c9493-8178-4765-a146-c35da4e98b3a |
      | 3027292b-517b-495a-b14b-9ab0a18b73db |
      | 88abcbdf-9292-492f-a6ec-adce18db8ebf |

