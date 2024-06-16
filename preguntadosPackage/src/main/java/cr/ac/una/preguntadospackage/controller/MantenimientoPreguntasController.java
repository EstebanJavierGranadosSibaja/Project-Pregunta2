package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.model.PregPreguntasDto;
import cr.ac.una.preguntadospackage.model.PregRespuestasDto;
import cr.ac.una.preguntadospackage.service.PregPreguntasService;
import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.Formato;
import cr.ac.una.preguntadospackage.util.Mensaje;
import cr.ac.una.preguntadospackage.util.Respuesta;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MantenimientoPreguntasController extends Controller implements Initializable {

    @FXML
    private MFXTextField txtId;
    @FXML
    private MFXTextField txtEnunciadoPregunta;
    @FXML
    private MFXTextField txtRespuesta1;
    @FXML
    private MFXTextField txtRespuesta2;
    @FXML
    private MFXTextField txtRespuesta4;
    @FXML
    private MFXTextField txtRespuesta3;
    @FXML
    private MFXButton btnVolver;
    @FXML
    private MFXButton btnBuscar;
    @FXML
    private MFXButton btnNuevo;
    @FXML
    private MFXButton btnEliminar;
    @FXML
    private MFXButton btnGuardar;
    @FXML
    private MFXComboBox<String> cbxCategoria;

    private PregPreguntasDto pregPreguntasDto;
    List<Node> requeridos = new ArrayList<>();
    List<PregRespuestasDto> respuestas = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> comboData = FXCollections.observableArrayList(
                "ARTE", "DEPORTE", "CIENCIAS", "HISTORIA", "GEOGRAFIA", "ENTRETENIMIENTO"
        );
        cbxCategoria.setItems(comboData);
        txtEnunciadoPregunta.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(250));
        txtRespuesta1.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(50));
        txtRespuesta2.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(50));
        txtRespuesta3.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(50));
        txtRespuesta4.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(50));
        nuevaPregunta();
        indicarRequeridos();
    }

    @Override
    public void initialize() {
    }

    private void nuevaPregunta() {
        unbindPregunta();
        pregPreguntasDto = new PregPreguntasDto();
        bindPregunta(true);
        txtId.clear();
        txtId.requestFocus();
        cbxCategoria.setValue("");
        cbxCategoria.requestFocus();
        txtRespuesta1.setText("");
        txtRespuesta2.setText("");
        txtRespuesta3.setText("");
        txtRespuesta4.setText("");
        txtRespuesta1.requestFocus();
        txtRespuesta2.requestFocus();
        txtRespuesta3.requestFocus();
        txtRespuesta4.requestFocus();
    }

    private void bindPregunta(Boolean nuevo) {
        if (!nuevo) {
            txtId.textProperty().bind(pregPreguntasDto.id);
        }
        txtEnunciadoPregunta.textProperty().bindBidirectional(pregPreguntasDto.textoPregunta);
    }

    private void unbindPregunta() {
        txtId.textProperty().unbind();
    }

    private void unbindRespuestas() {
        if (respuestas.get(0).getEsCorrecta().equals("T")) {
            txtRespuesta1.setStyle("mfx-textfield; " + "mfx-textfield:focused;" + "mfx-textfield:hover;" + "mfx-label-small;");
        }
        if (respuestas.get(1).getEsCorrecta().equals("T")) {
            txtRespuesta2.setStyle("mfx-textfield; " + "mfx-textfield:focused;" + "mfx-textfield:hover;" + "mfx-label-small;");
        }
        if (respuestas.get(2).getEsCorrecta().equals("T")) {
            txtRespuesta3.setStyle("mfx-textfield; " + "mfx-textfield:focused;" + "mfx-textfield:hover;" + "mfx-label-small;");
        }
        if (respuestas.get(3).getEsCorrecta().equals("T")) {
            txtRespuesta4.setStyle("mfx-textfield; " + "mfx-textfield:focused;" + "mfx-textfield:hover;" + "mfx-label-small;");
        }
    }

    private void bindRespuestas() {
        respuestas = pregPreguntasDto.getPregRespuestasList();
        txtRespuesta1.textProperty().bindBidirectional(respuestas.get(0).textoRespuesta);
        txtRespuesta2.textProperty().bindBidirectional(respuestas.get(1).textoRespuesta);
        txtRespuesta3.textProperty().bindBidirectional(respuestas.get(2).textoRespuesta);
        txtRespuesta4.textProperty().bindBidirectional(respuestas.get(3).textoRespuesta);
        cbxCategoria.setValue(pregPreguntasDto.getCatId().getCategoria());
        
        if (respuestas.get(0).getEsCorrecta().equals("T")) {
            txtRespuesta1.setStyle("-fx-text-fill: green; " + "-fx-border-color: green;");
        }
        if (respuestas.get(1).getEsCorrecta().equals("T")) {
            txtRespuesta2.setStyle("-fx-text-fill: green; " + "-fx-border-color: green;");
        }
        if (respuestas.get(2).getEsCorrecta().equals("T")) {
            txtRespuesta3.setStyle("-fx-text-fill: green; " + "-fx-border-color: green;");
        }
        if (respuestas.get(3).getEsCorrecta().equals("T")) {
            txtRespuesta4.setStyle("-fx-text-fill: green; " + "-fx-border-color: green;");
        }
    }

    public String validarRequeridos() {
        Boolean validos = true;
        String invalidos = "";
        for (Node node : requeridos) {
            if (node instanceof MFXTextField && (((MFXTextField) node).getText() == null || ((MFXTextField) node).getText().isBlank())) {
                if (validos) {
                    invalidos += ((MFXTextField) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXTextField) node).getFloatingText();
                }
                validos = false;
            } else if (node instanceof MFXPasswordField && (((MFXPasswordField) node).getText() == null || ((MFXPasswordField) node).getText().isBlank())) {
                if (validos) {
                    invalidos += ((MFXPasswordField) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXPasswordField) node).getFloatingText();
                }
                validos = false;
            } else if (node instanceof MFXDatePicker && ((MFXDatePicker) node).getValue() == null) {
                if (validos) {
                    invalidos += ((MFXDatePicker) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXDatePicker) node).getFloatingText();
                }
                validos = false;
            } else if (node instanceof MFXComboBox && ((MFXComboBox) node).getSelectionModel().getSelectedIndex() < 0) {
                if (validos) {
                    invalidos += ((MFXComboBox) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXComboBox) node).getFloatingText();
                }
                validos = false;
            }
        }
        if (validos) {
            return "";
        } else {
            return "Campos requeridos o con problemas de formato [" + invalidos + "].";
        }
    }

    private void indicarRequeridos() {
        requeridos.clear();
        requeridos.addAll(Arrays.asList(txtEnunciadoPregunta, txtRespuesta1, txtRespuesta2, txtRespuesta3, txtRespuesta4, cbxCategoria));
    }

    private void cargarPregunta(Long id) {
        try {
            PregPreguntasService preguntasService = new PregPreguntasService();
            Respuesta respuesta = preguntasService.getPregunta(id);
            if (respuesta.getEstado()) {
                unbindPregunta();
                this.pregPreguntasDto = (PregPreguntasDto) respuesta.getResultado("PregPregunta");
                bindPregunta(false);
                bindRespuestas();
                validarRequeridos();

            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validacion pregunta", getStage(), respuesta.getMensaje());
            }
        } catch (Exception ex) {
            Logger.getLogger(MantenimientoPreguntasController.class.getName()).log(Level.SEVERE, "Error consultando el empleado.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "cargarPregunta", getStage(), "Ocurrio un error consultando la pregunta.");
        }
    }

    @FXML
    private void onActionBtnBuscar(ActionEvent event) {
        ListaPreguntasController preguntasListaController = (ListaPreguntasController) FlowController.getInstance().getController("ListaPreguntasView");
        FlowController.getInstance().goViewInWindowModal("ListaPreguntasView", getStage(), Boolean.TRUE);
        PregPreguntasDto preguntaDto = preguntasListaController.getResultado();
        if (preguntaDto != null) {
            cargarPregunta(preguntaDto.getId());
        }
    }

    @FXML
    private void onActionBtnEliminar(ActionEvent event) {
        try {
            if (txtId.getText() == null || txtId.getText().isBlank()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Eliminar Pregunta", getStage(), "");
            } else {
                PregPreguntasService preguntasService = new PregPreguntasService();
                Respuesta respuesta = preguntasService.eliminarPregunta(Long.valueOf(txtId.getText()));
                if (respuesta.getEstado()) {
                    nuevaPregunta();
                    new Mensaje().showModal(Alert.AlertType.CONFIRMATION, "Validacion Pregunta", getStage(), "SE PUDO ELIMINAR");
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Validacion Pregunta", getStage(), respuesta.getMensaje());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PregPreguntasService.class.getName()).log(Level.SEVERE, "Error guardadndo la pregunta", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Eliminar Pregunta", getStage(), "Ocurrio un error eliminando la pregunta.");
        }
    }

    @FXML
    private void onActionBtnNuevo(ActionEvent event) {
        if (new Mensaje().showConfirmation("Limpiar Pregunta", getStage(), "¿Esta seguro que desea limpiar la pregunta?")) {
            if (!txtEnunciadoPregunta.getText().isBlank() || !txtEnunciadoPregunta.getText().isEmpty()) {
                unbindRespuestas();
            }
            nuevaPregunta();
        }
    }

    @FXML
    private void onKeyPressedTxtId(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && !txtId.getText().isBlank()) {
            cargarPregunta(Long.valueOf(txtId.getText()));
        }
    }

    @FXML
    private void onActionBtnGuardar(ActionEvent event) {
        try {
            String invalidos = validarRequeridos();
            if (!invalidos.isBlank()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Pregunta", getStage(), invalidos);
            } else {
                PregPreguntasService preguntasService = new PregPreguntasService();
                Respuesta respuesta = preguntasService.guardarPregunta(this.pregPreguntasDto);
                if (respuesta.getEstado()) {
                    unbindPregunta();
                    this.pregPreguntasDto = (PregPreguntasDto) respuesta.getResultado("PregPregunta");
                    bindPregunta(false);
                    bindRespuestas();
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Validacion Pregunta", getStage(), respuesta.getMensaje());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PregPreguntasService.class.getName()).log(Level.SEVERE, "Error guardadndo la pregunta", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Pregunta", getStage(), "Ocurrio un error guardando la pregunta.");
        }
    }

    @FXML
    private void onActionBtnVolver(ActionEvent event) {
        FlowController.getInstance().goView("MenuView");
    }
}
