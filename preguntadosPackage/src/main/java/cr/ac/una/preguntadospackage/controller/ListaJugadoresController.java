package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.model.PregJugadoresDto;
import cr.ac.una.preguntadospackage.service.PregJugadoresService;
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

    private ObservableList<PregJugadoresDto> jugadoresList;

    private PregJugadoresDto resultado;

    /**
     * Initializes the TableView columns and text fields
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbcId.setCellValueFactory(cd -> cd.getValue().id);
        tbcNombre.setCellValueFactory(cd -> cd.getValue().nombre);
        tbcPartidasJugadas.setCellValueFactory(cd -> cd.getValue().partidasJugadas);
        tbcPartidasGanadas.setCellValueFactory(cd -> cd.getValue().partidasGanadas);
        tbcPreguntasRespondidas.setCellValueFactory(cd -> cd.getValue().cantidasRespuestasGeneral);
        tbcPreguntasAcertadas.setCellValueFactory(cd -> cd.getValue().cantidasAcertadasGeneral);
        txtId.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txtNombre.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(30));
        txtPartidasJugadas.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txtPartidasGanadas.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txtPreguntasRespondidas.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txtPreguntasAcertadas.delegateSetTextFormatter(Formato.getInstance().integerFormat());
    }

    @Override
    public void initialize() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Handles mouse click event on the TableView If the primary button is
     * pressed twice, it triggers the action to accept the selected item
     */
    @FXML
    private void onMousePressedTbvJugadores(MouseEvent event) {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            onAcionAceptar(null);
        }
    }

    /**
     * Handles the action when the Filter button is clicked. It filters the
     * players based on the entered criteria.
     */
    @FXML
    private void onActionFiltrar(ActionEvent event) {
        PregJugadoresService jugadorService = new PregJugadoresService();
        Respuesta respuesta = jugadorService.getJugadores(txtId.getText().toUpperCase(), txtNombre.getText().toUpperCase(), txtPartidasJugadas.getText().toUpperCase(), txtPartidasGanadas.getText().toUpperCase(), txtPreguntasRespondidas.getText().toUpperCase(), txtPreguntasAcertadas.getText().toUpperCase());
        if (respuesta.getEstado()) {
            jugadoresList = FXCollections.observableArrayList((List<PregJugadoresDto>) respuesta.getResultado("PregJugadores"));
            tbvJugadores.setItems(jugadoresList);
            tbvJugadores.refresh();

        }
    }

    /**
     * Handles the action when the "Back" button is clicked. It refreshes the
     * table view and closes the current stage.
     */
    @FXML
    private void onAcionVolver(ActionEvent event) {
        tbvJugadores.refresh();
        getStage().close();
    }

    /**
     * Handles the action when the "Accept" button is clicked. If no player is
     * selected, it displays a warning message. Otherwise, it gets the selected
     * player and closes the current stage.
     */
    @FXML
    private void onAcionAceptar(ActionEvent event) {
        if (tbvJugadores.getSelectionModel().getSelectedItem() == null) {
            new Mensaje().showModal(Alert.AlertType.WARNING, "Cargar Estadisticas", getStage(), "Tiene que escoger algun jugador primero.");
        } else {
            resultado = (PregJugadoresDto) tbvJugadores.getSelectionModel().getSelectedItem();
            getStage().close();
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "¡¡¡ JUGADOR CARGADO !!!", getStage(), "El jugador se cargo correctamente.");
        }
    }

    /**
     * Gets the selected player.
     */
    public PregJugadoresDto getResultado() {
        return resultado;
    }

}
