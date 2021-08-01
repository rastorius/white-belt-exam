package com.kata.tictactoe;

import java.util.function.IntSupplier;

public class Bot {

    IntSupplier randomPositionSupplier;
    Game game;

    public Bot(IntSupplier intSupplier, Game game) {
        this.randomPositionSupplier = intSupplier;
        this.game = game;
    }

    public void printResult() {

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
        if (game.getStatus() == Status.X_NEXT) {
            System.out.println("Player X:");
        }
        if (game.getStatus() == Status.O_NEXT) {
            System.out.println("Player O:");
        }
        game.placeMark(position);
        game.print();
    }

    public int getMarkPosition() {
        return randomPositionSupplier.getAsInt();
    }
}
