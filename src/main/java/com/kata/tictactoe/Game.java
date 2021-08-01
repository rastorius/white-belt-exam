package com.kata.tictactoe;

public class Game {
    private Status status = Status.X_NEXT;

    public void placeMark(int i) {
        if(status == Status.X_NEXT) {
            status = Status.O_NEXT;
        } else if(status == Status.O_NEXT) {
            status = Status.X_NEXT;
        }
    }

    public Status getStatus() {
        return status;
    }
}