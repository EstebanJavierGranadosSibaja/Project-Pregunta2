/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.Mensaje;
import cr.ac.una.preguntadospackage.util.soundUtils;
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
        soundUtils.getInstance().playSound("click");
        FlowController.getInstance().goView("GameParametersView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Parametros de la partida", getStage(), "Acá podras ingresar los parametros de la partida, modo de juego, duelo, jugadores y más.");

    }

    @FXML
    private void onActionMentenimientoPreguntas(ActionEvent event) {
        soundUtils.getInstance().playSound("click");
        FlowController.getInstance().goView("MantenimientoPreguntasView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Mantenimiento de Preguntas", getStage(), "Acá podras ingresar al mentenimiento de preguntas, podras buscar, eliminar o guardar preguntas a tu antojo.");

    }

    @FXML
    private void onActionRankedGlobal(ActionEvent event) {
        soundUtils.getInstance().playSound("click");
        FlowController.getInstance().goView("EstadisticasDelJugadorView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Estadisticas de los Jugadores", getStage(), "Acá podras ver ciertas estadisticas del jugador que busques, ya sea de manera general o por categoria.");

    }

    @FXML
    private void onActionSobreNosotros(ActionEvent event) {
        soundUtils.getInstance().playSound("click");
        FlowController.getInstance().goView("SobreNosotrosView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Sobre Nostros", getStage(), "Acá podras conocer un poco más sobre nostros, quiere somos, que hacemos y algun otro dato curioso.");

    }

    @FXML
    private void onActionInformacion(ActionEvent event) {
        soundUtils.getInstance().playSound("click");
        FlowController.getInstance().goView("InformacionView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Informacion del Juego", getStage(), "Acá podras conocer más sobre como funciona el juego de Pregunta2, sus ayudas, modos de juego y demás.");

    }

    @FXML
    private void onActionCargarPartida(ActionEvent event) {
        soundUtils.getInstance().playSound("click");
        FlowController.getInstance().goView("ListaPartidasGuardasView");
        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Cargar Partidas", getStage(), "Acá podras ver las partidas que estan cargadas, podras volver a iniciarlas desde aqui.");
    }
}
