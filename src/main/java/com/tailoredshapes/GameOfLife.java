package com.tailoredshapes;

import java.util.Set;

import static com.tailoredshapes.underbar.UnderBar.reduce;

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

    public static Coord minCoord(Set<Coord> game){
        return reduce(game, new Coord(0,0), (current, value) ->
            new Coord(
                    current.X < value.X ? current.X : value.X,
                    current.Y < value.Y ? current.Y : value.Y
            )
        );
    }

    public static Coord maxCoord(Set<Coord> game){
        return reduce(game, new Coord(0,0), (current, value) ->
                new Coord(
                        current.X > value.X ? current.X : value.X,
                        current.Y > value.Y ? current.Y : value.Y
                )
        );
    }

    public static String stringify(Set<Coord> game) {
        Coord min = minCoord(game);
        Coord max = maxCoord(game);

        StringBuilder bob = new StringBuilder();

        for(int x = min.X; x < max.X; x++){
            for(int y = min.Y; y < max.Y; y++){
                bob.append(isAlive(game, new Coord(x,y)) ? "X," : "0,");
            }
            bob.append("\n");
        }
        return bob.toString();
    }
}
