Feature: Account Functionality

  Background:
    Given user opens website
    Then verify user lands on website
    Given user clicks on account button

  Scenario:Validate cancel ticket with invalid data
    And click on cancel Booking option
    Then verify the user is on Cancel Booking page
    And user enters an invalid "ticketNumber" and "phoneNumber"
    Then verify an appropriate error message is displayed

  Scenario: Verify error message on invalid email submission
    When the user clicks on the feedback icon
    Then the user is navigated to the feedback page
    When the user enters a valid name
    And the user enters an invalid email address
    And clicks the submit button
    Then verify that an error message is displayed for the invalid email

  Scenario: Verify error message on invalid mobile number submission
    When the user clicks on the feedback icon
    Then the user is navigated to the feedback page
    When the user enters a valid name
    And the user enters an invalid mobile number
    And clicks the submit button
    Then verify that an error message is displayed for the invalid mobile number



