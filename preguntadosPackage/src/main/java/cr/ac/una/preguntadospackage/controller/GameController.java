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

public class GameController extends Controller implements Initializable {

    private Boolean hasSpinnerBeenClicked = false;
    private ArrayList<Integer> activePlayersList = new ArrayList<>();
    private int playerCount = 2;
    private int selectedPawns = 0;
    private int currentSelectingPlayer = 1;
    public int currentPlayer = 1; // TODO: the selected player should be random

    @FXML private ImageView
            // Category Images
            imgSportShadow, imgHistory, imgScience, imgArtShadow, imgEntertainment, imgScienceShadow,
            imgCrownShadow, imgEntertainmentShadow, imgHistoryShadow, imgGeographyShadow, imgArt, imgSport,
            imgGeography, imgCrown,

            // Pawn Slot Images
            imgPawnRedSlot1, imgPawnRedSlot2, imgPawnRedSlot3, imgPawnRedSlot4,
            imgPawnPurpleSlot1, imgPawnPurpleSlot2, imgPawnPurpleSlot3, imgPawnPurpleSlot4,
            imgPawnOrangeSlot1, imgPawnOrangeSlot2, imgPawnOrangeSlot3, imgPawnOrangeSlot4,
            imgPawnGreenSlot1, imgPawnGreenSlot2, imgPawnGreenSlot3, imgPawnGreenSlot4,
            imgPawnBlueSlot1, imgPawnBlueSlot2, imgPawnBlueSlot3, imgPawnBlueSlot4,
            imgPawnPinkSlot1, imgPawnPinkSlot2, imgPawnPinkSlot3, imgPawnPinkSlot4,

            // Pawn Selection Images
            imgGreenPawnSelection, imgOrangePawnSelection, imgPurplePawnSelection, imgRedPawnSelection,
            imgBluePawnSelection, imgPinkPawnSelection,

            // Disabled Pawn Images
            imgDisabledGreenPawn, imgDisabledOrangePawn, imgDisabledPurplePawn, imgDisabledRedPawn,
            imgDisabledBluePawn, imgDisabledPinkPawn,

            // Other Elements
            imgSpinner;

