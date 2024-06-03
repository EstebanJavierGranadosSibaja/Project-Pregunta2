/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCircleToggleNode;
import io.github.palexdev.materialfx.controls.MFXSlider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Matteo2K24
 */
public class GameParametersController extends Controller implements Initializable {

    @FXML
    private MFXButton btnStart;
    @FXML
    private MFXButton btnCancel;
    @FXML
    private MFXCircleToggleNode toggleHard;
    @FXML
    private ToggleGroup Difficulty;
    @FXML
    private MFXCircleToggleNode toggleMid;
    @FXML
    private MFXCircleToggleNode toggleEasy;
    @FXML
    private Spinner nonMFXspinner;
    @FXML
    private ToggleGroup Difficulty1;
    @FXML
    private MFXSlider sldrGameTime;
    @FXML
    private Label lblGameTime1;
    @FXML
    private Label test1;
    @FXML
    private MFXCircleToggleNode toggleDuelMode;

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // start the spinner with 1 player
        nonMFXspinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 6, 2));
    }
    @Override
    public void initialize() {
    }

    @FXML
    private void onActionStart(ActionEvent event) {
        String gamemode;
        // get the selected game mode
        if(toggleEasy.isSelected()) gamemode = "F";
        else if(toggleMid.isSelected())gamemode = "M";
        else gamemode = "D";

        // get the selected player count
        int playerCount = (int) nonMFXspinner.getValue();

        PlayerSelectionController playerSelectionController = (PlayerSelectionController) FlowController.getInstance().getController("PlayerSelectionView");
        playerSelectionController.recieveParametersFromParametersView(playerCount, gamemode, "D", (int) sldrGameTime.getValue());
        FlowController.getInstance().goView("PlayerSelectionView");
    }

    @FXML
    private void onActionCancel(ActionEvent event) {
        // TODO: reset all the data
        FlowController.getInstance().goView("MenuView");
    }

    
}
