package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ChoiceBox count1;
    @FXML
    private ChoiceBox count2;
    @FXML
    private ChoiceBox count3;

    @FXML
    private TextField energy1;
    @FXML
    private TextField energy2;
    @FXML
    private TextField energy3;

    @FXML
    private Label state1;
    @FXML
    private Label state2;
    @FXML
    private Label state3;

    @FXML
    private ToggleButton btn;

    public void press() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        count1.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9" , "10");
        count1.getSelectionModel().select("1");
        count2.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9" , "10");
        count2.getSelectionModel().select("1");
        count3.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9" , "10");
        count3.getSelectionModel().select("1");
    }
}