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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

    /*

    TODO:

        The game currently only support less than 4 players due to the lack of assets

        The selector screen should be checked in the situation of loading the game from the DB.

        General functionality bugcheck.


     */








public class GameController extends Controller implements Initializable {

    Boolean hasSpinnerBeenClicked = false;
    ArrayList<Integer> activePlayersList = new ArrayList<>();

    @FXML private ImageView imgSportShadow, imgHistory, imgScience, imgArtShadow, imgEntertainment, imgScienceShadow, imgCrownShadow, imgEntertainmentShadow, imgHistoryShadow, imgGeographyShadow, imgArt, imgSport, imgGeography, imgCrown, imgPawnRedSlot4, imgPawnRedSlot2, imgPawnRedSlot3, imgPawnRedSlot1, imgPawnPurpleSlot2, imgPawnPurpleSlot1, imgPawnOrangeSlot4, imgPawnPurpleSlot4, imgPawnOrangeSlot3, imgPawnPurpleSlot3, imgPawnOrangeSlot2, imgPawnOrangeSlot1, imgPawnGreenSlot1, imgPawnGreenSlot3, imgPawnGreenSlot2, imgPawnGreenSlot4, imgSpinner, imgGreenPawnSelection, imgPurplePawnSelection, imgDisabledGreenPawn, imgDisabledRedPawn, imgDisabledOrangePawn, imgOrangePawnSelection, imgRedPawnSelection, imgDisabledPurplePawn;
    @FXML private Label lblPlayerCurrentlySelecting;
    @FXML private AnchorPane apSelectionScreen;

    int playercount = 2;
    int selectedPawns = 0;

    int currentSelectingPlayer = 1;

    // TODO: the selected player should be random
    int currentPlayer = 1;
    @FXML
    private ImageView imgPawnBlueSlot3;
    @FXML
    private ImageView imgPawnBlueSlot4;
    @FXML
    private ImageView imgPawnBlueSlot1;
    @FXML
    private ImageView imgPawnBlueSlot2;
    @FXML
    private ImageView imgPawnPinkSlot1;
    @FXML
    private ImageView imgPawnPinkSlot2;
    @FXML
    private ImageView imgPawnPinkSlot3;
    @FXML
    private ImageView imgPawnPinkSlot4;
    @FXML
    private ImageView imgDisabledPinkPawn;
    @FXML
    private ImageView imgBluePawnSelection;
    @FXML
    private ImageView imgPinkPawnSelection;
    @FXML
    private ImageView imgDisabledBluePawn;

    // this method takes care of setting up the player count and the help assistance level
    // TODO: implement the help assistance level and initialize the inventory slots
    public void setupPlayerCount(int playerCount, int helpAssistanceLevel) {
        this.playercount = playerCount;

        // disale the non avaible pawns (they will and can show up in the future, its just a method to disable them for now)
        disableNonAvaiblePawns(playerCount);

        // TODO: for now just disable the Anchor Pane that shows the player selection screen
        //apSelectionScreen.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // call the pawnHasBeenSelected method to fix the load from DB selecting screen skip
        pawnHasBeenSelected();

        // hide the non avaible inventory slots (the ones avaible will show up in the setupPlayerCount method)
        hideNonAvaibleInventorySlots();
        // hide the category animations and its shadows
        hideCategoryAnimation();
        // for now hide all the pawns and just show the number 1 of each color
        imgPawnGreenSlot1.setVisible(true); imgPawnOrangeSlot1.setVisible(true); imgPawnPurpleSlot1.setVisible(true); imgPawnRedSlot1.setVisible(true);
        imgPawnGreenSlot2.setVisible(false); imgPawnOrangeSlot2.setVisible(false); imgPawnPurpleSlot2.setVisible(false); imgPawnRedSlot2.setVisible(false);
        imgPawnGreenSlot3.setVisible(false); imgPawnOrangeSlot3.setVisible(false); imgPawnPurpleSlot3.setVisible(false); imgPawnRedSlot3.setVisible(false);
        imgPawnGreenSlot4.setVisible(false); imgPawnOrangeSlot4.setVisible(false); imgPawnPurpleSlot4.setVisible(false); imgPawnRedSlot4.setVisible(false);
        imgPawnBlueSlot1.setVisible(true); imgPawnBlueSlot2.setVisible(false); imgPawnBlueSlot3.setVisible(false); imgPawnBlueSlot4.setVisible(false);
        imgPawnPinkSlot1.setVisible(true); imgPawnPinkSlot2.setVisible(false); imgPawnPinkSlot3.setVisible(false); imgPawnPinkSlot4.setVisible(false);



    }

    @Override
    public void initialize() {
    }

