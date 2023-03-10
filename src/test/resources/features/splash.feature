@SmokeTest @Splash @AllTest
Feature: Splash Api controls

  Background: Login user
    Given I am an authorized  user "Login"

  @TestRail(33332)
  Scenario Outline: Splash Carsi is active
    Given I select city "<cityCode>"
    When I get carsi status
    Then Çarsı should be "True" on selected city
    Examples:
      | cityCode    |
      | TR_ISTANBUL |
      | TR_IZMIR    |

  Scenario Outline: Splash Vendor is not active
    Given I select city "<cityCode>"
    When I get carsi status
    Then Çarsı should be "False" on selected city
    Examples:
      | cityCode   |
      | TR_BILECIK |
