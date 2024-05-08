/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
    }

    @FXML
    private void onActionStart(ActionEvent event) {
        // Here all the texts inputs and checks should checked to see if they
        // are correctly filled
        
        // Then configure the main player + the secondary local players
        
        FlowController.getInstance().goView("GameView");
    }

    @FXML
    private void onActionCancel(ActionEvent event) {
        // Here all the texts inputs and checks should be cleared
        // boing, cleared!
        
        FlowController.getInstance().goView("MenuView");
    }

    
}