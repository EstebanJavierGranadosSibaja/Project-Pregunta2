package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.soundUtils;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PlayerCategoryCrownSelectionController extends Controller implements Initializable {
    @javafx.fxml.FXML
    private ImageView imgDisabledGeography;
    @javafx.fxml.FXML
    private ImageView imgDisabledSports;
    @javafx.fxml.FXML
    private ImageView imgDisabledArt;
    @javafx.fxml.FXML
    private ImageView imgDisabledEntertainment;
    @javafx.fxml.FXML
    private ImageView imgDisabledScience;
    @javafx.fxml.FXML
    private ImageView imgDisabledHistory;

    QuestionController questionController = (QuestionController) FlowController.getInstance().getController("QuestionView");
    public Boolean onLastCasilla = false;
    public Boolean comesFromAyuda = false; // this enables us to know if the player is coming from the help view
    // so that way we are not considering it as the last casilla or crown

    @Override
    public void initialize() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    // this method disables or enables coins depending if the player has already has it or not
    public void setupCoins(){

        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");
        if(Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaArte(), "I") || Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaArte(), "U")){
            imgDisabledGeography.setVisible(false);
        }
        if(Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaDeporte(), "I") || Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaDeporte(), "U")){
            imgDisabledSports.setVisible(false);
        }
        if(Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaHistoria(), "I") || Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaHistoria(), "U")){
            imgDisabledArt.setVisible(false);
        }
        if(Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaEntretenimiento(), "I") || Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaEntretenimiento(), "U")){
            imgDisabledEntertainment.setVisible(false);
        }
        if(Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaCiencias(), "I") || Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaCiencias(), "U")){
            imgDisabledScience.setVisible(false);
        }
        if(Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaGeografia(), "I") || Objects.equals(gameController.players[gameController.currentSelectingPlayer].getFichaGeografia(), "U")){
            imgDisabledHistory.setVisible(false);
        }
    }

    private void resetEverything() {
        imgDisabledGeography.setVisible(true);
        imgDisabledSports.setVisible(true);
        imgDisabledArt.setVisible(true);
        imgDisabledEntertainment.setVisible(true);
        imgDisabledScience.setVisible(true);
        imgDisabledHistory.setVisible(true);
        comesFromAyuda = false;
        onLastCasilla = false;
    }

    @javafx.fxml.FXML
    public void onActionEntertainment(Event event) {
        soundUtils.getInstance().playSound("click");
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("entertainment", !comesFromAyuda);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();
    }

    @javafx.fxml.FXML
    public void onActionHistory(Event event) {
        soundUtils.getInstance().playSound("click");
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("history", !comesFromAyuda);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();
    }

    @javafx.fxml.FXML
    public void onActionArt(Event event) {
        soundUtils.getInstance().playSound("click");
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("art", !comesFromAyuda);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();
    }

    @javafx.fxml.FXML
    public void onActionGeography(Event event) {
        soundUtils.getInstance().playSound("click");
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("geography", true);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();
    }

    @javafx.fxml.FXML
    public void onActionSports(Event event) {
        soundUtils.getInstance().playSound("click");
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("sports", !comesFromAyuda);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();
    }

    @javafx.fxml.FXML
    public void onActionScience(Event event) {
        soundUtils.getInstance().playSound("click");
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("sciencie", !comesFromAyuda);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();
    }
}