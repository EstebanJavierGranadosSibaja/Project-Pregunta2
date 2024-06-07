package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

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

    public void recieveParametersFromParametersView(int amountOfPlayers, String gameMode, String duelMode, int timeLimitInMinutes){
        // save up this variables (they are just going to be passed to the game view) like saving something in your pocket
        this.amountOfPlayers = amountOfPlayers;
        this.gameMode = gameMode;
        this.duelMode = duelMode;
        this.timeLimitInMinutes = timeLimitInMinutes;
    }

    // IMAGES >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // if the player clicks a pawn, but then changes his mind and clicks another one, the previous pawn should be re-enabled
    // but we have to take into consideration the other already selected pawns
    private void re_enablePastSelectedPawn(){
        switch (currentSelectedColor){
            case "pink": imgDisabledPinkPawn.setVisible(false); break;
            case "green": imgDisabledGreenPawn.setVisible(false); break;
            case "orange": imgDisabledOrangePawn.setVisible(false); break;
            case "purple": imgDisabledPurplePawn.setVisible(false); break;
            case "blue": imgDisabledBluePawn.setVisible(false); break;
            case "red": imgDisabledRedPawn.setVisible(false); break;
            default: System.out.println("No pawn was selected before");
        }
    }

    @javafx.fxml.FXML
    public void onActionGreenPawnSelected(Event event) {
        re_enablePastSelectedPawn();
        currentSelectedColor = "green";
        imgDisabledGreenPawn.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onActionOrangePawnSelected(Event event) {
        re_enablePastSelectedPawn();
        currentSelectedColor = "orange";
        imgDisabledOrangePawn.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onActionPinkPawnSelected(Event event) {
        re_enablePastSelectedPawn();
        currentSelectedColor = "pink";
        imgDisabledPinkPawn.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onActionPurplePawnSelected(Event event) {
        re_enablePastSelectedPawn();
        currentSelectedColor = "purple";
        imgDisabledPurplePawn.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onActionBluePawnSelected(Event event) {
        re_enablePastSelectedPawn();
        currentSelectedColor = "blue";
        imgDisabledBluePawn.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onActionRedPawnSelected(Event event) {
        re_enablePastSelectedPawn();
        currentSelectedColor = "red";
        imgDisabledRedPawn.setVisible(true);
    }

    // BUTTONS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @javafx.fxml.FXML
    public void onActionConfirmar(ActionEvent actionEvent) {
        if(!txtPlayerName.getText().isBlank() && !currentSelectedColor.isBlank()){

            // save the player name and color
            playerNames[currentPlayer] = txtPlayerName.getText();
            playerColors[currentPlayer] = currentSelectedColor;

            // String[] playerColors, String[] playerNames, int amountOfPlayers, String gameMode, String duelMode, int timeLimitInMinutes

            if(currentPlayer == amountOfPlayers - 1){
                // if all players have been selected, go to the game view
                gameController.recieveParameters(playerColors, playerNames, amountOfPlayers, gameMode, duelMode, timeLimitInMinutes);
                FlowController.getInstance().goView("GameView");

            } else {
                // if there are still players to select, go to the next player
                currentPlayer++;
                lblPlayerNumber.setText("Jugador " + (currentPlayer + 1));
                txtPlayerName.clear();
                currentSelectedColor = "";
                txtPlayerName.requestFocus();
            }
        }
    }

    @javafx.fxml.FXML
    public void onActionGoBack(ActionEvent actionEvent) {
    }
}
