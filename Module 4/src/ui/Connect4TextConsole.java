/**
 * ui.Connect4TextConsole class contains all of the logical
 * UI elements presented to the two players of the game
 *
 * @author Jason Green, jgreen44@asu.edu
 * @version 1.0
 */

package ui;

import core.Connect4;
import core.Connect4ComputerPlayer;

import java.util.Scanner;


public class Connect4TextConsole extends Connect4 {


    /**
     * Instantiates a new ui.Connect4TextConsole.
     */
// default constructor
    public Connect4TextConsole() {

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char player = 'O';

        char[][] grid = new char[6][7];

        Connect4 connect = new Connect4();
        Connect4ComputerPlayer computer = new Connect4ComputerPlayer();

        connect.initializeArray(grid);
        drawGrid(grid);
        System.out.println("Begin Game");



            System.out.println("Enter 'P' if you want to play against " +
                    "another player; enter 'C' to play against computer");


            // check if user inputs only a string, not an integer
            while (scanner.hasNextInt()) {
                System.out.println("Please only enter 'P' or 'C' to play the game");
                scanner.next();
            }

            String comp = scanner.next();
            if (comp.equalsIgnoreCase("P")) {
                do {
                    player = connect.chooseNextPlayer(player);
                    System.out.println("Player " + player + " - your turn. Choose a column number from 1 - 7");


                    // error checking if user enters an integer
                    while (!scanner.hasNextInt()) {
                        System.out.println("Please enter a number only!");
                        scanner.next();

                    }

                    int number = scanner.nextInt();

                    // check if number is between 1 and 7
                    number = checkNumberValue(number);

                    if (validatePersonMove(grid, number)) {
                        connect.dropChip(grid, number, player);
                        drawGrid(grid);
                    }

                } while (connect.checkWinner(grid, player));
                System.out.println("Player " + player + " has won!");
            } else if (comp.equalsIgnoreCase("C")) {
                do {
                    System.out.println("Start game against computer.");
                    player = computer.chooseNextPlayer(player);

                    if (player == 'X') {
                        System.out.println("It is your turn. Choose a column number from 1 - 7");


                        // error checking if user enters an integer
                        while (!scanner.hasNextInt()) {
                            System.out.println("Please enter a number only!");
                            scanner.next();

                        }

                        int number = scanner.nextInt();
                        // check if number is between 1 and 7
                        number = checkNumberValue(number);


                        if (validatePersonMove(grid, number)) {
                            connect.dropChip(grid, number, player);
                            drawGrid(grid);
                        }

                    } else if (player == 'O') {
                        // logic for the computer
                        Connect4ComputerPlayer.computerMakeMove(grid, player);
                    }
                } while (connect.checkWinner(grid, player));
                System.out.println("Player " + player + " has won!");
            }
            scanner.close();
        }


    public void runGame() {
        main(null);
    }
}
