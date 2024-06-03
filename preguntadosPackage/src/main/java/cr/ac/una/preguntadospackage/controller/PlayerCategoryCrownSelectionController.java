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


    @Override
    public void initialize() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /*
    FOR REFERENCE;
    return switch (category) {
            case 0 -> "sciencie";
            case 1 -> "geography";
            case 2 -> "crown";
            case 3 -> "entertainment";
            case 4 -> "art";
            case 5 -> "sports";
            case 6 -> "history";
            default -> null;
        };

        THERE SHOULD BE AN ICON POPING UP WITH THE CATEGORY USING THIS slowPopUp ANIMATION METHOD
     */

    @javafx.fxml.FXML
    public void onActionEntertainment(Event event) {
        questionController.setCategoryTheme("entertainment");
        FlowController.getInstance().goView("QuestionView");
    }

    @javafx.fxml.FXML
    public void onActionHistory(Event event) {
        questionController.setCategoryTheme("history");
        FlowController.getInstance().goView("QuestionView");
    }

    @javafx.fxml.FXML
    public void onActionArt(Event event) {
        questionController.setCategoryTheme("art");
        FlowController.getInstance().goView("QuestionView");
    }

    @javafx.fxml.FXML
    public void onActionGeography(Event event) {
        questionController.setCategoryTheme("geography");
        FlowController.getInstance().goView("QuestionView");
    }

    @javafx.fxml.FXML
    public void onActionSports(Event event) {
        questionController.setCategoryTheme("sports");
        FlowController.getInstance().goView("QuestionView");
    }

    @javafx.fxml.FXML
    public void onActionScience(Event event) {
        questionController.setCategoryTheme("sciencie");
        FlowController.getInstance().goView("QuestionView");
    }
}
