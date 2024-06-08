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

public class OpcionesDeMantenimientoController extends Controller implements Initializable {

    @FXML
    private MFXButton btnModificarPreguntas;
    @FXML
    private MFXButton btnNuevaPregunta;
    @FXML
    private MFXButton btnVolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void initialize() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void onActionBtnModificarPreguntas(ActionEvent event) {
        FlowController.getInstance().goView("ListaPreguntasView");
    }

    @FXML
    private void onActionBtnNuevaPregunta(ActionEvent event) {
        FlowController.getInstance().goView("MantenimientoPreguntasView");
    }

    @FXML
    private void onActionBtnVolver(ActionEvent event) {
        FlowController.getInstance().goView("MenuView");
    }

}
