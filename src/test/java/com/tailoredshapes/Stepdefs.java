package com.tailoredshapes;


import io.cucumber.datatable.DataTable;
import io.cucumber.docstring.DocString;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.tailoredshapes.underbar.UnderBar.map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Stepdefs{
    private Set<Coord> game;

    @Given("^we have a game:")
    public void we_have_a_game(DocString game){
        this.game = processCSVGame(game.getContent());
    }

    @When("^we advance the game$")
    public void we_advance_the_game(){
        game = GameOfLife.next(this.game);
    }

    @Then("^the cell (\\d+),(\\d+) should be alive$")
    public void the_cell_should_be_alive(Integer x, Integer y){
        assertTrue(new Coord(x,y) + " was incorrectly Dead", GameOfLife.isAlive(game, new Coord(x,y)));
    }

    @Then("^the cell (\\d+),(\\d+) should be dead$")
    public void the_cell_should_be_dead(Integer x, Integer y){
        assertFalse(new Coord(x,y) + " was incorrectly Alive", GameOfLife.isAlive(game, new Coord(x,y)));
    }

    @Then("^the game state is:")
    public void the_game_state_is(DocString state) throws Exception{
        Set<Coord> processedState = processCSVGame(state.getContent());

            if(!game.equals(processedState)) {
                System.out.println("Expected: ");
                System.out.println(GameOfLife.stringify(processedState));
                System.out.println("Actual: ");
                System.out.println(GameOfLife.stringify(game));
                throw new Exception();
            }
    }

    public static Set<Coord> processCSVGame(String csv){
        HashSet<Coord> game = new HashSet<>();
        String[] lines = csv.split("\n");
        List<String[]> state = map(lines, (line) -> line.split(","));
        for(int x = 0; x < state.size(); x++){
            for(int y = 0; y < state.get(x).length; y++){
                if(state.get(x)[y].equals("X")){
                    game.add(new Coord(x,y));
                }
            }
        }
        return game;
    }
}
