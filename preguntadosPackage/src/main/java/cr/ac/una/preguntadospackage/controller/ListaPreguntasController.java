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
public class ListaPreguntasController extends Controller implements Initializable {

    @FXML
    private MFXTextField txtId;
    @FXML
    private MFXTextField txtCategoria;
    @FXML
    private MFXTextField txtEnunciado;
    @FXML
    private MFXTextField txtCantidadRespuestas;
    @FXML
    private MFXTextField txtCantidadAciertos;
    @FXML
    private MFXButton btnFiltrar;
    @FXML
    private TableView<?> tbvPreguntas;
    @FXML
    private TableColumn<?, ?> tbcId;
    @FXML
    private TableColumn<?, ?> tbcCategoria;
    @FXML
    private TableColumn<?, ?> tbcEnunciado;
    @FXML
    private TableColumn<?, ?> tbcCantidadRespuestas;
    @FXML
    private TableColumn<?, ?> tbcCantidadAcertadas;
    @FXML
    private MFXButton btnVolver;
    @FXML
    private MFXButton btnAceptar11;

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
    private void onActionFiltrar(ActionEvent event) {
    }

    @FXML
    private void onMousePressedTbvPreguntas(MouseEvent event) {
    }

    @FXML
    private void onAcionVolver(ActionEvent event) {
         FlowController.getInstance().goView("MenuView");
    }

    @FXML
    private void onAcionAceptar(ActionEvent event) {
    }
    
}
