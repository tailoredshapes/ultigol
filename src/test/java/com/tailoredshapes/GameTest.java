package com.tailoredshapes;

import org.junit.Test;

import java.util.Set;

import static com.tailoredshapes.underbar.UnderBar.set;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void ifAValueIsMissingFromTheGameItIsPresumedDead() {
        Set<Coord> game = set();

        assertFalse(Game.isAlive(game, 0, 0));

    }

    @Test
    public void ifAValueIsPresentInTheGameItIsAlive() {
        Set<Coord> game = set();

        game.add(new Coord(0, 0));

        assertTrue(Game.isAlive(game, 0, 0));
        assertFalse(Game.isAlive(game, 0, 1));
    }
}