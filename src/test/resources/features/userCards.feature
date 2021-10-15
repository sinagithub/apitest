@SmokeTest @Checkout @UserCards @AllTest
Feature: Checkout User cards controls

  Background: Login user
    Given I am an authorized  user "Login"

  Scenario Outline: User can list cards and can check card details
    When I list my credit cards
    Then I validate user cards response AskCVV is "true"
    And I validate user cards response HasSavedCreditCard is "true"
    And I validate user cards response Success is "true"
    Then I select card with "<Pan>"
    Then I validate card name is "<Name>"
    And I validate selected card BankKod is "<BankKod>"
    And I validate selected card IsMaxiMobile status "<IsMaxiMobile>"
    And I validate selected card PointAmount is <PointAmount>
    Then I validate selected card CardBrand is "<CardBrand>"
    And I validate selected card image is "<Image>"
    And I validate selected card ImageHttps is "<ImageHttps>"


    Examples: Expected Card details
      | Pan              | Name           | BankKod | IsMaxiMobile | PointAmount | CardBrand  | Image                                                              | ImageHttps                                                               |
      | 554960******0029 | Garanti Kartım | 062     | false        | 0           | MasterCard | //images.yemeksepetim.com/App_Themes/BankLogos/garanti_bankasi.png | https://images.yemeksepetim.com/App_Themes/BankLogos/garanti_bankasi.png |
      | 520932******6435 | Akbank Hilal   | 046     | false        | 0           | MasterCard | //images.yemeksepetim.com/App_Themes/BankLogos/akbank.png          | https://images.yemeksepetim.com/App_Themes/BankLogos/akbank.png          |