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
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author esteb
 */
public class EstadisticasDelJugadorController extends Controller implements Initializable {

    @FXML
    private PieChart pchGeneral;
    @FXML
    private PieChart pchCiencias;
    @FXML
    private PieChart pchHistoria;
    @FXML
    private PieChart pchGeografia;
    @FXML
    private PieChart pchArte;
    @FXML
    private PieChart pchEntretenimiento;
    @FXML
    private PieChart pchDeporte;
    @FXML
    private MFXButton btnVolver;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void onActionBtnVolver(ActionEvent event) {
        FlowController.getInstance().goView("ListaJugadoresView");
    }
    
}
