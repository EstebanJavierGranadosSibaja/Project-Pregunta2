/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

public class MenuController extends Controller implements Initializable {

    @FXML
    private MFXButton btnPlayMultiplayer;
    @FXML
    private MFXButton btnMantenimientoPreguntas;
    @FXML
    private MFXButton btnRankedGlobal;
    @FXML
    private MFXButton btnSobreNosotros;
    @FXML
    private MFXButton btnInformacion;
    @FXML
    private MFXButton btnCargarPartida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void initialize() {
    }

    @FXML
    private void onActionPlayMultiplayer(ActionEvent event) {
        FlowController.getInstance().goView("GameParametersView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Parametros de la Partida", getStage(), "Estos son los parametros de la partida, acá podras parametrizar cosas como el modo de juego, el duelo, jugadores y más.");
    }

    @FXML
    private void onActionMentenimientoPreguntas(ActionEvent event) {
        FlowController.getInstance().goView("MantenimientoPreguntasView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Mantenimiento de Preguntas", getStage(), "Bienvenido, este es el mantenimiento de preguntas, acá podras buscar, actualizar, eliminar o guardar preguntas.");

    }

    @FXML
    private void onActionRankedGlobal(ActionEvent event) {
        FlowController.getInstance().goView("EstadisticasDelJugadorView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Ranking de Jugadores", getStage(), "Bienvenido, este es el ranking de jugadores, acá podras buscar jugadores y ver algunas estadisticas interesantes.");

    }

    @FXML
    private void onActionSobreNosotros(ActionEvent event) {
        FlowController.getInstance().goView("SobreNosotrosView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Sobre Nosotros", getStage(), "Bienvenido, esta es la ventana de 'sobre nosotros', acá podras conocer acerca de quienes somos, que no gusta y que hacemos.");

    }

    @FXML
    private void onActionInformacion(ActionEvent event) {
        FlowController.getInstance().goView("InformacionView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Información del Juego", getStage(), "Bienvenido, esta es la información del juego, acá podras conocer como funciona Pregunta2, sus mecanicas y demas.");

    }

    @FXML
    private void onActionCargarPartida(ActionEvent event) {
        FlowController.getInstance().goView("ListaPartidasGuardasView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Cargado de Partidas", getStage(), "Bienvenido, esta es la lista de partidas guardadas, acá podras buscar y cargar partidas previamente guardadas.");

    }
}
