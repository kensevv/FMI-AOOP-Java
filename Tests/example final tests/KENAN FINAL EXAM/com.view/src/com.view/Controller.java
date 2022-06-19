package com.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.model.InventoryManagement;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {
    private InventoryManagement inventoryManagement;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textField;

    @FXML
    private Button showInventoryBtn;

    @FXML
    private Button sortBtn;

    @FXML
    private Button findAverageBtn;

    @FXML
    private Button groupBtn;

    @FXML
    private Button quitBtn;

    @FXML
    void findAverageBtnOnAction(ActionEvent event) {
        textField.setText(String.valueOf(inventoryManagement.averagePrice()));
    }

    @FXML
    void groupBtnOnAction(ActionEvent event) {
        textField.setText(inventoryManagement.findLargestPricePerCategory());
    }

    @FXML
    void quitBtnOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void showInventoryBtnOnAction(ActionEvent event) {
        textField.setText(inventoryManagement.showInventory());
    }

    @FXML
    void sortBtnOnAction(ActionEvent event) {
        textField.setText("");
        inventoryManagement.sortInventoryTypeAndID().stream().forEach(inventory -> {
            textField.appendText(inventory.toString());
            textField.appendText("\n");
        });
    }

    @FXML
    void initialize() {
        this.inventoryManagement = new InventoryManagement();

        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'sample.fxml'.";
        assert showInventoryBtn != null : "fx:id=\"showInventoryBtn\" was not injected: check your FXML file 'sample.fxml'.";
        assert sortBtn != null : "fx:id=\"sortBtn\" was not injected: check your FXML file 'sample.fxml'.";
        assert findAverageBtn != null : "fx:id=\"findAverageBtn\" was not injected: check your FXML file 'sample.fxml'.";
        assert groupBtn != null : "fx:id=\"groupBtn\" was not injected: check your FXML file 'sample.fxml'.";
        assert quitBtn != null : "fx:id=\"quitBtn\" was not injected: check your FXML file 'sample.fxml'.";
    }
}