    public void calculateNextPawnMovement(int playerNumber){

        // TODO: get the user pawn color to analize its current position
        // asume its already stored in the next variable:
        String pawnColorOfTheUser = "orange"; // the color should be based on the selected one
        int pawnPositionOfTheUser = 1; // asume the pawn position was getted from the user
        System.out.println("we are here");
        switch (pawnColorOfTheUser){
            case "red": {
                System.out.println("ENTERED red");
                // the pawn show be "moved" here
                if(pawnPositionOfTheUser == 1){
                    System.out.println("ENTERED RED POSITION 1");
                    imgPawnRedSlot1.setVisible(false);
                    imgPawnRedSlot2.setVisible(true);
                    imgPawnRedSlot3.setVisible(false);
                    imgPawnRedSlot4.setVisible(false);
                }
                else if(pawnPositionOfTheUser == 2){
                    imgPawnRedSlot1.setVisible(false);
                    imgPawnRedSlot2.setVisible(false);
                    imgPawnRedSlot3.setVisible(true);
                    imgPawnRedSlot4.setVisible(false);
                }
                else if(pawnPositionOfTheUser == 3){
                    imgPawnRedSlot1.setVisible(false);
                    imgPawnRedSlot2.setVisible(false);
                    imgPawnRedSlot3.setVisible(false);
                    imgPawnRedSlot4.setVisible(true);
                } else {
                    // by this point the user is completly dead or is going to win
                    // TODO: calculate the thing when the user lands on the fourth point
                }
                break;
            }
            case "purple": {
                // the pawn show be "moved" here
                if(pawnPositionOfTheUser == 1){
                    imgPawnPurpleSlot1.setVisible(false);
                    imgPawnPurpleSlot2.setVisible(true);
                    imgPawnPurpleSlot3.setVisible(false);
                    imgPawnPurpleSlot4.setVisible(false);
                }
                else if(pawnPositionOfTheUser == 2){
                    imgPawnPurpleSlot1.setVisible(false);
                    imgPawnPurpleSlot2.setVisible(false);
                    imgPawnPurpleSlot3.setVisible(true);
                    imgPawnPurpleSlot4.setVisible(false);
                }
                else if(pawnPositionOfTheUser == 3){
                    imgPawnPurpleSlot1.setVisible(false);
                    imgPawnPurpleSlot2.setVisible(false);
                    imgPawnPurpleSlot3.setVisible(false);
                    imgPawnPurpleSlot4.setVisible(true);
                } else {
                    // by this point the user is completly dead or is going to win
                    // TODO: calculate the thing when the user lands on the fourth point
                }
                break;
            }
            case "green": {
                // the pawn show be "moved" here
                if(pawnPositionOfTheUser == 1){
                    imgPawnGreenSlot1.setVisible(false);
                    imgPawnGreenSlot2.setVisible(true);
                    imgPawnGreenSlot3.setVisible(false);
                    imgPawnGreenSlot4.setVisible(false);
                }
                else if(pawnPositionOfTheUser == 2){
                    imgPawnGreenSlot1.setVisible(false);
                    imgPawnGreenSlot2.setVisible(false);
                    imgPawnGreenSlot3.setVisible(true);
                    imgPawnGreenSlot4.setVisible(false);
                }
                else if(pawnPositionOfTheUser == 3){
                    imgPawnGreenSlot1.setVisible(false);
                    imgPawnGreenSlot2.setVisible(false);
                    imgPawnGreenSlot3.setVisible(false);
                    imgPawnGreenSlot4.setVisible(true);
                } else {
                    // by this point the user is completly dead or is going to win
                    // TODO: calculate the thing when the user lands on the fourth point
                }
                break;
            }
            case "orange": {
                // the pawn show be "moved" here
                if(pawnPositionOfTheUser == 1){
                    imgPawnOrangeSlot1.setVisible(false);
                    imgPawnOrangeSlot2.setVisible(true);
                    imgPawnOrangeSlot3.setVisible(false);
                    imgPawnOrangeSlot4.setVisible(false);
                }
                else if(pawnPositionOfTheUser == 2){
                    imgPawnOrangeSlot1.setVisible(false);
                    imgPawnOrangeSlot2.setVisible(false);
                    imgPawnOrangeSlot3.setVisible(true);
                    imgPawnOrangeSlot4.setVisible(false);
                }
                else if(pawnPositionOfTheUser == 3){
                    imgPawnOrangeSlot1.setVisible(false);
                    imgPawnOrangeSlot2.setVisible(false);
                    imgPawnOrangeSlot3.setVisible(false);
                    imgPawnOrangeSlot4.setVisible(true);
                } else {
                    // by this point the user is completly dead or is going to win
                    // TODO: calculate the thing when the user lands on the fourth point
                }
            }

        }


    }

    private Image createImageWithCorrespondingCategory(String category){
        // TODO: create the image based on its category by getting it from the resources
        switch (category){
            case "arte": {

                break;
            }
            case "historia": {

                break;
            }
            case "deporte": {

                break;
            }
            case "geografia": {

                break;
            }
        }
        return null;
    }

