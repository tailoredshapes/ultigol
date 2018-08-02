package com.tailoredshapes;

import java.util.Objects;

public class Coord {
    final int X, Y;

    public Coord(int x, int y) {
        X = x;
        Y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return X == coord.X &&
                Y == coord.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    @Override
    public String toString() {
        return "(" +
                X +
                ", " + Y +
                ')';
    }
}
