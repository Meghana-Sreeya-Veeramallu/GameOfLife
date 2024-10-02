package org.example.Entities;

import org.example.Exceptions.AllCellsDeadException;
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

        scanner.nextLine();

        try {
            Game game = new Game(rows, cols, seedPercentage);
            boolean continueGame = true;
            while (continueGame) {
                System.out.println("Press Enter to continue or 'q' to quit.");

                String userResponse = scanner.nextLine();

                if (userResponse.equalsIgnoreCase("q")) {
                    continueGame = false;
                } else {
                    try{
                        game.run();
                    } catch (AllCellsDeadException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                }
            }
        } catch (InvalidRowsOrColumnsException | InvalidSeedPercentageException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
