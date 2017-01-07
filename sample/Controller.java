package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class Controller implements Initializable {

    final int MAX_ENERGY_PER_TIME = 1000;

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
    private ToggleButton counter;

    @FXML
    private TextField maxEnergyPerTime;

    public void pressCounter() throws InterruptedException {
        int int_amountOfTeapots = Integer.parseInt((String) amountOfTeapots.getValue());
        int int_energyForTeapot = Integer.parseInt(energyForTeapot.getText());
        int energyForAllTeapots = int_amountOfTeapots  * int_energyForTeapot;

        int int_amountOfBulbs = Integer.parseInt((String) amountOfBulbs.getValue());
        int int_energyForBulb = Integer.parseInt(energyForBulb.getText());
        int energyForAllBulbs = int_amountOfBulbs  * int_energyForBulb;

        int int_amountOfComputers = Integer.parseInt((String) amountOfComputers.getValue());
        int int_energyForComputer = Integer.parseInt(energyForComputer.getText());
        int energyForAllComputers = int_amountOfComputers  * int_energyForComputer;

        int energyPerTime = energyForAllTeapots + energyForAllBulbs + energyForAllComputers;

        int currentEnergy = 0;

        if (energyPerTime > Integer.parseInt(String.valueOf(maxEnergyPerTime.getText()))) {
            counter.setText("ВЫКЛ");
            counter.setSelected(false);
            return;
        } else {
            while(true) {
                currentEnergy = currentEnergy + energyPerTime;
                System.out.println(String.valueOf((int)currentEnergy));
                //counter.setText(String.valueOf((int)currentEnergy));
                Thread.sleep(5000);
                if(!counter.isSelected()) {
                    break;
                }
            }
        }
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