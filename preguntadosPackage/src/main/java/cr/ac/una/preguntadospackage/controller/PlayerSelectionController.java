package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.Mensaje;
import cr.ac.una.preguntadospackage.util.soundUtils;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;

public class PlayerSelectionController extends Controller implements Initializable {

    @javafx.fxml.FXML
    private ImageView imgBluePawnSelection;
    @javafx.fxml.FXML
    private ImageView imgGreenPawnSelection;
    @javafx.fxml.FXML
    private ImageView imgDisabledPinkPawn;
    @javafx.fxml.FXML
    private ImageView imgPurplePawnSelection;
    @javafx.fxml.FXML
    private ImageView imgPinkPawnSelection;
    @javafx.fxml.FXML
    private ImageView imgDisabledGreenPawn;
    @javafx.fxml.FXML
    private ImageView imgDisabledOrangePawn;
    @javafx.fxml.FXML
    private ImageView imgRedPawnSelection;
    @javafx.fxml.FXML
    private ImageView imgDisabledBluePawn;
    @javafx.fxml.FXML
    private ImageView imgDisabledRedPawn;
    @javafx.fxml.FXML
    private ImageView imgOrangePawnSelection;
    @javafx.fxml.FXML
    private ImageView imgDisabledPurplePawn;

    GameController gameController = (GameController) FlowController.getInstance().getController("GameView");

    int amountOfPlayers;
    String gameMode;
    String duelMode;
    int timeLimitInMinutes;

    String[] playerNames = new String[6];
    String[] playerColors = new String[6];

    int currentPlayer = 0;
    String currentSelectedColor = "";
    @javafx.fxml.FXML
    private MFXTextField txtPlayerName;
    @javafx.fxml.FXML
    private Label lblPlayerNumber;

    @Override
    public void initialize() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblPlayerNumber.setText("Jugador " + (currentPlayer + 1));
    }

    public void recieveParametersFromParametersView(int amountOfPlayers, String gameMode, String duelMode, int timeLimitInMinutes) {
        // save up this variables (they are just going to be passed to the game view) like saving something in your pocket
        this.amountOfPlayers = amountOfPlayers;
        this.gameMode = gameMode;
        this.duelMode = duelMode;
        this.timeLimitInMinutes = timeLimitInMinutes;
    }

    @javafx.fxml.FXML
    public void onActionGreenPawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        re_enablePastSelectedPawn();
        currentSelectedColor = "green";
        imgDisabledGreenPawn.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onActionOrangePawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        re_enablePastSelectedPawn();
        currentSelectedColor = "orange";
        imgDisabledOrangePawn.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onActionPinkPawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        re_enablePastSelectedPawn();
        currentSelectedColor = "pink";
        imgDisabledPinkPawn.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onActionPurplePawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        re_enablePastSelectedPawn();
        currentSelectedColor = "purple";
        imgDisabledPurplePawn.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onActionBluePawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        re_enablePastSelectedPawn();
        currentSelectedColor = "blue";
        imgDisabledBluePawn.setVisible(true);
    }

    @FXML
    public void onActionRedPawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        re_enablePastSelectedPawn();
        currentSelectedColor = "red";
        imgDisabledRedPawn.setVisible(true);
    }

    // BUTTONS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @javafx.fxml.FXML
    public void onActionConfirmar(ActionEvent actionEvent) {
        soundUtils.getInstance().playSound("click");
        if (!txtPlayerName.getText().isBlank() && !currentSelectedColor.isBlank()) {

            // save the player name and color
            playerNames[currentPlayer] = txtPlayerName.getText();
            playerColors[currentPlayer] = currentSelectedColor;

            if (currentPlayer == amountOfPlayers - 1) {
                // if all players have been selected, go to the game view
                gameController.recieveParameters(playerColors, playerNames, amountOfPlayers, gameMode, duelMode, timeLimitInMinutes);
                FlowController.getInstance().goView("GameView");
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "¡¡¡ ES HORA DE JUGAR !!!", getStage(), "Es ahora o nunca, el momento de jugar a llegado. ¡¡¡SOLO UNO PUEDE GANAR!!!");

            } else {
                // if there are still players to select, go to the next player
                currentPlayer++;
                lblPlayerNumber.setText("Jugador " + (currentPlayer + 1));
                txtPlayerName.clear();
                currentSelectedColor = "";
                txtPlayerName.requestFocus();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Por favor, seleccione un color y un nombre para el jugador");
            alert.setHeaderText("SELECCION DE PERSONAJE INCOMPLETA");
            alert.show();
        }
    }

    @FXML
    public void onActionGoBack(ActionEvent actionEvent) {
        FlowController.getInstance().goView("GameParametersView");
        soundUtils.getInstance().playSound("click");
        FlowController.getInstance().goView("GameParametersView");
    }

    private void re_enablePastSelectedPawn() {
        switch (currentSelectedColor) {
            case "pink":
                imgDisabledPinkPawn.setVisible(false);
                break;
            case "green":
                imgDisabledGreenPawn.setVisible(false);
                break;
            case "orange":
                imgDisabledOrangePawn.setVisible(false);
                break;
            case "purple":
                imgDisabledPurplePawn.setVisible(false);
                break;
            case "blue":
                imgDisabledBluePawn.setVisible(false);
                break;
            case "red":
                imgDisabledRedPawn.setVisible(false);
                break;
            default:
                System.out.println("No pawn was selected before");
        }
    }
}
