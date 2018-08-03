package com.tailoredshapes;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class Stepdefs implements En{
    public Stepdefs() {

        Given("we have a game:", (String docString) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        Then("the cell {double} should be dead", (Double double1) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

    }
}
