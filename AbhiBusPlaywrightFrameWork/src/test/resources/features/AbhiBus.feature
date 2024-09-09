Feature: Verify functionalities of AbhiBus

  Scenario:user able to search for Bus
    Given user opens website
    Then verify user lands on website
    When user enters from and to station
    And user set date
    And click on search button
    Then verify user is on search result page

  Scenario: swap button for to and from station in book bus tickets validation
    Given user opens website
    Then verify user lands on website
    When user enters from and to station
    And user clicks on swap button
    Then verify the to and from station places are swapped

  Scenario:sort by price
    Given user opens website
    Then verify user lands on website
    When user enters from and to station
    And user set date
    And click on search button
    Then verify user is on search result page
    When user click on sort by price
    Then verify buses are sorted by price