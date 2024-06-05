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
    private MFXButton btnMantenimientoPreguntas;
    @FXML
    private MFXButton btnRankedGlobal;
    @FXML
    private MFXButton btnSobreNosotros;
    @FXML
    private MFXButton btnInformacion;
    @FXML
    private MFXButton btnCargarPartida;

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
    private void onActionMentenimientoPreguntas(ActionEvent event) {
        FlowController.getInstance().goView("ListaPreguntasView");
    }

    @FXML
    private void onActionRankedGlobal(ActionEvent event) {
        FlowController.getInstance().goView("ListaJugadoresView");
    }

    @FXML
    private void onActionSobreNosotros(ActionEvent event) {
         FlowController.getInstance().goView("SobreNosotrosView");
    }

    @FXML
    private void onActionInformacion(ActionEvent event) {
        FlowController.getInstance().goView("InformacionView");
    }

    @FXML
    private void onActionCargarPartida(ActionEvent event) {
    }
}
