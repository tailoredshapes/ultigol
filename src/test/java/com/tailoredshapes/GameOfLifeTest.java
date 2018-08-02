package com.tailoredshapes;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.tailoredshapes.underbar.UnderBar.set;
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

    @Test
    public void canCountLivingNeighbours() {
        game = set(
                new Coord(1, 1),
                new Coord(0,1),
                new Coord(0,0),
                new Coord(1,0));

        assertEquals(3, GameOfLife.countNeighbours(game, new Coord(1,1)));
        assertEquals(2, GameOfLife.countNeighbours(game, new Coord(2,1)));
    }

}