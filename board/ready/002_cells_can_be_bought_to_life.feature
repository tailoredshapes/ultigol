Feature: Life!
  Lets allow a little interaction. Players can bring a cell to life.

  Scenario: A cell can be bought to life
    Given we have a game:
      """
      X,0,0
      0,0,0
      0,0,0
      """
    Then the cell 0,0 should be alive
    And the cell 0,1 should be dead