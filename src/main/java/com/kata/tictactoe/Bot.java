package com.kata.tictactoe;

import java.util.function.IntSupplier;

public class Bot {

    IntSupplier randomPositionSupplier;

    public Bot(IntSupplier intSupplier, Game game) {
        this.randomPositionSupplier = intSupplier;
    }

    public void mark() {

    }

    public int getMarkPosition() {
       return randomPositionSupplier.getAsInt();
    }
}
