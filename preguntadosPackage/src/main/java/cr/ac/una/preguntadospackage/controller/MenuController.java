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

/**
 * FXML Controller class
 *
 * @author Matteo2K24
 */
public class MenuController extends Controller implements Initializable {

    @FXML
    private MFXButton btnPlayMultiplayer;
    @FXML
    private MFXButton btnInfo;
    @FXML
    private MFXButton btnQuestionMaintenance;
    @FXML
    private MFXButton btnSettings;

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
    private void onActionPlayMultiplayer(ActionEvent event) {
        FlowController.getInstance().goView("GameParametersView");
    }


    @FXML
    private void onActionInfo(ActionEvent event) {
        FlowController.getInstance().goView("InformationView");
    }

    @FXML
    private void onActionQuestionMaintenance(ActionEvent event) {
    }

    @FXML
    private void onActionSettings(ActionEvent event) {
        FlowController.getInstance().goView("SettingsView");
    }
    
}
