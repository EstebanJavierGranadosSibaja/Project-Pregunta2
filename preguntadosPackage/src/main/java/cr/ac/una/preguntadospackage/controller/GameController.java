package cr.ac.una.preguntadospackage.controller;

import java.net.URL;
import java.util.ResourceBundle;
import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.soundUtils;
import javafx.animation.RotateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import cr.ac.una.preguntadospackage.model.*;

public class GameController extends Controller implements Initializable {

    private int playerCount = 2; // default value as 2 is the minimum amount of players
    private int selectedSectors = 0;
    private int currentSelectingPlayer = 1; // the player that is currently selecting a pawn (1-6)

    @FXML private Label lblPlayerCurrentlySelecting;
    @FXML private AnchorPane apSelectionScreen;

    // for now create the 6 players as DTOs
    PregJugpartidaDto[] players = new PregJugpartidaDto[6];

    @FXML private ImageView
            imgDisabledPinkPawn, imgSector2Pawn2, imgSector2Pawn1, imgSector2Pawn4, imgSector2Pawn3,
            imgPurplePawnSelection, imgSector6Pawn2, imgSector6Pawn1, imgDisabledBluePawn, imgSector6Pawn4,
            imgSector6Pawn3, imgSport, imgBluePawnSelection, imgSector3Pawn4, imgSector3Pawn2, imgSector3Pawn3,
            imgDisabledOrangePawn, imgSector5Pawn1, imgOrangePawnSelection, imgSector5Pawn2, imgSector5Pawn3,
            imgRedPawnSelection, imgCrown, imgDisabledPurplePawn, imgSelectorSector5, imgSelectorSector4,
            imgSelectorSector6, imgSector4Pawn2, imgSelectorSector1, imgGreenPawnSelection, imgSector4Pawn1,
            imgSelectorSector3, imgSelectorSector2, imgPinkPawnSelection, imgSpinner, imgSector5Pawn4,
            imgDisabledGreenPawn, imgSector3Pawn1, imgDisabledRedPawn, imgGeography, imgEntertainment,
            imgSector1Pawn4, imgSector4Pawn4, imgSector4Pawn3, imgArt, imgSector1Pawn1, imgSector1Pawn2,
            imgSector1Pawn3, imgHistory, imgScience;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // for now initialize the players (DEBUG)
        for (int i = 0; i < 6; i++) {
            players[i] = new PregJugpartidaDto();
        }

