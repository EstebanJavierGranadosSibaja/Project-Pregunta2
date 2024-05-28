package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Matteo2K24
 */

public class QuestionController extends Controller implements Initializable {

    GameController gameController = (GameController) FlowController.getInstance().getController("GameView");

    @FXML
    private Label lblPregunta;
    @FXML
    private MFXButton btnRespuesta1;
    @FXML
    private MFXButton btnRespuesta3;
    @FXML
    private MFXButton btnRespuesta2;
    @FXML
    private MFXButton btnRespuesta4;
    @FXML
    private Label lblCategory;

    private String category;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @Override
    public void initialize() {
    }

    public void setCategoryTheme(String category) {
        this.category = category;
        lblCategory.setText(category.toUpperCase());
        switch(category) {
        }
    }

    private void calculateAnswerResult(int questionNumber){
        // TODO: Add the logic to check if the given question by the DB is correct

        // for now just asume is correct and thats it
        // TODO: make this more simple and non-parameter like
    }

    @FXML
    public void onActionRespuesta1(ActionEvent actionEvent) {
        calculateAnswerResult(1);

        // TODO: SHOULD BE MANAGED WITH ID INSTEAD OF HARDCODED VALUE
        gameController.showCoin(category, gameController.players[gameController.currentSelectingPlayer -1].getPosicionSector());

        // TODO: SHOULD BEDONE MODIFYING THE DATABASE
        if(gameController.currentSelectingPlayer == gameController.playerCount) gameController.currentSelectingPlayer = 0;

        gameController.currentSelectingPlayer++;

        // debug return to the main menu
        FlowController.getInstance().goView("GameView");
    }

    @FXML
    public void onActionRespuesta2(ActionEvent actionEvent) { calculateAnswerResult(2); }

    @FXML
    public void onActionRespuesta3(ActionEvent actionEvent) { calculateAnswerResult(3); }

    @FXML
    public void onActionRespuesta4(ActionEvent actionEvent) { calculateAnswerResult(4); }





}
