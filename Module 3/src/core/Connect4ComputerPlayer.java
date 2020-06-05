package core;

import java.util.Random;
import java.util.Scanner;

/**
 * The type Connect 4 computer player.
 */
public class Connect4ComputerPlayer extends Connect4 {
    /**
     * Instantiates a new Connect 4 computer player.
     */
// default constructor
    public Connect4ComputerPlayer() {

    }

    /**
     * Rand int int.
     *
     * @param min the min
     * @param max the max
     * @return the int
     */
    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public char chooseNextPlayer(char player) {
        if (player == 'X') {
            player = 'O';
        } else if (player == 'O') {
            player = 'X';
        }
        return player;
    }

    /**
     * Computer makes the move.
     *
     * @param grid   the grid
     * @param player the player
     */
    public static void computerMakeMove(char[][] grid, char player) {
        int number = randInt(1, 7);
        if (Connect4.validateMove(grid, number)) {
            for (int row = grid.length - 1; row >= 0; row--) {
                if (grid[row][number - 1] == SPACE) {
                    grid[row][number - 1] = player;
                    break;
                }
            }
            Connect4.drawGrid(grid);
        }

    }


}
