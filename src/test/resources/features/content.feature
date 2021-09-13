@SmokeTest @Content
Feature: Content api controls

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
      | GuideId                              | GuideHeader                          | GuideStatus | GuideText                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
      | 3d2fba21-6d57-48ab-92f7-fb42d0cd6c5c | Mahalle'den nasıl sipariş veririm?   | true        | Yemeksepeti uygulamasında Mahalle logosuna tıklayarak Mahalle'ye geçebilirsiniz. Eğer size hizmet verilen lokasyonlar içindeyseniz, ihtiyacınız olan ürünleri mahallenizdeki onlarca farklı yerel esnaflardan (kasap, manav, şarküteri, petshop vb.) ve market zincirlerinden sepetinize ekleyerek sipariş oluşturabilirsiniz. \n\nSipariş verebileceğiniz yerel esnaf ve market zincirleri konumunuza bağlı olarak değişecektir. Uygulama üzerinden adres bilgilerinizi girerek mahallenize hizmet verdiğimiz dükkanları seçebilirsiniz.\n |
      | 0bdbeb8f-cea7-4813-894d-0d69e22b4748 | Mahalle hangi illere hizmet veriyor? | true        | Mahalle olarak şu anda İstanbul, İzmir ve Ankara’daki pek çok bölgeye hizmet vermekteyiz.\n\nYemeksepeti uygulamasını açtığınızda, seçili adresinize Mahalle hizmet veriyorsa, Mahalle'ye tıklayarak siparişlerinizi oluşturabilirsiniz. \nAyrıca Yemeksepeti ana sayfasında, üst bölümdeki Mahalle logosundan Mahalle'ye geçiş yapabilirsiniz. Eğer buton görünmüyorsa, seçili adresinize şu anda hizmet veremiyoruz.\n                                                                                                                    |