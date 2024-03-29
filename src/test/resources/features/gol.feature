Feature: Main game
  Any live cell with fewer than two live neighbors dies, as if by under population.
  Any live cell with two or three live neighbors lives on to the next generation.
  Any live cell with more than three live neighbors dies, as if by overpopulation.
  Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

  Scenario: A cell starts dead
   Given we have a game:
    """life
    ...
    ...
    ...
    """
    Then the cell 0,0 should be dead

  Scenario: A cell can be bought to life
    Given we have a game:
      """life
      0..
      ...
      ...
      """
    Then the cell 0,0 should be alive
     And the cell 0,1 should be dead

  Scenario: Loneliness
    Given we have a game:
      """life
      0..
      ...
      ...
      """
     When we advance the game
     Then the cell 0,0 should be dead

  Scenario: Survival with 2 neighbours and a little reproduction
    Given we have a game:
      """life
      .....
      .000.
      .....
      """
     When we advance the game
     Then the game state is:
      """life
      ..0..
      ..0..
      ..0..
      """


  Scenario: Explode
    Given we have a game:
      """life
      .....
      .000.
      .000.
      .000.
      .....
      """
    When we advance the game
    Then the game state is:
      """life
      ..0..
      .0.0.
      0...0
      .0.0.
      ..0..
      """

  Scenario: Reproduction
    Given we have a game:
      """life
      00.
      0..
      ...
      """
     When we advance the game
     Then the game state is:
      """life
      00.
      00.
      ...
      """
