Feature: Survival
  Its rough out there for a cell. But if you have 2 or 3 neighbours you get to live!

  Scenario: Survival with 2 neighbours
    Given we have a game:
      """
      0,0,0,0,0
      0,X,X,X,0
      0,0,0,0,0
      """
    When we advance the game
    Then the game state is:
      """
      0,0,0,0,0
      0,0,X,0,0
      0,0,0,0,0
      """


  Scenario: Survival with 3 neighbours
    Given we have a game:
      """
      0,0,0,0,0
      0,0,X,0,0
      0,X,X,X,0
      0,0,0,0,0
      """
    When we advance the game
    Then the game state is:
      """
      0,0,0,0,0
      0,0,X,0,0
      0,X,X,X,0
      0,0,0,0,0
      """