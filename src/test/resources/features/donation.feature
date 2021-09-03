@SmokeTest @Checkout @Donation
Feature: Checkout User Donation controls

  Background: Login user
    Given I select city "TR_ISTANBUL"

  Scenario Outline: User can list donation Foundations on checkout
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor payment method
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
      | 43be6d4b-fc9e-4ab3-ad99-365ee3229664 |
      | 163c9493-8178-4765-a146-c35da4e98b3a |
      | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 |
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 2
    When I get checkout options
    Then I check donation Enabled value is "true" on basket checkout response
    And I check foundation name is listed "<FoundationName>"
    And I check foundation FoundationId is listed "<FoundationId>"
    And I check foundation FoundationDescription is listed "<FoundationDescription>"
    And I check foundation FoundationIconUrl is listed "<FoundationIconUrl>"
    And I check foundation IsActive is "<IsActive>" "<FoundationId>"

    Examples: Expected Donation foundation details
      | FoundationId | FoundationName                                            | FoundationDescription                                                                                                       | FoundationIconUrl                                                  | IsActive |
      | 4            | Toplum Gönüllüleri Vakfı (TOG) Sağlık Bilimleri Burs Fonu | Sağlık alanında öğrenimini sürdüren bir gencin eğitimine destek ol, onun dokunduğu yaşamlarda senin de payın olsun!         | https://cdn.yemeksepeti.com/App_Themes/donation/tog_icon.jpg       | true     |
      | 3            | Türk Eğitim Vakfı (TEV) Yemek Yardımı Fonu                | Bir üniversite öğrencisine aylık yemek yardımında bulun, okuma mücadelesi veren Türk Eğitim Vakfı bursiyerlerine destek ol. | https://cdn.yemeksepeti.com/App_Themes/donation/tev_icon.png       | true     |
      | 1            | Türk Kızılay Aşevlerine Nakdi Bağış Desteği               | Kızılay’ın Aşevleri Projesine bağış yaparak iyilik sofralarımıza katkıda bulunabilirsiniz.                                  | https://cdn.yemeksepeti.com/App_Themes/donation/kizilay_icon_2.png | true     |
      | 2            | UNICEF – Türkiye’de Kapsayıcı Eğitim Fonu                 | Türkiye’de en dezavantajlı çocuklar başta olmak üzere her çocuğun kapsayıcı, kaliteli eğitime erişmesini destekle.          | https://cdn.yemeksepeti.com/App_Themes/donation/tev_icon.png       | true     |
      | 5            | TEMA Vakfı Doğa Koruma Fonu                               | Toprak, hava, su ve ormanların korunması için yasal ve bilimsel temelli saha çalışmalarımızı destekle.                      | https://cdn.yemeksepeti.com/App_Themes/donation/tema_icon.png      | true     |

  Scenario Outline: User can list donation options default values on checkout
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor payment method
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
      | 43be6d4b-fc9e-4ab3-ad99-365ee3229664 |
      | 163c9493-8178-4765-a146-c35da4e98b3a |
      | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 |
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 2
    When I get checkout options
    And I check donation <TypeId> <Rank> on get basket checkout
    And I check donation "<ValueText>" <Rank> <TypeId> on get basket checkout
    And I check donation status "<IsSelected>" <Rank> on get basket checkout
    And I check donation value is valid <TypeId>

    Examples: Expected Donation details
      | Rank | TypeId | ValueText     | IsSelected |
      | 0    | 2      | Yuvarla       | false      |
      | 1    | 3      | 5 TL          | false      |
      | 2    | 4      | Tutar Giriniz | false      |


  Scenario: User can select default and custom donation on checkout with Mahalle vendor
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor payment method
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
      | 43be6d4b-fc9e-4ab3-ad99-365ee3229664 |
      | 163c9493-8178-4765-a146-c35da4e98b3a |
      | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 |
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check donation Enabled value is "true" on basket checkout response
    When I set paymentMethodId is "111fb8a2-45a4-4e09-8a10-4d7d94d70be3", PaymentType : 1
    Then I set ContactlessDelivery is "true"
    Then I set donation to 5 tl option type is 2 foundation id is "3"
    And I put basket to checkout LastChangedProperty is 3
    And I check Donation is selected with 5 tl typeId 3 on put basket checkout response
    Then I set donation to 5 tl option type is 3 foundation id is "3"
    And I put basket to checkout LastChangedProperty is 3
    And I check Donation is selected with 5 tl typeId 3 on put basket checkout response

  Scenario: User can not select donation with Mahalle vendor supporting offline payment
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor payment method
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check donation Enabled value is "false" on basket checkout response
    And Staff update vendor payment method
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
      | 163c9493-8178-4765-a146-c35da4e98b3a |
      | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 |

  Scenario: User can't donate with donation value 0 for Mahalle vendor
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor payment method
      | de2e3a82-8b55-4334-8a2e-467fe7f7db24 |
      | 43be6d4b-fc9e-4ab3-ad99-365ee3229664 |
      | 163c9493-8178-4765-a146-c35da4e98b3a |
      | 111fb8a2-45a4-4e09-8a10-4d7d94d70be3 |
    And I get unique basket id
    And I delete basket
    When I navigate selected vendor
    Then I choose a category with more than 10 products
    Then I choose a sub category with more than 11 products
    When I list the products from selected sub category
    Then I select a random available product from selected category
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I check donation Enabled value is "true" on basket checkout response
    When I set paymentMethodId is "111fb8a2-45a4-4e09-8a10-4d7d94d70be3", PaymentType : 1
    Then I set ContactlessDelivery is "true"
    Then I set donation to 0 tl option type is 3 foundation id is "3"
    And I put basket to checkout LastChangedProperty is 3
    And I validate put basket checkout response status is 400 with Message "'Donation Value' değeri '0' değerinden büyük olmalı."
