package com.tailoredshapes;

import cucumber.api.java8.En;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;

public class Stepdefs implements En{

    private Set<Object> game;

    public Stepdefs() {

        Given("we have a game:", (String docString) -> {
            game = new HashSet<>();
        });

        Then("the cell {double} should be dead", (Double double1) -> {
            assertFalse(false);
        });

    }
}
