Feature: Main game
  Scenario: A cell starts dead
   Given we have a game:
    """
    0,0,0
    0,0,0
    0,0,0
    """
    Then the cell 0,0 should be dead

  Scenario: A cell can be bought to life
    Given we have a game:
      """
      X,0,0
      0,0,0
      0,0,0
      """
    Then the cell 0,0 should be alive
     And the cell 0,1 should be dead

  Scenario: Loneliness
    Given we have a game:
      """
      X,0,0
      0,0,0
      0,0,0
      """
     When we advance the game
     Then the cell 0,0 should be dead

  Scenario: Survival with 2 neighbours
    Given we have a game:
      """
      X,X,X
      """
     When we advance the game
     Then the game state is:
      """
      0,X,0
      """


  Scenario: Overpopulation and survival with 3 neighbours
    Given we have a game:
      """
      X,X,X
      X,X,X
      X,X,X
      """
    When we advance the game
    Then the game state is:
      """
      X,0,X
      0,0,0
      X,0,X
      """

  Scenario: Reproduction
    Given we have a game:
      """
      X,X,0
      X,0,0
      0,0,0
      """
     When we advance the game
     Then the game state is:
      """
      X,X,0
      X,X,0
      0,0,0
      """
