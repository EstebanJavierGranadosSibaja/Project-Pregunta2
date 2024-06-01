/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import io.github.palexdev.materialfx.controls.MFXCircleToggleNode;
import io.github.palexdev.materialfx.controls.MFXSlider;
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
        if(toggleEasy.isSelected()){
            gamemode = "F";
        } else if(toggleMid.isSelected()){
            gamemode = "M";
        } else {
            gamemode = "D";
        }
        
        // Then configure the main player + the secondary local players

        // create an instance of the game controller and pass the parameters
        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");
        int playerCount = (int) nonMFXspinner.getValue();


        gameController.setUpGameEnviroment(playerCount, gamemode, toggleDuelMode.isSelected() ? "A" : "I", (int) sldrGameTime.getValue());

        FlowController.getInstance().goView("GameView");
    }

    @FXML
    private void onActionCancel(ActionEvent event) {
        // clear the game parameters and go back to the menu

        
        FlowController.getInstance().goView("MenuView");
    }

    
}
