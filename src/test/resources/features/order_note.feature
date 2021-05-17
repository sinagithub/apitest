@SmokeTest @Splash
Feature: Order Api note controls

  Background: Login user
    Given I am an authorized new user

  Scenario: New User can validate order not is empty and can add Order note and can validate order note limit, order note title
    Given I select city "TR_ISTANBUL"
    When I get order notes
    Then I can validate order note list is empty
    And I can write order not with upper than max character 300
    When I get order notes
    Then I can validate order note list is empty
    When I can write order note with character count 0
    When I get order notes
    Then I can validate order note list is empty
    When I can write order note with character count 300
    When I get order notes
    Then I can validate added note is exist on order notes response
    Then I can validate added note created date is valid
    And Order can validate order title is saved with first 20 character
    When I can write order note with character count 300
    When I get order notes
    Then I can validate order note list size is 2

  Scenario: New User can not add order note upper than max limit 300
    Given I select city "TR_ISTANBUL"
    When I get order notes
    Then I can validate order note list is empty
    And I can write order not with upper than max character 300
    When I get order notes
    Then I can validate order note list is empty
    And  I can validate order note response status code is 500
