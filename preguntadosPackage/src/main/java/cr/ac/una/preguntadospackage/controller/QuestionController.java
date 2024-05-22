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

    private int category;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }    

    @Override
    public void initialize() {
    }


    public void setCategoryTheme(int category) {
        this.category = category;
        switch(category){
            case 0:
                // TODO: Get from the database the questions for the category "Historia"
                // and set the question and answers in the labels

                // TODO: Configure the buttons to show the answers
                // and set the correct answer to the button

                lblCategory.setText("CIENCIA");

                break;
            case 1:
                lblCategory.setText("GEOGRAFIA");





                break;
            case 2:

                lblCategory.setText("CORONA");



                break;
            case 3:

                lblCategory.setText("ENTRETENIMIENTO");



                break;
            case 4:

                lblCategory.setText("ARTE");





                break;
            case 5:

                lblCategory.setText("DEPORTE");





                break;

            case 6:

                lblCategory.setText("HISTORIA");


                break;
        }
    }


    @FXML
    public void onActionRespuesta4(ActionEvent actionEvent) {
        // Debug message
        System.out.println("Respuesta 4");

    }

    @FXML
    public void onActionRespuesta3(ActionEvent actionEvent) {
        // Debug message
        System.out.println("Respuesta 3");

    }

    @FXML
    public void onActionRespuesta2(ActionEvent actionEvent) {
        // Debug message
        System.out.println("Respuesta 2");

    }

    @FXML
    public void onActionRespuesta1(ActionEvent actionEvent) {
        // Debug message
        System.out.println("Respuesta 1 - \n>>>>>>>DEBUG: Return to the main menu and consider it as a correct answer");

        // debug return to the main menu
        FlowController.getInstance().goView("GameView");
    }
}
