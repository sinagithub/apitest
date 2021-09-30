@SmokeTest @Campaign @AllTest
Feature: Campaign Controls

  Background: Login user
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    * Staff update active campaigns status to passive

  Scenario: User Can list campaign banners on home page
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation campaign tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "true"
    * Staff select campaign isShownOnHomePage is "true"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/static/discount.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "10"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select StateInfo "this campaign is created for selected tag, type is general, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When HomePage banners are available
    Then I check created campaign banner listed and url is valid on home page banners

  @Basket @Campaign
  Scenario: User can list created General Fixed Discount campaign with OTP required value is false in basket
    Given I am an authorized user with "testuser_noOTPValidation" "123456"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 79c4ac62-0de9-43ef-80df-dee2941b8951 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "false", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/campaign.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user, type is general, award type is basket total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is listed in basket response
    * I validate created name is valid in basket response
    * I validate campaign IsOtpRequired is valid in basket response
    * I validate calculated Total value for DiscountType is FixedDiscount and AwardType is Total in basket -- for Campaign
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Campaign
  Scenario: User can list created General Constant Price campaign with OTP required value is false in basket
    Given I am an authorized user with "testuser_noOTPValidation" "123456"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 79c4ac62-0de9-43ef-80df-dee2941b8951 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "false", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 1, DiscountTypeId 3, DiscountValue 5, MaxDiscountValue 5
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/campaign.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user, type is general, award type is basket total, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is listed in basket response
    * I validate created name is valid in basket response
    * I validate campaign IsOtpRequired is valid in basket response
    * I validate calculated Total value for DiscountType is ConstantPrice and AwardType is Total in basket -- for campaign
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Campaign
  Scenario: User can list created General Fixed Discount campaign with OTP required value is true in basket
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "false", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/campaign.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user, type is general, award type is basket total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is listed in basket response
    * I validate created name is valid in basket response
    * I validate campaign IsOtpRequired is valid in basket response
    * I validate calculated Total value for DiscountType is FixedDiscount and AwardType is Total in basket -- for Campaign
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Campaign
  Scenario: User can list created General Constant Price campaign with OTP required value is true in basket
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "false", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 1, DiscountTypeId 3, DiscountValue 5, MaxDiscountValue 5
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/campaign.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user, type is general, award type is basket total, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is listed in basket response
    * I validate created name is valid in basket response
    * I validate campaign IsOtpRequired is valid in basket response
    * I validate calculated Total value for DiscountType is ConstantPrice and AwardType is Total in basket -- for campaign
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Campaign
  Scenario: User can list created General Constant Price  Vendor campaign with OTP required value is true in basket
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "false", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 1, DiscountTypeId 3, DiscountValue 5, MaxDiscountValue 5
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/campaign.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff select campaign target TypeId of defined "de16d652-dae4-4cdd-9905-86c93a34b20d"
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user, type is general, award type is basket total, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is listed in basket response
    * I validate created name is valid in basket response
    * I validate campaign IsOtpRequired is valid in basket response
    * I validate calculated Total value for DiscountType is ConstantPrice and AwardType is Total in basket -- for campaign
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Campaign
  Scenario: User can not list created General Constant Price Vendor campaign with OTP required value is true in basket with different vendor
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    When A list of Carşı Vendor are available on home page
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "false", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 1, DiscountTypeId 3, DiscountValue 5, MaxDiscountValue 5
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/campaign.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff define vendor id list with home index for tag creation "defaultFirstVendor"
    * Staff select campaign target TypeId of defined Vendor index
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user, type is general, award type is basket total, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultSecondVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is not listed in basket response
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  Scenario: User can not list used Fixed Discount Campaign in basket
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * Staff update active campaigns status to passive
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestCampaign", UsageLimit 5, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://cdn.yemeksepeti.com/Labels/Promotion/eski_indirim_yuzde.png?v=9"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "1"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user, type is campaign, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is listed in basket response
    * I validate created image url is valid in basket response
    * I validate created name is valid in basket response
    * I validate campaign IsOtpRequired is valid in basket response
    * I add selected product until the basket amount is higher than minimum delivery price
    * I get checkout options
    When I set ContactlessDelivery is "false"
    Then I set paymentMethodId is "de2e3a82-8b55-4334-8a2e-467fe7f7db24", PaymentType : 2
    * I put basket to checkout LastChangedProperty is 2
    * I write user note "test-siparişi"
    * I set use point "false"
    *   I post checkout with selected options - checkout type is 1
    * I check checkout response is 200
    * I wait until new basket id is generated
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is not listed in basket response
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Campaign
  Scenario: User can not list created General Fixed Discount campaign when conditions are not met in basket
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "test user tag", description "test user tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/campaign.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "2000"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for all users, type is general, award type is basket total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is not listed in basket response
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Campaign
  Scenario: User can not list created General OTPRequired campaign when having no OTP confirmation
    Given I am an authorized user with "testuser_noOTPValidation" "123456"
    * My addresses list should be available
    * I select pinned available address
    * Staff update active campaigns status to passive
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/campaign.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for all users, type is general, award type is basket total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is not listed in basket response
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Basket @Campaign
  Scenario: User can not list draft Campaign in basket
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "true", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/campaign.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "2000"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for all users, type is general, award type is basket total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is not listed in basket response
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"


  @Basket @Campaign
  Scenario: User can not list used General Fixed VendorTag Discount campaign in Campaign Tab
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define vendors for tag creation
      | 2cf84108-9a0a-4147-ab73-33bff422b525 |
      | de16d652-dae4-4cdd-9905-86c93a34b20d |
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    Then Staff create vendor tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "false", IsOneTimePerUser "false", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/static/discount.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff select campaign target TypeId for created vendor tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user and 2 vendor, type is general, award type is basket total, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When A list of Carşı Vendor are available on home page
    Then I get unique basket id
    And I delete basket
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is listed in basket response
    * I validate created image url is valid in basket response
    * I validate created name is valid in basket response
    * I validate campaign IsOtpRequired is valid in basket response
    * I add selected product until the basket amount is higher than minimum delivery price
    * I get checkout options
    When I set ContactlessDelivery is "false"
    Then I set paymentMethodId is "de2e3a82-8b55-4334-8a2e-467fe7f7db24", PaymentType : 2
    * I put basket to checkout LastChangedProperty is 2
    * I write user note "Pokemon Otomasyonu"
    * I set use point "false"
    * I post checkout with selected options - checkout type is 1
    * I check checkout response is 200
    * I wait until new basket id is generated
    Then I select mahalle vendor from defined vendors type is "defaultSecondVendor" on home page
    When I navigate selected vendor
    Then I choose "Atıştırmalık" product category from category list
    * I choose "Çikolata" sub category from sub category
    When I list the products from selected sub category
    Then I select a random available product from selected category
    * I add selected product until the basket amount is higher than minimum delivery price
    When I get the basket
    Then I list Campaigns in basket response
    * I validate created campaign is not listed in basket response
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"
    * Staff delete created vendor tag in tagging createdUserId "1",createdUserName "automation"


  @Campaign
  Scenario: User can list created General Constant Price Vendor campaign in Campaign Tab
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    Then A list of Carşı Vendor are available on home page
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "false", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 1, DiscountTypeId 3, DiscountValue 5, MaxDiscountValue 5
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/static/discount.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff define vendor id list with home index for tag creation "defaultFirstVendor"
    * Staff select campaign target TypeId of defined Vendor index
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user, type is general, award type is basket total, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    * I navigate campaign of "defaultFirstVendor"
    * I validate created campaign is listed in vendor campaigns response
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Campaign
  Scenario: User can list created General Fixed Discount campaign in Campaign Tab
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    When Staff create target poll
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "false", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/static/discount.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user, type is general, award type is basket total, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    Then I list Campaigns in campaign response
    * I validate created campaign is listed in campaign response
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"

  @Campaign
  Scenario: User can list created General Constant Price VendorTag campaign in Campaign Tab
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * A list of Carşı Vendor are available on home page
    When Staff create target poll
    Then Staff define vendors for tag creation
      | 2cf84108-9a0a-4147-ab73-33bff422b525 |
      | de16d652-dae4-4cdd-9905-86c93a34b20d |
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff create vendor tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "false", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 1, DiscountTypeId 3, DiscountValue 5, MaxDiscountValue 5
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/static/discount.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff select campaign target TypeId for created vendor tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user and 2 vendor, type is general, award type is basket total, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    Then I list Campaigns in campaign response
    * I navigate campaign of "defaultFirstVendor"
    * I validate created campaign is listed in vendor campaigns response
    * I navigate campaign of "defaultSecondVendor"
    * I validate created campaign is listed in vendor campaigns response
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"
    * Staff delete created vendor tag in tagging createdUserId "1",createdUserName "automation"

  @Campaign
  Scenario: User can list created General Fixed VendorTag Discount campaign in Campaign Tab
    Given I am an authorized user with "mahalletestuser1" "123456"
    * My addresses list should be available
    * I select pinned available address
    * A list of Carşı Vendor are available on home page
    When Staff create target poll
    Then Staff define vendors for tag creation
      | 2cf84108-9a0a-4147-ab73-33bff422b525 |
      | de16d652-dae4-4cdd-9905-86c93a34b20d |
    Then Staff define users for tag creation
      | 8d66ee87-ddbb-4593-bbf0-d11571ef49a0 |
    Then Staff create user tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff create vendor tag name "Automation tag", description "Automation tag", createdUserId "1",createdUserName "automation", endDate
    * Staff select Campaign with Name "AutomationTestGeneralCampaign", UsageLimit 1, IsOtpRequired "false", IsOneTimePerUser "true", IsCouponRequired "false", IsShownOnCheckout "false", StartDate, EndDate, IsShownOnHomePage "false"
    * Staff select campaign Award with TypeId 3, DiscountTypeId 2, DiscountValue 10, MaxDiscountValue 10
    * Staff select campaign DescriptionTr with Title "AutomationTestCampaign", Description "AutomationTestCampaign", ImageUrl "https://mahalle-cdn.yemeksepeti.com/campaign/static/discount.png"
    * Staff select campaign Conditions with TypeId 1, OperatorTypeId 5, Value "5"
    * Staff select campaign target TypeId for created user tag
    * Staff select campaign target TypeId for created vendor tag
    * Staff set selected targets
    * Staff select Coupon for campaigns (empty)
    * Staff select StateInfo "this campaign is created for 1 user and 2 vendor, type is general, award type is basket total, discount type is constant price"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    Then I navigate campaign of "defaultFirstVendor"
    * I validate created campaign is listed in vendor campaigns response
    * Staff delete created campaign in marketing
    * Staff delete created user tag in tagging createdUserId "1",createdUserName "automation"
    * Staff delete created vendor tag in tagging createdUserId "1",createdUserName "automation"
