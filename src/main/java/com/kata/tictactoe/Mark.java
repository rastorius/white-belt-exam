package com.kata.tictactoe;

public enum Mark {
    X("X"), O("O"), EMPTY(" ");

    private final String value;

    Mark(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
