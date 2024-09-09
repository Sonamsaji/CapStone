Feature: Verify functionalities of AbhiBus

  Scenario:user able to search for Bus
    Given user opens website
    Then verify user lands on website
#    When user enters from and to station
#    And user set date
#    And click on search button
#    Then verify user is on search result page

  Scenario: swap button for to and from station in book bus tickets validation
    Given user opens website
    Then verify user lands on website
    When user enters from and to station
    And user clicks on swap button
    Then verify the to and from station places are swapped

    Scenario: validation of today button in book bus tickets
      Given user opens website
      Then verify user lands on website
      When user clicks on today
      Then verify todays date is displayed

  Scenario: tomorrow button in book bus tickets validation
    Given user opens website
    Then verify user lands on website
    When user clicks on tomorrow
    Then verify tomorrows date is displayed

  Scenario: validation of user clicking search without entering stations
    Given  user opens website
    Then verify user lands on website
    When click on search button
    Then verify user is displayed with error message for not entering station

    Scenario: validation of bus search result
      Given user opens website
      Then verify user lands on website
      When user enters from and to station
      And user set date
      And click on search button
      Then verify user is displayed with correct search results






