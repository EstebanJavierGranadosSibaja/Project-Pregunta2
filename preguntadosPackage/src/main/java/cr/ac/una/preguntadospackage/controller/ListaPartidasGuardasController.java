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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author esteb
 */
public class ListaPartidasGuardasController extends Controller implements Initializable {

    @FXML
    private MFXTextField txtNombre;
    @FXML
    private MFXTextField txtModoJuego;
    @FXML
    private MFXTextField txtModoDuelo;
    @FXML
    private MFXTextField txtCantidadRondasJugadas;
    @FXML
    private MFXTextField txtCantidadJugadores;
    @FXML
    private MFXTextField txtEstadoPartida;
    @FXML
    private MFXButton btnFiltrar;
    @FXML
    private TableView<?> tbvPartidas;
    @FXML
    private TableColumn<?, ?> tbcId;
    @FXML
    private TableColumn<?, ?> tbcNombre;
    @FXML
    private TableColumn<?, ?> tbcModoJuego;
    @FXML
    private TableColumn<?, ?> tbcModoDuelo;
    @FXML
    private TableColumn<?, ?> tbcCantidadRondasJugadas;
    @FXML
    private TableColumn<?, ?> tbcCantidadJugadores;
    @FXML
    private MFXButton btnVolver;
    @FXML
    private MFXButton btnAceptar11;
    @FXML
    private MFXTextField txtIdPartida;
    @FXML
    private TableColumn<?, ?> tbcEstadoPartida;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onActionFiltrar(ActionEvent event) {
    }

    @FXML
    private void onMousePressedTbvPartidas(MouseEvent event) {
    }

    @FXML
    private void onAcionVolver(ActionEvent event) {
        tbvPartidas.refresh();
        FlowController.getInstance().goView("MenuView");
    }

    @FXML
    private void onAcionAceptar(ActionEvent event) {
    }

    @Override
    public void initialize() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
