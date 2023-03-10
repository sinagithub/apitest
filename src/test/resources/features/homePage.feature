@SmokeTest @HomePage @AllTest
Feature: Homepage Api controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address

  @TestRail(33329)
  Scenario: HomePage Vendor listing
    And A list of Carşı Vendor are available on home page
    #Then I check all carsı vendor image url status is 200
    Then I check all carsı vendor names is not empty

  @TestRail(33331)
  Scenario: HomePage Banner listing
    And  HomePage banners are available
    Then HomePage banners urls are valid
    #And HomePage banners OmnitureKeyword should not empty
    * HomePage banners deeplink url should not empty

  @TestRail(44533)
  Scenario: HomePage IsAllCategory Field Check According to Vendor Category
    When I list homepage categories
    Then I validate IsAllCategory parameter as true for Tümü category
    And I validate IsAllCategory parameter as false for except Tümü category
