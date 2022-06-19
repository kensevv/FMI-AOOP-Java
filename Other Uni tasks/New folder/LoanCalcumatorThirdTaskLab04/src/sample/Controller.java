package sample;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="grdMain"
    private GridPane grdMain; // Value injected by FXMLLoader

    @FXML // fx:id="txaValues"
    private TextArea txaValues; // Value injected by FXMLLoader

    @FXML // fx:id="txtLoanAmount"
    private TextField txtLoanAmount; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumberOfYears"
    private TextField txtNumberOfYears; // Value injected by FXMLLoader

    @FXML // fx:id="btnShowTable"
    private Button btnShowTable; // Value injected by FXMLLoader

    public void btnShowTablePressed(ActionEvent actionEvent) {
        String interestAmount = txtLoanAmount.getText();
        String numberOfYears = txtLoanAmount.getText();
        int interestAmountNum = 0;
        int numbersOfYearsNum = 0;
        String var1 = "";
        try{
            interestAmountNum = Integer.parseInt(interestAmount);
            numbersOfYearsNum = Integer.parseInt(numberOfYears);
        }
        catch(Exception exp){
            // TODO Error Dialog
        }
        txaValues.appendText("Interest Rate\t\t\t\t");
        txaValues.appendText("Monthly Payment\t\t\t\t\t\t");
        txaValues.appendText("Total Payment\n ");

        for(double var6 = 5.0D; var6 <= 8.0D; var6 += 0.125D) {
            double var2 = var6 / 1200.0D;
            double var4 = ((double)(interestAmountNum)) * var2 / (1.0D - 1.0D / Math.pow(1.0D + var2,
                    ((double)(numbersOfYearsNum)) * 12.0D));
            var1 = var1 + String.format("%-24.3f%-34.2f%-8.2f\n", var6, var4,
                    var4 * 12.0D * ((double)numbersOfYearsNum));
            txaValues.appendText(var1);
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert grdMain != null : "fx:id=\"grdMain\" was not injected: check your FXML file 'sample.fxml'.";
        assert txaValues != null : "fx:id=\"txaValues\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtLoanAmount != null : "fx:id=\"txtLoanAmount\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtNumberOfYears != null : "fx:id=\"txtNumberOfYears\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnShowTable != null : "fx:id=\"btnShowTable\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
