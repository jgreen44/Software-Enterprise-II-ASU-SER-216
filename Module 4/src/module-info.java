module java_fx {
    requires javafx.fxml;
    requires javafx.controls;

    opens event_driven_samples;
    opens ui;
}