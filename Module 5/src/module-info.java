module module5_javafx {
    requires javafx.fxml;
    requires javafx.controls;

    opens ui;
    opens core;
    opens tic_tac_toe;

}
