package cr.ac.una.preguntadospackage.controller;

//import cr.ac.una.preguntadospackage.model.PregRespuestasDto;
import cr.ac.una.preguntadospackage.model.PregPreguntasDto;
import cr.ac.una.preguntadospackage.model.PregRespuestasDto;
import cr.ac.una.preguntadospackage.service.PregPreguntasService;
import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.Respuesta;
import cr.ac.una.preguntadospackage.util.animationUtils;
import cr.ac.una.preguntadospackage.util.soundUtils;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    int oponentPlayer = -1;
    @FXML
    private ImageView imgDisabledPasar;
    @FXML
    private ImageView imgDisabledDobleOportunidad;
    @FXML
    private ImageView imgDisabledBomba;
    @FXML
    private Label lblCategory1;

    private ObservableList<PregPreguntasDto> preguntasList;

    private ObservableList<PregRespuestasDto> respuestasList;

    private PregPreguntasDto pregPreguntaDto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //gameController = (GameController) FlowController.getInstance().getController("GameView");
        // initialize the array
        for (int i = 0; i < 4; i++) {
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

        PregPreguntasService preguntasService = new PregPreguntasService();
        Respuesta respuesta = new Respuesta();

        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");

        // enable/disable avaible ayudas
        if (!Objects.equals(gameController.players[gameController.currentSelectingPlayer].getDobleAyuda(), "A")) {
            System.out.println("Doble ayuda inhabilitada");
            imgDisabledDobleOportunidad.setVisible(true);
        }
        if (!Objects.equals(gameController.players[gameController.currentSelectingPlayer].getPasarAyuda(), "A")) {
            System.out.println("Pasar Ayuda inhabilitada");
            imgDisabledPasar.setVisible(true);
        }
        if (!Objects.equals(gameController.players[gameController.currentSelectingPlayer].getBombaAyuda(), "A")) {
            System.out.println("Bomba Ayuda inhabilitada");
            imgDisabledBomba.setVisible(true);
        }

        this.isCrowned = isCrowned;
        this.isCrowned = isCrowned;
        this.category = category;

        lblCategory.setText(category.toUpperCase());
        switch (category) {
            case "sciencie":
                imgScienceChar.setVisible(true);
                respuesta = preguntasService.getPreguntas("CIENCIA");
                preguntasList = FXCollections.observableArrayList((List<PregPreguntasDto>) respuesta.getResultado("PregPreguntas"));
                Collections.shuffle(preguntasList);
                pregPreguntaDto = preguntasList.get(0);
                break;
            case "geography":
                imgGeographyChar.setVisible(true);
                respuesta = preguntasService.getPreguntas("GREOGRAFIA");
                preguntasList = FXCollections.observableArrayList((List<PregPreguntasDto>) respuesta.getResultado("PregPreguntas"));
                Collections.shuffle(preguntasList);
                pregPreguntaDto = preguntasList.get(0);
                break;
            case "entertainment":
                imgEntertainmentChar.setVisible(true);
                respuesta = preguntasService.getPreguntas("ENTRETENIMIENTO");
                preguntasList = FXCollections.observableArrayList((List<PregPreguntasDto>) respuesta.getResultado("PregPreguntas"));
                Collections.shuffle(preguntasList);
                pregPreguntaDto = preguntasList.get(0);
                break;
            case "art":
                imgArtChar.setVisible(true);
                respuesta = preguntasService.getPreguntas("ARTE");
                preguntasList = FXCollections.observableArrayList((List<PregPreguntasDto>) respuesta.getResultado("PregPreguntas"));
                Collections.shuffle(preguntasList);
                pregPreguntaDto = preguntasList.get(0);
                break;
            case "sports":
                imgSportsChar.setVisible(true);
                respuesta = preguntasService.getPreguntas("DEPORTE");
                preguntasList = FXCollections.observableArrayList((List<PregPreguntasDto>) respuesta.getResultado("PregPreguntas"));
                Collections.shuffle(preguntasList);
                pregPreguntaDto = preguntasList.get(0);
                break;
            case "history":
                imgHistoryChar.setVisible(true);
                respuesta = preguntasService.getPreguntas("HISTORIA");
                preguntasList = FXCollections.observableArrayList((List<PregPreguntasDto>) respuesta.getResultado("PregPreguntas"));
                Collections.shuffle(preguntasList);
                pregPreguntaDto = preguntasList.get(0);
                break;
        }
        setText();
    }

    private void setText() {
        respuestasList = pregPreguntaDto.getPregRespuestasList();
        Collections.shuffle(respuestasList);

        lblPregunta.setText(pregPreguntaDto.getTextoPregunta());
        btnRespuesta1.setText(respuestasList.get(0).getTextoRespuesta());
        btnRespuesta2.setText(respuestasList.get(1).getTextoRespuesta());
        btnRespuesta3.setText(respuestasList.get(2).getTextoRespuesta());
        btnRespuesta4.setText(respuestasList.get(3).getTextoRespuesta());
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
        btnRespuesta1.setText("");
        btnRespuesta2.setText("");
        btnRespuesta3.setText("");
        btnRespuesta4.setText("");

        // reset the bools
        isCrowned = false;
        onLastCasilla = false;
    }

    private void calculateAnswerResult(int questionNumber) {
        soundUtils.getInstance().playSound("click");
        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");
        if (respuestas[(questionNumber - 1)].getEsCorrecta().equals("T")) {
            gameController.playerCorrectAnswer(category, isCrowned, this.onLastCasilla);
            if (onLastCasilla) {
                this.onLastCasilla = false;
            }
            this.isCrowned = false;
            doubleChance = false;
        } else {
            if (doubleChance) {
                doubleChance = false;
                switch (questionNumber) { // remove the button that was selected
                    case 1:
                        btnRespuesta1.setVisible(false);
                        break;
                    case 2:
                        btnRespuesta2.setVisible(false);
                        break;
                    case 3:
                        btnRespuesta3.setVisible(false);
                        break;
                    case 4:
                        btnRespuesta4.setVisible(false);
                        break;
                }
                return;
            } else {
                gameController.currentSelectingPlayer++;
                if (gameController.currentSelectingPlayer == gameController.partida.getCantidadJugadores().intValue()) {
                    gameController.currentSelectingPlayer = 0;
                }
                if (oponentPlayer != -1) {
                    gameController.currentSelectingPlayer = oponentPlayer;
                    //resetCategoryTheme();
                    System.out.println("The other player should be choosing now");
                    FlowController.getInstance().goView("PlayerCategoryCrownSelectionView");
                    oponentPlayer = -1;
                } else {
                    gameController.lblCurrentPlayerTurn.setText("Turno de " + gameController.players[gameController.currentSelectingPlayer].getNombreJugador());
                    FlowController.getInstance().goView("GameView");
                }
            }
        }
        // play an animation to indicate the current playing sector
        animationUtils.getInstance().playAnimation("fade", gameController.getSectorImageByID(gameController.players[gameController.currentSelectingPlayer].getPosicionSector().intValue()), 0, 0, 0, 0);
        resetCategoryTheme();
    }

    @FXML
    public void onActionRespuesta1(ActionEvent actionEvent) {
        calculateAnswerResult(1);
    }

    @FXML
    public void onActionRespuesta2(ActionEvent actionEvent) {
        calculateAnswerResult(2);
    }

    @FXML
    public void onActionRespuesta3(ActionEvent actionEvent) {
        calculateAnswerResult(3);
    }

    @FXML
    public void onActionRespuesta4(ActionEvent actionEvent) {
        calculateAnswerResult(4);
    }

    @FXML
    public void onActionBomba(Event event) {
        soundUtils.getInstance().playSound("click");
        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");
        gameController.players[gameController.currentSelectingPlayer].setBombaAyuda("U");

        // two incorrect options (randomly selected) are removed
        System.out.println("Bomba");

        // logic goes here
        // Identify the incorrect answers
        List<Integer> incorrectAnswers = new ArrayList<>();
        for (int i = 0; i < respuestas.length; i++) {
            if (respuestas[i].getEsCorrecta().equals("F")) {
                incorrectAnswers.add(i);
            }
        }

        // Select two incorrect answers at random
        Collections.shuffle(incorrectAnswers);
        List<Integer> selectedAnswers = incorrectAnswers.subList(0, Math.min(2, incorrectAnswers.size()));

        for (int answer : selectedAnswers) {
            switch (answer) {
                case 0:
                    btnRespuesta1.setVisible(false);
                    break;
                case 1:
                    btnRespuesta2.setVisible(false);
                    break;
                case 2:
                    btnRespuesta3.setVisible(false);
                    break;
                case 3:
                    btnRespuesta4.setVisible(false);
                    break;
            }
        }

        // show the disabled image
        imgDisabledBomba.setVisible(true);
    }

    @FXML
    public void onActionPasar(Event event) {
        soundUtils.getInstance().playSound("click");
        // reset the category theme
        resetCategoryTheme();

        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");
        gameController.players[gameController.currentSelectingPlayer].setPasarAyuda("U");

        // the player can select another category
        PlayerCategoryCrownSelectionController playerCategoryCrownSelectionController = (PlayerCategoryCrownSelectionController) FlowController.getInstance().getController("PlayerCategoryCrownSelectionView");
        playerCategoryCrownSelectionController.comesFromAyuda = true;
        FlowController.getInstance().goView("PlayerCategoryCrownSelectionView");
        System.out.println("Pasar");

        // show the disabled image
        imgDisabledPasar.setVisible(true);
    }

    @FXML
    public void onActionDobleOportunidad(Event event) {
        soundUtils.getInstance().playSound("click");
        GameController gameController = (GameController) FlowController.getInstance().getController("GameView");
        gameController.players[gameController.currentSelectingPlayer].setDobleAyuda("U");

        // the player can select two answers
        System.out.println("Doble Oportunidad");
        doubleChance = true; //functions as a bounce shield

        // show the disabled image
        imgDisabledDobleOportunidad.setVisible(true);
    }

    @Deprecated
    public void onActionExit(Event event) {
        soundUtils.getInstance().playSound("click");
        FlowController.getInstance().goView("MainMenuView");
    }
}
