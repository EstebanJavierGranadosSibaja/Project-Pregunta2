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
 * FXML Controller class Controller for the "SobreNosotrosView" (About Us) view.
 *
 * @author Matteo2K24
 */
public class SobreNosotrosController extends Controller implements Initializable {

    @FXML
    private MFXButton btnQuitInfo;

    /**
     * Initializes the controller class. This method is called when the
     * controller is initialized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * Initializes the controller. This method is called when the controller is
     * initialized.
     */
    @Override
    public void initialize() {
    }

    /**
     * Handles the action when the user clicks on the "Quit Info" button.
     * Returns to the main menu view.
     */
    @FXML
    private void onActionQuitInfo(ActionEvent event) {
        FlowController.getInstance().goView("MenuView");
    }

}
