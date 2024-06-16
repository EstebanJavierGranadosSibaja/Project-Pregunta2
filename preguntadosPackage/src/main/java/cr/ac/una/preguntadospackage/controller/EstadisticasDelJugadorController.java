/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.model.PregJugadores;
import cr.ac.una.preguntadospackage.model.PregJugadoresDto;
import cr.ac.una.preguntadospackage.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

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

    private PregJugadoresDto pregJugadoresDto;

    private ListaJugadoresController listaJugadoresResultado;
    @FXML
    private MFXButton btnBuscar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void initialize() {
        // Initialization method for FXML controller
    }

    private void updateChartData(PregJugadoresDto pregJugadoresDto) {
        // Get data of the selected player
        if (pregJugadoresDto.getId() != null && pregJugadoresDto.getId() > 0) {
            this.pregJugadoresDto = pregJugadoresDto;
        }

        // Update charts with new data
        setPieChartData();
    }

    private void setPieChartData() {
        // Data for the general chart
        ObservableList<PieChart.Data> generalData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas " + pregJugadoresDto.getCantidasAcertadasGeneral(), pregJugadoresDto.getCantidasAcertadasGeneral()),
                new PieChart.Data("Incorrectas " + (pregJugadoresDto.getCantidasRespuestasGeneral() - pregJugadoresDto.getCantidasAcertadasGeneral()), pregJugadoresDto.getCantidasRespuestasGeneral() - pregJugadoresDto.getCantidasAcertadasGeneral())
        );
        pchGeneral.setData(generalData);

        // Data for the Science chart
        ObservableList<PieChart.Data> cienciasData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(2).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(2).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchCiencias.setData(cienciasData);

        // Data for the History chart
        ObservableList<PieChart.Data> historiaData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(3).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(3).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchHistoria.setData(historiaData);

        // Data for the Geography chart
        ObservableList<PieChart.Data> geografiaData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(4).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(4).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchGeografia.setData(geografiaData);

        // Data for the Art chart
        ObservableList<PieChart.Data> arteData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchArte.setData(arteData);

        // Data for the Entertainment chart
        ObservableList<PieChart.Data> entretenimientoData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(5).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(5).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchEntretenimiento.setData(entretenimientoData);

        // Data for the Sports chart
        ObservableList<PieChart.Data> deporteData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(1).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(1).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchDeporte.setData(deporteData);
    }

    @FXML
    private void onActionBtnVolver(ActionEvent event) {
        // Clear chart data
        pchGeneral.setData(FXCollections.observableArrayList());
        pchCiencias.setData(FXCollections.observableArrayList());
        pchHistoria.setData(FXCollections.observableArrayList());
        pchGeografia.setData(FXCollections.observableArrayList());
        pchArte.setData(FXCollections.observableArrayList());
        pchEntretenimiento.setData(FXCollections.observableArrayList());
        pchDeporte.setData(FXCollections.observableArrayList());

        // Go back to the previous view
        FlowController.getInstance().goView("MenuView");
    }

    @FXML
    private void onActionBtnBuscar(ActionEvent event) {
        // Searc a player in ListaJugadoresController 
        ListaJugadoresController jugadoresListaController = (ListaJugadoresController) FlowController.getInstance().getController("ListaJugadoresView");
        FlowController.getInstance().goViewInWindowModal("ListaJugadoresView", getStage(), Boolean.TRUE);
        // Get player and use the information for the pie chats
        PregJugadoresDto jugadoresDto = jugadoresListaController.getResultado();
        if (jugadoresDto != null) {
            updateChartData(jugadoresDto);
        }
    }
}

