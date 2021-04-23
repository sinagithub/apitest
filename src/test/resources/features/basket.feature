@Basket
Feature: Basket Controls

  Scenario: User can get basket id : every time same id
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned address with id "{81cfbad7-36f9-455b-9204-0ea674b2406a}"
    Then I get unique basket id
    And I check basket ıd is same than old basket id


  Scenario: User can get new basket id when area changed
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned address with id "{af4c03a9-f84e-4522-aaac-99b9ef81454a}"
    Then I get unique basket id
    When  I select pinned address with id "{81cfbad7-36f9-455b-9204-0ea674b2406a}"
    Then I can get new basket id
    And I check basket ıd is same than old basket id