@SmokeTest @Checkout @PaymentMethods @AllTest
Feature: Checkout User Payment Method controls

  Background: Login user
    Given I select city "TR_ISTANBUL"

  @TestRail(33504)
  Scenario Outline: User not having saved credit card can list Other Online credit Card option on checkout - PaymentTypes
    Given I am an authorized user with "yahya.kara@yemeksepeti.com" "test11"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    * I delete basket
    When I list my credit cards
    Then I validate CreditCards list is empty in user cards response
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list PaymentTypes in basket checkout response
    And I check PaymentTypeTitle "<PaymentTypeTitle>" is exist in basket checkout response
    And I check PaymentTypeId "<PaymentTypeId>" is exist in basket checkout response
    And I check payment type IconUrl "<IconUrl>" "<PaymentTypeTitle>" is exist in basket checkout response
    Examples: Expected Payment Type details
      | PaymentTypeId                        | PaymentTypeTitle | IconUrl                                                                         |
      | 7420d62c-5794-4520-835d-1d2036052f31 | Online Ödeme     | https://cdn.yemeksepeti.com/app_themes/Store/PaymentMethod/guvenlialisveris.png |
      | da037061-192e-42fd-996f-74fe47444344 | Kapıda Ödeme     | https://cdn.yemeksepeti.com/app_themes/Store/PaymentMethod/cash.png             |

  @TestRail(33505)
  Scenario Outline: User having saved credit card can list Saved credit Card options on checkout
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    * I delete basket
    When I list my credit cards
    Then I validate user cards response HasSavedCreditCard is "true"
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list PaymentTypes in basket checkout response
    Then I select payment type with "<PaymentTypeId>" in basket checkout response
    Then I select payment method id "<PaymentMethodId>" in selected payment type
    And I select sub method with "<subId>" in selected payment method
    And I check sub Name is "<Name>" is exist in selected payment sub method
    And I check sub ImageUrl is "<IconUrl>" is exist in selected payment sub method
    And I check sub Pan is "<Description>" is exist in selected payment sub method
    And I check sub BinNumber is <BinNumber> is exist in selected payment sub method
    And I check sub PointAmount is <PointAmount> is exist in selected payment sub method
    And I check sub IsSelected is "<IsSelected>" is exist in selected payment sub method
    And I check sub CheckoutTypeId is <CheckoutTypeId> is exist in selected payment sub method
    And I check sub PaymentType is <PaymentType> is exist in selected payment sub method

    Examples: Expected Payment sub methods
      | PaymentTypeId                        | PaymentMethodId                      | subId                            | Name           | IconUrl                                                                  | Description      | BinNumber | PointAmount | IsSelected | CheckoutTypeId | PaymentType |
      | 7420d62c-5794-4520-835d-1d2036052f31 | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 | 6dd07657e24177d582cca099c1f18122 | Garanti Kartım | https://images.yemeksepetim.com/App_Themes/BankLogos/garanti_bankasi.png | 554960******0029 | 554960    | 0           | true       | 4              | 1           |
      | 7420d62c-5794-4520-835d-1d2036052f31 | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 | 22a110a9625a58f658e8e8886395a1c4 | Akbank Hilal   | https://images.yemeksepetim.com/App_Themes/BankLogos/akbank.png          | 520932******6435 | 520932    | 0           | false      | 4              | 1           |

  @TestRail(33506)
  Scenario Outline: User can list offline payment options on checkout
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    * I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And Staff get selected vendor details from internal vendor service
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    Then I choose "Kedi Maması" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list PaymentTypes in basket checkout response
    Then I select payment type with "<PaymentMainTypeId>" in basket checkout response
    Then I select payment method id "<PaymentMethodId>" in selected payment type
    And I check PaymentType <PaymentType> in selected payment method
    And I check Rank <Rank> in selected payment method
    And I check CheckoutTypeId <CheckoutTypeId> in selected payment method
    And I check Name "<PaymentMethodsName>" in selected payment method
    And I check Description "<Description>" in selected payment method
    And I check IconUrl "<IconUrl>" in selected payment method
    And I check IsSelected "<IsSelected>" in selected payment method
    And I check IsExpandable "<IsExpandable>" in selected payment method
    And I check IsExpanded "<IsExpanded>" in selected payment method

    Examples: Expected Payment Method details
      | PaymentMainTypeId                    | Rank | PaymentMethodId                      | PaymentMethodsName | PaymentType | CheckoutTypeId | IconUrl                                                                         | Description                  | IsSelected | IsExpandable | IsExpanded |
      | da037061-192e-42fd-996f-74fe47444344 | 4    | de2e3a82-8b55-4334-8a2e-467fe7f7db24 | Nakit              | 2           | 1              | https://cdn.yemeksepeti.com/app_themes/Store/PaymentMethod/cash.png             | Kapıda nakit ödeme           | false      | false        | false      |
      | da037061-192e-42fd-996f-74fe47444344 | 5    | 43be6d4b-fc9e-4ab3-ad99-365ee3229664 | Kapida Kredi Karti | 2           | 1              | https://cdn.yemeksepeti.com/app_themes/Store/PaymentMethod/creditcardonstep.png | Kapıda kredi kartı ile ödeme | false      | false        | false      |


