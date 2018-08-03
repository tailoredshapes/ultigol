Feature: A game starts dead
  If the player does nothing the game does nothing.

  TM: What does that mean?
  BA: We need a very simple environment to get us rolling. No real value. Don't over think it.

  Scenario: A cell starts dead
    Given we have a game:
    """
    0,0,0
    0,0,0
    0,0,0
    """
    Then the cell 0,0 should be dead
