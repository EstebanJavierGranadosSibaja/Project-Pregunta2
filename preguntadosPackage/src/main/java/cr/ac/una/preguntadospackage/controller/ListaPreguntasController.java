package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.model.PregCategoriasDto;
import cr.ac.una.preguntadospackage.model.PregPreguntasDto;
import cr.ac.una.preguntadospackage.service.PregPreguntasService;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    private TableColumn<PregPreguntasDto, String> tbcCategoria;
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

    private PregCategoriasDto preguntaCategoria;
    @FXML
    private MFXButton btnAceptar11;

    /**
     * Initializes the TableView columns and text fields
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbcId.setCellValueFactory(cd -> cd.getValue().id);
        tbcCategoria.setCellValueFactory(cd -> cd.getValue().catId.getSimpleCategoria());
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
    }

    /**
     * Handles the action when the Filter button is clicked. It filters the
     * questions based on the entered criteria.
     */
    @FXML
    private void onActionFiltrar(ActionEvent event) {
        PregPreguntasService preguntaService = new PregPreguntasService();
        Respuesta respuesta = preguntaService.getPreguntas(txtId.getText().toUpperCase(), txtEnunciado.getText().toUpperCase(), txtCantidadRespuestas.getText().toUpperCase(), txtCantidadAciertos.getText().toUpperCase(), txtEstado.getText().toUpperCase(), txtCategoria.getText().toUpperCase());
        if (respuesta.getEstado()) {
            preguntasList = FXCollections.observableArrayList((List<PregPreguntasDto>) respuesta.getResultado("PregPreguntas"));
            tbvPreguntas.setItems(preguntasList);
            tbvPreguntas.refresh();
        }
    }

    /**
     * Handles mouse click event on the TableView. If the primary button is
     * pressed twice, it triggers the action to accept the selected item.
     */
    @FXML
    private void onMousePressedTbvPreguntas(MouseEvent event) {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            onAcionAceptar(null);
        }
    }

    /**
     * Handles the action when the "Back" button is clicked. It refreshes the
     * table view and closes the current view.
     */
    @FXML
    private void onAcionVolver(ActionEvent event) {
        tbvPreguntas.refresh();
        getStage().close();
    }

    /**
     * Handles the action when the "Accept" button is clicked. If no question is
     * selected, it displays a warning message.
     */
    @FXML
    private void onAcionAceptar(ActionEvent event) {
        if (tbvPreguntas.getSelectionModel().getSelectedItem() == null) {
            new Mensaje().showModal(Alert.AlertType.WARNING, "Cargar Pregunta", getStage(), "Tiene que escoger alguna pregunta primero.");
        } else {
            resultado = (PregPreguntasDto) tbvPreguntas.getSelectionModel().getSelectedItem();
            getStage().close();
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "¡¡¡ PREGUNTA CARGADA !!!", getStage(), "La pregunta se cargo correctamente.");

        }
    }

    /**
     * Returns the selected question.
     */
    public PregPreguntasDto getResultado() {
        return resultado;
    }
}
