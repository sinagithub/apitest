@SmokeTest @Splash
Feature: Splash Api controls

  Background: Login user
    Given I am an authorized  user "Login"

  Scenario: Splash Carsi is active
    Given I select city "TR_ISTANBUL"
    When I get carsi status
    Then Çarsı should be "True" on selected city
    And User carsi Logo url is valid
    And User check campaign id list are valid
    And User check campaign Seo list are valid
    And User check campaign ThumbImage list are valid

  Scenario: Splash Vendor is not active
    Given I select city "TR_ANKARA"
    When I get carsi status
    Then Çarsı should be "False" on selected city
    And User carsi Logo url is valid