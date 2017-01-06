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
    private ChoiceBox amountOfTeapots;
    @FXML
    private ChoiceBox amountOfBulbs;
    @FXML
    private ChoiceBox amountOfComputers;

    @FXML
    private TextField energyForTeapot;
    @FXML
    private TextField energyForBulb;
    @FXML
    private TextField energyForComputer;

    @FXML
    private Label stateOfTeapots;
    @FXML
    private Label stateOfBulbs;
    @FXML
    private Label stateOfComputers;

    @FXML
    private ToggleButton btn;

    public void pressCounter() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        amountOfTeapots.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9" , "10");
        amountOfTeapots.getSelectionModel().select("1");
        amountOfBulbs.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9" , "10");
        amountOfBulbs.getSelectionModel().select("1");
        amountOfComputers.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9" , "10");
        amountOfComputers.getSelectionModel().select("1");
    }
}