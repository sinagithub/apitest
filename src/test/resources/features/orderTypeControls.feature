@Order @IgnoreLive
Feature: Order type controls
  #PaymentType : Online = 1 - Offline = 2
  Background: Login user
    Given I select city "TR_ISTANBUL"

  Scenario: User can order with Offline payment - Kapıda Kredi Kartı
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 7
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor payment method
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
      | 43be6d4b-fc9e-4ab3-ad99-365ee3229664 |
    * I get unique basket id
    * I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    * I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product
    And I add selected product until the basket amount is higher than minimum delivery price
    * I select alternate product option type is 1
    * I get the basket
    And I get checkout options
    When I set ContactlessDelivery is "true"
    Then I set paymentMethodId is "43be6d4b-fc9e-4ab3-ad99-365ee3229664", PaymentType : 2 , BinNumber: 0 , IsApproved : "true"
    And I put basket to checkout LastChangedProperty is 2
    * I write user note "test-siparişi"
    * I set use point "false"
    * I post checkout with selected options - checkout type is 1
    * I check checkout response is 200
    * I check OrderId is created on checkout response


  Scenario: User can order with Offline payment - Kapıda Nakit
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 7
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor payment method
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
      | 43be6d4b-fc9e-4ab3-ad99-365ee3229664 |
    * I get unique basket id
    * I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    * I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product
    And I add selected product until the basket amount is higher than minimum delivery price
    * I select alternate product option type is 1
    * I get the basket
    And I get checkout options
    When I set ContactlessDelivery is "true"
    Then I set paymentMethodId is "de2e3a82-8b55-4334-8a2e-467fe7f7db24", PaymentType : 2 , BinNumber: 0 , IsApproved : "true"
    And I put basket to checkout LastChangedProperty is 2
    * I write user note "test-siparişi"
    * I set use point "false"
    * I post checkout with selected options - checkout type is 1
    * I check checkout response is 200
    * I check OrderId is created on checkout response


  Scenario: User can order with Online payment - Saved Credit Card
    Given I am an authorized user with "mahalletestuser" "123456"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 2
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor payment method
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
      | 43be6d4b-fc9e-4ab3-ad99-365ee3229664 |
      | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 |
    * I get unique basket id
    * I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    * I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random product
    And I add selected product until the basket amount is higher than minimum delivery price
    * I select alternate product option type is 1
    * I get the basket
    And I get checkout options
    When I set ContactlessDelivery is "true"
    Then I set paymentMethodId is "111fb8a2-45a4-4e09-8a10-4d7d94d70be3", PaymentType : 1 , BinNumber: 544078 , IsApproved : "true"
    * I set saved card model cardName "Garanti Kartım2", cvv "846"
    And I put basket to checkout LastChangedProperty is 2
    * I write user note "test-siparişi"
    * I set use point "false"
    * I post checkout with selected options - checkout type is 4
    * I check checkout response is 200
    * I check OrderId is created on checkout response
    * Send refund email to "tugce.kor@yemeksepeti.com"



