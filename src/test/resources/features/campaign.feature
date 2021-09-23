@SmokeTest @Campaign
Feature: Campaign Controls

  Background: Login user
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"

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
    * Staff update active campaigns status to passive
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
    * I validate created image url is valid in basket response
    * I validate created name is valid in basket response
    * I validate campaign IsOtpRequired is valid in basket response
    * I validate calculated Total value for DiscountType is FixedDiscount and AwardType is Total in basket -- for Campaign
    * Staff delete created campaign in marketing
    * Staff delete created tag in tagging createdUserId "1",createdUserName "automation"




