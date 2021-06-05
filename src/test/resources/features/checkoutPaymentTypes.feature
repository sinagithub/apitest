@SmokeTest @Checkout @PaymentMethods
Feature: Checkout User Payment Method controls

  Background: Login user
    Given I select city "TR_ISTANBUL"

  Scenario Outline: User not having saved credit card can list Other Online credit Card option on checkout - PaymentTypes
    Given I am an authorized user with "mahalletestuser" "Mahalle1!"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    When I list my credit cards
    Then I validate CreditCards list is empty in user cards response
    When  A list of Carşı Vendor are available on home page
    Then I select vendor with payment methods
      | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 |
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list PaymentTypes in basket checkout response
    And I check PaymentTypeTitle "<PaymentTypeTitle>" is exist in basket checkout response
    And I check PaymentTypeId "<PaymentTypeId>" is exist in basket checkout response
    And I check payment type IconUrl "<IconUrl>" is exist in basket checkout response
    Examples: Expected Payment Type details
      | PaymentTypeId                        | PaymentTypeTitle | IconUrl                                                                         |
      | 7420d62c-5794-4520-835d-1d2036052f31 | Online Ödeme     | https://cdn.yemeksepeti.com/app_themes/Store/PaymentMethod/guvenlialisveris.png |
      | da037061-192e-42fd-996f-74fe47444344 | Kapıda Ödeme     | https://cdn.yemeksepeti.com/app_themes/Store/PaymentMethod/cash.png             |


  Scenario Outline: User having saved credit card can list Saved credit Card options on checkout
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    When I list my credit cards
    Then I validate user cards response HasSavedCreditCard is "false"
    When  A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "111fb8a2-45a4-4e09-8a10-4d7d94d70be3"
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list PaymentTypes in basket checkout response
    Then I select payment type with "<PaymentTypeId>" in basket checkout response
    Then I select payment method id "<PaymentMethodId>" in selected payment method
    And I select sub method with "<subId>" in selected payment method
    And I check sub Name is "<Name>" is exist in selected payment sub method
    And I check sub ImageUrl is "<ImageUrl>" is exist in selected payment sub method
    And I check sub Pan is "<Pan>" is exist in selected payment sub method
    And I check sub BinNumber is <BinNumber> is exist in selected payment sub method
    And I check sub PointAmount is <PointAmount> is exist in selected payment sub method
    And I check sub IsSelected is "<IsSelected>" is exist in selected payment sub method
    And I check sub CheckoutTypeId is <CheckoutTypeId> is exist in selected payment sub method

    Examples: Expected Payment sub methods
      | PaymentTypeId                        | PaymentMethodId                      | subId | Name           | ImageUrl                                                                 | Pan              | BinNumber | PointAmount | IsSelected | CheckoutTypeId |
      | 7420d62c-5794-4520-835d-1d2036052f31 | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 | 062   | Garanti Kartım | https://images.yemeksepetim.com/App_Themes/BankLogos/garanti_bankasi.png | 554960******0029 | 554960    | 0           | true       | 3              |
      | 7420d62c-5794-4520-835d-1d2036052f31 | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 | 046   | Akbank Hilal   | https://images.yemeksepetim.com/App_Themes/BankLogos/akbank.png          | 520932******6435 | 520932    | 0           | false      | 3              |
