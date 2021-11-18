Feature: Stable patterns
  Scenario: Block
    Given we have a game:
      """life
      ....
      .00.
      .00.
      ....
      """
    When we advance the game
    Then the game state is:
      """life
      ....
      .00.
      .00.
      ....
      """

  Scenario: Behive
    Given we have a game:
      """life
      ......
      ..00..
      .0..0.
      ..00..
      ......
      """
    When we advance the game
    Then the game state is:
      """life
      ......
      ..00..
      .0..0.
      ..00..
      ......
      """

  Scenario: Loaf
    Given we have a game:
      """life
      ......
      ..00..
      .0..0.
      ..0.0.
      ...0..
      ......
      """
    When we advance the game
    Then the game state is:
      """life
      ......
      ..00..
      .0..0.
      ..0.0.
      ...0..
      ......
      """

  Scenario: Tub
    Given we have a game:
      """life
      .....
      ..0..
      .0.0.
      ..0..
      .....
      """
    When we advance the game
    Then the game state is:
      """life
      .....
      ..0..
      .0.0.
      ..0..
      .....
      """
