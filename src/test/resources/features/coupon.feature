@SmokeTest @Coupon @AllTest
Feature: Coupon controls in basket and user coupons menu

  Background: Login user
    Given I select city "TR_ISTANBUL"
    When Staff update active campaigns status to passive

  @Basket @Coupon @TestRail(33373)
  Scenario: User can list created Fixed Discount Coupon with creating coupon name
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/static/discount.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "Automation"
    * Staff select StateInfo "this campaign is created for selected tag, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When I list Coupons in campaign coupons response
    * I validate created coupon is listed in campaign coupons response
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
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
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @IgnoreLive @Coupon @TestRail(33374)
  Scenario: User can list created Fixed Discount Coupon without creating coupon name
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/static/discount.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "0"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon true, CouponCount 1, UsageLimit 1, prefixSuffix 1, constantCode "Test"
    * Staff select StateInfo "this campaign is created for selected tag, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When I list Coupons in campaign coupons response
    * I validate created coupon is listed in campaign coupons response
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I validate created coupon IsSelected value is "false"
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon @TestRail(33375)
  Scenario: User can add created Constant Price Coupon in basket
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 1, DiscountTypeId 3, DiscountValue 10, MaxDiscountValue 0
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/static/discount.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "Automation"
    * Staff select StateInfo "this campaign is created for 1 user, type is coupon, award type is basket total, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I get coupon code with created campaign id
    * I validate created coupon is listed in basket response
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 200 and message is ""
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "true"
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I validate calculated Total value for DiscountType is ConstantPrice and AwardType is Total in basket -- for coupon
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Checkout @Coupon @TestRail(33376)
    #test1
  Scenario: User can not list and can not use used Fixed Discount Coupon in basket
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=9"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "Automation"
    * Staff select StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 200 and message is ""
    * I add selected product until the basket amount is higher than minimum delivery price
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "true"
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I get checkout options
    When I set ContactlessDelivery is "false"
    Then I set paymentMethodId is "de2e3a82-8b55-4334-8a2e-467fe7f7db24", PaymentType : 2
    * I put basket to checkout LastChangedProperty is 2
    * I write user note "test-sipari??i"
    * I set use point "false"
    * I post checkout with selected options - checkout type is 1
    * I check checkout response is 200
    * I wait until new basket id is generated
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "Bu kuponun kullan??m limiti dolmu??tur."
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon @TestRail(33377)
  Scenario: User can not add usertag Fixed Discount Coupon when user id does not exist in tag list
    Given I am an authorized user with "mahalletestuser2@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    * Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=11"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "Automation"
    * Staff select StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "Bu kupon kodu ge??ersizdir."
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon @TestRail(33378)
  Scenario: User can not add Constant Price Coupon when Vendor does not exist in target
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    When A list of Car???? Vendor are available on home page
    When Staff create target poll
    Then Staff define users for tag creation
      | 500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff define vendor id list with home index for tag creation "defaultFirstVendor"
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 2, DiscountTypeId 3, DiscountValue 0, MaxDiscountValue 0
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "2"
    * Staff select campaign target TypeId for created user tag
    * Staff select campaign target TypeId of defined Vendor index
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "Automation"
    * Staff select StateInfo "this campaign is created for 1 vendor, type is coupon, award type is delivery fee, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultSecondVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "Bu kupon kodu bu ma??aza i??in ge??erli de??ildir."
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon @TestRail(33379)
  Scenario: User not having OTP validation can not add coupon campaign to basket
    Given I am an authorized user with "mahalleNoOtp@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | c141657c-3067-4204-b45f-902ed7096483 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=12"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "Automation"
    * Staff select StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "false"
    * I validate apply coupon status is 400 and message is "Kuponu kullanabilmeniz i??in numaran??z?? do??rulaman??z gerekmektedir."
    Then I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon @TestRail(33383)
  Scenario: User can add created Fixed Discount Compensation Coupon in basket
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "false", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 0
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=14"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for all users
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "auto"
    * Staff select StateInfo "this campaign is created for all user, type is coupon, award type is delivery fee, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    * Staff convert campaign to compensation coupon campaign in marketing
    * Staff create compensation coupon for user id "500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe" whose endDate is next 1 day in marketing
    When A list of Car???? Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    * I get unique basket id
    * I delete basket
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
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
    * I validate calculated Total value for DiscountType is FixedDiscount and AwardType is Total in basket --For Coupon Cases
    * Staff delete created campaign in marketing

  @Basket @Coupon @TestRail(33384)
  Scenario: User can not add other users' Compensation Coupon in basket
    Given I am an authorized user with "mahalletestuser2@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "false", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 0
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=14"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for all users
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "auto"
    * Staff select StateInfo "this campaign is created for all user, type is coupon, award type is delivery fee, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    * Staff convert campaign to compensation coupon campaign in marketing
    * Staff create compensation coupon for user id "500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe" whose endDate is next 1 day in marketing
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    * I add created compensation coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "Bu kupon kodu ge??ersizdir."
    * Staff delete created campaign in marketing

  @Basket @Coupon @TestRail(33385)
  Scenario: User can not add used Compensation Coupon in basket
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "false", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 0
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=14"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for all users
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "auto"
    * Staff select StateInfo "this campaign is created for all user, type is coupon, award type is delivery fee, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    * Staff convert campaign to compensation coupon campaign in marketing
    * Staff create compensation coupon for user id "500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe" whose endDate is next 1 day in marketing
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created compensation coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 200 and message is ""
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "true"
    * I add selected product until the basket amount is higher than minimum delivery price
    * I get checkout options
    When I set ContactlessDelivery is "false"
    Then I set paymentMethodId is "de2e3a82-8b55-4334-8a2e-467fe7f7db24", PaymentType : 2
    * I put basket to checkout LastChangedProperty is 2
    * I write user note "test-sipari??i"
    * I set use point "false"
    * I post checkout with selected options - checkout type is 1
    * I check checkout response is 200
    * I wait until new basket id is generated
    When A list of Car???? Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I add created compensation coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "Bu kupon kodu ge??ersizdir."
    * Staff delete created campaign in marketing

  @Basket @Coupon @TestRail(33386)
  Scenario: User can not list but can use IsShownOnCheckout:false Fixed Discount Coupon in basket
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    * Staff define users for tag creation
      | 500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe |
    * Staff create user tag name "OnCheckout:FCoupon", description "IsShownOnCheckout:false coupon", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 4, Value "1"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "ShownOnCheckoutfalse"
    * Staff select StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    Then I list Coupons in campaign coupons response
    * I validate created coupon is not listed in basket response
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 200 and message is ""
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon @TestRail(33387)
  Scenario: User can not list and can not use out of date Coupon in basket
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    When Staff define users for tag creation
      | 500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 4, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "ShownOnCheckoutfalse"
    * Staff select StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    * Staff Manipulate campaign status 4
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    Then I list Coupons in campaign coupons response
    * I validate created coupon is not listed in basket response
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "Bu kupon kodu ge??ersizdir."
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon @TestRail(33388)
  Scenario: User can not list and can not use permanently closed Campaign Coupon in basket
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    * I get unique basket id
    When Staff create target poll
    Then Staff define users for tag creation
      | 500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 4, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "ShownOnCheckoutfalse"
    * Staff select StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    * Staff suspend created campaign
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "Bu kupon kodu ge??ersizdir."
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon @TestRail(33389)
  Scenario: User can not list and can not use draft Campaign Coupon in basket
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=8"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 4, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "ShownOnCheckoutfalse"
    * Staff select StateInfo "this campaign is created for 1 user, type is coupon, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is not listed in basket response
    * I list Campaigns in basket response
    * I validate campaign of created coupon is not listed in basket campaigns
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "Bu kupon kodu ge??ersizdir."
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon @TestRail(33390)
  Scenario: User can delete added Subtotal %50 discount Coupon in basket
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    * Staff define users for tag creation
      | 500e7e1c-b2ad-4cd1-8cdd-c1433040d6fe |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCouponCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "true", IsShownOnCheckout "true", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 1, DiscountTypeId 1, DiscountValue 50, MaxDiscountValue 200
    * Staff select campaign DescriptionTr with Title "AutomationTestCouponCampaign", Description "AutomationTestCouponCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=18"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "3"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select campaign Coupon with CreateCoupon false, CouponCount 1, prefixSuffix 0, UsageLimit 1, couponCode "auto"
    * Staff select StateInfo "this campaign is created for 1 user, type is coupon, award type is basket total, discount type is percentage discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Coupons in basket response
    * I validate created coupon is listed in basket response
    * I get coupon code with created campaign id
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 200 and message is ""
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "true"
    * I validate basket total original is valid for Percentage discount value is 50 in basket
    * I delete created coupon from basket
    * I get the basket
    * I list Coupons in basket response
    * I validate created coupon IsSelected value is "false"
    * I can check basket subTotal is valid on basket
    * I can check basket total is valid
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Coupon @TestRail(33390)
  Scenario: User can not add null coupon code in basket
    Given I am an authorized  user "Login"
    * My addresses list should be available
    * I select pinned available address
    When A list of Car???? Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Kedi" product category from category list
    * I choose "Kedi Mamas??" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    * I add created coupon to basket PaymentMethodId is "", UserHasOtpValidation is "true"
    * I validate apply coupon status is 400 and message is "Kupon kodu alan?? bo?? olamaz. L??tfen kupon kodunuzu giriniz."
