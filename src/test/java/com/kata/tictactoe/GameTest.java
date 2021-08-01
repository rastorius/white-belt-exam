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

        // when
        game.placeMark(0);

        // then
        assertThat(game.getStatus()).isEqualTo(Status.O_NEXT);
    }
}
