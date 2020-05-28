import java.util.Scanner;

public class Connect4 {

    private static final char BAR = '|';
    private static final String SPACE = " ";
    private int row, col;
    Scanner scanner = new Scanner(System.in);

    // default contructor
    public Connect4() {
    }

    public char chooseNextPlayer(char player){
       if(player == 'X'){
           player = 'O';
       }else if(player == 'O'){
           player = 'X';
       }
       return player;
    }

    public boolean checkNumberValue(int number) {
        boolean checkNumber = true;
        if (number < 1 || number > 7) {
            while (checkNumber) {
                System.out.println("Please choose a number between 1 - 7");
                number = scanner.nextInt();
                if (number > 0 && number < 8) {
                    checkNumber = false;
                }
            }
        }
        return true;
    }

    public void dropChip(char[][] grid, int number, char player){
        for (int row = grid.length -1; row >=0  ; row--) {
            if(grid[row][number -  1] == ' '){
                grid[row][number - 1] = player;
                break;
            }
        }
    }

    public void drawGrid(char[][] grid) {
        for (row = 0; row < grid.length; row++) {
            System.out.print(BAR);
            for (col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col]);
                System.out.print(BAR);
            }
            System.out.println();
        }
    }

    public void initializeArray(char[][] grid) {
        for (row = 0; row < grid.length; row++) {
            for (col = 0; col < grid[0].length; col++) {
                grid[row][col] = ' ';
            }
        }
    }

    public boolean checkWinner(char[][] grid, char player) {
        return checkDiagonalDown(grid, player) ||
                checkDiagonalUp(grid, player) ||
                checkHorizontal(grid, player) ||
                checkVertical(grid, player);
    }


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

    public boolean checkDiagonalUp(char[][] grid, char player) {
        for (row = 0; row < grid.length; row++) {
            for (col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player && grid[row - 1][col + 1] == player
                        && grid[row - 2][col + 2] == player
                        && grid[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

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
}
