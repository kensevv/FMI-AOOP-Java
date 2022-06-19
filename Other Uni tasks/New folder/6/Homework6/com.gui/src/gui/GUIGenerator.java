/**
 * Sample Skeleton for 'GUIGenerator.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import providers.CipherGenerator;
import providers.Result;
import providers.Wrapper;
import services.Cipherable;

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
        String seedValue = txtSeedEnter.getText();
        String sizeValue = txtEnterSize.getText();

        if(seedValue.equals("") || sizeValue.equals("")){
            Alert newAl = new Alert(Alert.AlertType.ERROR);
            newAl.setHeaderText("Error");
            newAl.setTitle("Error");
            newAl.setContentText("One or the both of the fields is/are empty");
            newAl.show();
        }
        else {
            int sizeInt = Integer.parseInt(sizeValue);
            int seedInt = Integer.parseInt(seedValue);

            Wrapper wr = new Wrapper(sizeInt);
            Cipherable cp = wr.makeFixedSelection();

            CipherGenerator cg = new CipherGenerator();

            Result res = cg.countDistinct(cp, seedInt);

            char[] chars = res.getChars();
            int charsCount = chars.length;
            String result = "[ ";

            int notRepeatedChars = 0;
            int helperInt = 0;

            for (int i = 0; i < charsCount; i++) {
                char currChar = chars[i];
                for (int j = 0; j < charsCount; j++) {
                    char nextChar = chars[j];
                    if(i != j) {
                        if (currChar == nextChar) helperInt++;
                    }
                }
                if(helperInt == 0) notRepeatedChars++;
                helperInt = 0;
            }

            for (int i = 0; i < charsCount; i++) {
                if (i != charsCount - 1)
                    result += chars[i] + ", ";
                else
                    result += chars[i] + " ";
            }
            result += "]";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Generate random A-Z");
            alert.setTitle("Count of the characters are: " + charsCount);
            alert.setContentText(result + "\nResult:" + notRepeatedChars);
            alert.show();
        }
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnRandomSubsetOnAction(ActionEvent event) {
        String seedValue = txtSeedEnter.getText();
        String sizeValue = txtEnterSize.getText();

        if(seedValue.equals("") || sizeValue.equals("")){
            Alert newAl = new Alert(Alert.AlertType.ERROR);
            newAl.setHeaderText("Error");
            newAl.setTitle("Error");
            newAl.setContentText("One or the both of the fields is/are empty");
            newAl.show();
        }
        else {
            int sizeInt = Integer.parseInt(sizeValue);
            int seedInt = Integer.parseInt(seedValue);

            Wrapper wr = new Wrapper(sizeInt);
            Cipherable cp = wr.makeFixedRandom();

            CipherGenerator cg = new CipherGenerator();

            Result res = cg.countDistinct(cp, seedInt);

            char[] chars = res.getChars();
            int charsCount = chars.length;
            String result = "[ ";

            int notRepeatedChars = 0;
            int helperInt = 0;

            for (int i = 0; i < charsCount; i++) {
                char currChar = chars[i];
                for (int j = 0; j < charsCount; j++) {
                    char nextChar = chars[j];
                    if(i != j) {
                        if (currChar == nextChar) helperInt++;
                    }
                }
                if(helperInt == 0) notRepeatedChars++;
                helperInt = 0;
            }

            for (int i = 0; i < charsCount; i++) {
                if (i != charsCount - 1)
                    result += chars[i] + ", ";
                else
                    result += chars[i] + " ";
            }
            result += "]";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Generate random A-Z");
            alert.setTitle("Count of the characters are: " + charsCount);
            alert.setContentText(result + "\nResult:" + notRepeatedChars);
            alert.show();
        }
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
