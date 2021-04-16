@Basket
Feature: Basket Controls

  Background: Login and Address Listing
    Given I select city "TR_ISTANBUL"
    And I am an authorized  user "Login"
    And  My addresses list should be available
    When  I select pinned available address

  Scenario: User can get basket id : every time same id
    Then I get unique basket id
    And I can get basket id : same old basket id

