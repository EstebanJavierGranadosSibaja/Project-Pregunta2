/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Flow;

import io.github.palexdev.materialfx.controls.MFXCircleToggleNode;
import io.github.palexdev.materialfx.controls.MFXSlider;
import io.github.palexdev.materialfx.controls.MFXSpinner;
import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author Matteo2K24
 */
public class GameParametersController extends Controller implements Initializable {

    @FXML
    private MFXButton btnStart;
    @FXML
    private Label test;
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
    private MFXCircleToggleNode toggleHard1;
    @FXML
    private Label lblGameTime;
    @FXML
    private MFXSlider sldrGameTime;

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
        // Here all the texts inputs and checks should checked to see if they
        // are correctly filled
        
        // Then configure the main player + the secondary local players

        // create an instance of the game controller and pass the parameters
        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");
        gameController.setupPlayerCount((int) nonMFXspinner.getValue(), 1);

        FlowController.getInstance().goView("GameView");
    }

    @FXML
    private void onActionCancel(ActionEvent event) {
        // Here all the texts inputs and checks should be cleared
        // boing, cleared!
        
        FlowController.getInstance().goView("MenuView");
    }

    
}
