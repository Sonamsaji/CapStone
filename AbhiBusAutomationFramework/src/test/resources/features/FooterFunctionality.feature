Feature: Footer Functionality

  Background:
    Given user opens website
    Then verify user lands on website

  Scenario: User navigates to the job description page
    When user clicks on the Careers icon in the footer
    Then verify user is on the Careers page
    And user clicks on any job title
#    Then verify user is on the job description page
    But if there are no job openings, print No job openings available


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

  Scenario: Validate FAQ item expansion on the FAQ page
    When the user clicks on the FAQ icon in the footer
    Then verify user lands on FAQ page
    When the user clicks the keydown symbol for a specific FAQ item
    Then keydown symbol should be in the active or expanded state


