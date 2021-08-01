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
}
