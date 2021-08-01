package com.kata.tictactoe;

import java.util.function.IntSupplier;

public class Bot {

    IntSupplier randomPositionSupplier;

    public Bot(IntSupplier intSupplier) {
        this.randomPositionSupplier = intSupplier;
    }

    public int getMarkPosition() {
       return randomPositionSupplier.getAsInt();
    }
}
