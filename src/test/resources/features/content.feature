@SmokeTest @Splash
Feature: Splash Api controls

  Background: Login user
    Given I am an authorized  user "Login"

  Scenario Outline: User can list Operation Guide
    Given I select city "TR_ISTANBUL"
    When I can list Faq content
    Then I select operation guide with id "<GuideId>"
    Then I can validate selected operation guide text is "<GuideText>"
    Then I can validate selected operation guide header is "<GuideHeader>"
    And I can validate selected operation guide is active "<GuideStatus>"

    Examples: Operation guide data content
      | GuideId                              | GuideHeader                                   | GuideStatus | GuideText                                                                                                                                                                                                                                                     |
        | 1dfb20c3-eea0-432e-bed7-ead6cf81cb72 | Nasıl sipariş verebilirim?                    | true        | Bulunduğunuz semti seçtikten sonra listelenen restoranlar arasından damak tadınıza uygun olanı bulabilir ve dilediğiniz yemekleri sepete atabilirsiniz. Adresinizi ve ödeme şeklinizi seçtikten sonra siparişinizi tamamlayabilirsiniz. Hepsi bu kadar basit. |
      | c693caf6-d0bb-4606-9fec-ee0061377c7b | Bilgilerimi restoranlarla paylaşacak mısınız? | false       | Siparişinizin size sorunsuz ulaşabilmesi için telefon numaranızı ve adresinizi restoranlarla paylaşıyoruz. Bunun dışında hiçbir sebeple bilgileriniz, restoranlarla ya da başka firmalarla paylaşılmamaktadır.                                                |

