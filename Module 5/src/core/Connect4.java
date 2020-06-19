/**
 * core.Connect4 class contains all the game logic for the
 * traditional game of "Connect Four"
 *
 * @author Jason Green, jgreen44@asu.edu
 * @version 1.0
 */

package core;

import ui.Connect4TextConsole;

import java.util.Scanner;

/**
 * The type Connect 4.
 */
public class Connect4 {

    private static final char BAR = '|';
    protected static final char SPACE = ' ';
    private static int row;
    private static int col;

    /**
     * Instantiates a new Connect 4.
     */
    // default constructor
    public Connect4() {
    }


    /**
     * Choose next player in the game.
     *
     * @param player the player
     * @return char consisting of X or O
     */
    public char chooseNextPlayer(char player) {
        if (player == 'X') {
            player = 'O';
        } else if (player == 'O') {
            player = 'X';
        }
        return player;
    }


//    /**
//     * Checks the number to make sure the user
//     * has chosen 1 - 7.
//     *
//     * @param number the number
//     * @return the int
//     */
//    public static int checkNumberValue(int number) {
//        Scanner scanner = new Scanner(System.in);
//        boolean checkNumber = true;
//        if (number < 1 || number > 7) {
//            while (checkNumber) {
//                System.out.println("Please choose a number between 1 - 7");
//                number = scanner.nextInt();
//                if (number > 0 && number < 8) {
//                    checkNumber = false;
//                }
//            }
//        }
////        scanner.close();
//        return number;
//    }

    /**
     * Places an X or O depending on what column the
     * player chooses.
     *
     * @param grid   the grid
     * @param number the number
     * @param player the player
     */
    public void dropChip(char[][] grid, int number, char player) {
        for (int row = grid.length - 1; row >= 0; row--) {
            if (grid[row][number - 1] == SPACE) {
                grid[row][number - 1] = player;
                break;
            }
        }
    }

    /**
     * Draws grid for the UI.
     *
     * @param grid the grid
     */
    public static void drawGrid(char[][] grid) {
        for (row = 0; row < grid.length; row++) {
            System.out.print(BAR);
            for (col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col]);
                System.out.print(BAR);
            }
            System.out.println();
        }
    }

    /**
     * Initialize array.
     *
     * @param grid the grid
     */
    public void initializeArray(char[][] grid) {
        for (row = 0; row < grid.length; row++) {
            for (col = 0; col < grid[0].length; col++) {
                grid[row][col] = ' ';
            }
        }
    }

    /**
     * Checks the winner of the game.
     *
     * @param grid   the grid
     * @param player the player
     * @return boolean if any one of the four winning
     * positions are met
     */
    public boolean checkWinner(char[][] grid, char player) {
        return !checkDiagonalDown(grid, player) &&
                !checkDiagonalUp(grid, player) &&
                !checkHorizontal(grid, player) &&
                !checkVertical(grid, player) &&
                checkTie(grid, player);
    }


    /**
     * Checks if a player has four consecutive chips
     * in a downward diagonal fashion.
     *
     * @param grid   the grid
     * @param player the player
     * @return the boolean
     */
    public boolean checkDiagonalDown(char[][] grid, char player) {
        for (row = 0; row < grid.length - 3; row++) {
            for (col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player && grid[row + 1][col + 1] == player
                        && grid[row + 2][col + 2] == player
                        && grid[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a player has four consecutive chips
     * in an upward diagonal fashion.
     *
     * @param grid   the grid
     * @param player the player
     * @return the boolean
     */
    public boolean checkDiagonalUp(char[][] grid, char player) {
        try {
            for (row = 0; row < grid.length; row++) {
                for (col = 0; col < grid[0].length - 3; col++) {
                    if (grid[row][col] == player && grid[row - 1][col + 1] == player
                            && grid[row - 2][col + 2] == player
                            && grid[row - 3][col + 3] == player) {
                        return true;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * hecks if a player has four consecutive chips
     * in a horizontal fashion.
     *
     * @param grid   the grid
     * @param player the player
     * @return the boolean
     */
    public boolean checkHorizontal(char[][] grid, char player) {
        for (row = 0; row < grid.length; row++) {
            for (col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player && grid[row][col + 1] == player
                        && grid[row][col + 2] == player
                        && grid[row][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * hecks if a player has four consecutive chips
     * in a vertical fashion.
     *
     * @param grid   the grid
     * @param player the player
     * @return the boolean
     */
    public boolean checkVertical(char[][] grid, char player) {
        for (row = 0; row < grid.length - 3; row++) {
            for (col = 0; col < grid[0].length; col++) {
                // check vertical bottom to top
                if (grid[row][col] == player && grid[row + 1][col] == player
                        && grid[row + 2][col] == player
                        && grid[row + 3][col] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a tie is encountered.
     *
     * @param grid   the grid
     * @param player the player
     * @return the boolean
     */
    public boolean checkTie(char[][] grid, char player){
        int tracker = 0;
        for (int i = 0; i < grid.length ; i++) {
            if(grid[0][i] != SPACE){
                tracker++;
            }
            if(tracker == 7){
                System.out.println("There is a tie!");
                return false;
            }
        }
        return true;
    }

    /**
     * Validate move boolean.
     *
     * @param grid   the grid
     * @param number the number
     * @return the boolean
     */
    public static boolean validatePersonMove(char[][] grid, int number) {
        Scanner scanner = new Scanner(System.in);
        while (grid[0][number - 1] != SPACE) {
            System.out.println("All columns filled. Please choose another column");

            // error checking if user enters an integer
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number only!");
                scanner.next();
            }
            number = scanner.nextInt();
            Connect4TextConsole.checkNumberValue(number);
            scanner.close();
        }
        return true;
    }




}
