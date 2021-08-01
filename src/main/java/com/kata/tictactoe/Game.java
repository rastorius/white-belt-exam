package com.kata.tictactoe;

public class Game {
    Mark[] board = new Mark[]{Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY};
    private Status status = Status.X_NEXT;

    public void placeMark(int i) {
        if (status == Status.X_NEXT) {
            board[i] = Mark.X;
            status = Status.O_NEXT;
        } else if (status == Status.O_NEXT) {
            board[i] = Mark.O;
            status = Status.X_NEXT;
        }

        Mark winner = checkVerticalWin1();
        if (winner == Mark.EMPTY) {
            winner = checkVerticalWin2();
        }
        if (winner == Mark.EMPTY) {
            winner = checkVerticalWin3();
        }
        if (winner == Mark.EMPTY) {
            winner = checkHorizontalWin1();
        }
        if (winner == Mark.EMPTY) {
            winner = checkHorizontalWin2();
        }

        if (winner == Mark.X) {
            status = Status.X_WON;
        }
        if (winner == Mark.O) {
            status = Status.O_WON;
        }
    }

    private Mark checkHorizontalWin1() {
        if (board[0] == board[1] && board[1] == board[2]) {
            return board[0];
        } else {
            return Mark.EMPTY;
        }
    }

    private Mark checkHorizontalWin2() {
        if (board[3] == board[4] && board[4] == board[5]) {
            return board[3];
        } else {
            return Mark.EMPTY;
        }
    }

    private Mark checkVerticalWin1() {
        if (board[0] == board[3] && board[3] == board[6]) {
            return board[0];
        } else {
            return Mark.EMPTY;
        }
    }

    private Mark checkVerticalWin2() {
        if (board[1] == board[4] && board[4] == board[7]) {
            return board[1];
        } else {
            return Mark.EMPTY;
        }
    }

    private Mark checkVerticalWin3() {
        if (board[2] == board[5] && board[5] == board[8]) {
            return board[2];
        } else {
            return Mark.EMPTY;
        }
    }

    public Status getStatus() {
        return status;
    }


}
