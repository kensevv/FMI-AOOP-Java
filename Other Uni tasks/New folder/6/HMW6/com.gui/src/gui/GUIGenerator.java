/**
 * Sample Skeleton for 'GUIGenerator.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GUIGenerator {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ancRandomGenerate"
    private GridPane ancRandomGenerate; // Value injected by FXMLLoader

    @FXML // fx:id="btnGenerateRandom"
    private Button btnGenerateRandom; // Value injected by FXMLLoader

    @FXML // fx:id="txtSeedEnter"
    private TextField txtSeedEnter; // Value injected by FXMLLoader

    @FXML // fx:id="txtEnterSize"
    private TextField txtEnterSize; // Value injected by FXMLLoader

    @FXML // fx:id="btnRandomSubset"
    private Button btnRandomSubset; // Value injected by FXMLLoader

    @FXML // fx:id="btnQuit"
    private Button btnQuit; // Value injected by FXMLLoader

    @FXML
    void btnGenerateRandomOnAction(ActionEvent event) {

    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {

    }

    @FXML
    void btnRandomSubsetOnAction(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert ancRandomGenerate != null : "fx:id=\"ancRandomGenerate\" was not injected: check your FXML file 'GUIGenerator.fxml'.";
        assert btnGenerateRandom != null : "fx:id=\"btnGenerateRandom\" was not injected: check your FXML file 'GUIGenerator.fxml'.";
        assert txtSeedEnter != null : "fx:id=\"txtSeedEnter\" was not injected: check your FXML file 'GUIGenerator.fxml'.";
        assert txtEnterSize != null : "fx:id=\"txtEnterSize\" was not injected: check your FXML file 'GUIGenerator.fxml'.";
        assert btnRandomSubset != null : "fx:id=\"btnRandomSubset\" was not injected: check your FXML file 'GUIGenerator.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'GUIGenerator.fxml'.";

    }
}
