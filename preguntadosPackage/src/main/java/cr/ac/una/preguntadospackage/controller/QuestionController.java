package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.model.PregRespuestasDto;
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

    /**
     * Initializes the controller class.
     */

    private PregRespuestasDto respuestas[] = new PregRespuestasDto[4];




    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // initialize the array
        for(int i = 0; i < 4; i++){
            respuestas[i] = new PregRespuestasDto();
        }

        // for now configure it so the first one is correct always
        respuestas[0].setEsCorrecta("V");
        respuestas[1].setEsCorrecta("F");
        respuestas[2].setEsCorrecta("F");
        respuestas[3].setEsCorrecta("F");
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
        // print the current selecting player
        System.out.println("Player " + gameController.currentSelectingPlayer + " selected answer " + questionNumber);

        if(respuestas[questionNumber - 1].getEsCorrecta().equals("V")){
            // print the player current sector and casilla
            System.out.println("Player " + gameController.currentSelectingPlayer + " is in sector " + gameController.players[gameController.currentSelectingPlayer - 1].getPosicionSector() + " and casilla " + gameController.players[gameController.currentSelectingPlayer - 1].getPosicionCasilla());
            gameController.movePawnForward(gameController.players[gameController.currentSelectingPlayer - 1].getPosicionSector(), gameController.players[gameController.currentSelectingPlayer - 1].getPosicionCasilla());
            gameController.showCoin(category, gameController.players[gameController.currentSelectingPlayer - 1].getPosicionSector());
            gameController.players[gameController.currentSelectingPlayer - 1].setPosicionCasilla(gameController.players[gameController.currentSelectingPlayer - 1].getPosicionCasilla() + 1);
        } else {
            // the logic for the wrong answer goes here
        }
        // anyway we need to move to the next player
        if(gameController.currentSelectingPlayer == gameController.playerCount) gameController.currentSelectingPlayer = 0;
        gameController.currentSelectingPlayer++;

        // print the current selecting player after the ++
        gameController.lblCurrentPlayerTurn.setText("TURNO DEL JUGADOR: " + gameController.currentSelectingPlayer);

        // debug return to the main menu
        FlowController.getInstance().goView("GameView");
    }

    @FXML
    public void onActionRespuesta1(ActionEvent actionEvent) { calculateAnswerResult(1); }

    @FXML
    public void onActionRespuesta2(ActionEvent actionEvent) { calculateAnswerResult(2); }

    @FXML
    public void onActionRespuesta3(ActionEvent actionEvent) { calculateAnswerResult(3); }

    @FXML
    public void onActionRespuesta4(ActionEvent actionEvent) { calculateAnswerResult(4); }





}
