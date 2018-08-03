package com.tailoredshapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordTest {

    @Test
    public void testToString() {
        assertEquals("(0,0)", new Coord(0,0).toString());
    }

    @Test
    public void testEquality() {
        assertEquals(new Coord(0, 0), new Coord(0, 0));
    }
}