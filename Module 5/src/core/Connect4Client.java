package core;

import java.io.*;
import java.net.*;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.Connect4GUI;


public class Connect4Client extends Application implements Connect4Constants {

    // Indicate whether the player has the turn
    private boolean myTurn = false;

    // Indicate the token for the player
    private char myToken = ' ';

    // Indicate the token for the other player
    private char otherToken = ' ';

    // create the cell
    private Cell[][] cell = new Cell[ROWS][COLS];

    // Create and initialize a status label
    private Label lblStatus = new Label();

    // Indicate selected row and column by the current move
    private int rowSelected;
    private int columnSelected;

    // Create and initialize a title label
    private Label lblTitle = new Label();

    // Input and output streams from/to server
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    // Continue to play?
    private boolean continueToPlay = true;

    // Wait for the player to mark a cell
    private boolean waiting = true;

    // Host name or ip
    private String host = "localhost";

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Connect 4");

        GridPane pane = new GridPane();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                pane.add(cell[i][j] = new Cell(), j, i);
            }
        }


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        HBox hbox = addHBox();
        borderPane.setRight(addVBox(lblStatus));
        borderPane.setBottom(hbox);


        Scene scene = new Scene(borderPane, STAGE_WIDTH, STAGE_HEIGHT + 50);
        stage.setTitle("Connect4"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
        // Connect to the server
        connectToServer();
    }



    private void connectToServer() {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket(host, 8000);

            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Control the game on a separate thread
        new Thread(() -> {
            try {
                // Get notification from the server
                int player = fromServer.readInt();

                // Am I player 1 or 2?
                if (player == PLAYER1) {
                    myToken = 'X';
                    otherToken = 'O';
                    Platform.runLater(() -> {
                        lblTitle.setText("Player 1 with token 'X'");
                        lblStatus.setText("Waiting for player 2 to join");
                    });

                    // Receive startup notification from the server
                    fromServer.readInt(); // Whatever read is ignored

                    // The other player has joined
                    Platform.runLater(() ->
                            lblStatus.setText("Player 2 has joined. I start first"));

                    // It is my turn
                    myTurn = true;
                } else if (player == PLAYER2) {
                    myToken = 'O';
                    otherToken = 'X';
                    Platform.runLater(() -> {
                        lblTitle.setText("Player 2 with token 'O'");
                        lblStatus.setText("Waiting for player 1 to move");
                    });
                }

                // Continue to play
                while (continueToPlay) {
                    if (player == PLAYER1) {
                        waitForPlayerAction(); // Wait for player 1 to move
                        sendMove(); // Send the move to the server
                        receiveInfoFromServer(); // Receive info from the server
                    } else if (player == PLAYER2) {
                        receiveInfoFromServer(); // Receive info from the server
                        waitForPlayerAction(); // Wait for player 2 to move
                        sendMove(); // Send player 2's move to the server
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    /**
     * Wait for the player to mark a cell
     */
    private void waitForPlayerAction() throws InterruptedException {
        while (waiting) {
            Thread.sleep(100);
        }
        waiting = true;
    }

    private void sendMove() throws IOException {
        toServer.writeInt(rowSelected); // Send the selected row
        toServer.writeInt(columnSelected); // Send the selected column
    }

    /**
     * Receive info from the server
     */
    private void receiveInfoFromServer() throws IOException {
        // Receive game status
        int status = fromServer.readInt();

        if (status == PLAYER1_WON) {
            // Player 1 won, stop playing
            continueToPlay = false;
            if (myToken == 'X') {
                Platform.runLater(() -> lblStatus.setText("I won! (X)"));
            } else if (myToken == 'O') {
                Platform.runLater(() ->
                        lblStatus.setText("Player 1 (X) has won!"));
                receiveMove();
            }
        } else if (status == PLAYER2_WON) {
            // Player 2 won, stop playing
            continueToPlay = false;
            if (myToken == 'O') {
                Platform.runLater(() -> lblStatus.setText("I won! (O)"));
            } else if (myToken == 'X') {
                Platform.runLater(() ->
                        lblStatus.setText("Player 2 (O) has won!"));
                receiveMove();
            }
        } else if (status == DRAW) {
            // No winner, game is over
            continueToPlay = false;
            Platform.runLater(() ->
                    lblStatus.setText("Game is over, no winner!"));

            if (myToken == 'O') {
                receiveMove();
            }
        } else {
            receiveMove();
            Platform.runLater(() -> lblStatus.setText("My turn"));
            myTurn = true; // It is my turn
        }
    }

    private void receiveMove() throws IOException {
        // Get the other player's move
        int row = fromServer.readInt();
        int column = fromServer.readInt();
        Platform.runLater(() -> cell[row][column].setToken(otherToken));
    }

    /**
     * Fired when button one is clicked.
     */
    class ButtonOne implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = ROWS; i > 0; i--) {
                    if (cell[i - 1][0].getToken() == ' ') {
                        cell[i - 1][0].handleMouseClick();
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("button 1 error" + ex.getMessage());
            }
        }
    }

    /**
     * Fired when button two is clicked.
     */
    class ButtonTwo implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = ROWS; i > 0; i--) {
                    if (cell[i - 1][1].getToken() == ' ') {
                        cell[i - 1][1].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 2 error!");
            }
        }
    }

    /**
     * Fired when button three is clicked.
     */
    class ButtonThree implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = ROWS; i > 0; i--) {
                    if (cell[i - 1][2].getToken() == ' ') {
                        cell[i - 1][2].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 3 error!");
            }
        }
    }

    /**
     * Fired when button four is clicked.
     */
    class ButtonFour implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = ROWS; i > 0; i--) {
                    if (cell[i - 1][3].getToken() == ' ') {
                        cell[i - 1][3].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 4 error!");
            }
        }
    }

    /**
     * Fired when button five is clicked..
     */
    class ButtonFive implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = ROWS; i >= 0; i--) {
                    if (cell[i - 1][4].getToken() == ' ') {
                        cell[i - 1][4].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 5 error!");
            }
        }
    }

    /**
     * Fired when button six is clicked.
     */
    class ButtonSix implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = ROWS; i >= 0; i--) {
                    if (cell[i - 1][5].getToken() == ' ') {
                        cell[i - 1][5].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 6 error!");
            }
        }
    }

    /**
     * Fired when button seven is clicked.
     */
    class ButtonSeven implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = ROWS; i > 0; i--) {
                    if (cell[i - 1][6].getToken() == ' ') {
                        cell[i - 1][6].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 7 error! " + ex.getMessage());
            }
        }
    }

    public class Cell extends Pane{

        // Indicate the row and column of this cell in the board
        private int row;
        private int column;


        // Token used for this cell
        private char token = ' ';

        /**
         * Instantiates a new Cell.
         */
        public Cell() {
            setStyle("-fx-border-color: black");
            this.setPrefSize(STAGE_WIDTH, STAGE_HEIGHT);

        }

        /**
         * Return token
         *
         * @return the token
         */
        public char getToken() {
            return token;
        }

        /**
         * Set a new token
         */
        public void setToken(char c) {
            token = c;
            repaint();
        }

        protected void repaint() {
            Ellipse ellipse = new Ellipse(this.getWidth() / 2,
                    this.getHeight() / 2, this.getWidth() / 2 - 10,
                    this.getHeight() / 2 - 10);
            ellipse.centerXProperty().bind(this.widthProperty().divide(2));
            ellipse.centerYProperty().bind(this.heightProperty().divide(2));
            ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
            ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
            ellipse.setStroke(Color.BLACK);


            if (token == '1') {

                ellipse.setFill(Color.YELLOW);
                getChildren().add(ellipse); // Add the ellipse to the pane
            } else if (token == '2') {


                ellipse.setFill(Color.RED);
                getChildren().add(ellipse); // Add the ellipse to the pane
            }

        }

        /* Handle a mouse click event */
        private void handleMouseClick() {
            // If cell is empty and game is not over
            if (token == ' ' && myTurn) {
                setToken(myToken);  // Set the player's token in the cell
                myTurn = false;
                rowSelected = row;
                columnSelected = column;
                waiting = false; // Just completed a successful move
            }
        }


    }

    /**
     * Adds horizontal box to the GUI.
     *
     * @return the h box
     */
    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button number1 = new Button("#1");
        number1.setPrefSize(100, 20);
        number1.setOnAction(new ButtonOne());

        Button number2 = new Button("#2");
        number2.setPrefSize(100, 20);
        number2.setOnAction(new ButtonTwo());

        Button number3 = new Button("#3");
        number3.setPrefSize(100, 20);
        number3.setOnAction(new ButtonThree());

        Button number4 = new Button("#4");
        number4.setPrefSize(100, 20);
        number4.setOnAction(new ButtonFour());

        Button number5 = new Button("#5");
        number5.setPrefSize(100, 20);
        number5.setOnAction(new ButtonFive());

        Button number6 = new Button("#6");
        number6.setPrefSize(100, 20);
        number6.setOnAction(new ButtonSix());

        Button number7 = new Button("#7");
        number7.setPrefSize(100, 20);
        number7.setOnAction(new ButtonSeven());


        hbox.getChildren().addAll(number1, number2, number3, number4, number5, number6, number7);

//        number1.setOnAction(new ButtonOne())

        return hbox;
    }

    /**
     * Adds vertical box to the GUI.
     *
     * @param lblStatus the lbl status
     * @return the v box
     */
    public VBox addVBox(Label lblStatus) {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(8);


        Text titleText = new Text("Moves:");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        lblStatus.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 14));
        VBox.setMargin(titleText, new Insets(10, 0, 10, 10));
        vbox.getChildren().addAll(titleText, lblStatus);

        return vbox;
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
