package org.example.Entities;

import org.example.Exceptions.InvalidIterationNumberException;
import org.example.Exceptions.InvalidRowsOrColumnsException;
import org.example.Exceptions.InvalidSeedPercentageException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        System.out.print("Enter seed percentage (0-100): ");
        double seedPercentage = scanner.nextDouble();

        System.out.print("Enter number of iterations: ");
        int iterations = scanner.nextInt();

        try {
            Game game = new Game(rows, cols, seedPercentage);
            game.run(iterations);
        } catch (InvalidRowsOrColumnsException | InvalidIterationNumberException | InvalidSeedPercentageException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
