package org.example.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    public void testCellDefaultStateIsDead() {
        Cell cell = new Cell();
        assertFalse(cell.isAlive());
    }

    @Test
    public void testSetAlive() {
        Cell cell = new Cell();
        cell.setAlive();
        assertTrue(cell.isAlive());
    }

    // Tests for determineNextState() and updateState() method
    @Test
    public void testDetermineNextStateAliveWithTwoNeighbors() {
        Cell cell = new Cell();
        cell.setAlive();
        cell.determineNextState(2);
        cell.updateState();
        assertTrue(cell.isAlive());
    }

    @Test
    public void testDetermineNextStateAliveWithThreeNeighbors() {
        Cell cell = new Cell();
        cell.setAlive();
        cell.determineNextState(3);
        cell.updateState();
        assertTrue(cell.isAlive());
    }

    @Test
    public void testDetermineNextStateDeadWithMoreThanThreeNeighbors() {
        Cell cell = new Cell();
        cell.setAlive();
        cell.determineNextState(4);
        cell.updateState();
        assertFalse(cell.isAlive());
    }

    @Test
    public void testDetermineNextStateDeadWithLessThanTwoNeighbors() {
        Cell cell = new Cell();
        cell.setAlive();
        cell.determineNextState(1);
        cell.updateState();
        assertFalse(cell.isAlive());
    }

    @Test
    public void testDetermineNextStateAliveForDeadCellWithThreeNeighbors() {
        Cell cell = new Cell();
        cell.determineNextState(3);
        cell.updateState();
        assertTrue(cell.isAlive());
    }

    @Test
    public void testDetermineNextStateDeadForDeadCellWithLessThanThreeNeighbors() {
        Cell cell = new Cell();
        cell.determineNextState(2);
        cell.updateState();
        assertFalse(cell.isAlive());
    }

    @Test
    public void testDetermineNextStateDeadForDeadCellWithMoreThanThreeNeighbors() {
        Cell cell = new Cell();
        cell.determineNextState(4);
        cell.updateState();
        assertFalse(cell.isAlive());
    }
}