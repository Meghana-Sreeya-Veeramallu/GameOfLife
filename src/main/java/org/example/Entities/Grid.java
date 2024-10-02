package org.example.Entities;

import org.example.Exceptions.InvalidRowsOrColumnsException;

public class Grid {

    private final Cell[][] cells;
    private final int rows;
    private final int cols;

    public Grid(int rows, int cols) throws InvalidRowsOrColumnsException {
        if (rows <= 2 || cols <= 2) {
            throw new InvalidRowsOrColumnsException("Rows and columns should be greater than 2");
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

    public boolean isAlive(int row, int col) throws InvalidRowsOrColumnsException{
        if (!isInBounds(row, col)) {
            throw new InvalidRowsOrColumnsException("Row and column must be within grid bounds");
        }
        return cells[row][col].isAlive();
    }

    public void setAlive(int row, int col) throws InvalidRowsOrColumnsException{
        if (!isInBounds(row, col)) {
            throw new InvalidRowsOrColumnsException("Row and column must be within grid bounds");
        }
        cells[row][col].setAlive();
    }

    public void update() {
        Cell[][] newCells = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);
                newCells[i][j] = new Cell();

                if (shouldBeAlive(cells[i][j], aliveNeighbors)) {
                    newCells[i][j].setAlive();
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = newCells[i][j];
            }
        }
    }

    private int countAliveNeighbors(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) continue;
                if (isInBounds(i,j) && cells[i][j].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean shouldBeAlive(Cell cell, int aliveNeighbors) {
        return (cell.isAlive() && (aliveNeighbors == 2 || aliveNeighbors == 3)) || (!cell.isAlive() && aliveNeighbors == 3);
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
