package com.tailoredshapes;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class Stepdefs implements En{
    public Stepdefs() {
        Given("^we have a game:", (String game) -> {
            throw new PendingException();
        });

        When("^we advance the game$", () -> {
            throw new PendingException();
        });

        Then("^the cell (\\d+),(\\d+) should be alive$", (Integer x, Integer y) -> {
            throw new PendingException();
        });

        Then("^the cell (\\d+),(\\d+) should be dead$", (Integer x, Integer y) -> {
            throw new PendingException();
        });

        Then("^the game state is:", (String state) -> {
            throw new PendingException();
        });
    }
}
