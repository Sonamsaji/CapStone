Feature: Navigation Functionality

  Background:
    Given user opens website
    Then verify user lands on website

  Scenario: Apply discount offer on bus ticket booking
    When the user clicks on Offers from the navigation menu
    And the user clicks View Details button
    And clicks the Copy Code icon
    Then verify the message is displayed
