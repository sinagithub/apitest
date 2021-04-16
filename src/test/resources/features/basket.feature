@Basket
Feature: Basket Controls

  Scenario: User can get basket id : every time same id
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I check basket ıd is same than old basket id


  Scenario: User can get new basket id when area changed
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    Then I select pinned available address with order  2
    Then I can get new basket id
    And I check basket ıd is same than old basket id
