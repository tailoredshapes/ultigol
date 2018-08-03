Feature: Loneliness
  Now that we control life and death, lets introduce some rules! We're going to simulate loneliness

  First introduction to the notion of a turn.

  Scenario: Loneliness
    Given we have a game:
      """
      X,0,0
      0,0,0
      0,0,0
      """
    When we advance the game
    Then the cell 0,0 should be dead