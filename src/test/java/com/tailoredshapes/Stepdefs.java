package com.tailoredshapes;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

import java.util.Set;

import static com.tailoredshapes.underbar.UnderBar.set;

public class Stepdefs implements En{
    public Stepdefs() {

        Given("we have a game:", (String docString) -> {
            Set<Coord> game = processCSV(docString);
            throw new PendingException();
        });


        Then("^the cell (\\d+),(\\d+) should be dead$", (Integer arg0, Integer arg1) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }

    public static Set<Coord> processCSV(String csv) {
        return set();
    }
}
