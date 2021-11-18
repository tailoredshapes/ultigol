package com.tailoredshapes;



import io.cucumber.java8.En;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.tailoredshapes.underbar.UnderBar.map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Stepdefs implements En {
    private Set<Coord> game;

    public Stepdefs() {
        DocStringType("life", Stepdefs::parseLife);

        Given("^we have a game:", (Set<Coord> game) -> this.game = game);

        When("^we advance the game$", () -> game = GameOfLife.next(this.game));

        Then("^the cell (\\d+),(\\d+) should be alive$", (Integer x, Integer y) -> assertTrue(new Coord(x,y) + " was incorrectly Dead", GameOfLife.isAlive(game, new Coord(x,y))));

        Then("^the cell (\\d+),(\\d+) should be dead$", (Integer x, Integer y) -> assertFalse(new Coord(x,y) + " was incorrectly Alive", GameOfLife.isAlive(game, new Coord(x,y))));

        Then("^the game state is:", (Set<Coord> processedState) -> {
            if(!game.equals(processedState)) {
                System.out.println("Expected: ");
                System.out.println(GameOfLife.stringify(processedState));
                System.out.println("Actual: ");
                System.out.println(GameOfLife.stringify(game));
                throw new Exception();
            }
        });
    }

    public static Set<Coord> parseLife(String docString){
        HashSet<Coord> game = new HashSet<>();
        String[] lines = docString.split("\n");

        List<char[]> state = map(lines, String::toCharArray);

        for(int x = 0; x < state.size(); x++){
            for(int y = 0; y < state.get(x).length; y++){
                if(state.get(x)[y] == '0' ){
                    game.add(new Coord(x,y));
                }
            }
        }
        return game;
    }
}
