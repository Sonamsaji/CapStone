Feature: train option Functionalities

  Background:
    Given user opens website
    Then verify user lands on website
    When the user clicks on Trains from the navigation menu
    Then verify the user is on the Train Ticket Booking page

  # Scenario checks that a list of trains is displayed when searching without filters.
  Scenario: Search for trains without applying filters
    And the user clicks the search button
    Then verify search result is displayed

    # Scenario checks that a filtered list of trains is displayed when filters are applied.
  Scenario: Search for trains and apply filters
    And the user clicks the search button
    Then verify search result is displayed
    And the user clicks on duration filter
    Then the filtered list of trains should be displayed correctly

  # Scenario checks that all filters work
  Scenario: Search for trains, apply filters
    And the user clicks the search button
    Then verify search result is displayed
    And the user applies some filters
    Then verify the filtered list of trains is displayed

    # Scenario checks that all filters are reset to default when the "Reset All" button is clicked.
  Scenario: Search for trains, apply filters, and reset filters
    And the user clicks the search button
    Then verify search result is displayed
    And the user applies some filters
    Then verify the filtered list of trains is displayed
    And the user clicks the Reset All button
    Then verify all filters are reset

