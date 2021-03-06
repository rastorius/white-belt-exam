package com.kata.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.IntSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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

    @Test
    @DisplayName("Initial state should be printed in the right format")
    void givenBot_whenPrintInit_thenShouldPrintInitialState() {
        // given
        IntSupplier intSupplier = mock(IntSupplier.class);
        Bot bot = new Bot(intSupplier, new Game());

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        String eol = System.lineSeparator();
        String expectedOutput =
                "Game Board Creation..." + eol +
                        " | | " + eol +
                        "-+-+-" + eol +
                        " | | " + eol +
                        "-+-+-" + eol +
                        " | | " + eol +
                        "Board Created." + eol +
                        "The game will start with player X" + eol;

        // when
        bot.printInit();

        // then
        assertThat(outContent.toString()).isEqualTo(expectedOutput);

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Print X placement should be printed in the right format")
    void givenNewGame_whenMarkWithX_thenShouldPrintXPlacement() {
        // given
        IntSupplier intSupplier = mock(IntSupplier.class);
        when(intSupplier.getAsInt()).thenReturn(0);
        Bot bot = new Bot(intSupplier, new Game());

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        String eol = System.lineSeparator();
        String expectedOutput =
                "Player X:" + eol +
                        "X| | " + eol +
                        "-+-+-" + eol +
                        " | | " + eol +
                        "-+-+-" + eol +
                        " | | " + eol;

        // when
        bot.mark();

        // then
        assertThat(outContent.toString()).isEqualTo(expectedOutput);

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Print O placement should be printed in the right format")
    void givenOneMark_whenMarkWithO_thenShouldPrintOPlacement() {
        // given
        IntSupplier intSupplier = mock(IntSupplier.class);
        when(intSupplier.getAsInt()).thenReturn(0).thenReturn(1);
        Bot bot = new Bot(intSupplier, new Game());
        bot.mark();

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        String eol = System.lineSeparator();
        String expectedOutput =
                "Player O:" + eol +
                        "X|O| " + eol +
                        "-+-+-" + eol +
                        " | | " + eol +
                        "-+-+-" + eol +
                        " | | " + eol;

        // when
        bot.mark();

        // then
        assertThat(outContent.toString()).isEqualTo(expectedOutput);

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Print X winning should be printed in the right format")
    void givenXWon_whenPrintResult_thenShouldPrintCorrectString() {
        // given
        IntSupplier intSupplier = mock(IntSupplier.class);
        Game game = mock(Game.class);
        when(game.getStatus()).thenReturn(Status.X_WON);
        Bot bot = new Bot(intSupplier, game);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "PLAYER X WON!" + System.lineSeparator();

        // when
        bot.printResult();

        // then
        assertThat(outContent.toString()).isEqualTo(expectedOutput);

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Print O winning should be printed in the right format")
    void givenOWon_whenPrintResult_thenShouldPrintCorrectString() {
        // given
        IntSupplier intSupplier = mock(IntSupplier.class);
        Game game = mock(Game.class);
        when(game.getStatus()).thenReturn(Status.O_WON);
        Bot bot = new Bot(intSupplier, game);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "PLAYER O WON!" + System.lineSeparator();

        // when
        bot.printResult();

        // then
        assertThat(outContent.toString()).isEqualTo(expectedOutput);

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Print draw should be printed in the right format")
    void givenDraw_whenPrintResult_thenShouldPrintCorrectString() {
        // given
        IntSupplier intSupplier = mock(IntSupplier.class);
        Game game = mock(Game.class);
        when(game.getStatus()).thenReturn(Status.DRAW);
        Bot bot = new Bot(intSupplier, game);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "GAME ENDS WITH A DRAW!" + System.lineSeparator();

        // when
        bot.printResult();

        // then
        assertThat(outContent.toString()).isEqualTo(expectedOutput);

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Game is not on when it is a draw")
    void givenDraw_whenIsGameOn_thenShouldReturnFalse() {
        // given
        IntSupplier intSupplier = mock(IntSupplier.class);
        Game game = mock(Game.class);
        when(game.getStatus()).thenReturn(Status.DRAW);
        Bot bot = new Bot(intSupplier, game);

        // when
        boolean result = bot.isGameOn();

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Game is not on when it is an X win")
    void givenXWin_whenIsGameOn_thenShouldReturnFalse() {
        // given
        IntSupplier intSupplier = mock(IntSupplier.class);
        Game game = mock(Game.class);
        when(game.getStatus()).thenReturn(Status.X_WON);
        Bot bot = new Bot(intSupplier, game);

        // when
        boolean result = bot.isGameOn();

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Game is not on when it is an O win")
    void givenOWin_whenIsGameOn_thenShouldReturnFalse() {
        // given
        IntSupplier intSupplier = mock(IntSupplier.class);
        Game game = mock(Game.class);
        when(game.getStatus()).thenReturn(Status.O_WON);
        Bot bot = new Bot(intSupplier, game);

        // when
        boolean result = bot.isGameOn();

        // then
        assertThat(result).isFalse();
    }
}
