module sample {
    requires javafx.fxml;
    requires javafx.controls;
    requires person;
    opens sample to javafx.fxml;
    exports sample to javafx.graphics;
}