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
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void updateChartData(PregJugadoresDto pregJugadoresDto) {
        // Obtén los datos del jugador seleccionado
        if (pregJugadoresDto.getId() != null && pregJugadoresDto.getId() > 0) {
            this.pregJugadoresDto = pregJugadoresDto;
        }

        // Actualiza los gráficos con los nuevos datos
        setPieChartData();
    }

    private void setPieChartData() {
// Datos para el gráfico general
        ObservableList<PieChart.Data> generalData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas " + pregJugadoresDto.getCantidasAcertadasGeneral(), pregJugadoresDto.getCantidasAcertadasGeneral()),
                new PieChart.Data("Incorrectas " + (pregJugadoresDto.getCantidasRespuestasGeneral() - pregJugadoresDto.getCantidasAcertadasGeneral()), pregJugadoresDto.getCantidasRespuestasGeneral() - pregJugadoresDto.getCantidasAcertadasGeneral())
        );
        pchGeneral.setData(generalData);

        // Datos para el gráfico de Ciencias
        ObservableList<PieChart.Data> cienciasData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(2).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(2).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchCiencias.setData(cienciasData);

        // Datos para el gráfico de Historia
        ObservableList<PieChart.Data> historiaData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(3).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(3).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchHistoria.setData(historiaData);

        // Datos para el gráfico de Geografía
        ObservableList<PieChart.Data> geografiaData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(4).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(4).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchGeografia.setData(geografiaData);

        // Datos para el gráfico de Arte
        ObservableList<PieChart.Data> arteData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchArte.setData(arteData);

        // Datos para el gráfico de Entretenimiento
        ObservableList<PieChart.Data> entretenimientoData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(5).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(5).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchEntretenimiento.setData(entretenimientoData);

        // Datos para el gráfico de Deporte
        ObservableList<PieChart.Data> deporteData = FXCollections.observableArrayList(
                new PieChart.Data("Correctas", pregJugadoresDto.getPregCategoriasjugadorList().get(1).getCantidadRespuestas()),
                new PieChart.Data("Incorrectas", pregJugadoresDto.getPregCategoriasjugadorList().get(1).getCantidadRespuestas() - pregJugadoresDto.getPregCategoriasjugadorList().get(0).getCantidadAcertada())
        );
        pchDeporte.setData(deporteData);
    }

    @FXML
    private void onActionBtnVolver(ActionEvent event) {
        // Limpia los datos del gráfico
        pchGeneral.setData(FXCollections.observableArrayList());
        pchCiencias.setData(FXCollections.observableArrayList());
        pchHistoria.setData(FXCollections.observableArrayList());
        pchGeografia.setData(FXCollections.observableArrayList());
        pchArte.setData(FXCollections.observableArrayList());
        pchEntretenimiento.setData(FXCollections.observableArrayList());
        pchDeporte.setData(FXCollections.observableArrayList());

        // Vuelve a la vista anterior
        FlowController.getInstance().goView("MenuView");
    }

    @FXML
    private void onActionBtnBuscar(ActionEvent event) {
        ListaJugadoresController jugadoresListaController = (ListaJugadoresController) FlowController.getInstance().getController("ListaJugadoresView");
        FlowController.getInstance().goViewInWindowModal("ListaJugadoresView", getStage(), Boolean.TRUE);
        PregJugadoresDto jugadoresDto = jugadoresListaController.getResultado();
        if (jugadoresDto != null) {
            updateChartData(jugadoresDto);
        }
    }

}
