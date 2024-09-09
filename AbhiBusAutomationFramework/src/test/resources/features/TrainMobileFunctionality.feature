Feature: Train Booking

  Background:
    Given user opens website
    Then verify user lands on website

  Scenario: Successful Train Search
    When the user clicks on the Train Booking option
    Then the user should be on the Train Booking page
    When the user enters the source station
    And the user enters the destination station
    And the user clicks the Search button
    Then the user should be on the Train Results page

  Scenario: Validate dates are showing correctly
    When the user clicks on the Train Booking option
    Then the user should be on the Train Booking page
    And the user clicks the today button
    Then verify today's date is showing
    And the user clicks the tomorrow date button
    Then verify tomorrow's date is showing
    And the user clicks the day after tomorrow date button
    Then verify the day after tomorrow's date is showing
