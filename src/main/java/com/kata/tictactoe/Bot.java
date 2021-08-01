package com.kata.tictactoe;

import java.util.function.IntSupplier;

public class Bot {

    IntSupplier randomPositionSupplier;
    Game game;

    public Bot(IntSupplier intSupplier, Game game) {
        this.randomPositionSupplier = intSupplier;
        this.game = game;
    }

    public void printInit() {
        System.out.println("Game Board Creation...");
        game.print();
        System.out.println("Board Created.");
        System.out.println("The game will start with player X");
    }

    public void mark() {
        int position = randomPositionSupplier.getAsInt();
        while (!game.canMark(position)) {
            position = randomPositionSupplier.getAsInt();
        }
        game.placeMark(position);
    }

    public int getMarkPosition() {
        return randomPositionSupplier.getAsInt();
    }
}
