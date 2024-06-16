package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.model.PregJugpartidaDto;
import cr.ac.una.preguntadospackage.util.FlowController;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.Flow;

public class PlayerDuelSelectionController extends Controller implements Initializable {

    QuestionController questionController = (QuestionController) FlowController.getInstance().getController("QuestionView");
    public Boolean onLastCasilla = false;
    public Boolean comesFromAyuda = false; // this enables us to know if the player is coming from the help view
    @javafx.fxml.FXML
    private Label lblBluePlayer;
    @javafx.fxml.FXML
    private Label lblRedPlayer;
    @javafx.fxml.FXML
    private ImageView imgDisabledPinkPawn;
    @javafx.fxml.FXML
    private Label lblYellowPlaye;
    @javafx.fxml.FXML
    private Label lblPurplePlayer;
    @javafx.fxml.FXML
    private ImageView imgDisabledGreenPawn;
    @javafx.fxml.FXML
    private ImageView imgDisabledBluePawn;
    @javafx.fxml.FXML
    private Label lblPinkPlayer;
    @javafx.fxml.FXML
    private Label lblGreenPlayer;
    @javafx.fxml.FXML
    private ImageView imgDisabledRedPawn;
    @javafx.fxml.FXML
    private ImageView imgDisabledYellowPawn;
    @javafx.fxml.FXML
    private ImageView imgDisabledPurplePawn;

    @Override
    public void initialize() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setPlayersNamesAndColors() {

        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");
        for(PregJugpartidaDto player: gameController.players){
            if(Objects.equals(player.getColorPeon(), "blue")){
                imgDisabledBluePawn.setVisible(false);
                lblBluePlayer.setText(player.getNombreJugador());
            } else if(Objects.equals(player.getColorPeon(), "red")){
                imgDisabledRedPawn.setVisible(false);
                lblRedPlayer.setText(player.getNombreJugador());
            } else if(Objects.equals(player.getColorPeon(), "pink")){
                imgDisabledPinkPawn.setVisible(false);
                lblPinkPlayer.setText(player.getNombreJugador());
            } else if(Objects.equals(player.getColorPeon(), "yellow")){
                imgDisabledYellowPawn.setVisible(false);
                lblYellowPlaye.setText(player.getNombreJugador());
            } else if(Objects.equals(player.getColorPeon(), "purple")){
                imgDisabledPurplePawn.setVisible(false);
                lblPurplePlayer.setText(player.getNombreJugador());
            } else if(Objects.equals(player.getColorPeon(), "green")){
                imgDisabledGreenPawn.setVisible(false);
                lblGreenPlayer.setText(player.getNombreJugador());
            }
        }

    }

    private void playerHasBeenSelected(String color){
        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");
        QuestionController questionController = (QuestionController) FlowController.getInstance().getController("QuestionView");
        for(int i = 0; i < gameController.partida.getCantidadJugadores(); i++){
            if(Objects.equals(gameController.players[i].getColorPeon(), color)){
                questionController.oponentPlayer = i;

                FlowController.getInstance().goView("PlayerCategoryCrownSelectionView");
            }
        }
    }

    @javafx.fxml.FXML
    public void onActionRedPawn(Event event) {
        playerHasBeenSelected("red");
    }

    @javafx.fxml.FXML
    public void onActionGreenPawn(Event event) {
        playerHasBeenSelected("green");
    }

    @javafx.fxml.FXML
    public void onActionPinkPawn(Event event) {
        playerHasBeenSelected("pink");
    }

    @javafx.fxml.FXML
    public void onActionPurplePawn(Event event) {
        playerHasBeenSelected("purple");
    }

    @javafx.fxml.FXML
    public void onActionYellowPawn(Event event) {
        playerHasBeenSelected("yellow");
    }

    @javafx.fxml.FXML
    public void onActionBluePawn(Event event) {
        playerHasBeenSelected("blue");
    }
}