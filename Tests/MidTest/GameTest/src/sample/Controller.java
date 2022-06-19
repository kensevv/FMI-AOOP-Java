package sample;

        import java.net.URL;
        import java.util.ResourceBundle;

        import cards.BeziqueCards;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextArea;

public class Controller {
    private BeziqueCards deck;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonDealHand;

    @FXML
    private Button buttonHasAKQJ10;

    @FXML
    private Button buttonCheckMarriage;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private Label trumpLabel;

    @FXML
    void btnDealHand(ActionEvent event) {
        textArea2.setText(""); // clearing text area 2

        boolean hasMoreCardsToDeal = deck.dealHand();

        textArea1.setText(deck.printCards());

        if(hasMoreCardsToDeal == false){
            buttonDealHand.setDisable(true);
        }
    }

    @FXML
    void btnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnHasAKQJ10(ActionEvent event) {
        if(deck.hasAKQJ10()){
            textArea2.appendText(String.format("В изтеглената ръка има ACE, KING, QUEEN, JACK, TEN от Коз: %s \n", deck.getTrump().name()));
        }
        else {
            textArea2.appendText(String.format("В изтеглената ръка НЯМА ACE, KING, QUEEN, JACK, TEN от Коз: %s \n", deck.getTrump().name()));
        }
    }

    @FXML
    void btnHasMarriage(ActionEvent event) {
        if (deck.hasMarriage() == true){
            textArea2.appendText(String.format("В изтеглената ръка има двойка KING-QUEEN от Коз: %s \n", deck.getTrump().name()));
        }
        else {
            textArea2.appendText(String.format("В изтеглената ръка НЯМА двойка KING-QUEEN от Коз: %s \n", deck.getTrump().name()));
        }

    }

    @FXML
    void initialize() {
        assert buttonDealHand != null : "fx:id=\"buttonDealHand\" was not injected: check your FXML file 'sample.fxml'.";
        assert buttonHasAKQJ10 != null : "fx:id=\"buttonHasAKQJ10\" was not injected: check your FXML file 'sample.fxml'.";
        assert buttonCheckMarriage != null : "fx:id=\"buttonCheckMarriage\" was not injected: check your FXML file 'sample.fxml'.";
        assert textArea1 != null : "fx:id=\"textArea1\" was not injected: check your FXML file 'sample.fxml'.";
        assert textArea2 != null : "fx:id=\"textArea2\" was not injected: check your FXML file 'sample.fxml'.";
        assert trumpLabel != null : "fx:id=\"trumpLabel\" was not injected: check your FXML file 'sample.fxml'.";

        deck = new BeziqueCards();
        deck.shuffleCards();
        trumpLabel.setText( String.format("TRUMP: %s", deck.getTrump().name()));
    }
}
