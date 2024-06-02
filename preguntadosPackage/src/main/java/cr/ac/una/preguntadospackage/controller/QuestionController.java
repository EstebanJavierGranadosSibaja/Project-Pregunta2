package cr.ac.una.preguntadospackage.controller;

//import cr.ac.una.preguntadospackage.model.PregRespuestasDto;

import cr.ac.una.preguntadospackage.model.PregRespuestasDto;
import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.animationUtils;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

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
    @FXML
    private ImageView imgGeographyChar;
    @FXML
    private ImageView imgScienceChar;
    @FXML
    private ImageView imgSportsChar;
    @FXML
    private ImageView imgArtChar;
    @FXML
    private ImageView imgEntertainmentChar;
    @FXML
    private ImageView imgHistoryChar;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

       // initialize the array
        for(int i = 0; i < 4; i++){
            respuestas[i] = new PregRespuestasDto();
        }

        // for now configure it so the first one is correct always TODO:
        respuestas[0].setEsCorrecta("T");
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
            case "sciencie":
                imgScienceChar.setVisible(true);
                break;
            case "geography":
                imgGeographyChar.setVisible(true);
                break;
            case "entertainment":
                imgEntertainmentChar.setVisible(true);
                break;
            case "art":
                imgArtChar.setVisible(true);
                break;
            case "sports":
                imgSportsChar.setVisible(true);
                break;
            case "history":
                imgHistoryChar.setVisible(true);
                break;
        }
    }

    private void resetCategoryTheme() {
        imgScienceChar.setVisible(false);
        imgGeographyChar.setVisible(false);
        imgHistoryChar.setVisible(false);
        imgEntertainmentChar.setVisible(false);
        imgArtChar.setVisible(false);
        imgSportsChar.setVisible(false);
        imgHistoryChar.setVisible(false);
    }

    private void calculateAnswerResult(int questionNumber){
        // print the current selecting player
        System.out.println("Player " + gameController.currentSelectingPlayer + " selected answer " + questionNumber);
        System.out.println((questionNumber-1));
        System.out.println(respuestas[questionNumber - 1 ].getEsCorrecta());

        if(respuestas[(questionNumber - 1)].getEsCorrecta().equals("T")){
            System.out.println("Es correcta!");
            // print the player current sector and casilla

            // the logic for the correct answer goes here
            gameController.playerCorrectAnswer(category);
            System.out.println(category);


        } else {
            // the logic for the wrong answer goes here
        }
        // anyway we need to move to the next player
        if(gameController.currentSelectingPlayer == gameController.partida.getCantidadJugadores().intValue()) gameController.currentSelectingPlayer = 0;
        gameController.currentSelectingPlayer++;

        // print the current selecting player after the ++
        gameController.lblCurrentPlayerTurn.setText("TURNO DEL JUGADOR: " + gameController.currentSelectingPlayer);

        // debug return to the main menu
        FlowController.getInstance().goView("GameView");

        // play an animation to indicate the current playing sector
        animationUtils.getInstance().playAnimation("blink", gameController.getSectorImageIDbySector(gameController.players[gameController.currentSelectingPlayer].getPosicionSector().intValue()));

        resetCategoryTheme();
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