        CheckIfAllThePawnsHaveBeenSelected();
        hideAllPawns();
        hideNonAvailableInventorySlots();
        hideCategoryAnimation();
        resetPawnVisibility(); // TODO: this should be called when the game starts but overwritten by the player's previous progress saved in the database
    }

    @Override
    public void initialize() {}

    //
    public void setupPlayerCount(int playerCount, int helpAssistanceLevel) {
        // TODO: Implement the logic for setting up the player count and the help assistance level
        this.playerCount = playerCount;
        disableNonAvailablePawns(playerCount);
    }

    private void showCoin(String coinCategory, int inventoryNumber) {
        // based on the coin color, enable it in the player's inventory
        // this could be made by just changing the coin image into the colored one
    }

    private void hideAllPawns() {
        imgSector1Pawn1.setVisible(false);imgSector1Pawn2.setVisible(false);imgSector1Pawn3.setVisible(false);imgSector1Pawn4.setVisible(false);
        imgSector2Pawn1.setVisible(false);imgSector2Pawn2.setVisible(false);imgSector2Pawn3.setVisible(false);imgSector2Pawn4.setVisible(false);
        imgSector3Pawn1.setVisible(false);imgSector3Pawn2.setVisible(false);imgSector3Pawn3.setVisible(false);imgSector3Pawn4.setVisible(false);
        imgSector4Pawn1.setVisible(false);imgSector4Pawn2.setVisible(false);imgSector4Pawn3.setVisible(false);imgSector4Pawn4.setVisible(false);
        imgSector5Pawn1.setVisible(false);imgSector5Pawn2.setVisible(false);imgSector5Pawn3.setVisible(false);imgSector5Pawn4.setVisible(false);
        imgSector6Pawn1.setVisible(false);imgSector6Pawn2.setVisible(false);imgSector6Pawn3.setVisible(false);imgSector6Pawn4.setVisible(false);
    }

    public void calculateNextPawnMovement(int playerNumber) {
        switch ("") {
            case "red":
                break;
            case "purple":

                break;
            case "green":

                break;
            case "orange":

                break;
        }
    }

    private void hideNonAvailableInventorySlots() {
        // TODO: Implement hiding logic for non-available inventory slots
        // this method should make all the coins gray for the non playing players
    }

    // this method hides all the pawns that are not available (just for initial setup)
    public void disableNonAvailablePawns(int playerCount) {
        imgDisabledGreenPawn.setVisible(false);
        imgDisabledOrangePawn.setVisible(false);
        imgDisabledPurplePawn.setVisible(false);
        imgDisabledRedPawn.setVisible(false);
        imgDisabledPinkPawn.setVisible(false);
        imgDisabledBluePawn.setVisible(false);
    }

    private Boolean hasSpinnerBeenClicked = false;
    @FXML
    public void onActionSpinRoulette(MouseEvent event) {
        if (hasSpinnerBeenClicked) return;

        soundUtils.getInstance().playSound("roulleteClick");

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

            soundUtils.getInstance().playSound("question");

            QuestionController questionController = (QuestionController) FlowController.getInstance().getController("QuestionView");
            questionController.setCategoryTheme(category);
            FlowController.getInstance().goView("QuestionView");

            hasSpinnerBeenClicked = false;
            hideCategoryAnimation();
        });
    }

    // this method shows the category animation depending on the category
    // TODO: make it actually animate and not only show the image
    public void playCategoryAnimation(int category) {
        switch (category) {
            case 0:
                imgScience.setVisible(true);
                break;
            case 1:
                imgGeography.setVisible(true);

                break;
            case 2:
                imgCrown.setVisible(true);

                break;
            case 3:
                imgEntertainment.setVisible(true);

                break;
            case 4:
                imgArt.setVisible(true);

                break;
            case 5:
                imgSport.setVisible(true);

                break;
        }
    }

    private void hideCategoryAnimation() {
        imgArt.setVisible(false);
        imgCrown.setVisible(false);
        imgEntertainment.setVisible(false);
        imgGeography.setVisible(false);
        imgHistory.setVisible(false);
        imgScience.setVisible(false);
        imgSport.setVisible(false);
    }

    private Image getPawnImageByColor(String color) {
        switch (color) {
            case "green": return new Image(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnGreen.png").toString());
            case "orange": return new Image(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnOrange.png").toString());
            case "purple": return new Image(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnPurple.png").toString());
            case "red": return new Image(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnRed.png").toString());
            case "pink": return new Image(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnPink.png").toString());
            case "blue": return new Image(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnBlue.png").toString());
            default: return null; // this should never happen (programmer logic be like)
        }
    }

    public String getColorByImageId(String imageId) {
        switch (imageId) {
            case "imgGreenPawnSelection":
                return "green";
            case "imgOrangePawnSelection":
                return "orange";
            case "imgPurplePawnSelection":
                return "purple";
            case "imgRedPawnSelection":
                return "red";
            case "imgPinkPawnSelection":
                return "pink";
            case "imgBluePawnSelection":
                return "blue";
            default:
                return "";
        }
    }

    // this method is called when the player selects a pawn in the selection screen
    private void CheckIfAllThePawnsHaveBeenSelected() {
        if (currentSelectingPlayer - 1 == playerCount) {
            apSelectionScreen.setVisible(false);
            currentSelectingPlayer = 1;
        }
    }

    private void setPawnImages(ImageView[] pawns, Image pawnImage) {
        for (ImageView pawn: pawns) {
            pawn.setImage(pawnImage);
        }
    }

    private void setPawnsWithColorOnSector(int sector, String color) {
        ImageView[] sectorPawns = getPawnsBySector(sector);
        Image pawnImage = getPawnImageByColor(color);

        if (sectorPawns != null && pawnImage != null) {
            setPawnImages(sectorPawns, pawnImage);
        }
    }

    private ImageView[] getPawnsBySector(int sector) {
        switch (sector) {
            case 1:
                return new ImageView[] {
                        imgSector1Pawn1,
                        imgSector1Pawn2,
                        imgSector1Pawn3,
                        imgSector1Pawn4
                };
            case 2:
                return new ImageView[] {
                        imgSector2Pawn1,
                        imgSector2Pawn2,
                        imgSector2Pawn3,
                        imgSector2Pawn4
                };
            case 3:
                return new ImageView[] {
                        imgSector3Pawn1,
                        imgSector3Pawn2,
                        imgSector3Pawn3,
                        imgSector3Pawn4
                };
            case 4:
                return new ImageView[] {
                        imgSector4Pawn1,
                        imgSector4Pawn2,
                        imgSector4Pawn3,
                        imgSector4Pawn4
                };
            case 5:
                return new ImageView[] {
                        imgSector5Pawn1,
                        imgSector5Pawn2,
                        imgSector5Pawn3,
                        imgSector5Pawn4
                };
            case 6:
                return new ImageView[] {
                        imgSector6Pawn1,
                        imgSector6Pawn2,
                        imgSector6Pawn3,
                        imgSector6Pawn4
                };
            default:
                return null;
        }
    }

    private void visuallyInitializePawns() {
        for (int i = 0; i < playerCount; i++) {
            // show the first pawn of the player
            switch (players[i].getPosicionSector()) {
                case 1: {
                    imgSector1Pawn1.setVisible(true);
                    break;
                }
                case 2: {
                    imgSector2Pawn1.setVisible(true);
                    break;
                }
                case 3: {
                    imgSector3Pawn1.setVisible(true);
                    break;
                }
                case 4: {
                    imgSector4Pawn1.setVisible(true);
                    break;
                }
                case 5: {
                    imgSector5Pawn1.setVisible(true);
                    break;
                }
                case 6: {
                    imgSector6Pawn1.setVisible(true);
                    break;
                }
            }
        }
    }

    private void CheckIfAllTheSectorsHaveBeenSelected() {
        if (selectedSectors == playerCount) {
            // hide all the sector selectors
            imgSelectorSector1.setVisible(false);
            imgSelectorSector2.setVisible(false);
            imgSelectorSector3.setVisible(false);
            imgSelectorSector4.setVisible(false);
            imgSelectorSector5.setVisible(false);
            imgSelectorSector6.setVisible(false);

            // cycle through the players and show their assigned sector and color saved
            for (int i = 0; i < playerCount; i++) {
                setPawnsWithColorOnSector(players[i].getPosicionSector(), players[i].getColorPeon());
            }
            visuallyInitializePawns();

            // cycle through the players and show their assigned sector and color saved (DEBUG)
            for (PregJugpartidaDto player: players) {
                System.out.println("Player has been assigned the sector " + player.getPosicionSector() + " and the color " + player.getColorPeon() + "IGNORAR SI ES -1");
            }
        }
    }

    @FXML
    public void onActionGreenPawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        handlePawnSelection(imgGreenPawnSelection);
    }

    @FXML
    public void onActionOrangePawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        handlePawnSelection(imgOrangePawnSelection);
    }

    @FXML
    public void onActionPurplePawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        handlePawnSelection(imgPurplePawnSelection);
    }

    @FXML
    public void onActionRedPawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        handlePawnSelection(imgRedPawnSelection);
    }

    @FXML
    public void onActionPinkPawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        handlePawnSelection(imgPinkPawnSelection);
    }

    @FXML
    public void onActionBluePawnSelected(Event event) {
        soundUtils.getInstance().playSound("click");
        handlePawnSelection(imgBluePawnSelection);
    }

    // this method is called when the player selects a pawn in the selection screen
    private void handlePawnSelection(ImageView pawnSelection) {
        pawnSelection.setVisible(false);

        players[currentSelectingPlayer - 1].setColorPeon(getColorByImageId(pawnSelection.getId()));
        currentSelectingPlayer++;
        lblPlayerCurrentlySelecting.setText("Player " + currentSelectingPlayer);

        CheckIfAllThePawnsHaveBeenSelected(); // checks if all the pawns have been selected, TODO: Rename this method
    }

    private void resetPawnVisibility() {}

    @FXML
    public void onActionSector4(Event event) {
        players[currentSelectingPlayer - 1].setPosicionSector(4);
        imgSelectorSector4.setVisible(false);
        currentSelectingPlayer++;
        selectedSectors++;
        CheckIfAllTheSectorsHaveBeenSelected();
    }

    @FXML
    public void onActionSector3(Event event) {
        players[currentSelectingPlayer - 1].setPosicionSector(3);
        imgSelectorSector3.setVisible(false);
        currentSelectingPlayer++;
        selectedSectors++;
        CheckIfAllTheSectorsHaveBeenSelected();
    }

    @FXML
    public void onActionSector6(Event event) {
        players[currentSelectingPlayer - 1].setPosicionSector(6);
        imgSelectorSector6.setVisible(false);
        currentSelectingPlayer++;
        selectedSectors++;
        CheckIfAllTheSectorsHaveBeenSelected();
    }

    @FXML
    public void onActionSector5(Event event) {
        players[currentSelectingPlayer - 1].setPosicionSector(5);
        imgSelectorSector5.setVisible(false);
        currentSelectingPlayer++;
        selectedSectors++;
        CheckIfAllTheSectorsHaveBeenSelected();
    }

    @FXML
    public void onActionSector2(Event event) {
        players[currentSelectingPlayer - 1].setPosicionSector(2);
        imgSelectorSector2.setVisible(false);
        currentSelectingPlayer++;
        selectedSectors++;
        CheckIfAllTheSectorsHaveBeenSelected();
    }

    @FXML
    public void onActionSector1(Event event) {
        players[currentSelectingPlayer - 1].setPosicionSector(1);
        imgSelectorSector1.setVisible(false);
        currentSelectingPlayer++;
        selectedSectors++;
        CheckIfAllTheSectorsHaveBeenSelected();
    }

    // TODO: Assign a css tag and make the hover effect in the css file instead of here, so that way I dont have to repeat the same code for each sector
    @FXML
    public void onHoverSector2(Event event) {
        imgSelectorSector2.setEffect(new Bloom());
    }

    @FXML
    public void onNotHoverSector2(Event event) {
        imgSelectorSector2.setEffect(null);
    }

}