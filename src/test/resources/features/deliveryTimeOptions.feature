@SmokeTest @Content
Feature: Content api controls

  Background: Login user
    Given I select city "TR_ISTANBUL"

  Scenario Outline: User can select delivery time as Now and can not list delivery time as Future
    Given I am an authorized user with "mahalletestuser" "Mahalle1!"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    When  A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 0
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor delivery time method set AcceptsFutureOrder "false"
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list DeliveryTimeOptions in basket checkout response
    And I select DeliveryTime with "<Id>" option in basket checkout response
    And I check "<Title>" "<Id>"  in delivery time options
    And I check "<Description>" "<Id>" in delivery time options
    Then I validate Future option does not exist in DeliveryTimeOptions
    And Staff update vendor delivery time method set "AcceptsFutureOrder" "true"

    Examples: Expected delivery Time Options
      |Id | Title |                  Description                       |
      | 1 | Hemen | Siparişiniz hazırlanıp hemen yola çıkarılacaktır.  |

  Scenario Outline: User can select delivery time as Future
    Given I am an authorized user with "mahalletestuser" "Mahalle1!"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    When  A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 0
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor delivery time method set "AcceptsFutureOrder" "true"
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list DeliveryTimeOptions in basket checkout response
    And I select DeliveryTime with "<Id>" option in basket checkout response
    And I check "<Title>" "<Id>"  in delivery time options
    And I check "<Description>" "<Id>" in delivery time options

    Examples: Expected delivery Time Options
      |Id |     Title     |                          Description                            |
      | 2 | İleri Tarihli | Sipariş, seçtiğiniz tarih ve saat aralığında size ulaşacaktır.  |

  Scenario Outline: User can list delivery time slots in Future Orders
    Given I am an authorized user with "mahalletestuser" "Mahalle1!"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    When  A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 0
    And Staff get selected vendor details from internal vendor service
    And Staff update vendor delivery time method set "AcceptsFutureOrder" "true"
    And Staff update vendor working days as all with "DeliveryInterval"
    And Staff get selected vendor's "IsCurrentSpan" "true" interval details
    #http://mahalle-api-stg.yemeksepeti.com/vendor/api/v1/vendor/{{VendorId}}/slots servisinden true dönen spain için
    # "StartHour" ve  "EndHour" birleştirilerek alınacak
    And Staff get selected vendor's following "IsCurrentSpan" "true" interval details
    #http://mahalle-api-stg.yemeksepeti.com/vendor/api/v1/vendor/{{VendorId}}/slots servisinden sonraki false dönen spain için
    # "StartHour" ve  "EndHour" birleştirilerek alınacak
    And Staff count selected vendor's "false" interval amount for each day span
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list DeliveryTimeOptions in basket checkout response
    And I select DeliveryTime with "<Id>" option in basket checkout response
    When I list Days "<Id>" in basket checkout response
    Then I select 1st "Day" with "<Id>" option in basket checkout response
    And I list "Text" values in "Hours" list of 1st day
    And I validate Current span does not exist in "Hours" list in basket checkout response
    And I validate "Hours" of 1st "Day" is the same with selected vendor's slot response
    Then I select 2nd "Day" with "<Id>" option in basket checkout response
    And I  list "Text" values in "Hours" of 2nd day
    And I validate "Hours" of 2nd "Day" is the same with selected vendor's slot response

    Examples: Expected delivery Time Options
      |Id |     Title     |                          Description                            |
      | 2 | İleri Tarihli | Sipariş, seçtiğiniz tarih ve saat aralığında size ulaşacaktır.  |