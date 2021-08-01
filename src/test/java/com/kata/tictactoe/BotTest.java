package com.kata.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class BotTest {

    @Test
    @DisplayName("Mark placement should be random")
    void givenRandomNumberSupplier_whenGetMarkPosition_thenShouldReturnSuppliedRandom() {
        // given
        int expectedPosition = 0;

        IntSupplier intSupplier = mock(IntSupplier.class);
        when(intSupplier.getAsInt()).thenReturn(expectedPosition);

        Bot bot = new Bot(intSupplier, new Game());

        // when
        int position = bot.getMarkPosition();

        // then
        assertThat(position).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("Marked field should not be marked again")
    void givenOccupiedPosition_whenMark_thenShouldGenerateANewOne() {
        // given
        Game game = new Game();
        game.placeMark(0);

        IntSupplier intSupplier = mock(IntSupplier.class);
        when(intSupplier.getAsInt()).thenReturn(0).thenReturn(1);

        Bot bot = new Bot(intSupplier, game);

        // when
        bot.mark();

        // then
        verify(intSupplier, times(2)).getAsInt();
    }
}
