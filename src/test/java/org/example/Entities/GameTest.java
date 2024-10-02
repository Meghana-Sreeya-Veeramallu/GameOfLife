package org.example.Entities;

import org.example.Exceptions.InvalidIterationNumberException;
import org.example.Exceptions.InvalidRowsOrColumnsException;
import org.example.Exceptions.InvalidSeedPercentageException;
import org.junit.jupiter.api.Test;

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

    @Test
    void testInvalidIterations() {
        Game game = new Game(5, 5, 50);
        assertThrows(InvalidIterationNumberException.class, () -> {game.run(0);});
        assertThrows(InvalidIterationNumberException.class, () -> {game.run(-5);});
    }

    @Test
    void testValidGameRun() {
        Game game = new Game(5, 5, 20);
        assertDoesNotThrow(() -> game.run(3));
    }
}
