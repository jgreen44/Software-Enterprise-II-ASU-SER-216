/**
 * ui.Connect4TextConsole class contains all of the logical
 * UI elements presented to the two players of the game
 *
 * @author Jason Green, jgreen44@asu.edu
 * @version 1.0
 */

package ui;

import core.Connect4;


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

        connect.initializeArray(grid);
        connect.drawGrid(grid);
        System.out.println("Begin Game");

        do {
            player = connect.chooseNextPlayer(player);
            System.out.println("Player " + player + " - your turn. Choose a column number from 1 - 7");
            int number = connect.scanner.nextInt();


            // check if number is between 1 and 7
            number = connect.checkNumberValue(number);

            if (connect.validateMove(grid, number)) {
                connect.dropChip(grid, number, player);
                connect.drawGrid(grid);
            }


        } while (!connect.checkWinner(grid, player));

        System.out.println("Player " + player + " has won!");


    }
}
