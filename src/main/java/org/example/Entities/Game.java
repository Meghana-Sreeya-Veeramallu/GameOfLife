package org.example.Entities;

import org.example.Exceptions.InvalidIterationNumberException;
import org.example.Exceptions.InvalidRowsOrColumnsException;
import org.example.Exceptions.InvalidSeedPercentageException;

import java.util.Random;

public class Game {
    private final Grid grid;
    private final double seedPercentage;

    public Game(int rows, int cols, double seedPercentage) throws InvalidRowsOrColumnsException, InvalidSeedPercentageException {
        grid = new Grid(rows, cols);
        if (seedPercentage < 0 || seedPercentage > 100) {
            throw new InvalidSeedPercentageException("Seed percentage must be between 0 and 100");
        }
        this.seedPercentage = seedPercentage;
        initializeCells(rows, cols);
    }

    private void initializeCells(int rows, int cols) {
        int totalCells = rows * cols;
        int aliveCellsCount = (int) Math.round((seedPercentage / 100) * totalCells);

        Random random = new Random();
        while (aliveCellsCount > 0) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (!grid.isAlive(row, col)) {
                grid.setAlive(row, col);
                aliveCellsCount--;
            }
        }
    }

    public void run(int iterations) throws InvalidIterationNumberException {
        if (iterations <= 0) {
            throw new InvalidIterationNumberException("Iterations must be positive");
        }
        for (int i = 0; i < iterations; i++) {
            System.out.println("Iteration " + (i + 1));
            grid.display();
            grid.update();
        }
    }
}