    @FXML private Label lblPlayerCurrentlySelecting;
    @FXML private AnchorPane apSelectionScreen;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pawnHasBeenSelected();
        hideNonAvailableInventorySlots();
        hideCategoryAnimation();
        resetPawnVisibility();
    }

    @Override
    public void initialize() {}

    public void setupPlayerCount(int playerCount, int helpAssistanceLevel) {
        this.playerCount = playerCount;
        disableNonAvailablePawns(playerCount);
    }

    public void calculateNextPawnMovement(int playerNumber) {
        String pawnColorOfTheUser = "orange"; // This should be based on the selected one (TODO)
        int pawnPositionOfTheUser = 1; // Assume the pawn position was retrieved from the user (TODO)

        switch (pawnColorOfTheUser) {
            case "red":
                movePawn(imgPawnRedSlot1, imgPawnRedSlot2, imgPawnRedSlot3, imgPawnRedSlot4, pawnPositionOfTheUser);
                break;
            case "purple":
                movePawn(imgPawnPurpleSlot1, imgPawnPurpleSlot2, imgPawnPurpleSlot3, imgPawnPurpleSlot4, pawnPositionOfTheUser);
                break;
            case "green":
                movePawn(imgPawnGreenSlot1, imgPawnGreenSlot2, imgPawnGreenSlot3, imgPawnGreenSlot4, pawnPositionOfTheUser);
                break;
            case "orange":
                movePawn(imgPawnOrangeSlot1, imgPawnOrangeSlot2, imgPawnOrangeSlot3, imgPawnOrangeSlot4, pawnPositionOfTheUser);
                break;
        }
    }

    private void movePawn(ImageView slot1, ImageView slot2, ImageView slot3, ImageView slot4, int position) {
        // + 1 because the idea is to show the next slot (1-based index) and make the previous one invisible, making the illusion of movement
        slot1.setVisible(position + 1 == 1); // This is always false because the position always starts at 1, so 1 + 1 is always 2 and so on
        slot2.setVisible(position + 1 == 2);
        slot3.setVisible(position + 1 == 3);
        slot4.setVisible(position + 1 == 4);
    }

    public void addCorrespondingCoinToPlayer(String category, int inventoryNumber) {
        // TODO: hide the gray coin from the inventory and  show the colored coin in the player's inventory depending on the category
    }

    private void hideNonAvailableInventorySlots() {
        // TODO: Implement hiding logic for non-available inventory slots
        // this method should make all the coins gray for the non playing players
    }

    // this method hides all the pawns that are not available(just for initial setup)
    public void disableNonAvailablePawns(int playerCount) {
        imgDisabledGreenPawn.setVisible(false);
        imgDisabledOrangePawn.setVisible(false);
        imgDisabledPurplePawn.setVisible(false);
        imgDisabledRedPawn.setVisible(false);
        imgDisabledPinkPawn.setVisible(false);
        imgDisabledBluePawn.setVisible(false);
    }

    // this method shows the category animation depending on the category
    // TODO: make it actually animate and not only show the image
    public void playCategoryAnimation(int category) {
        switch (category) {
            case 0: imgScience.setVisible(true); imgScienceShadow.setVisible(true); break;
            case 1: imgGeography.setVisible(true); imgGeographyShadow.setVisible(true); break;
            case 2: imgCrown.setVisible(true); imgCrownShadow.setVisible(true); break;
            case 3: imgEntertainment.setVisible(true); imgEntertainmentShadow.setVisible(true); break;
            case 4: imgArt.setVisible(true); imgArtShadow.setVisible(true); break;
            case 5: imgSport.setVisible(true); imgSportShadow.setVisible(true); break;
        }
    }

    private void hideCategoryAnimation() {
        imgArt.setVisible(false); imgArtShadow.setVisible(false); imgCrown.setVisible(false); imgCrownShadow.setVisible(false);
        imgEntertainment.setVisible(false); imgEntertainmentShadow.setVisible(false); imgGeography.setVisible(false); imgGeographyShadow.setVisible(false);
        imgHistory.setVisible(false); imgHistoryShadow.setVisible(false); imgScience.setVisible(false); imgScienceShadow.setVisible(false);
        imgSport.setVisible(false); imgSportShadow.setVisible(false);
    }

    @FXML
    public void onActionSpinner(MouseEvent event) {
        if (hasSpinnerBeenClicked) return;

        hasSpinnerBeenClicked = true;

        imgSpinner.setRotate(27);
        double randomDegrees = Math.random() * 360;
        int category = (int) Math.floor(randomDegrees / 51.4);

        RotateTransition rt = new RotateTransition(javafx.util.Duration.seconds(4.5), imgSpinner);
        rt.setByAngle(randomDegrees + 3600);
        rt.play();

        playCategoryAnimation(category);

        rt.setOnFinished(e -> {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                System.out.println("Error pausing thread: " + ex.getMessage());
            }

            QuestionController questionController = (QuestionController) FlowController.getInstance().getController("QuestionView");
            questionController.setCategoryTheme(category);
            FlowController.getInstance().goView("QuestionView");

            hasSpinnerBeenClicked = false;
            hideCategoryAnimation();
        });
    }

    private void pawnHasBeenSelected() {
        if (selectedPawns == playerCount) {
            apSelectionScreen.setVisible(false);
        }
        lblPlayerCurrentlySelecting.setText("CURRENT SELECTING PLAYER: " + currentSelectingPlayer);
    }

    @FXML
    public void onActionGreenPawnSelected(Event event) {
        handlePawnSelection(imgGreenPawnSelection, imgDisabledGreenPawn);
    }

    @FXML
    public void onActionOrangePawnSelected(Event event) {
        handlePawnSelection(imgOrangePawnSelection, imgDisabledOrangePawn);
    }

    @FXML
    public void onActionPurplePawnSelected(Event event) {
        handlePawnSelection(imgPurplePawnSelection, imgDisabledPurplePawn);
    }

    @FXML
    public void onActionRedPawnSelected(Event event) {
        handlePawnSelection(imgRedPawnSelection, imgDisabledRedPawn);
    }

    @FXML
    public void onActionPinkPawnSelected(Event event) {
        handlePawnSelection(imgPinkPawnSelection, imgDisabledPinkPawn);
    }

    @FXML
    public void onActionBluePawnSelected(Event event) {
        handlePawnSelection(imgBluePawnSelection, imgDisabledBluePawn);
    }

    private void handlePawnSelection(ImageView pawnSelection, ImageView disabledPawn) {
        selectedPawns++;
        currentSelectingPlayer++;
        pawnHasBeenSelected();
        pawnSelection.setVisible(false);
        disabledPawn.setVisible(true);
    }

    private void resetPawnVisibility() {
        imgPawnGreenSlot1.setVisible(true); imgPawnOrangeSlot1.setVisible(true); imgPawnPurpleSlot1.setVisible(true); imgPawnRedSlot1.setVisible(true);
        imgPawnGreenSlot2.setVisible(false); imgPawnOrangeSlot2.setVisible(false); imgPawnPurpleSlot2.setVisible(false); imgPawnRedSlot2.setVisible(false);
        imgPawnGreenSlot3.setVisible(false); imgPawnOrangeSlot3.setVisible(false); imgPawnPurpleSlot3.setVisible(false); imgPawnRedSlot3.setVisible(false);
        imgPawnGreenSlot4.setVisible(false); imgPawnOrangeSlot4.setVisible(false); imgPawnPurpleSlot4.setVisible(false); imgPawnRedSlot4.setVisible(false);
        imgPawnBlueSlot1.setVisible(true); imgPawnBlueSlot2.setVisible(false); imgPawnBlueSlot3.setVisible(false); imgPawnBlueSlot4.setVisible(false);
        imgPawnPinkSlot1.setVisible(true); imgPawnPinkSlot2.setVisible(false); imgPawnPinkSlot3.setVisible(false); imgPawnPinkSlot4.setVisible(false);
    }
}
