/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.Mensaje;
import cr.ac.una.preguntadospackage.util.soundUtils;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCircleToggleNode;
import io.github.palexdev.materialfx.controls.MFXSlider;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;

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
    @FXML
    private MFXTextField txtNombrePartida;
    
    private String nombrePartida;

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
        soundUtils.getInstance().playSound("click");
        String gamemode;
        // get the selected game mode
        if (toggleEasy.isSelected()) {
            gamemode = "F";
        } else if (toggleMid.isSelected()) {
            gamemode = "M";
        } else {
            gamemode = "D";
        }

        nombrePartida = txtNombrePartida.getText();
        
        // get the selected player count
        int playerCount = (int) nonMFXspinner.getValue();

        PlayerSelectionController playerSelectionController = (PlayerSelectionController) FlowController.getInstance().getController("PlayerSelectionView");
        playerSelectionController.recieveParametersFromParametersView(playerCount, gamemode, "D", (int) sldrGameTime.getValue());
        FlowController.getInstance().goView("PlayerSelectionView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Seleccion del Jugador y su Peon", getStage(), "Acá podras escoger el nombre de los jugadores y sus peones correspondientes.");

    }

    @FXML
    private void onActionCancel(ActionEvent event) {
        soundUtils.getInstance().playSound("click");
        // reset the game parameters
        nonMFXspinner.getValueFactory().setValue(2);
        sldrGameTime.setValue(1);
        toggleEasy.setSelected(true);
        toggleDuelMode.setSelected(false);
        toggleMid.setSelected(false);
        toggleHard.setSelected(false);
        FlowController.getInstance().goView("MenuView");
    }

    @FXML
    private void onActionTxtNombrePartida(ActionEvent event) {
    }

    public String getNombrePartida() {
        return nombrePartida;
    }

}
