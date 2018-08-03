Feature: A game starts dead
  If the player does nothing the game does nothing

  Scenario: A cell starts dead
    Given we have a game:
    """
    0,0,0
    0,0,0
    0,0,0
    """
    Then the cell 0,0 should be dead
