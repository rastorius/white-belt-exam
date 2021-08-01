package com.kata.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @Test
    @DisplayName("First mark can only be X")
    void givenNewGame_whenGetStatus_thenStatusShouldBeXNext() {
        // given
        Game game = new Game();
        Status expectedStatus = Status.X_NEXT;

        // when
        Status status = game.getStatus();

        // then
        assertThat(status).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("After X the next mark should be O")
    void givenNewGame_whenPlaceMarkX_thenStatusShouldBeONext() {
        // given
        Game game = new Game();
        Status expectedStatus = Status.O_NEXT;

        // when
        game.placeMark(0);

        // then
        assertThat(game.getStatus()).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("After O the next mark should be X")
    void givenFirstMarkPlaced_whenPlaceMarkO_thenStatusShouldBeXNext() {
        // given
        Game game = new Game();
        game.placeMark(0);
        Status expectedStatus = Status.X_NEXT;

        // when
        game.placeMark(1);

        // then
        assertThat(game.getStatus()).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("Win #1 Vertical 1 - X")
    void givenWinningVertical1XMark_whenGetStatus_thenStatusShouldBeXWon() {
        // given
        Game game = new Game();
        game.placeMark(0);
        game.placeMark(1);
        game.placeMark(3);
        game.placeMark(4);
        game.placeMark(6);

        Status expectedStatus = Status.X_WON;

        // when
        Status status = game.getStatus();

        // then
        assertThat(status).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("Win #1 Vertical 1 - O")
    void givenWinningVertical1OMark_whenGetStatus_thenStatusShouldBeOWon() {
        // given
        Game game = new Game();
        game.placeMark(3);
        game.placeMark(0);
        game.placeMark(8);
        game.placeMark(3);
        game.placeMark(7);
        game.placeMark(6);

        Status expectedStatus = Status.O_WON;

        // when
        Status status = game.getStatus();

        // then
        assertThat(status).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("Win #2 Vertical 2")
    void givenWinningVertical2XMark_whenGetStatus_thenStatusShouldBeXWon() {
        // given
        Game game = new Game();
        game.placeMark(1);
        game.placeMark(2);
        game.placeMark(4);
        game.placeMark(6);
        game.placeMark(7);

        Status expectedStatus = Status.X_WON;

        // when
        Status status = game.getStatus();

        // then
        assertThat(status).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("Win #3 Vertical 3")
    void givenWinningVertical3XMark_whenGetStatus_thenStatusShouldBeXWon() {
        // given
        Game game = new Game();
        game.placeMark(2);
        game.placeMark(3);
        game.placeMark(5);
        game.placeMark(6);
        game.placeMark(8);

        Status expectedStatus = Status.X_WON;

        // when
        Status status = game.getStatus();

        // then
        assertThat(status).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("Win #4 Horizontal 1")
    void givenWinningHorizontal1XMark_whenGetStatus_thenStatusShouldBeXWon() {
        // given
        Game game = new Game();
        game.placeMark(0);
        game.placeMark(3);
        game.placeMark(1);
        game.placeMark(6);
        game.placeMark(2);

        Status expectedStatus = Status.X_WON;

        // when
        Status status = game.getStatus();

        // then
        assertThat(status).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("Win #5 Horizontal 2")
    void givenWinningHorizontal2XMark_whenGetStatus_thenStatusShouldBeXWon() {
        // given
        Game game = new Game();
        game.placeMark(3);
        game.placeMark(2);
        game.placeMark(4);
        game.placeMark(6);
        game.placeMark(5);

        Status expectedStatus = Status.X_WON;

        // when
        Status status = game.getStatus();

        // then
        assertThat(status).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("Win #6 Horizontal 3")
    void givenWinningHorizontal3XMark_whenGetStatus_thenStatusShouldBeXWon() {
        // given
        Game game = new Game();
        game.placeMark(6);
        game.placeMark(1);
        game.placeMark(7);
        game.placeMark(5);
        game.placeMark(8);

        Status expectedStatus = Status.X_WON;

        // when
        Status status = game.getStatus();

        // then
        assertThat(status).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("Win #7 Diagonal 1")
    void givenWinningDiagonal1XMark_whenGetStatus_thenStatusShouldBeXWon() {
        // given
        Game game = new Game();
        game.placeMark(0);
        game.placeMark(1);
        game.placeMark(4);
        game.placeMark(5);
        game.placeMark(8);

        Status expectedStatus = Status.X_WON;

        // when
        Status status = game.getStatus();

        // then
        assertThat(status).isEqualTo(expectedStatus);
    }
}
