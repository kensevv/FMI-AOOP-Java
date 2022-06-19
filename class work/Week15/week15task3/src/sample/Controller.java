package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblFromCelsius;

    @FXML
    private Label lblToFahrenheit;

    @FXML
    private Label lblFromFahrenheit;

    @FXML
    private Label lblToCelsius;

    @FXML
    private TextField txtFromCelsius;

    @FXML
    private TextField txtToFahrenheit;

    @FXML
    private TextField txtFromFahrenheit;

    @FXML
    private TextField txtToCelsius;

    @FXML
    void initialize() {
        assert lblFromCelsius != null : "fx:id=\"lblFromCelsius\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblToFahrenheit != null : "fx:id=\"lblToFahrenheit\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblFromFahrenheit != null : "fx:id=\"lblFromFahrenheit\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblToCelsius != null : "fx:id=\"lblToCelsius\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtFromCelsius != null : "fx:id=\"txtFromCelsius\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtToFahrenheit != null : "fx:id=\"txtToFahrenheit\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtFromFahrenheit != null : "fx:id=\"txtFromFahrenheit\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtToCelsius != null : "fx:id=\"txtToCelsius\" was not injected: check your FXML file 'sample.fxml'.";

        // fluent api
        // txtFromCelsiou -> txttoFahrennheir
       /* DoubleBinding celsiousInput = new DoubleBinding() {
            {
                super.bind(txtFromCelsius.textProperty());
            }
            @Override
            protected double computeValue() {
               String input = txtFromCelsius.textProperty().get();
               if(input.isBlank()){
                   return 0.0;
               }
               return Double.parseDouble(input);
            }
        };
        txtToFahrenheit.textProperty().bind(celsiousInput.multiply(9.0 / 5.0).add(32).asString("%.2f"));


        DoubleBinding fahrenheitInput = new DoubleBinding() {
            {
                super.bind(txtFromFahrenheit.textProperty());
            }
            @Override
            protected double computeValue() {
                String input = txtFromFahrenheit.textProperty().get();
                if(input.isBlank()){
                    return 0.0;
                }
                return Double.parseDouble(input);
            }
        };
        txtToCelsius.textProperty().bind(fahrenheitInput.subtract(32).multiply(5.0 / 9.0).asString("%.2f"));*/

        //bindings class
        DoubleBinding celsiusInput = Bindings.createDoubleBinding( () -> {
            String input = txtFromCelsius.textProperty().get();
            if(input.isBlank()){
                return 0.0;
            }
            return Double.parseDouble(input);
        }, txtFromCelsius.textProperty());
        txtToFahrenheit.textProperty().bind(Bindings.format("%.2f",
                Bindings.add(Bindings.multiply(celsiusInput, 9.0 / 5.0), 32)));

        DoubleBinding fahrenheitInput = Bindings.createDoubleBinding( () -> {
            String input = txtFromFahrenheit.textProperty().get();
            if(input.isBlank()){
                return 0.0;
            }
            return Double.parseDouble(input);
        }, txtFromFahrenheit.textProperty());
        txtToCelsius.textProperty().bind(Bindings.format("%.2f",
                Bindings.multiply(Bindings.subtract(fahrenheitInput, 32), 5.0 / 9.0)));


        //low level binding
       /* StringBinding convertCelsiusToFahrenheit = new StringBinding() {
            {
                super.bind(txtFromCelsius.textProperty());
            }
            @Override
            protected String computeValue() {
                String input = txtFromCelsius.textProperty().get();
                double celsius;
                if(input.isBlank()){
                    celsius = 0.0;
                }
                else {
                    celsius = 9.0 / 5.0 * Double.parseDouble(input) +32;
                }

                return String.format("%.2f", celsius);
            }
        };
        txtToFahrenheit.textProperty().bind(convertCelsiusToFahrenheit);

        StringBinding convertFahrenheitToCelsius = new StringBinding() {
            {
                super.bind(txtFromFahrenheit.textProperty());
            }
            @Override
            protected String computeValue() {
                String input = txtFromFahrenheit.textProperty().get();
                double fahr;
                if(input.isBlank()){
                    fahr = 0.0;
                }
                else {
                    fahr = 5.0 / 9.0 * Double.parseDouble(input) - 32;
                }

                return String.format("%.2f", fahr);
            }
        };
        txtToCelsius.textProperty().bind(convertFahrenheitToCelsius);*/
    }
}
