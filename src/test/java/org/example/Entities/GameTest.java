package org.example.Entities;

import org.example.Exceptions.InvalidRowsOrColumnsException;
import org.example.Exceptions.InvalidSeedPercentageException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    void testGameInitialization() {
        Game game = new Game(5, 5, 20);
        assertNotNull(game);
    }

    @Test
    void testGameInitializationWithInvalidColumns() {
        assertThrows(InvalidRowsOrColumnsException.class, () -> {new Game(5, 1, 20);});
    }

    @Test
    void testInvalidSeedPercentageTooLow() {
        assertThrows(InvalidSeedPercentageException.class, () -> {new Game(5, 5, -1);});
    }

    @Test
    void testInvalidSeedPercentageTooHigh() {
        assertThrows(InvalidSeedPercentageException.class, () -> {new Game(5, 5, 101);});
    }

    // Tests for display() method
    @Test
    void testDisplay() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Game game = new Game(3, 3, 0);
        String expectedOutput = "- - - \n- - - \n- - - \n\n".replaceAll("\\s+", " ");

        game.display();

        String actualOutput = outContent.toString().replaceAll("\\s+", " ");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testValidGameRun() {
        Game game = new Game(5, 5, 20);
        assertDoesNotThrow(game::run);
    }
}
