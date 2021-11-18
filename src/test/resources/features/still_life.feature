Feature: Stable patterns
  Scenario: Block
    Given we have a game:
      """world
      0,0,0,0
      0,X,X,0
      0,X,X,0
      0,0,0,0
      """
    When we advance the game
    Then the game state is:
      """world
      0,0,0,0
      0,X,X,0
      0,X,X,0
      0,0,0,0
      """

  Scenario: Behive
    Given we have a game:
      """world
      0,0,0,0,0,0
      0,0,X,X,0,0
      0,X,0,0,X,0
      0,0,X,X,0,0
      0,0,0,0,0,0
      """
    When we advance the game
    Then the game state is:
      """world
      0,0,0,0,0,0
      0,0,X,X,0,0
      0,X,0,0,X,0
      0,0,X,X,0,0
      0,0,0,0,0,0
      """

  Scenario: Loaf
    Given we have a game:
      """world
      0,0,0,0,0,0
      0,0,X,X,0,0
      0,X,0,0,X,0
      0,0,X,0,X,0
      0,0,0,X,0,0
      0,0,0,0,0,0
      """
    When we advance the game
    Then the game state is:
      """world
      0,0,0,0,0,0
      0,0,X,X,0,0
      0,X,0,0,X,0
      0,0,X,0,X,0
      0,0,0,X,0,0
      0,0,0,0,0,0
      """

  Scenario: Tub
    Given we have a game:
      """world
      0,0,0,0,0
      0,0,X,0,0
      0,X,0,X,0
      0,0,X,0,0
      0,0,0,0,0
      """
    When we advance the game
    Then the game state is:
      """world
      0,0,0,0,0
      0,0,X,0,0
      0,X,0,X,0
      0,0,X,0,0
      0,0,0,0,0
      """
