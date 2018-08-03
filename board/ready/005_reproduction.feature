Feature: Reproduction
  Our final rule! If a dead cell has exactly 3 living neighbours it comes to life

  Scenario: Reproduction
    Given we have a game:
      """
      0,0,0,0
      0,X,X,0
      0,X,0,0
      0,0,0,0
      """
    When we advance the game
    Then the game state is:
      """
      0,0,0,0
      0,X,X,0
      0,X,X,0
      0,0,0,0
      """