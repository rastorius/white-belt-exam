package com.kata.tictactoe;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntSupplier;

public class Bot {

    IntSupplier randomPositionSupplier;
    Game game;

    public Bot(IntSupplier intSupplier, Game game) {
        this.randomPositionSupplier = intSupplier;
        this.game = game;
    }

    public boolean isGameOn() {
        return game.getStatus() != Status.DRAW
                && game.getStatus() != Status.X_WON
                && game.getStatus() != Status.O_WON;
    }

    public void printResult() {
        if (game.getStatus() == Status.X_WON) {
            System.out.println("PLAYER X WON!");
        }
        if (game.getStatus() == Status.O_WON) {
            System.out.println("PLAYER O WON!");
        }
        if (game.getStatus() == Status.DRAW) {
            System.out.println("GAME ENDS WITH A DRAW!");
        }
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


    public static void main(String[] args) {
        IntSupplier sup = () -> ThreadLocalRandom.current().nextInt(0, 9);
        Game game = new Game();

        Bot bot = new Bot(sup, game);

        bot.printInit();

        while(bot.isGameOn()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bot.mark();

        }

        bot.printResult();
    }
}
