package org.example.Entities;

import org.example.Exceptions.AllCellsDeadException;
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
        if (!hasAliveCells()) {
            throw new AllCellsDeadException("All cells are dead, cannot continue");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);
                cells[i][j].determineNextState(aliveNeighbors);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j].updateState();
            }
        }
    }

    private boolean hasAliveCells() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].isAlive()) {
                    return true;
                }
            }
        }
        return false;
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

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(cells[i][j].isAlive() ? "* " : "- ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
