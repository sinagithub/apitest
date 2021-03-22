Feature: Splash Api controls

  Background: Login user
    Given I am an authorized  user "Login"

  @SmokeTest @Splash
  Scenario: Splash Vendor is active
    Given I select city "TR_ISTANBUL"
    When I get carsi vendor status
    Then Çarsı should be "True" on selected city
    And Çarsı info should be valid

  @SmokeTest @Splash
  Scenario: Splash Vendor is not active
    Given I select city "TR_ANKARA"
    When I get carsi vendor status
    Then Çarsı should be "False" on selected city
    And Çarsı info should be valid