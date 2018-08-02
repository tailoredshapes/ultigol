package com.tailoredshapes;

import java.util.Set;

public class GameOfLife {

    public static boolean isAlive(Set<Coord> game, Coord coord) {
        return game.contains(coord);
    }

    public static Set<Coord> bringToLife(Set<Coord> game, Coord coord) {
        game.add(coord);
        return game;
    }

    public static Set<Coord> kill(Set<Coord> game, Coord coord) {
        game.remove(coord);
        return game;
    }

    public static Set<Coord> next(Set<Coord> game) {
        return game;
    }
}
