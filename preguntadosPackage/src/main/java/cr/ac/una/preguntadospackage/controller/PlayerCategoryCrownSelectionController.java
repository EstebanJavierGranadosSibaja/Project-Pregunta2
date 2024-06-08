package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
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

    private void resetEverything() {
        imgDisabledGeography.setVisible(false);
        imgDisabledSports.setVisible(false);
        imgDisabledArt.setVisible(false);
        imgDisabledEntertainment.setVisible(false);
        imgDisabledScience.setVisible(false);
        imgDisabledHistory.setVisible(false);
        comesFromAyuda = false;
        onLastCasilla = false;
    }

    @javafx.fxml.FXML
    public void onActionEntertainment(Event event) {
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("entertainment", !comesFromAyuda);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();
    }

    @javafx.fxml.FXML
    public void onActionHistory(Event event) {
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("history", !comesFromAyuda);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();


        /*questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("history", true);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();

         */
    }

    @javafx.fxml.FXML
    public void onActionArt(Event event) {
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("art", !comesFromAyuda);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();
    }

    @javafx.fxml.FXML
    public void onActionGeography(Event event) {
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("geography", true);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();
    }

    @javafx.fxml.FXML
    public void onActionSports(Event event) {
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("sports", !comesFromAyuda);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();
    }

    @javafx.fxml.FXML
    public void onActionScience(Event event) {
        questionController.onLastCasilla = onLastCasilla;
        questionController.setCategoryTheme("sciencie", !comesFromAyuda);
        FlowController.getInstance().goView("QuestionView");
        resetEverything();
    }
}
