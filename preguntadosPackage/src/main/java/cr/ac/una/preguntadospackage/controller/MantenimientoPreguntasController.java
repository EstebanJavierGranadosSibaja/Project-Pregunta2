/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
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
 * @author esteb
 */
public class MantenimientoPreguntasController extends Controller implements Initializable {

    @FXML
    private MFXTextField txtEnunciadoPregunta;
    @FXML
    private MFXButton btnVolver;
    @FXML
    private MFXButton btnAceptarGuardar;
    @FXML
    private MFXTextField txtRespuesta1;
    @FXML
    private MFXTextField txtRespuesta2;
    @FXML
    private MFXTextField txtRespuesta4;
    @FXML
    private MFXTextField txtRespuesta3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onActionBtnVolver(ActionEvent event) {
        txtEnunciadoPregunta.clear();
        txtRespuesta1.clear();
        txtRespuesta2.clear();
        txtRespuesta3.clear();
        txtRespuesta4.clear();
        FlowController.getInstance().goView("OpcionesDeMantenimientoView");
    }

    @FXML
    private void onActionBtnAceptarGuardar(ActionEvent event) {
        txtEnunciadoPregunta.clear();
        txtRespuesta1.clear();
        txtRespuesta2.clear();
        txtRespuesta3.clear();
        txtRespuesta4.clear();
        FlowController.getInstance().goView("OpcionesDeMantenimientoView");
    }

    @Override
    public void initialize() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
