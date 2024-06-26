/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.model.PregJugadoresDto;
import cr.ac.una.preguntadospackage.model.PregPrinpartida;
import cr.ac.una.preguntadospackage.model.PregPrinpartidaDto;
import cr.ac.una.preguntadospackage.service.PregPrinpartidaService;
import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.Formato;
import cr.ac.una.preguntadospackage.util.Mensaje;
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
import javafx.scene.control.Alert;
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
    private MFXTextField txtIdPartida;
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
    private TableView<PregPrinpartidaDto> tbvPartidas;
    @FXML
    private TableColumn<PregPrinpartidaDto, String> tbcId;
    @FXML
    private TableColumn<PregPrinpartidaDto, String> tbcNombre;
    @FXML
    private TableColumn<PregPrinpartidaDto, String> tbcModoJuego;
    @FXML
    private TableColumn<PregPrinpartidaDto, String> tbcModoDuelo;
    @FXML
    private TableColumn<PregPrinpartidaDto, String> tbcCantidadRondasJugadas;
    @FXML
    private TableColumn<PregPrinpartidaDto, String> tbcCantidadJugadores;
    @FXML
    private TableColumn<PregPrinpartidaDto, String> tbcEstadoPartida;
    @FXML
    private MFXButton btnVolver;
    @FXML
    private MFXButton btnAceptar11;

    private ObservableList<PregPrinpartidaDto> partidasList;

    private PregJugadoresDto resultado;

    /**
     * Initializes the TableView columns and text fields
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbcId.setCellValueFactory(cd -> cd.getValue().id);
        tbcNombre.setCellValueFactory(cd -> cd.getValue().nombrePartida);
        tbcModoJuego.setCellValueFactory(cd -> cd.getValue().modoJuego);
        tbcModoDuelo.setCellValueFactory(cd -> cd.getValue().modoDuelo);
        tbcCantidadRondasJugadas.setCellValueFactory(cd -> cd.getValue().cantidadRondas);
        tbcCantidadJugadores.setCellValueFactory(cd -> cd.getValue().cantidadJugadores);
        tbcEstadoPartida.setCellValueFactory(cd -> cd.getValue().estadoPartida);
        txtIdPartida.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txtNombre.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(30));
        txtModoJuego.delegateSetTextFormatter(Formato.getInstance().letrasFormat(1));
        txtModoDuelo.delegateSetTextFormatter(Formato.getInstance().letrasFormat(1));
        txtCantidadRondasJugadas.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txtCantidadJugadores.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txtEstadoPartida.delegateSetTextFormatter(Formato.getInstance().letrasFormat(1));
    }

    /**
     * Handles the action when the Filter button is clicked. It filters the
     * saved games based on the entered criteria.
     */
    @FXML
    private void onActionFiltrar(ActionEvent event) {
        PregPrinpartidaService partidaService = new PregPrinpartidaService();
        Respuesta respuesta = partidaService.getPartidas(txtIdPartida.getText().toUpperCase(), txtNombre.getText().toUpperCase(), txtModoJuego.getText().toUpperCase(), txtModoDuelo.getText().toUpperCase(), txtCantidadRondasJugadas.getText().toUpperCase(), txtCantidadJugadores.getText().toUpperCase(), txtEstadoPartida.getText().toUpperCase());
        if (respuesta.getEstado()) {
            partidasList = FXCollections.observableArrayList((List<PregPrinpartidaDto>) respuesta.getResultado("PregPrinpartidas"));
            tbvPartidas.setItems(partidasList);
            tbvPartidas.refresh();

        }
    }

    /**
     * Handles mouse click event on the TableView. If the primary button is
     * pressed twice, it triggers the action to accept the selected item.
     */
    @FXML
    private void onMousePressedTbvPartidas(MouseEvent event) {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            onAcionAceptar(null);
        }
    }

    /**
     * Handles the action when the "Back" button is clicked. It refreshes the
     * table view and goes back to the main menu view.
     */
    @FXML
    private void onAcionVolver(ActionEvent event) {
        tbvPartidas.refresh();
        FlowController.getInstance().goView("MenuView");
    }

    /**
     * Handles the action when the "Accept" button is clicked. If no saved game
     * is selected, it displays a warning message.
     */
    @FXML
    private void onAcionAceptar(ActionEvent event) {
        if (tbvPartidas.getSelectionModel().getSelectedItem() == null) {
            new Mensaje().showModal(Alert.AlertType.WARNING, "Cargar Partida", getStage(), "Tiene que escoger alguna partida primero.");
        } else {
        }
    }

    /**
     * Initializes the controller.
     */
    @Override
    public void initialize() {
    }

}
