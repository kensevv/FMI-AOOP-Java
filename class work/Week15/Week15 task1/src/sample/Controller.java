package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblInput;

    @FXML
    private Slider sldInput;

    @FXML
    private TextField txtInput;

    @FXML
    void initialize() {
        assert lblInput != null : "fx:id=\"lblInput\" was not injected: check your FXML file 'sample.fxml'.";
        assert sldInput != null : "fx:id=\"sldInput\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'sample.fxml'.";

        // FLUENT API
        //txtInput.textProperty().bind(sldInput.valueProperty().asString("%.2f"));
        //lblInput.textProperty().bind(sldInput.valueProperty().asString(".2f"));

        // Binding class
        //txtInput.textProperty().bind(Bindings.format("%.2f", sldInput.valueProperty()));
        //lblInput.textProperty().bind(Bindings.format("%.2f", sldInput.valueProperty()));

        // low level binding
       /* StringBinding binding = new StringBinding() {
            {
                super.bind(sldInput.valueProperty());
            }
            @Override
            protected String computeValue() {
               return String.format("%.2f", sldInput.valueProperty().get());
            }
        };
        txtInput.textProperty().bind(binding);
        lblInput.textProperty().bind(binding);*/

        //change listener
        sldInput.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                txtInput.setText(String.format("%.2f", newValue));
                lblInput.setText(String.format("%.2f", newValue));
            }
        });

        // change listener - lambda
        sldInput.valueProperty().addListener(((observableValue, oldValue, newValue) -> {
            txtInput.setText(String.format("%.2f", newValue));
            lblInput.setText(String.format("%.2f", newValue));
        } ));
    }
}