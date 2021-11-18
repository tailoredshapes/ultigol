package com.tailoredshapes;

import java.util.HashSet;
import java.util.Set;

import static com.tailoredshapes.underbar.UnderBar.map;
import static com.tailoredshapes.underbar.UnderBar.reduce;
import static com.tailoredshapes.underbar.UnderBar.set;

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
        HashSet<Coord> interestingCoordinates = reduce(
                map(game, GameOfLife::getNeighbours),
                new HashSet<>(),
                (s, cs) -> {
                    s.addAll(cs);
                    return s;
                });

        return reduce(interestingCoordinates, new HashSet<>(), (s, c) -> {
            int livingNeighbours = countNeighbours(game, c);
            switch (livingNeighbours) {
                case 2:
                    if(isAlive(game, c)) s.add(c);
                    return s;
                case 3:
                    s.add(c);
                    return s;
                default:
                    return s;
            }
        });
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
                bob.append(isAlive(game, new Coord(x,y)) ? "0" : ".");
            }
            bob.append("\n");
        }
        return bob.toString();
    }

    public static Set<Coord> getNeighbours(Coord coord){
        return set(
                new Coord(coord.X - 1, coord.Y - 1),
                new Coord(coord.X, coord.Y - 1),
                new Coord(coord.X + 1, coord.Y - 1),
                new Coord(coord.X + 1, coord.Y),
                new Coord(coord.X + 1, coord.Y + 1),
                new Coord(coord.X, coord.Y + 1),
                new Coord(coord.X - 1, coord.Y + 1),
                new Coord(coord.X - 1, coord.Y)
        );
    }

    public static int countNeighbours(Set<Coord> game, Coord coord) {
        return reduce(getNeighbours(coord), 0, (count, c) -> isAlive(game, c) ? ++count : count);
    }
}
