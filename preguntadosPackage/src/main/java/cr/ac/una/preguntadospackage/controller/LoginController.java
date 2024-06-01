/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.animationUtils;
import cr.ac.una.preguntadospackage.util.soundUtils;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
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
public class LoginController extends Controller implements Initializable {

    @FXML
    private MFXTextField txtTag;
    @FXML
    private MFXTextField txtPassword;
    @FXML
    private MFXButton btnLogin;
    @FXML
    private MFXButton btnHelp;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void initialize() {
    }

    @FXML
    private void onActionLogin(ActionEvent event) {
        // play a sound
        soundUtils.getInstance().playSound("click");
        FlowController.getInstance().goMain();
        FlowController.getInstance().goView("MenuView");
        getStage().close();
    }
    


    @FXML
    private void onActionHelp(ActionEvent event) {
    }

    
}
