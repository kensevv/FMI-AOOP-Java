package sample;

/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class FXMLCalcController extends GridPane{

    private BigDecimal number = new BigDecimal("0.0");
    private BigDecimal secondNumber = new BigDecimal("0.0");
    private BigDecimal currentResult = new BigDecimal("0.0");
    private int devCounter = 0;
    private int mulCounter = 0;
    private int sepCounter = 0;

    private String currTxtFieldText = "";
    private String operation =  "";
    private String txtInputField =  "";
    private String txtInputFieldBase =  "";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="mainGrid"
    private GridPane mainGrid; // Value injected by FXMLLoader

    @FXML // fx:id="btnOne"
    private Button btnOne; // Value injected by FXMLLoader

    @FXML // fx:id="btnTwo"
    private Button btnTwo; // Value injected by FXMLLoader

    @FXML // fx:id="btnThree"
    private Button btnThree; // Value injected by FXMLLoader

    @FXML // fx:id="btnFive"
    private Button btnFive; // Value injected by FXMLLoader

    @FXML // fx:id="btnSix"
    private Button btnSix; // Value injected by FXMLLoader

    @FXML // fx:id="btnFour"
    private Button btnFour; // Value injected by FXMLLoader

    @FXML // fx:id="btnPlus"
    private Button btnPlus; // Value injected by FXMLLoader

    @FXML // fx:id="btnPointSep"
    private Button btnPointSep; // Value injected by FXMLLoader

    @FXML // fx:id="btnMinus"
    private Button btnMinus; // Value injected by FXMLLoader

    @FXML // fx:id="btnMultiply"
    private Button btnMultiply; // Value injected by FXMLLoader

    @FXML // fx:id="btnDevited"
    private Button btnDevited; // Value injected by FXMLLoader

    @FXML // fx:id="btnEquals"
    private Button btnEquals; // Value injected by FXMLLoader

    @FXML // fx:id="btnC"
    private Button btnC; // Value injected by FXMLLoader

    @FXML // fx:id="btnCA"
    private Button btnCA; // Value injected by FXMLLoader

    @FXML // fx:id="btnOff"
    private Button btnOff; // Value injected by FXMLLoader

    @FXML // fx:id="txtCurrentCalcultaion"
    private TextField txtCurrentCalcultaion; // Value injected by FXMLLoader

    @FXML // fx:id="txtInput"
    private TextField txtInput; // Value injected by FXMLLoader

    @FXML // fx:id="btnSeven"
    private Button btnSeven; // Value injected by FXMLLoader

    @FXML // fx:id="btnEight"
    private Button btnEight; // Value injected by FXMLLoader

    @FXML // fx:id="btnNine"
    private Button btnNine; // Value injected by FXMLLoader

    @FXML // fx:id="btnZero"
    private Button btnZero; // Value injected by FXMLLoader

    @FXML // fx:id="btnDoubleZero"
    private Button btnDoubleZero; // Value injected by FXMLLoader

    @FXML
    void btnNineActivation(ActionEvent event) {
        if(operation == "="){
            clear();
        }
        if(operation == "."){
            if(sepCounter == 0)
                number = new BigDecimal("0");
            sepCounter++;
        }

        int numberData = number.intValue();
        if(numberData == 0) number = number.add(BigDecimal.valueOf(9));
        else {
            number = number.multiply(BigDecimal.valueOf(10));
            number = number.add(BigDecimal.valueOf(9));
        }

        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);

        if(operation != ".")
            txtInput.setText(floor + "");
        else{
            txtInputField = txtInputFieldBase + floor.toString();
            txtInput.setText(txtInputField);
        }
    }

    @FXML
    void btnEightActivation(ActionEvent event) {
        if(operation == "="){
            clear();
        }
        if(operation == "."){
            if(sepCounter == 0)
                number = new BigDecimal("0");
            sepCounter++;
        }
        int numberData = number.intValue();
        if (numberData == 0) number = number.add(BigDecimal.valueOf(8));
        else {
            number = number.multiply(BigDecimal.valueOf(10));
            number = number.add(BigDecimal.valueOf(8));
        }

        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);

        if(operation != ".")
            txtInput.setText(floor + "");
        else{
            txtInputField = txtInputFieldBase + floor.toString();
            txtInput.setText(txtInputField);
        }
    }

    @FXML
    void btnSevenActivation(ActionEvent event) {
        if(operation == "="){
            clear();
        }
        if(operation == "."){
            if(sepCounter == 0)
                number = new BigDecimal("0");
            sepCounter++;
        }
        int numberData = number.intValue();
        if(numberData == 0) number = number.add(BigDecimal.valueOf(7));
        else {
            number = number.multiply(BigDecimal.valueOf(10));
            number = number.add(BigDecimal.valueOf(7));
        }

        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);

        if(operation != ".")
            txtInput.setText(floor + "");
        else{
            txtInputField = txtInputFieldBase + floor.toString();
            txtInput.setText(txtInputField);
        }
    }

    @FXML
    void btnSixActivation(ActionEvent event) {
        if(operation == "="){
            clear();
        }
        if(operation == "."){
            if(sepCounter == 0)
                number = new BigDecimal("0");
            sepCounter++;
        }
        int numberData = number.intValue();
        if(numberData == 0) number = number.add(BigDecimal.valueOf(6));
        else {
            number = number.multiply(BigDecimal.valueOf(10));
            number = number.add(BigDecimal.valueOf(6));
        }

        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);

        if(operation != ".")
            txtInput.setText(floor + "");
        else{
            txtInputField = txtInputFieldBase + floor.toString();
            txtInput.setText(txtInputField);
        }
    }

    @FXML
    void btnFiveActivation(ActionEvent event) {
        if(operation == "="){
            clear();
        }
        if(operation == "."){
            if(sepCounter == 0)
                number = new BigDecimal("0");
            sepCounter++;
        }
        int numberData = number.intValue();
        if(numberData == 0) number = number.add(BigDecimal.valueOf(5));
        else {
            number = number.multiply(BigDecimal.valueOf(10));
            number = number.add(BigDecimal.valueOf(5));
        }

        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);

        if(operation != ".")
            txtInput.setText(floor + "");
        else{
            txtInputField = txtInputFieldBase + floor.toString();
            txtInput.setText(txtInputField);
        }
    }

    @FXML
    void btnFourActivation(ActionEvent event) {
        if(operation == "="){
            clear();
        }
        if(operation == "."){
            if(sepCounter == 0)
                number = new BigDecimal("0");
            sepCounter++;
        }
        int numberData = number.intValue();
        if(numberData == 0) number = number.add(BigDecimal.valueOf(4));
        else {
            number = number.multiply(BigDecimal.valueOf(10));
            number = number.add(BigDecimal.valueOf(4));
        }

        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);

        if(operation != ".")
            txtInput.setText(floor + "");
        else{
            txtInputField = txtInputFieldBase + floor.toString();
            txtInput.setText(txtInputField);
        }
    }

    @FXML
    void btnThreeActivation(ActionEvent event) {
        if(operation == "="){
            clear();
        }
        if(operation == "."){
            if(sepCounter == 0)
                number = new BigDecimal("0");
            sepCounter++;
        }
        int numberData = number.intValue();
        if(numberData == 0) number = number.add(BigDecimal.valueOf(3));
        else {
            number = number.multiply(BigDecimal.valueOf(10));
            number = number.add(BigDecimal.valueOf(3));
        }

        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);

        if(operation != ".")
            txtInput.setText(floor + "");
        else{
            txtInputField = txtInputFieldBase + floor.toString();
            txtInput.setText(txtInputField);
        }
    }

    @FXML
    void btnTwoActivation(ActionEvent event) {
        if(operation == "="){
            clear();
        }
        if(operation == "."){
            if(sepCounter == 0)
                number = new BigDecimal("0");
            sepCounter++;
        }
        int numberData = number.intValue();
        if(numberData == 0) number = number.add(BigDecimal.valueOf(2));
        else {
            number = number.multiply(BigDecimal.valueOf(10));
            number = number.add(BigDecimal.valueOf(2));
        }

        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);

        if(operation != ".")
            txtInput.setText(floor + "");
        else{
            txtInputField = txtInputFieldBase + floor.toString();
            txtInput.setText(txtInputField);
        }
    }

    @FXML
    void btnOneActivation(ActionEvent event) {
        if(operation == "="){
            clear();
        }
        if(operation == "."){
            if(sepCounter == 0)
                number = new BigDecimal("0");
            sepCounter++;
        }
        int numberData = number.intValue();
        if(numberData == 0) number = number.add(BigDecimal.valueOf(1));
        else {
            number = number.multiply(BigDecimal.valueOf(10));
            number = number.add(BigDecimal.valueOf(1));
        }

        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);

        if(operation != ".")
            txtInput.setText(floor + "");
        else{
            txtInputField = txtInputFieldBase + floor.toString();
            txtInput.setText(txtInputField);
        }
    }

    @FXML
    void btnZeroActivation(ActionEvent event) {
        if(operation == "="){
            clear();
        }
        if(operation == "."){
            if(sepCounter == 0)
                number = new BigDecimal("0");
            sepCounter++;
        }
        int numberData = number.intValue();
        if(numberData == 0) number = number.add(BigDecimal.valueOf(0));
        else {
            number = number.multiply(BigDecimal.valueOf(10));
            number = number.add(BigDecimal.valueOf(0));
        }

        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);

        if(operation != ".")
            txtInput.setText(floor + "");
        else{
            txtInputField = txtInputFieldBase + floor.toString();
            txtInput.setText(txtInputField);
        }
    }

    @FXML
    void btnDoubleZeroActivation(ActionEvent event) {
        if(operation == "="){
            clear();
        }
        if(operation == "."){
            if(sepCounter == 0)
                number = new BigDecimal("0");
            sepCounter++;
        }
        int numberData = number.intValue();
        if(numberData == 0) number = number.add(BigDecimal.valueOf(0));
        else {
            number = number.multiply(BigDecimal.valueOf(100));
            //number = number.add(BigInteger.valueOf(3));
        }

        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);

        if(operation != ".")
            txtInput.setText(floor + "");
        else{
            txtInputField = txtInputFieldBase + floor.toString();
            txtInput.setText(txtInputField);
        }
    }

    public void txtButtonPressed(KeyEvent keyEvent) {
        if(operation == "="){
            clear();
        }

        String key = keyEvent.getText();
        String txtNumber = txtInput.getText();
        int currentNum = 0;

        KeyCode code = keyEvent.getCode();
        if (code != KeyCode.BACK_SPACE || code != KeyCode.LEFT || code != KeyCode.RIGHT || code != KeyCode.ALT || code != KeyCode.CONTROL || code != KeyCode.SHIFT || code != KeyCode.NUM_LOCK) {
            if(!key.equals("")) {
                try {
                    currentNum = Integer.parseInt(key);
                    if(currentNum == 0) number = number.add(BigDecimal.valueOf(currentNum));
                    else {
                        number = number.multiply(BigDecimal.valueOf(10));
                        number = number.add(BigDecimal.valueOf(currentNum));
                    }

                    //txtInput.setText(number + "");
                } catch (Exception exp) {
                    txtInput.setText(number.toString());
                }
            }
            else{
                if(txtNumber.equals("")){
                    number = new BigDecimal("0");
                }
            }
        }
        else{
            BigDecimal currNumber = new BigDecimal(txtNumber);
            number = currNumber;
        }
    }

    @FXML
    void btnOffActivation(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnPlusActivation(ActionEvent event) {
        BigDecimal leftNumber;
        if(sepCounter > 0){
            leftNumber = new BigDecimal(txtInputField);
        }
        else {
            leftNumber = number;
        }

        currentResult = secondNumber.add(leftNumber);
        secondNumber = leftNumber;
        number = new BigDecimal("0");
        txtInput.setText(currentResult.toString());

        if(operation == "."){
            currTxtFieldText += txtInputField + " +";
            number = new BigDecimal(txtInputField);

            //currentResult = secondNumber.add(number);
            //secondNumber = leftNumber;
            //number = new BigDecimal("0");
            txtInput.setText(currentResult.toString());
            sepCounter = 0;
        }
        else
            currTxtFieldText += leftNumber + " +";

        txtCurrentCalcultaion.setText(currTxtFieldText.toString());
        operation = "+";
    }

    @FXML
    void btnMinusActivation(ActionEvent event) {
        operation = "-";

        BigDecimal leftNumber = number;
        currentResult = number.subtract(secondNumber);
        secondNumber = leftNumber;
        number = new BigDecimal("0");
        txtInput.setText(currentResult.toString());

        currTxtFieldText += leftNumber + " -";

        txtCurrentCalcultaion.setText(currTxtFieldText);
    }

    @FXML
    void btnMultiplicationActivation(ActionEvent event) {
        mulCounter++;
        operation = "*";

        secondNumber = new BigDecimal("1");
        BigDecimal leftNumber = number;

        BigDecimal floor = leftNumber.setScale(0, RoundingMode.FLOOR);

        if(mulCounter > 1){
            currentResult = currentResult.multiply(number);
        }
        else {
            currentResult = number.multiply(secondNumber);
        }

        BigDecimal floorCurrRes = currentResult.setScale(0, RoundingMode.FLOOR);

        secondNumber = floor;
        number = new BigDecimal("0");
        txtInput.setText(floorCurrRes.toString());

        currTxtFieldText += floor + " *";

        txtCurrentCalcultaion.setText(currTxtFieldText);

        //currTxtFieldText = "";
    }

    @FXML
    void btnDeviationActivation(ActionEvent event) {
        devCounter++;
        operation = "/";
        secondNumber = new BigDecimal("1");
        BigDecimal leftNumber = number;
        if(devCounter > 1){
            currentResult = currentResult.divide(number);
        }
        else {
            currentResult = number.divide(secondNumber);
        }
        secondNumber = leftNumber;
        number = new BigDecimal("0");
        txtInput.setText(currentResult.toString());

        currTxtFieldText += leftNumber + " ÷";

        txtCurrentCalcultaion.setText(currTxtFieldText);
    }

    @FXML
    void btnPointSepActivation(ActionEvent event) {
        operation = ".";
        BigDecimal floor = number.setScale(0, RoundingMode.FLOOR);
        txtInputField = floor.toString();
        txtInputField += ".";
        txtInputFieldBase = txtInputField;
        txtInput.setText(txtInputField);
    }

    @FXML
    void btnCAActivation(ActionEvent event) {
        clear();
    }

    @FXML
    void btnCAAtivation(ActionEvent event) {
        BigDecimal leftNumber = number;
        secondNumber = leftNumber;
        number = new BigDecimal("0");

        currTxtFieldText = leftNumber + " +";

        txtCurrentCalcultaion.setText(currTxtFieldText);
        operation = "+";
    }

    @FXML
    void btnEqualsActivation(ActionEvent event) {
        currTxtFieldText += " ";
        if(operation == "+"){
            if(sepCounter > 0){
                number = new BigDecimal(txtInputField);
            }
            currentResult = currentResult.add(number);
        }
        else if(operation == "-"){
            currentResult = currentResult.subtract(number);
        }
        else if(operation == "*"){
            mulCounter = 0;
            currentResult = currentResult.multiply(number);
        }
        else if(operation == "."){

        }

        else if(operation == "/"){
            if(devCounter > 1){
                devCounter = 0;
                currentResult = currentResult.divide(number, 8, BigDecimal.ROUND_HALF_UP);
            }
            else {
                devCounter = 0;
                currentResult = currentResult.divide(number, 8, BigDecimal.ROUND_HALF_UP);
            }
        }

        BigDecimal floor = currentResult.setScale(0, RoundingMode.FLOOR);
        BigDecimal ceiling = currentResult.setScale(0, RoundingMode.CEILING);


        if(floor.equals(ceiling)){
            currentResult = currentResult.setScale(0, RoundingMode.CEILING);
        }

        currTxtFieldText += " ";
        currTxtFieldText += number.toString();
        currTxtFieldText += " =";

        txtCurrentCalcultaion.setText(currTxtFieldText);
        txtInput.setText(currentResult.toString());

        operation = "=";
    }

    public void clear(){
        number = new BigDecimal("0");
        secondNumber = new BigDecimal("0");

        txtCurrentCalcultaion.setText("");
        txtInput.setText("");
        currTxtFieldText = "";
    }

    public FXMLCalcController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/sample.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert mainGrid != null : "fx:id=\"mainGrid\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnOne != null : "fx:id=\"btnOne\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnTwo != null : "fx:id=\"btnTwo\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnThree != null : "fx:id=\"btnThree\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnFive != null : "fx:id=\"btnFive\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSix != null : "fx:id=\"btnSix\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnFour != null : "fx:id=\"btnFour\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnPointSep != null : "fx:id=\"btnPointSep\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMultiply != null : "fx:id=\"btnMultiply\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDevited != null : "fx:id=\"btnDevited\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEquals != null : "fx:id=\"btnEquals\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnC != null : "fx:id=\"btnC\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnCA != null : "fx:id=\"btnCA\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnOff != null : "fx:id=\"btnOff\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtCurrentCalcultaion != null : "fx:id=\"txtCurrentCalcultaion\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSeven != null : "fx:id=\"btnSeven\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEight != null : "fx:id=\"btnEight\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnNine != null : "fx:id=\"btnNine\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnZero != null : "fx:id=\"btnZero\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDoubleZero != null : "fx:id=\"btnDoubleZero\" was not injected: check your FXML file 'sample.fxml'.";
    }
}
