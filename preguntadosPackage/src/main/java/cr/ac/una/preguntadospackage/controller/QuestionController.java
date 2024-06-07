package cr.ac.una.preguntadospackage.controller;

//import cr.ac.una.preguntadospackage.model.PregRespuestasDto;

import cr.ac.una.preguntadospackage.model.PregRespuestasDto;
import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.animationUtils;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Matteo2K24
 */

public class QuestionController extends Controller implements Initializable {

    //GameController gameController;

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

    Boolean isCrowned;
    Boolean onLastCasilla = false;
    Boolean doubleChance = false;
    @FXML
    private ImageView imgDisabledPasar;
    @FXML
    private ImageView imgDisabledDobleOportunidad;
    @FXML
    private ImageView imgDisabledBomba;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //gameController = (GameController) FlowController.getInstance().getController("GameView");

       // initialize the array
        for(int i = 0; i < 4; i++){
            respuestas[i] = new PregRespuestasDto();
        }

        // for now configure it so the first one is correct always TODO:
// this should be replaced with the actual question and answers coming from the database
        respuestas[0].setEsCorrecta("T");
        respuestas[1].setEsCorrecta("F");
        respuestas[2].setEsCorrecta("F");
        respuestas[3].setEsCorrecta("F");

    }

    @Override
    public void initialize() {
    }

    public void setCategoryTheme(String category, Boolean isCrowned) {

        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");

        // enable/disable avaible ayudas
        for(int i = 0; i < 3 ; i++){
            if(!Objects.equals(gameController.players[gameController.currentSelectingPlayer].getDobleAyuda(), "A")){
                imgDisabledDobleOportunidad.setVisible(true);
            }
            if(!Objects.equals(gameController.players[gameController.currentSelectingPlayer].getPasarAyuda(), "A")){
                imgDisabledPasar.setVisible(true);
            }
            if(!Objects.equals(gameController.players[gameController.currentSelectingPlayer].getBombaAyuda(), "A")){
                imgDisabledBomba.setVisible(true);
            }
        }

        this.isCrowned = isCrowned;

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

        // show all the buttons
        btnRespuesta1.setVisible(true);
        btnRespuesta2.setVisible(true);
        btnRespuesta3.setVisible(true);
        btnRespuesta4.setVisible(true);

        // reset the label
        lblCategory.setText("");
        lblPregunta.setText("Pregunta");

        // reset the bools
        isCrowned = false;
        onLastCasilla = false;
    }

    private void calculateAnswerResult(int questionNumber){
        // print the current selecting player
        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");
        System.out.println("Player " + gameController.currentSelectingPlayer + " selected answer " + questionNumber);
        System.out.println((questionNumber-1));


        if(respuestas[(questionNumber - 1)].getEsCorrecta().equals("T")){
            // print the states of isCrowned and onLastCasilla
            System.out.println("isCrowned: " + isCrowned);
            System.out.println("onLastCasilla: " + onLastCasilla);

            gameController.playerCorrectAnswer(category, isCrowned, this.onLastCasilla);
            if(onLastCasilla) this.onLastCasilla = false;
            this.isCrowned = false;
            doubleChance = false;

        } else {
            if(doubleChance){
                doubleChance = false;
                // remove the button that was selected
                switch (questionNumber){
                    case 1: btnRespuesta1.setVisible(false); break;
                    case 2: btnRespuesta2.setVisible(false); break;
                    case 3: btnRespuesta3.setVisible(false); break;
                    case 4: btnRespuesta4.setVisible(false); break;
                }
                return;
            } else {
                gameController.currentSelectingPlayer++;
                if(gameController.currentSelectingPlayer == gameController.partida.getCantidadJugadores().intValue()) gameController.currentSelectingPlayer = 0;
                FlowController.getInstance().goView("GameView");
            }
        }
        // anyway we need to move to the next player


        // debug return to the main menu


        // play an animation to indicate the current playing sector
        //animationUtils.getInstance().playAnimation("fade", gameController.getSectorImageIDbySector(gameController.players[gameController.currentSelectingPlayer].getPosicionSector().intValue()), 0, 0, 0, 0);

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


    @FXML
    public void onActionBomba(Event event) {
        // two incorrect options (randomly selected) are removed
        System.out.println("Bomba");

        // show the disabled image
        imgDisabledBomba.setVisible(true);
    }

    @FXML
    public void onActionPasar(Event event) {
        // the player can select another category
        PlayerCategoryCrownSelectionController playerCategoryCrownSelectionController = (PlayerCategoryCrownSelectionController) FlowController.getInstance().getController("PlayerCategoryCrownSelectionView");
        playerCategoryCrownSelectionController.comesFromAyuda = true;
        FlowController.getInstance().goView("PlayerCategoryCrownSelectionView");
        System.out.println("Pasar");

        // reset the category theme
        resetCategoryTheme();

        // show the disabled image
        imgDisabledPasar.setVisible(true);
    }

    @FXML
    public void onActionDobleOportunidad(Event event) {
        // the player can select two answers
        System.out.println("Doble Oportunidad");
        doubleChance = true; //functions as a bounce shield

        // show the disabled image
        imgDisabledDobleOportunidad.setVisible(true);
    }

    @FXML
    public void onActionExit(Event event) {
        FlowController.getInstance().goView("MainMenuView");
    }
}
