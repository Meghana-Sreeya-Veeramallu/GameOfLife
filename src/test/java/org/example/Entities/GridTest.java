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

    // Tests for isAlive() and setAlive() methods
    @Test
    void testIsAliveThrowsExceptionForOutOfBounds() {
        Grid grid = new Grid(3, 3);

        assertThrows(InvalidRowsOrColumnsException.class, () -> {grid.isAlive(-1, 0);});
        assertThrows(InvalidRowsOrColumnsException.class, () -> {grid.isAlive(0, -1);});
        assertThrows(InvalidRowsOrColumnsException.class, () -> {grid.isAlive(3, 3);});
    }

    @Test
    void testSetAliveThrowsExceptionForOutOfBounds() {
        Grid grid = new Grid(3, 3);

        assertThrows(InvalidRowsOrColumnsException.class, () -> {grid.setAlive(-1, 0);});
        assertThrows(InvalidRowsOrColumnsException.class, () -> {grid.setAlive(0, -1);});
        assertThrows(InvalidRowsOrColumnsException.class, () -> {grid.setAlive(3, 3);});
    }

    @Test
    void testNewGridCellsAreDead() {
        Grid grid = new Grid(2, 2);
        assertFalse(grid.isAlive(0, 0));
        assertFalse(grid.isAlive(0, 1));
        assertFalse(grid.isAlive(1, 0));
        assertFalse(grid.isAlive(1, 1));
    }

    @Test
    void testSetAliveMakesCellAlive() {
        Grid grid = new Grid(2, 2);
        grid.setAlive(0, 0);
        assertTrue(grid.isAlive(0, 0));
    }

    @Test
    void testSetAliveDoesNotAffectOtherCells() {
        Grid grid = new Grid(2, 2);
        grid.setAlive(0, 0);
        assertTrue(grid.isAlive(0, 0));
        assertFalse(grid.isAlive(0, 1));
        assertFalse(grid.isAlive(1, 0));
        assertFalse(grid.isAlive(1, 1));
    }

    // Tests for update() method
    @Test
    void testCellWithNoNeighborsDies() {
        Grid grid = new Grid(3, 3);
        grid.setAlive(1, 1);

        grid.update();

        assertFalse(grid.isAlive(1, 1));
    }

    @Test
    void testCellWithOneNeighborDies() {
        Grid grid = new Grid(3, 3);
        grid.setAlive(1, 1);
        grid.setAlive(1, 2);

        grid.update();

        assertFalse(grid.isAlive(1, 1));
    }

    @Test
    void testCellWithTwoNeighborsSurvives() {
        Grid grid = new Grid(3, 3);
        grid.setAlive(1, 1);
        grid.setAlive(1, 2);
        grid.setAlive(2, 1);

        grid.update();

        assertTrue(grid.isAlive(1, 1));
    }

    @Test
    void testCellWithThreeNeighborsSurvives() {
        Grid grid = new Grid(3, 3);
        grid.setAlive(1, 1);
        grid.setAlive(1, 2);
        grid.setAlive(2, 1);
        grid.setAlive(2, 2);

        grid.update();

        assertTrue(grid.isAlive(1, 1));
    }

    @Test
    void testCellWithFourNeighborsDies() {
        Grid grid = new Grid(3, 3);
        grid.setAlive(1, 1);
        grid.setAlive(0, 1);
        grid.setAlive(1, 0);
        grid.setAlive(1, 2);
        grid.setAlive(2, 1);

        grid.update();

        assertFalse(grid.isAlive(1, 1));
    }

    @Test
    void testDeadCellWithThreeNeighborsBecomesAlive() {
        Grid grid = new Grid(3, 3);
        grid.setAlive(1, 0);
        grid.setAlive(0, 1);
        grid.setAlive(2, 1);

        grid.update();

        assertTrue(grid.isAlive(1, 1));
    }

    @Test
    void testDeadCellWithLessThanThreeNeighborsRemainsDead() {
        Grid grid = new Grid(3, 3);
        grid.setAlive(1, 0);
        grid.setAlive(0, 1);

        grid.update();

        assertFalse(grid.isAlive(1, 1));
    }

    @Test
    void testDeadCellWithMoreThanThreeNeighborsRemainsDead() {
        Grid grid = new Grid(3, 3);
        grid.setAlive(0, 0);
        grid.setAlive(0, 1);
        grid.setAlive(0, 2);
        grid.setAlive(1, 0);
        grid.setAlive(2, 0);

        grid.update();

        assertFalse(grid.isAlive(1, 1));
    }
}
