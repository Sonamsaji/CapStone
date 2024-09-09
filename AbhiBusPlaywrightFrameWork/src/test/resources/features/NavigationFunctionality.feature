Feature: Navigation Functionality

  Background:
    Given user opens website
    Then verify user lands on website

  Scenario: Apply discount offer on bus ticket booking
    When the user clicks on Offers from the navigation menu
    And the user clicks View Details button
    And clicks the Copy Code icon
    Then verify the message is displayed

  Scenario: Validate cancel ticket with invalid data
    When the user clicks on the Quick Links icon in the footer
    And the user clicks on the Cancel Booking option
    Then verify the user is on the Cancel Booking page
    And the user enters an invalid "ticketNumber" and "phoneNumber"
    Then verify an appropriate error message is displayed to the user

  Scenario: Validate chatbot functionality on the Cancel Booking page
    When the user clicks on the Quick Links icon in the footer
    And the user clicks on the Cancel Booking option
    Then verify the user is on the Cancel Booking page
    And the user enters an invalid "ticketNumber" and "phoneNumber"
    Then verify an appropriate error message is displayed to the user
    When the user clicks the chatbot icon
    Then verify the chatbot box loads successfully
