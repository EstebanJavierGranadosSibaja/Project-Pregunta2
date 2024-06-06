/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.model.PregCategoriasDto;
import cr.ac.una.preguntadospackage.model.PregPreguntasDto;
import cr.ac.una.preguntadospackage.service.PregPreguntasService;
import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.Formato;
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
    private MFXTextField txtEstado;
    @FXML
    private MFXButton btnFiltrar;
    @FXML
    private TableView<PregPreguntasDto> tbvPreguntas;
    @FXML
    private TableColumn<PregPreguntasDto, String> tbcId;
    @FXML
    private TableColumn<PregCategoriasDto, String> tbcCategoria;
    @FXML
    private TableColumn<PregPreguntasDto, String> tbcEnunciado;
    @FXML
    private TableColumn<PregPreguntasDto, String> tbcCantidadRespuestas;
    @FXML
    private TableColumn<PregPreguntasDto, String> tbcCantidadAcertadas;
    @FXML
    private TableColumn<PregPreguntasDto, Boolean> tbcEstado;
    @FXML
    private MFXButton btnVolver;

    private ObservableList<PregPreguntasDto> preguntasList;

    private PregPreguntasDto resultado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbcId.setCellValueFactory(cd -> cd.getValue().id);
        //tbcCategoria.setCellValueFactory(cd -> cd.getValue().categoria);
        tbcEnunciado.setCellValueFactory(cd -> cd.getValue().textoPregunta);
        tbcCantidadRespuestas.setCellValueFactory(cd -> cd.getValue().cantidadRespuestas);
        tbcCantidadAcertadas.setCellValueFactory(cd -> cd.getValue().cantidadAciertos);
        tbcEstado.setCellValueFactory(cd -> cd.getValue().estado);
        txtId.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txtCategoria.delegateSetTextFormatter(Formato.getInstance().letrasFormat(30));
        txtEnunciado.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(500));
        txtCantidadRespuestas.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txtCantidadAciertos.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txtEstado.delegateSetTextFormatter(Formato.getInstance().letrasFormat(1));
    }

    @Override
    public void initialize() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void onActionFiltrar(ActionEvent event) {
        PregPreguntasService empService = new PregPreguntasService();
        Respuesta respuesta = empService.getPreguntas(txtId.getText().toUpperCase(), txtEnunciado.getText().toUpperCase(), txtCantidadRespuestas.getText().toUpperCase(), txtCantidadAciertos.getText().toUpperCase(), txtEstado.getText().toUpperCase());
        if (respuesta.getEstado()) {
            preguntasList = FXCollections.observableArrayList((List<PregPreguntasDto>) respuesta.getResultado("PregPreguntas"));
            tbvPreguntas.setItems(preguntasList);
            tbvPreguntas.refresh();
        }
    }

    @FXML
    private void onMousePressedTbvPreguntas(MouseEvent event) {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            onAcionAceptar(null);
        }
    }

    @FXML
    private void onAcionVolver(ActionEvent event) {
        FlowController.getInstance().goView("MenuView");
    }

    @FXML
    private void onAcionAceptar(ActionEvent event) {
//        resultado = (PregPreguntasDto) tbvPreguntas.getSelectionModel().getSelectedItem();
//        //getStage().close();
    }

}
