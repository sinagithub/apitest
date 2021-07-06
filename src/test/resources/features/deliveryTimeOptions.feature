@SmokeTest @DeliveryTime
Feature: Delivery time controls in checkout

  Background: Login user
    Given I select city "TR_ISTANBUL"

  Scenario: User can list delivery time as Future
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And Staff get selected vendor details from internal vendor service
    And Staff create working pool for selected vendor
    And Staff select working day DayOfWeek 0, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 1, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 4, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 5, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 6, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff update vendor working days with selected times for deliveryInterval 120
    And Staff update vendor delivery time method set AcceptsFutureOrder "true"
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list DeliveryTimeOptions in basket checkout response
    And I check Title "İleri Tarihli" in future DeliveryTime option
    And I check Description "Sipariş, seçtiğiniz tarih ve saat aralığında size ulaşacaktır." in future DeliveryTime option
    And I check working day size is 8
    And I check available working day size is 6 or 5
    And Staff select working day DayOfWeek 0, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 1, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 2, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 3, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 4, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 5, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 6, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff update vendor working days with selected times for deliveryInterval 120

  Scenario: User can select delivery time as Now
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And Staff get selected vendor details from internal vendor service
    And Staff create working pool for selected vendor
    And Staff select working day DayOfWeek 0, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 1, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 4, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 5, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 6, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff update vendor working days with selected times for deliveryInterval 120
    And Staff update vendor delivery time method set AcceptsFutureOrder "true"
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list DeliveryTimeOptions in basket checkout response
    And I check Title "Hemen" in now DeliveryTime option
    And I check Description "Siparişiniz hazırlanıp hemen yola çıkarılacaktır." in now DeliveryTime option
    And Staff select working day DayOfWeek 0, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 1, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 2, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 3, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 4, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 5, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 6, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff update vendor working days with selected times for deliveryInterval 120

  Scenario: User can not list future time option when vendor doesn't allow future order
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
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
    And I check future option not exist in delivery time option list
    And Staff update vendor delivery time method set AcceptsFutureOrder "true"

  Scenario: User can list future delivery time slots
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    And Staff get selected vendor details from internal vendor service
    And Staff create working pool for selected vendor
    And Staff select vendor workday for only tomorrow StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff update vendor working days with selected times for deliveryInterval 120
    And Staff update vendor delivery time method set AcceptsFutureOrder "true"
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list DeliveryTimeOptions in basket checkout response
    Then I check future delivery option only enabled on tomorrow
    Then I check tomorrow delivery time all hours is enabled
    And Staff select working day DayOfWeek 0, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 1, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 2, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 3, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 4, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 5, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff select working day DayOfWeek 6, StartHour 10, StartMinute 0, EndHour 22, EndMinute 0
    And Staff update vendor working days with selected times for deliveryInterval 120

  Scenario: User can select delivery time as Now for banabi
    Given I am an authorized  user "Login"
    And  My addresses list should be available
    And  I select pinned available address
    And I get unique basket id
    When  Banabi Vendor is available
    Then I select banabi vendor
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    And I can add the selected product to basket quantity is 1
    When I get checkout options
    Then I list DeliveryTimeOptions in basket checkout response
    And I check Title "Hemen" in now DeliveryTime option
    And I check Description "Siparişiniz hazırlanıp hemen yola çıkarılacaktır." in now DeliveryTime option
    And I check future option not exist in delivery time option list