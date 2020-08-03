
package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private Button btnTahmin;

    @FXML
    private Button btBasla;

    @FXML
    private TextField txtBasamak;

    @FXML
    private TextField txtTahmin;

    @FXML
    private Label lblBasamak;

    @FXML
    private Label lblRapor;

    @FXML
    private ListView<String> lstRapor;

    @FXML
    private ListView<String> lstRaporSayi;

    private int digitCount = 0;
    int number = 0;
    int counter = 0;
    private ObservableList<String> messageList = FXCollections.observableArrayList();
    private ObservableList<String> guessList = FXCollections.observableArrayList();
    GuessIt guessIt = new GuessIt();


    @FXML
    private void appoint() {
        digitCount = Integer.parseInt(txtBasamak.getText());
        Randomizer randomizer = new Randomizer();
        txtBasamak.setEditable(false);
        btBasla.setDisable(true);
        number = randomizer.produce(digitCount);
        txtTahmin.requestFocus();
    }

    @FXML
    private void guess() {
        if(digitCount<1) {
            lblRapor.setText("Önce rakam sayısı belirtmelisiniz.");
            return;
        }
        int calc = Integer.parseInt(txtTahmin.getText());

        if(!guessIt.guessTheNumber(number, calc)){
            counter++;
            lblRapor.setText(counter + ". tahmin : " + calc);
            guessList.add(lblRapor.getText());
            messageList.add(guessIt.message);
            lstRapor.setItems(messageList);
            lstRaporSayi.setItems(guessList);

            txtTahmin.setText("");
            txtTahmin.requestFocus();
        }else {
            ++counter;
            lblRapor.setText(counter + ". tahminde buldunuz : " + calc);
            guessList.add(lblRapor.getText());
            messageList.add(guessIt.message);
            txtTahmin.setEditable(false);
        }
    }

}
