module com.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.services;
    requires com.providers;

    opens gui to javafx.fxml;
    exports  gui;
}