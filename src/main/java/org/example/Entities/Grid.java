package org.example.Entities;

import org.example.Exceptions.InvalidRowsOrColumnsException;

public class Grid {

    private final Cell[][] cells;
    private final int rows;
    private final int cols;

    public Grid(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new InvalidRowsOrColumnsException("Rows and columns should be greater than 0");
        }
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
}
