Feature: Booking Functionality

  Background:
    Given user opens website
    Then verify user lands on website

  Scenario: Verify RSRTC page navigation and seat are displaying
    When the user clicks on the RSRTC icon
    Then verify the user is on the RSRTC page
    When the user clicks on the select date option and selects a date
#    Then verify the user is getting results for the selected date
    When the user clicks on the Show Seats option
    Then verify the seats are displayed

  Scenario: Verify RSRTC page navigation and seat visibility toggle
    When the user clicks on the RSRTC icon
    Then verify the user is on the RSRTC page
    When the user clicks on the select date option and selects a date
#    Then verify the user is getting results for the selected date
    When the user clicks on the Show Seats option
    Then verify the seats are displayed
    When the user clicks on Hide Seats
    Then verify the seats are hidden

  Scenario: Verify seat booking functionality on RSRTC page
    When the user clicks on the RSRTC icon
    Then verify the user is on the RSRTC page
    When the user clicks on the select date option and selects a date
#    Then verify the user is getting results for the selected date
    When the user clicks on the Show Seats option
    Then verify the seats are displayed
    Then the user selects a seat and check whether the seat is booked or not

  Scenario: Verify booking functionality
    When the user clicks on the RSRTC icon
    Then verify the user is on the RSRTC page
    When the user clicks on the select date option and selects a date
#    Then verify the user is getting results for the selected date
    When the user clicks on the Show Seats option
    When the user selects a seat and clicks the continue button
    And fills in the trip details and billing address
    And clicks on the continue to pay button
    Then verify the payment page is loading

