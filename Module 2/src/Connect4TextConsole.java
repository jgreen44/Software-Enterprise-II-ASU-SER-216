public class Connect4TextConsole extends Connect4 {


    // default constructor
    public Connect4TextConsole(char X, char Y){

    }

    public static void main(String[] args) {
        char player = 'O';

        char[][] grid = new char[6][7];
        Connect4 connect = new Connect4();

        connect.initializeArray(grid);
        connect.drawGrid(grid);


        do{
            player = connect.chooseNextPlayer(player);
            System.out.println("Begin Game");
            System.out.println("Player " + player + " - your turn. Choose a column number from 1 - 7");
            int number = connect.scanner.nextInt();


            // check if number is between 1 and 7
            connect.checkNumberValue(number);
            connect.dropChip(grid, number, player);
            connect.drawGrid(grid);


        }while(!connect.checkWinner(grid, player));

        System.out.println("Player " + player + " has won!");












    }
}
