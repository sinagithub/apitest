@SmokeTest @Coupon
Feature: Coupon controls in basket and user coupons menu

  Background: Login user
    Given I select city "TR_ISTANBUL"

  @Basket @Coupon
  Scenario: User can list created Fixed Discount Coupon with creating coupon name
     ## Pass ama kampanya silme eklenecek
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for selected tag, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When I list Coupons in campaign coupons response
    * I validate created coupon is listed in campaign coupons response
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    * I validate coupon image url is valid in basket response
    * I validate coupon name is valid in basket response
    * I validate coupon code is valid in basket response
    * I validate coupon IsOtpRequired is valid in basket response
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I validate created coupon IsSelected value is "false"
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @IgnoreLive @Coupon
  Scenario: User can list created Fixed Discount Coupon without creating coupon name
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "0"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon true, CouponCount 1, UsageLimit 1, prefixSuffix 1, constantCode "Test"
    * Staff select  StateInfo "this campaign is created for selected tag, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When I list Coupons in campaign coupons response
    * I validate created coupon is listed in campaign coupons response
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I validate created coupon IsSelected value is "false"
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon
  Scenario: User can add created Constant Price Coupon in basket
    ## Eksik Validasyon
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    * I delete basket
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 1, DiscountTypeId 3, DiscountValue 0, MaxDiscountValue 0
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is basket total, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I get coupon code with created campaign id
    * I validate created coupon is listed in basket response
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 200 and message is ""
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "true"
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
  #  * I validate calculated Total value for DiscountType is ConstantPrice and AwardType is Basket Total in basket
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon
  Scenario: User can add created Constant Price Delivery Fee Coupon in basket
    # Eksik delivery fee geliştirmesi bekliyor
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    * I delete basket
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 2, DiscountTypeId 3, DiscountValue 0, MaxDiscountValue 0
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is delifery fee, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "1", UserHasOtpValidation is "true"
    * I validate apply coupon status is 200 and message is ""
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "true"
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    #* I validate calculated delivery fee value for DiscountType is ConstantPrice and AwardType is Delivery Fee in basket
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Checkout @Coupon
  Scenario: User can not list and can not use used Fixed Discount Coupon in basket
    ## Basket not found ve validasyon hatası bekliyor
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=9"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 1
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 200 and message is ""
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "true"
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
  #  * I validate calculated SubTotal value for DiscountType is FixedDiscount and AwardType is SubTotal in basket
    * I get checkout options
    When I set ContactlessDelivery is "false"
    Then I set paymentMethodId is "de2e3a82-8b55-4334-8a2e-467fe7f7db24", PaymentType : 2 , BinNumber: 0 , IsApproved : "true"
    * I put basket to checkout LastChangedProperty is 2
    * I write user note "test-siparişi"
    * I set use point "false"
    * I post checkout with selected options - checkout type is 1
    * I check checkout response is 200
    * I get unique basket id
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "CouponUsed"
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon
  Scenario: User can not add usertag Fixed Discount Coupon when user id does not exist in tag list
    Given I am an authorized user with "mahalletestuser2" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    * Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=11"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "UserTagNotValid"
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon
  Scenario: User can not add Constant Price Coupon when Vendor does not exist in target
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    * I delete basket
    When A list of Carşı Vendor are available on home page
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff define vendor id list with home index for tag creation 0
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 2, DiscountTypeId 3, DiscountValue 0, MaxDiscountValue 0
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff select campaign target TypeId of defined Vendor index
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 vendor, type is coupon, award type is delivery fee, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I select Carsı vendor with order - 2
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "VendorNotValid"
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon
  Scenario: User not having OTP validation can not add coupon campaign to basket
    Given I am an authorized user with "testuser_noOTPValidation" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    Then Staff define users for tag creation
      | 79C4AC62-0DE9-43EF-80DF-DEE2941B8951 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=12"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "false"
    * I validate apply coupon status is 400 and message is "Kampanya kullanımı için OTP gerekli."
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Coupon
  Scenario: User can list banabi and mahalle coupons in coupons page
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    * I select Banabi platform
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    And Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 2, DiscountTypeId 3, DiscountValue 2, MaxDiscountValue 2
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=13"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is delivery fee, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    Then I list Coupons in campaign coupons response
    * I validate created coupon is listed in campaign coupons response
    * I validate coupon CampaignTitle is "20 TL Size Özel İndirim", Description is "Gönderim ücreti de dahil olmak üzere tüm sepet tutarınız üzerinden geçerli olacak indirim kuponunuzu dilediğiniz zaman kullanabilirsiniz.", ImageUrl is "https://cdn.banabi.com/images/campaign/fdc4d1c4-196d-445c-bc02-d007cd38d82b.png" is listed in campaign coupons response
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon
  Scenario: User can not add banabi coupon in mahalle when having banabi & mahalle coupons
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    Then I list Coupons in campaign coupons response
    When I get the basket
    Then I list Campaigns in basket response
    * I validate campaign is not listed campaign title is "20 TL Size Özel İndirim" in basket response
    * I apply campaign to basket campaign id is "109520" hasOtp is "true"
    * I validate apply campaign status is 404 and message is "NotFound"

  @Basket @Coupon
  Scenario: User can apply banabi coupon
    #Banabı kupon uygulama sorunu
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Banabi Vendor is available
    Then I select banabi vendor
    * I delete basket
    * I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    Then I list Coupons in campaign coupons response
    When I get the basket
    Then I list Campaigns in basket response
    * I validate campaign is not listed campaign title is "20 TL Size Özel İndirim" in basket response
    * I apply campaign to basket campaign id is "109520" hasOtp is "true"
    * I validate apply campaign status is 200 and message is ""

  @Basket @Coupon
  Scenario: User can add created Fixed Discount Compensation Coupon in basket
    #Validate adımı eksik
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "false", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 0
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=14"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for all users
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for all user, type is coupon, award type is delivery fee, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    * Staff convert campaign to compensation coupon campaign in marketing
    * Staff create compensation coupon for user id "8d66ee87-ddbb-4593-bbf0-d11571ef49a0" whose endDate is next 1 day in marketing
    * Staff get created compensation campaign coupon id in marketing
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I add created compensation coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "true"
    #* I validate calculated SubTotal value for DiscountType is FixedDiscount and AwardType is SubTotal in basket
    * Staff delete created campaign in marketing

  @Basket @Coupon
  Scenario: User can not add other users' Compensation Coupon in basket
     #Pass
    Given I am an authorized user with "mahalletestuser2" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "false", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 0
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=14"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for all users
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for all user, type is coupon, award type is delivery fee, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    * Staff convert campaign to compensation coupon campaign in marketing
    * Staff create compensation coupon for user id "8d66ee87-ddbb-4593-bbf0-d11571ef49a0" whose endDate is next 1 day in marketing
    * Staff get created compensation campaign coupon id in marketing
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "CouponNotValid"
    * Staff delete created campaign in marketing

  @Basket @Coupon
  Scenario: User can not add used Compensation Coupon in basket
     #basket_validation_error ve basket not found bekliyor
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "false", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 0
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=14"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for all users
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for all user, type is coupon, award type is delivery fee, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    * Staff convert campaign to compensation coupon campaign in marketing
    * Staff create compensation coupon for user id "8d66ee87-ddbb-4593-bbf0-d11571ef49a0" whose endDate is next 1 day in marketing
    * Staff get created compensation campaign coupon id in marketing
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created compensation coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 200 and message is ""
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "true"
    #* I validate calculated SubTotal value for DiscountType is FixedDiscount and AwardType is SubTotal in basket
    * I get checkout options
    When I set ContactlessDelivery is "false"
    Then I set paymentMethodId is "de2e3a82-8b55-4334-8a2e-467fe7f7db24", PaymentType : 2 , BinNumber: 0 , IsApproved : "true"
    * I put basket to checkout LastChangedProperty is 2
    * I write user note "test-siparişi"
    * I set use point "false"
    * I post checkout with selected options - checkout type is 1
    * I check checkout response is 200
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "CouponNotValid"
    * Staff delete created campaign in marketing

  @Basket @Coupon
  Scenario: User can not list but can use IsShownOnCheckout:false Fixed Discount Coupon in basket
    #Sub total bekliyor
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    * Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    * Staff create user tag name "IsShownOnCheckout:false coupon", description "IsShownOnCheckout:false coupon", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "false", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 4, Value "1"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "ShownOnCheckoutfalse"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    Then I list Coupons in campaign coupons response
    * I validate created coupon is not listed in basket response
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 200 and message is ""
    #* I validate calculated SubTotal value for DiscountType is FixedDiscount and AwardType is SubTotal in basket
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon
    #Pass
  Scenario: User can not list and can not use out of date Coupon in basket
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    When Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "false", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 4, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "ShownOnCheckoutfalse"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    * Staff Manipulate campaign status 4
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    Then I list Coupons in campaign coupons response
    * I validate created coupon is not listed in basket response
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "CouponNotValid"
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon
  Scenario: User can not list and can not use permanently closed Campaign Coupon in basket
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    When Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 4, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "ShownOnCheckoutfalse"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
     * Staff Manipulate campaign status 3
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "CouponNotValid"
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon
  Scenario: User can not list and can not use draft Campaign Coupon in basket
    #Pass
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "false", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 4, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "ShownOnCheckoutfalse"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    * I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "CouponNotValid"
    #* Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon
  Scenario: User can delete added Subtotal %50 discount Coupon in basket
    # Total kalmıs
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    * Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 1, DiscountTypeId 1, DiscountValue 50, MaxDiscountValue 200
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=18"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "3"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is basket total, discount type is percentage discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I select first vendor from "Super Market" category on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 200 and message is ""
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "true"
    #* I validate calculated Total value for DiscountType is Percentage and AwardType is Basket Total in basket
    * I delete created coupon from basket
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "false"
    * I validate calculated Total value when no campaign applied
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"
