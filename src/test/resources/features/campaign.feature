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
    * Staff select  StateInfo "this campaign is created for selected tag, type is general, award type is sub total, discount type is fixed discount"
    * Staff create campaign in marketing with selected campaign info operation User email "api-automation@yemeksepeti.com"
    * Staff activate created campaign in marketing operation User email "api-automation@yemeksepeti.com"
    When HomePage banners are available
    Then I check created campaign banner listed and url is valid on home page banners


