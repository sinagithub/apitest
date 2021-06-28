@SmokeTest @Coupon
Feature: Coupon controls in basket and user coupons menu

  Background: Login user
    Given I select city "TR_ISTANBUL"

  @Basket @Coupon
  Scenario: User can list created Fixed Discount Coupon with creating coupon name
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, ConstantCode "automation", UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is basket total, discount type is fixed discount"
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
    * I vaidate coupon name is valid in basket response
    * I validate coupon code is valid in basket response
    * I validate coupon IsOtpRequired is valid in basket response
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I check created coupon IsSelected value is "false"
    # Yazılacak
    #* Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging  createdUserId "1",createdUserName "automation"

  @Basket @IgnoreLive @Coupon
  Scenario: User can list created Fixed Discount Coupon without creating coupon name
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    * Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate, details "8d66ee87-ddbb-4593-bbf0-d11571ef49a0"
    # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 1
    * Staff select campaign Coupon with CreateCoupon "true", CouponCount 1, UsageLimit 1, prefixSuffix 1, constantCode "1"
    * Staff select  StateInfo "this campaign is created for all users, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
    When I navigate coupons
    Then I list Coupons in campaign coupons response
    * I validate created coupon is listed in campaign coupons response
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    * I validate campaign of created coupon is not listed in basket response
    * I check created coupon IsSelected value is "false"
    # Yazılacak
    * Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Basket @Coupon
  Scenario: User can add created Constant Price Coupon in basket
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 1, DiscountTypeId 3, DiscountValue 0
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is subtotal, discount type is constant price"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    * I add created coupon to basket
    * I validate selected coupon IsSelected is "true" in basket
    * I validate Total value in basket
    * Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Basket @Checkout @Coupon
  Scenario: User can not list used Fixed Discount Coupon in basket
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Stag get tag Id in tagging
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 2 user, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added couponstatus is 200
    * I validate basket
    Given I am an authorized user with "mahalletestuser2" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    * Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Basket @Coupon
  Scenario: User can not add used Fixed Discount Coupon in basket
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
      # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Stag get tag Id in tagging
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 2 user, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate basket
    * I check created coupon IsSelected value is "true"
    * I post checkout
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added coupon "CouponUsed" error message and status is 400
    Given I am an authorized user with "mahalletestuser2" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added couponstatus is 200
    * I validate basket
    * I check created coupon IsSelected value is "true"
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Basket @Coupon
  Scenario: User can not add usertag Fixed Discount Coupon when user id does not exist in tag list
    Given I am an authorized user with "mahalletestuser2" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added coupon "UserTagNotValid" error message and status is 400
    * I validate created coupon is not listed in basket response
    * Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Basket @Coupon
  Scenario: User can not add Constant Price Coupon when Vendor does not exist in target
    Given I am an authorized user with "mahalletestuser2" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 2, DiscountTypeId 3, DiscountValue 0
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 2, TargetId "876b5383-9876-43f1-89dc-80f2a6587b9c"
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 vendor, type is coupon, award type is delivery fee, discount type is constant price"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added coupon "VendorNotValid" error message and status is 400
    * I validate created coupon is not listed in basket response
    * Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Basket @Coupon
  Scenario: User not having OTP validation can not add coupon campaign to basket
    Given I am an authorized user with "testuser_noOTPValidation" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I can add the selected product to basket quantity is 20
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created coupon is not listed in basket response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "false" to basket
    * I validate added coupon "Kampanya kullanımı için OTP gerekli." error message and status is 400
    * I check created coupon campaign IsShown value is "true"
    * I Staff delete created campaign
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Coupon
  Scenario: User can list banabi and mahalle coupons in coupons page
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    And My addresses list should be available
    And I select pinned available address
    When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    # postman: Internal-APIS > Tagging > Post/api/v1/usertag

    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 2, DiscountTypeId 3, DiscountValue 1.9
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is delivery fee, discount type is constant price"
    * Staff create campaign in marketing
   # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
   # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
    When I navigate coupons
    Then I list Coupons in campaign coupons response
    * I validate created coupon is listed in campaign coupons response
    * I validate banabi coupon is listed in campaign coupons response
    * Staff delete created campaign in marketing
   # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Basket @Coupon
  Scenario: User can not add banabi coupon in mahalle when having banabi & mahalle coupons
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 2, DiscountTypeId 3, DiscountValue 1.9
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is delivery fee, discount type is constant price"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I navigate coupons
    Then I list Coupons in campaign coupons response
    * I validate banabi coupon is listed in campaign coupons response
    When I get the basket
    Then I list Campaigns in basket response
    * I validate banabi coupon is not listed in basket response
    * I add banabi campaign with PaymentMethodId "", UserHasOtpValidation "true" to basket
    * I validate added coupon "EKLENECEK" error message and status is 400
    * Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Basket @Coupon
  Scenario: User can add created Fixed Discount Compensation Coupon in basket
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 1
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "compensationCouponForAutomation"
    * Staff select StateInfo "this compensation coupon is created for all users, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Servisi yazılacak
    * Staff convert campaign to compensation coupon campaign in marketing
    # Postman -> Microservices > Marketing > post/api/v1/compensation
    * Staff create compensation coupon for user "8d66ee87-ddbb-4593-bbf0-d11571ef49a0" in marketing
    # Postman -> Microservices > Marketing > get/api/v1/compensation
    * Staff get created compensation campaign coupon id in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added couponstatus is 200
    * I validate basket
    * I check created coupon IsSelected value is "true"
    * I validate Total value in basket
    * Staff delete created campaign in marketing

  @Basket @Coupon
  Scenario: User can not add other users' Compensation Coupon in basket
    Given I am an authorized user with "mahalletestuser2" "automationtst135!"
    * My addresses list should be available* I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 1
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "compensationCouponForAutomation"
    * Staff select  StateInfo "this compensation coupon is created for all users, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    * Staff convert campaign to compensation coupon campaign in marketing
     # Postman -> Microservices > Marketing > post/api/v1/compensation
    * Staff create compensation coupon for user "8d66ee87-ddbb-4593-bbf0-d11571ef49a0" in marketing
    # Postman -> Microservices > Marketing > get/api/v1/compensation
    * Staff get created compensation campaign coupon id in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    When I navigate coupons
    Then I list Coupons in campaign coupons response
    * I validate created coupon is not listed in campaign coupons response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added coupon "CompensationCouponNotValid" error message and status is 400
    * Staff delete created campaign in marketing

  @Basket @Coupon
  Scenario: User can not add used Compensation Coupon in basket --- Error mesajı editlenecek
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 1
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "compensationCouponForAutomation"
    * Staff select  StateInfo "this compensation coupon is created for all users, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Servisi yazılacak
    * Staff convert campaign to compensation coupon campaign in marketing
     # Postman -> Microservices > Marketing > post/api/v1/compensation
    * Staff create compensation coupon for user "8d66ee87-ddbb-4593-bbf0-d11571ef49a0" in marketing
    # Postman -> Microservices > Marketing > get/api/v1/compensation
    * Staff get created compensation campaign coupon id in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added couponstatus is 200
    * I validate basket
    * I check created coupon IsSelected value is "true"
    * I post checkout
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added coupon "CompensationCouponNotValid" error message and status is 400
    * Staff delete created campaign in marketing

  @Basket @Coupon
  Scenario: User can not list but can use IsShownOnCheckout:false Fixed Discount Coupon in basket
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    * Staff create user tag name "IsShownOnCheckout:false coupon", description "IsShownOnCheckout:false coupon", createdUserId "1",createdUserName "automation", endDate, details "8d66ee87-ddbb-4593-bbf0-d11571ef49a0"
    # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "false", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "ShownOnCheckoutfalse"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
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
    * I validate created coupon is not listed in campaign coupons response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added couponstatus is 200
    * I validate basket
    * I validate selected coupon IsSelected is "true" in basket
    * I validate Total value in basket
    * Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging


  @Basket @Coupon
  Scenario: User can not list and can not use out of date Coupon in basket
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate

    # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "false", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "outOfDateCoupon"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
    * Staff manipulate created campaign EndDate "2021-06-18T15:21:59.931Z"
    When I navigate coupons
    Then I list Coupons in campaign coupons response
    * I validate created coupon is not listed in campaign coupons response
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
    * I validate created coupon is not listed in campaign coupons response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added coupon "CouponNotValid" error message and status is 400
    * I validate basket
    * I validate selected coupon IsSelected is "true" in basket
    * I validate Total value in basket
    * Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Basket @Coupon
  Scenario: User can not list and can not use permanently closed Campaign Coupon in basket
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate

    # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "false", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "outOfDateCoupon"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    # Postman -> Microservices > Marketing > get/api/v1/campaign/{campaignId}/coupon
    * Staff get created campaign coupon id in marketing
    * Staff manipulate created campaign Status "3"
    When I navigate coupons
    * I validate created coupon is not listed in campaign coupons response
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    Then I list Coupons in campaign coupons response
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    Then I list Coupons in campaign coupons response
    * I validate created coupon is not listed in campaign coupons response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added coupon "CouponNotValid" error message and status is 400
    * I validate basket
    * I validate selected coupon IsSelected is "true" in basket
    * I validate Total value in basket
    * Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Basket @Coupon
  Scenario: User can not list and can not use draft Campaign Coupon in basket
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate

    # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "false", StartDate, EndDate
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 10
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "outOfDateCoupon"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is basket total, discount type is fixed discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    * Staff get created campaign coupon id in marketing
    When I navigate coupons
    Then I list Coupons in campaign coupons response
    * I validate created coupon is not listed in campaign coupons response
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
    * I validate created coupon is not listed in campaign coupons response
    * I add created coupon Code, PaymentMethodId "3027292b-517b-495a-b14b-9ab0a18b73db", UserHasOtpValidation "true" to basket
    * I validate added coupon "CouponNotValid" error message and status is 400
    * I validate basket
    * I validate selected coupon IsSelected is "true" in basket
    * I validate Total value in basket
    * Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging

  @Basket @Coupon
  Scenario: User can delete added Subtotal %50 discount Coupon in basket
    Given I am an authorized user with "mahalletestuser1" "automationtst135!"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When A list of Carşı Vendor are available on home page
    Then I select vendor with payment method "3027292b-517b-495a-b14b-9ab0a18b73db"
    * Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate, details "8d66ee87-ddbb-4593-bbf0-d11571ef49a0"When Staff define users for tag creating
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    # postman: Internal-APIS > Tagging > Post/api/v1/usertag
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate
    * Staff select campaign Award with TypeId 1, DiscountTypeId 1, DiscountValue 50, MaxDiscountValue 200
    * Staff select campaign DescriptionTr with Title "", Description "", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=1"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value 20
    * Staff select campaign Targets with TypeId 4, TargetId
    * Staff select campaign Coupon with CreateCoupon "false", CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "userCouponForAutomation"
    * Staff select  StateInfo "this campaign is created for 1 user, type is coupon, award type is subtotal, discount type is percentage discount"
    # Postman -> Microservices > Marketing > post/api/v1/campaign
    * Staff create campaign in marketing
    # Postman -> Microservices > Marketing > put/api/v1/campaign/{campaignId}/activate
    * Staff activate created campaign in marketing
    * Staff get created campaign coupon id in marketing
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random product
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    * I add created coupon to basket
    * I validate selected coupon IsSelected is "true" in basket
    * I validate Total value in basket
    * I delete created coupon from basket
    * I validate selected coupon IsSelected is "false" in basket
    * I validate Total value in basket
    * Staff delete created campaign in marketing
    # postman: Internal-APIS > Tagging > delete/api/v1/usertag/{id}
    * Staff delete created tag in tagging