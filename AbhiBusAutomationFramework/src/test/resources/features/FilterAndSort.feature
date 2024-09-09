Feature: Validation of bus search filters
  Background:
    Given user opens website
    Then verify user lands on website
    When user enters from and to station
    And user set date
    And click on search button
    Then verify user is displayed with correct search results

  Scenario Outline: validation of price drop filter
    When user clicks on price drop filter
    Then verify price drop results are displayed
    When user clicks on "<bus type>" filter
    Then verify "<bus type>" results are displayed

    Examples:
      | bus type  |
      | AC        |
      | Sleeper   |

  Scenario: validation of sort by price
    When user click on sort by price
    Then verify buses are sorted by price

  Scenario: validation of sort by seats
    When user clicks on sort by seats
    Then verify buses are sorted by seats

  Scenario: validation of sort by ratings
    When user clicks on sort by rating
    Then verify buses are sorted by rating

  Scenario: validation of sort by arrival time
    When user clicks on sort by arrival time
    Then verify buses are sorted by its arrival time

  Scenario: validation of sort by departure time
    When user clicks on sort by departure time
    Then verify buses are sorted by its departure time
