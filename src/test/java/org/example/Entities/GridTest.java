package org.example.Entities;

import org.example.Exceptions.InvalidRowsOrColumnsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void testValidGridInitialization() {
        assertDoesNotThrow(() -> new Grid(5, 5));
    }

    @Test
    void testGridInitializationWhenRowsAreZero() {
        assertThrows(InvalidRowsOrColumnsException.class, () -> new Grid(0, 2));
    }

    @Test
    void testGridInitializationWhenColumnsAreNegative() {
        assertThrows(InvalidRowsOrColumnsException.class, () -> new Grid(6, -5));
    }

    @Test
    void testGridInitializationWhenRowsAndColumnsAreNegative() {
        assertThrows(InvalidRowsOrColumnsException.class, () -> new Grid(-5, -10));
    }
}
