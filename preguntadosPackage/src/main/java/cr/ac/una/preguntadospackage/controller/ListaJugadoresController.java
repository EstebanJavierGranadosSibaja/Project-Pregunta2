/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.model.PregJugadoresDto;
import cr.ac.una.preguntadospackage.service.PregJugadoresService;
import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.Respuesta;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class ListaJugadoresController extends Controller implements Initializable {

    @FXML
    private MFXButton btnFiltrar;
    @FXML
    private TableView<PregJugadoresDto> tbvJugadores;
    @FXML
    private TableColumn<PregJugadoresDto, String> tbcId;
    @FXML
    private TableColumn<PregJugadoresDto, String> tbcNombre;
    @FXML
    private TableColumn<PregJugadoresDto, String> tbcPartidasJugadas;
    @FXML
    private TableColumn<PregJugadoresDto, String> tbcPartidasGanadas;
    @FXML
    private TableColumn<PregJugadoresDto, String> tbcPreguntasRespondidas;
    @FXML
    private TableColumn<PregJugadoresDto, String> tbcPreguntasAcertadas;
    @FXML
    private MFXButton btnVolver;
    @FXML
    private MFXButton btnAceptar11;

    private ObservableList<PregJugadoresDto> jugadoresList;

    private PregJugadoresDto resultado;
    @FXML
    private MFXTextField txtId;
    @FXML
    private MFXTextField txtNombre;
    @FXML
    private MFXTextField txtPartidasJugadas;
    @FXML
    private MFXTextField txtPartidasGanadas;
    @FXML
    private MFXTextField txtPreguntasRespondidas;
    @FXML
    private MFXTextField txtPreguntasAcertadas;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbcId.setCellValueFactory(cd -> cd.getValue().id);
        tbcNombre.setCellValueFactory(cd -> cd.getValue().nombre);
        tbcPartidasJugadas.setCellValueFactory(cd -> cd.getValue().partidasJugadas);
        tbcPartidasGanadas.setCellValueFactory(cd -> cd.getValue().partidasGanadas);
        tbcPreguntasRespondidas.setCellValueFactory(cd -> cd.getValue().cantidasRespuestasGeneral);
        tbcPreguntasAcertadas.setCellValueFactory(cd -> cd.getValue().cantidasAcertadasGeneral);
    }

    @Override
    public void initialize() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void onMousePressedTbvJugadores(MouseEvent event) {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            onAcionAceptar(null);
        }
    }


    @FXML
    private void onActionFiltrar(ActionEvent event) {
        PregJugadoresService empService = new PregJugadoresService();
        Respuesta respuesta = empService.getJugadores(txtId.getText().toUpperCase(), txtNombre.getText().toUpperCase(), txtPartidasJugadas.getText().toUpperCase(), txtPartidasGanadas.getText().toUpperCase(), txtPreguntasRespondidas.getText().toUpperCase(), txtPreguntasAcertadas.getText().toUpperCase());
        if (respuesta.getEstado()) {
            jugadoresList = FXCollections.observableArrayList((List<PregJugadoresDto>) respuesta.getResultado("PregJugadores"));
            tbvJugadores.setItems(jugadoresList);
            tbvJugadores.refresh();

        }
    }

    @FXML
    private void onAcionVolver(ActionEvent event) {
        FlowController.getInstance().goView("MenuView");
    }

    @FXML
    private void onAcionAceptar(ActionEvent event) {
        resultado = (PregJugadoresDto) tbvJugadores.getSelectionModel().getSelectedItem();
        //getStage().close();
    } 
}