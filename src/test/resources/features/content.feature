@SmokeTest @Splash
Feature: Splash Api controls

  Background: Login user
    Given I am an authorized  user "Login"

  Scenario: User can list Operation Guide
    Given I select city "TR_ISTANBUL"
    When I can list operation guide
    Then I can validate operation guide is valid

  Scenario: User can list faq list
    Given I select city "TR_ISTANBUL"
    When I can list faq list
    Then I can validate faq is valid

  Scenario: User can list App about
    Given I select city "TR_ISTANBUL"
    When I can list about
    Then I can validate about is valid