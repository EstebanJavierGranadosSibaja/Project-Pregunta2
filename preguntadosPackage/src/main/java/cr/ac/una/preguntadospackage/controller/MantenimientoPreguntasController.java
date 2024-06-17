package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.model.PregPreguntasDto;
import cr.ac.una.preguntadospackage.model.PregRespuestasDto;
import cr.ac.una.preguntadospackage.service.PregPreguntasService;
import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.Formato;
import cr.ac.una.preguntadospackage.util.Mensaje;
import cr.ac.una.preguntadospackage.util.Respuesta;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
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
    private MFXTextField txtId; // Text field for question ID
    @FXML
    private MFXTextField txtEnunciadoPregunta; // Text field for question statement
    @FXML
    private MFXTextField txtRespuesta1; // Text field for answer 1
    @FXML
    private MFXTextField txtRespuesta2; // Text field for answer 2
    @FXML
    private MFXTextField txtRespuesta4; // Text field for answer 4
    @FXML
    private MFXTextField txtRespuesta3; // Text field for answer 3
    @FXML
    private MFXButton btnVolver; // Button to return
    @FXML
    private MFXButton btnBuscar; // Button to search
    @FXML
    private MFXButton btnNuevo; // Button to create new
    @FXML
    private MFXButton btnEliminar; // Button to delete
    @FXML
    private MFXButton btnGuardar; // Button to save
    @FXML
    private MFXComboBox<String> cbxCategoria; // Combo box for category selection
    @FXML
    private MFXCheckbox chbActiva;

    private PregPreguntasDto pregPreguntasDto; // DTO for question
    List<Node> requeridos = new ArrayList<>(); // List of required fields
    List<PregRespuestasDto> respuestas = new ArrayList<>(); // List of answers

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> comboData = FXCollections.observableArrayList(
                "ARTE", "DEPORTE", "CIENCIAS", "HISTORIA", "GEOGRAFIA", "ENTRETENIMIENTO"
        );
        cbxCategoria.setItems(comboData); // Setting data to the category combo box
//        txtEnunciadoPregunta.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(250)); // Setting text format for question statement
//        txtRespuesta1.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(50)); // Setting text format for answer 1
//        txtRespuesta2.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(50)); // Setting text format for answer 2
//        txtRespuesta3.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(50)); // Setting text format for answer 3
//        txtRespuesta4.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(50)); // Setting text format for answer 4
        nuevaPregunta(); // Creating a new question
        indicarRequeridos(); // Indicating required fields
    }

    @Override
    public void initialize() {
    }

    // Creating a new question
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

    // Binding question fields
    private void bindPregunta(Boolean nuevo) {
        if (!nuevo) {
            txtId.textProperty().bind(pregPreguntasDto.id);
        }
        
        chbActiva.selectedProperty().bindBidirectional(pregPreguntasDto.estado);
        txtEnunciadoPregunta.textProperty().bindBidirectional(pregPreguntasDto.textoPregunta);
    }

    // Unbinding question fields
    private void unbindPregunta() {
        txtId.textProperty().unbind();
    }

    // Unbinding answer fields
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
        // Binds response text fields to their respective properties
        respuestas = pregPreguntasDto.getPregRespuestasList();
        txtRespuesta1.textProperty().bindBidirectional(respuestas.get(0).textoRespuesta);
        txtRespuesta2.textProperty().bindBidirectional(respuestas.get(1).textoRespuesta);
        txtRespuesta3.textProperty().bindBidirectional(respuestas.get(2).textoRespuesta);
        txtRespuesta4.textProperty().bindBidirectional(respuestas.get(3).textoRespuesta);

        // Sets the selected category in the category combo box
        cbxCategoria.setValue(pregPreguntasDto.getCatId().getCategoria());

        // Styles the correct response text fields with green text and border
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

