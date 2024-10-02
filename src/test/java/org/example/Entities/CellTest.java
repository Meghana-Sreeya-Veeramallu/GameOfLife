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
}