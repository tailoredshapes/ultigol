package com.tailoredshapes;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class GameOfLifeTest {

    private Set<Coord> game;

    @Before
    public void setUp() {
        this.game = new HashSet<>();
    }

    @Test
    public void canTestIfACellIsAlive() {
        assertFalse(GameOfLife.isAlive(game, new Coord(0,0)));
    }

    @Test
    public void canBringACellToLife() {
        GameOfLife.bringToLife(game, new Coord(0,0));
        assertTrue(GameOfLife.isAlive(game, new Coord(0,0)));
        assertFalse(GameOfLife.isAlive(game, new Coord(0,1)));
    }

    @Test
    public void canKillACell() {
        GameOfLife.bringToLife(game, new Coord(0, 0));
        GameOfLife.kill(game, new Coord(0,0));

        assertFalse(GameOfLife.isAlive(game, new Coord(0, 0)));
    }

}