//    private void validarAdministrador() {
//        if (chbActiva.isSelected()) {
//            requeridos.addAll(Arrays.asList(txtUsuario, txtClave));
//            txtUsuario.setDisable(false);
//            txtClave.setDisable(false);
//        } else {
//            requeridos.removeAll(Arrays.asList(txtUsuario, txtClave));
//            txtUsuario.clear();
//            txtUsuario.setDisable(true);
//            txtClave.clear();
//            txtClave.setDisable(true);
//        }
//    }
    
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

    // Indicating required fields
    private void indicarRequeridos() {
        requeridos.clear();
        requeridos.addAll(Arrays.asList(txtEnunciadoPregunta, txtRespuesta1, txtRespuesta2, txtRespuesta3, txtRespuesta4, cbxCategoria));
    }

    // Loading a specific question
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
                new Mensaje().showModal(Alert.AlertType.ERROR, "Question validation", getStage(), respuesta.getMensaje());
            }
        } catch (Exception ex) {
            Logger.getLogger(MantenimientoPreguntasController.class.getName()).log(Level.SEVERE, "Error loading the question.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Load Question", getStage(), "An error occurred while loading the question.");
        }
    }

    @FXML
    private void onActionBtnBuscar(ActionEvent event) {
        // Opens the "ListaPreguntasView" in a modal window
        ListaPreguntasController preguntasListaController = (ListaPreguntasController) FlowController.getInstance().getController("ListaPreguntasView");
        FlowController.getInstance().goViewInWindowModal("ListaPreguntasView", getStage(), Boolean.TRUE);
        // Retrieves the selected question from the "ListaPreguntasController" and loads it if it's not null
        PregPreguntasDto preguntaDto = preguntasListaController.getResultado();
        if (preguntaDto != null) {
            cargarPregunta(preguntaDto.getId());
        }
    }

    @FXML
    private void onActionBtnEliminar(ActionEvent event) {
        try {
            // Checks if the question ID text field is empty
            if (txtId.getText() == null || txtId.getText().isBlank()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Delete Question", getStage(), "");
            } else {
                // Deletes the question if the ID is not empty
                PregPreguntasService preguntasService = new PregPreguntasService();
                Respuesta respuesta = preguntasService.eliminarPregunta(Long.valueOf(txtId.getText()));
                // Shows confirmation message after successful deletion or error message if deletion fails
                if (respuesta.getEstado()) {
                    nuevaPregunta();
                    new Mensaje().showModal(Alert.AlertType.CONFIRMATION, "Question Validation", getStage(), "DELETED SUCCESSFULLY");
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Question Validation", getStage(), respuesta.getMensaje());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PregPreguntasService.class.getName()).log(Level.SEVERE, "Error saving the question", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Delete Question", getStage(), "An error occurred while deleting the question.");
        }
    }

    @FXML
    private void onActionBtnNuevo(ActionEvent event) {
        // Clears the question form after user confirmation
        if (new Mensaje().showConfirmation("Clear Question", getStage(), "Are you sure you want to clear the question?")) {
            // Unbinds the responses if the question statement is not empty and creates a new question
            if (!txtEnunciadoPregunta.getText().isBlank() || !txtEnunciadoPregunta.getText().isEmpty()) {
                unbindRespuestas();
            }
            nuevaPregunta();
        }
    }

    @FXML
    private void onKeyPressedTxtId(KeyEvent event) {
        // Loads the question when Enter key is pressed in the question ID text field
        if (event.getCode() == KeyCode.ENTER && !txtId.getText().isBlank()) {
            cargarPregunta(Long.valueOf(txtId.getText()));
        }
    }

    @FXML
    private void onActionBtnGuardar(ActionEvent event) {
        try {
            // Validates required fields and shows error message if any field is empty
            String invalidos = validarRequeridos();
            if (!invalidos.isBlank()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Save Question", getStage(), invalidos);
            } else {
                // Saves the question if all required fields are filled
                PregPreguntasService preguntasService = new PregPreguntasService();
                Respuesta respuesta = preguntasService.guardarPregunta(this.pregPreguntasDto);
                // Updates the question after successful save or shows error message if save fails
                if (respuesta.getEstado()) {
                    unbindPregunta();
                    this.pregPreguntasDto = (PregPreguntasDto) respuesta.getResultado("PregPregunta");
                    bindPregunta(false);
                    bindRespuestas();
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Question Validation", getStage(), respuesta.getMensaje());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PregPreguntasService.class.getName()).log(Level.SEVERE, "Error saving the question", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Save Question", getStage(), "An error occurred while saving the question.");
        }
    }

    @FXML
    private void onActionBtnVolver(ActionEvent event) {
        // Returns to the main menu
        FlowController.getInstance().goView("MenuView");
    }

    @FXML
    private void onActionChbActiva(ActionEvent event) {
    }

}
