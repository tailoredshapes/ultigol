package com.tailoredshapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordTest {

    @Test
    public void testToString() {
        assertEquals("(0,0)", new Coord(0,0).toString());
    }
}