package sample;

import javafx.application.Platform;
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
    private ToggleButton counter;

    @FXML
    private TextField maxEnergyPerTime;

    static ThreadForCounter counterThread;

    int currentEnergy = 0;
    int energyPerTime = 0;
    int int_maxEnergyPerTime = 0;

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

        energyPerTime = energyForAllTeapots + energyForAllBulbs + energyForAllComputers;
        int_maxEnergyPerTime = Integer.parseInt(String.valueOf(maxEnergyPerTime.getText()));

        if (energyPerTime > int_maxEnergyPerTime) {
            counter.setText("ВЫКЛ");
            counter.setSelected(false);
            return;
        } else {
            counterThread = new ThreadForCounter();
            counterThread.start();
        }
    }

    class ThreadForCounter extends Thread {
        @Override
        public void run() {
            while(true) {
                try {
                    currentEnergy += energyPerTime;
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            counter.setText(String.valueOf(currentEnergy));
                            stateOfTeapots.setText("ВКЛ");
                            stateOfBulbs.setText("ВКЛ");
                        }
                    });
                    sleep(1000);
                } catch(IllegalStateException e1) {
                    e1.printStackTrace();
                } catch(InterruptedException e2) {
                    e2.printStackTrace();
                }
                if(!counter.isSelected()) {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            stateOfTeapots.setText("Остывает");
                            stateOfBulbs.setText("ВЫКЛ");
                        }
                    });
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