package com.kata.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BotTest {

    @Test
    @DisplayName("Mark placement should be random")
    void givenRandomNumberSupplier_whenGetMarkPosition_thenShouldReturnSuppliedRandom() {
        // given
        int expectedPosition = 0;

        IntSupplier intSupplier = mock(IntSupplier.class);
        when(intSupplier.getAsInt()).thenReturn(expectedPosition);

        Bot bot = new Bot(intSupplier);

        // when
        int position = bot.getMarkPosition();

        // then
        assertThat(position).isEqualTo(expectedPosition);
    }
}
