package cr.ac.una.preguntadospackage.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import cr.ac.una.preguntadospackage.util.FlowController;
import javafx.animation.RotateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class GameController extends Controller implements Initializable {

    Boolean hasSpinnerBeenClicked = false;
    ArrayList<Integer> activePlayersList = new ArrayList<>();
    @FXML private HBox hboxInventory2, hboxInventory1, hboxInventory4, hboxInventory3, hboxInventory6, hboxInventory5;
    @FXML private ImageView imgSportShadow, imgHistory, imgScience, imgArtShadow, imgEntertainment, imgScienceShadow, imgCrownShadow, imgEntertainmentShadow, imgHistoryShadow, imgGeographyShadow, imgArt, imgSport, imgGeography, imgCrown, imgPawnRedSlot4, imgPawnRedSlot2, imgPawnRedSlot3, imgPawnRedSlot1, imgPawnPurpleSlot2, imgPawnPurpleSlot1, imgPawnOrangeSlot4, imgPawnPurpleSlot4, imgPawnOrangeSlot3, imgPawnPurpleSlot3, imgPawnOrangeSlot2, imgPawnOrangeSlot1, imgPawnGreenSlot1, imgPawnGreenSlot3, imgPawnGreenSlot2, imgPawnGreenSlot4, imgSpinner, imgGreenPawnSelection, imgPurplePawnSelection, imgDisabledGreenPawn, imgDisabledRedPawn, imgDisabledOrangePawn, imgOrangePawnSelection, imgRedPawnSelection, imgDisabledPurplePawn;
    @FXML private Label lblPlayerCurrentlySelecting;
    @FXML private AnchorPane apSelectionScreen;

    // this method takes care of setting up the player count and the help assistance level
    // TODO: implement the help assistance level and initialize the inventory slots
    public void setupPlayerCount(int playerCount, int helpAssistanceLevel) {
        switch(playerCount) {
            case 2: hboxInventory1.setVisible(true); hboxInventory6.setVisible(true); break;
            case 3: hboxInventory1.setVisible(true); hboxInventory6.setVisible(true); hboxInventory4.setVisible(true); break;
            case 4: hboxInventory1.setVisible(true); hboxInventory6.setVisible(true); hboxInventory3.setVisible(true); hboxInventory4.setVisible(true); break;
            case 5: hboxInventory1.setVisible(true); hboxInventory6.setVisible(true); hboxInventory3.setVisible(true); hboxInventory4.setVisible(true); hboxInventory2.setVisible(true); break;
            case 6: hboxInventory1.setVisible(true); hboxInventory6.setVisible(true); hboxInventory3.setVisible(true); hboxInventory4.setVisible(true); hboxInventory5.setVisible(true); hboxInventory2.setVisible(true); break;
        }
        // disale the non avaible pawns (they will and can show up in the future, its just a method to disable them for now)
        disableNonAvaiblePawns(playerCount);

        // TODO: for now just disable the Anchor Pane that shows the player selection screen
        apSelectionScreen.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // hide the non avaible inventory slots (the ones avaible will show up in the setupPlayerCount method)
        hideNonAvaibleInventorySlots();
        // hide the category animations and its shadows
        hideCategoryAnimation();
        // for now hide all the pawns and just show the number 1 of each color
        imgPawnGreenSlot1.setVisible(true); imgPawnOrangeSlot1.setVisible(true); imgPawnPurpleSlot1.setVisible(true); imgPawnRedSlot1.setVisible(true);
        imgPawnGreenSlot2.setVisible(false); imgPawnOrangeSlot2.setVisible(false); imgPawnPurpleSlot2.setVisible(false); imgPawnRedSlot2.setVisible(false);
        imgPawnGreenSlot3.setVisible(false); imgPawnOrangeSlot3.setVisible(false); imgPawnPurpleSlot3.setVisible(false); imgPawnRedSlot3.setVisible(false);
        imgPawnGreenSlot4.setVisible(false); imgPawnOrangeSlot4.setVisible(false); imgPawnPurpleSlot4.setVisible(false); imgPawnRedSlot4.setVisible(false);

    }

    @Override
    public void initialize() {
    }

    private void hideNonAvaibleInventorySlots() {
        hboxInventory1.setVisible(false); hboxInventory2.setVisible(false); hboxInventory3.setVisible(false); hboxInventory4.setVisible(false); hboxInventory5.setVisible(false); hboxInventory6.setVisible(false);
    }

    // this method takes care of disabling the pawns that are not avaible (this disables the dark pawns the represent the disabled or already selected pawns)
    public void disableNonAvaiblePawns(int playerCount) {
        imgDisabledGreenPawn.setVisible(false);
        imgDisabledOrangePawn.setVisible(false);
        imgDisabledPurplePawn.setVisible(false);
        imgDisabledRedPawn.setVisible(false);
    }

    // this method takes care of showing the player that is currently selecting a pawn
    // TODO: make it better
    public void playCategoryAnimation(int category) {
        switch(category) {
            case 0: imgScience.setVisible(true); imgScienceShadow.setVisible(true); break;
            case 1: imgGeography.setVisible(true); imgGeographyShadow.setVisible(true); break;
            case 2: imgCrown.setVisible(true); imgCrownShadow.setVisible(true); break;
            case 3: imgEntertainment.setVisible(true); imgEntertainmentShadow.setVisible(true); break;
            case 4: imgArt.setVisible(true); imgArtShadow.setVisible(true); break;
            case 5: imgSport.setVisible(true); imgSportShadow.setVisible(true); break;
        }
    }

    // this method takes care of hiding the category animations and its shadows
    private void hideCategoryAnimation() {
        imgArt.setVisible(false); imgArtShadow.setVisible(false); imgCrown.setVisible(false); imgCrownShadow.setVisible(false); imgEntertainment.setVisible(false); imgEntertainmentShadow.setVisible(false); imgGeography.setVisible(false); imgGeographyShadow.setVisible(false); imgHistory.setVisible(false); imgHistoryShadow.setVisible(false); imgScience.setVisible(false); imgScienceShadow.setVisible(false); imgSport.setVisible(false); imgSportShadow.setVisible(false);
    }

    // this method takes care of showing the player that is currently selecting a pawn
    @FXML
    public void onActionSpinner(MouseEvent event) {


        // this is because the roulette is a little bit off center
        imgSpinner.setRotate(27);

        // this is to prevent the user from clicking the spinner multiple times
        if (hasSpinnerBeenClicked) {
            return;
        }

        // generate a random number between 0 and 360
        double randomDegrees = Math.random() * 360;
        // get that and divite it by 51.4 to get the category
        int category = (int) Math.floor(randomDegrees / 51.4);

        // create the animation itself
        RotateTransition rt = new RotateTransition(javafx.util.Duration.seconds(4.5), imgSpinner);
        // set the angle to rotate (random degrees + 3600 to make it spin multiple times, exactly 10)
        rt.setByAngle(randomDegrees + 3600);

        // start the animation
        rt.play();

        // show the category logo and shadow
        // TODO: fix this and make it pop out
        playCategoryAnimation(category);

        // lambda function to execute when the animation is finished
        rt.setOnFinished(e -> {
            // make the current main thread sleep for 2.5 seconds to show the category logo and shadow
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                System.out.println("Error al pausar el thread: " + ex.getMessage());
            }

            // get a QuestionController instance and set the category theme to prepare the questions
            QuestionController questionController = (QuestionController) FlowController.getInstance().getController("QuestionView");
            // set the category theme
            questionController.setCategoryTheme(category);

            // go to the question view (it already has the question theme set)
            FlowController.getInstance().goView("QuestionView");

            // reset the spinner clickability (at this point the user is on the question view)
            hasSpinnerBeenClicked = false;

            // hide the category logo and shadow
            hideCategoryAnimation();
        });
    }

    // this method takes care of showing the player that is currently selecting a pawn
    @FXML
    public void onActionGreenPawnSelected(Event event) {
        System.out.println("Green pawn selected");
    }

    // this method takes care of showing the player that is currently selecting a pawn
    @FXML
    public void onActionOrangePawnSelected(Event event) {
        System.out.println("Orange pawn selected");
    }

    // this method takes care of showing the player that is currently selecting a pawn
    @FXML
    public void onActionPurplePawnSelected(Event event) {
        System.out.println("Purple pawn selected");
    }

    // this method takes care of showing the player that is currently selecting a pawn
    @FXML
    public void onActionRedPawnSelected(Event event) {
        System.out.println("Red pawn selected");
    }
}
