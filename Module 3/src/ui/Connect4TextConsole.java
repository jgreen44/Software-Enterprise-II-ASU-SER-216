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


public class Connect4TextConsole extends Connect4 {


    /**
     * Instantiates a new ui.Connect4TextConsole.
     *
     * @param X the x
     * @param Y the y
     */
// default constructor
    public Connect4TextConsole(char X, char Y) {

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        char player = 'O';

        char[][] grid = new char[6][7];

        Connect4 connect = new Connect4();
        Connect4ComputerPlayer computer = new Connect4ComputerPlayer();

        connect.initializeArray(grid);
        connect.drawGrid(grid);
        System.out.println("Begin Game");

        System.out.println("Enter 'P' if you want to play against " +
                "another player; enter 'C' to play against computer");

        String comp = Connect4.scanner.next();
        if (comp.equalsIgnoreCase("P")) {
            do {
                player = connect.chooseNextPlayer(player);
                System.out.println("Player " + player + " - your turn. Choose a column number from 1 - 7");
                int number = Connect4.scanner.nextInt();

                // check if number is between 1 and 7
                number = connect.checkNumberValue(number);

                if (connect.validateMove(grid, number)) {
                    connect.dropChip(grid, number, player);
                    connect.drawGrid(grid);
                }
            } while (connect.checkWinner(grid, player));
            System.out.println("Player " + player + " has won!");
        } else {
            do {
                System.out.println("Start game against computer.");
                player = computer.chooseNextPlayer(player);

                if(player == 'X') {
                    System.out.println("It is your turn. Choose a column number from 1 - 7");
                    int number = Connect4.scanner.nextInt();
                    // check if number is between 1 and 7
                    number = connect.checkNumberValue(number);
                    if (connect.validateMove(grid, number)) {
                        connect.dropChip(grid, number, player);
                        connect.drawGrid(grid);
                    }
                }else if(player == 'O'){
                    // logic for the computer
                    Connect4ComputerPlayer.computerMakeMove(grid, player);
                }
            } while (connect.checkWinner(grid, player));
            System.out.println("Player " + player + " has won!");
        }
    }
}