    public void addCorrepondingCoinToPlayer(String category, int inventoryNumber){
        // get the inventory number of the user here
        // its this way because of the relay system we use to give the adaptive ilution to the user
        switch(category){
            case "arte": {
                if(inventoryNumber == 1){
                    // create the image here and save it into the corresponding inventory
                    Image coin = createImageWithCorrespondingCategory("arte");
                }
                else if(inventoryNumber == 2){

                }
                else if(inventoryNumber == 3){

                }
                else if(inventoryNumber == 4){

                }
                else if(inventoryNumber == 5){

                }
                else if(inventoryNumber == 6) {

                }
            }
            case "historia": {

                break;
            }
            case "deporte": {

                break;
            }
            case "geografia": {

                break;
            }




        }
    }

    private void hideNonAvaibleInventorySlots() {
    }

    // this method takes care of disabling the pawns that are not avaible (this disables the dark pawns the represent the disabled or already selected pawns)
    public void disableNonAvaiblePawns(int playerCount) {
        imgDisabledGreenPawn.setVisible(false);
        imgDisabledOrangePawn.setVisible(false);
        imgDisabledPurplePawn.setVisible(false);
        imgDisabledRedPawn.setVisible(false);
        imgDisabledPinkPawn.setVisible(false);
        imgDisabledBluePawn.setVisible(false);
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

    private void pawnHasBeenSelected(){
        // if the selected pawns are equal to the player count then hide the anchor pane selector screen
        if(selectedPawns == playercount){
            apSelectionScreen.setVisible(false);
        }

        // to improve the UI make the current player number be shown on the label
        lblPlayerCurrentlySelecting.setText("CURRENT SELECTING PLAYER:" + currentSelectingPlayer);
    }

    // this method takes care of showing the player that is currently selecting a pawn
    @FXML
    public void onActionGreenPawnSelected(Event event) {
        System.out.println("Green pawn selected");
        // asign the correponding pawn to the user here
        // TODO: assign the pawn to the user object

        // increase the selected pawns amount
        selectedPawns++;

        // increase the count of the current selecting player
        currentSelectingPlayer++;

        // check if we are finished
        pawnHasBeenSelected();

        // disable the green selector pawn and enable the non-avaible black pawn to show it as disabled
        imgGreenPawnSelection.setVisible(false);
        imgDisabledGreenPawn.setVisible(true);
    }

    // this method takes care of showing the player that is currently selecting a pawn
    @FXML
    public void onActionOrangePawnSelected(Event event) {
        System.out.println("Orange pawn selected");

        // asign the correponding pawn to the user here
        // TODO: assign the pawn to the user object

        // increase the selected pawns amount
        selectedPawns++;

        // increase the count of the current selecting player
        currentSelectingPlayer++;

        // check if we are finished
        pawnHasBeenSelected();


        // disable the orange selector pawn and enable the non-avaible black pawn to show it as disabled
        imgOrangePawnSelection.setVisible(false);
        imgDisabledOrangePawn.setVisible(true);
    }

    // this method takes care of showing the player that is currently selecting a pawn
    @FXML
    public void onActionPurplePawnSelected(Event event) {
        System.out.println("Purple pawn selected");

        // asign the correponding pawn to the user here
        // TODO: assign the pawn to the user object

        // increase the selected pawns amount
        selectedPawns++;

        // increase the count of the current selecting player
        currentSelectingPlayer++;

        // check if we are finished
        pawnHasBeenSelected();

        // disable the green selector pawn and enable the non-avaible black pawn to show it as disabled
        imgPurplePawnSelection.setVisible(false);
        imgDisabledPurplePawn.setVisible(true);
    }

    // this method takes care of showing the player that is currently selecting a pawn
    @FXML
    public void onActionRedPawnSelected(Event event) {
        System.out.println("Red pawn selected");

        // asign the correponding pawn to the user here
        // TODO: assign the pawn to the user object

        // increase the selected pawns amount
        selectedPawns++;

        // increase the count of the current selecting player
        currentSelectingPlayer++;

        // check if we are finished
        pawnHasBeenSelected();

        // disable the green selector pawn and enable the non-avaible black pawn to show it as disabled
        imgRedPawnSelection.setVisible(false);
        imgDisabledRedPawn.setVisible(true);
    }

    @FXML
    public void onActionPinkPawnSelected(Event event) {
        System.out.println("Pink pawn selected");

        // asign the correponding pawn to the user here

        // increase the selected pawns amount
        selectedPawns++;

        // increase the count of the current selecting player
        currentSelectingPlayer++;

        // check if we are finished
        pawnHasBeenSelected();

        // disable the pink selector pawn and enable the non-avaible black pawn to show it as disabled
        imgPinkPawnSelection.setVisible(false);
        imgDisabledPinkPawn.setVisible(true);
    }

    @FXML
    public void onActionBluePawnSelected(Event event) {
        System.out.println("Blue pawn selected");

        // asign the correponding pawn to the user here

        // increase the selected pawns amount
        selectedPawns++;

        // increase the count of the current selecting player
        currentSelectingPlayer++;

        // check if we are finished
        pawnHasBeenSelected();

        // disable the blue selector pawn and enable the non-avaible black pawn to show it as disabled
        imgBluePawnSelection.setVisible(false);
        imgDisabledBluePawn.setVisible(true);
    }
}
