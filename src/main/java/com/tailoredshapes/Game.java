package com.tailoredshapes;

import java.util.Set;

public interface Game {
    static boolean isAlive(Set<Coord> game, Integer x, Integer y) {
        return game.contains(new Coord(x, y));
    }
}
