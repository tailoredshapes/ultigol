package com.tailoredshapes;

import cucumber.api.java8.En;

import java.util.List;
import java.util.Set;

import static com.tailoredshapes.underbar.UnderBar.map;
import static com.tailoredshapes.underbar.UnderBar.set;
import static org.junit.Assert.assertFalse;

public class Stepdefs implements En{
    Set<Coord> game;

    public Stepdefs() {

        Given("we have a game:", (String docString) -> {
            game = processCSV(docString);
        });


        Then("^the cell (\\d+),(\\d+) should be dead$", (Integer x, Integer y) -> {
            assertFalse(Game.isAlive(game, x, y));
        });
    }
    public static Set<Coord> processCSV(String csv) {
        Set<Coord> game = set();

        String[] rows = csv.split("\n");
        List<String[]> cells = map(rows, (row) -> row.split(","));

        for (int x = 0; x < cells.size(); x++) {
            for (int y = 0; y < cells.get(x).length; y++) {
                if (cells.get(x)[y].equals("X")) {
                    game.add(new Coord(x, y));
                }
            }
        }
        return game;
    }
}
