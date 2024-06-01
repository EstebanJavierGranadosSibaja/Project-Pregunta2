package cr.ac.una.preguntadospackage.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.Flow;

import cr.ac.una.preguntadospackage.util.FlowController;
import cr.ac.una.preguntadospackage.util.animationUtils;
import cr.ac.una.preguntadospackage.util.soundUtils;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import cr.ac.una.preguntadospackage.model.*;

public class GameController extends Controller implements Initializable {

    private int selectedSectors = 0;
    public int currentSelectingPlayer = 1; // the player that is currently selecting a pawn (1-6)
    private Boolean haveAllPlayersSelectedSectors = false;

    @FXML public Label lblPlayerCurrentlySelecting, lblCurrentPlayerTurn;
    @FXML private AnchorPane apSelectionScreen;

    // for now create the 6 players as DTOs
    public PregJugpartidaDto[] players;
    PregPrinpartidaDto partida;

    @FXML private ImageView
            imgDisabledPinkPawn, imgSector2Pawn2, imgSector2Pawn1, imgSector2Pawn4, imgSector2Pawn3, imgPurplePawnSelection, imgSector6Pawn2, imgSector6Pawn1, imgDisabledBluePawn, imgSector6Pawn4, imgSector6Pawn3, imgSport, imgBluePawnSelection, imgSector3Pawn4, imgSector3Pawn2, imgSector3Pawn3, imgDisabledOrangePawn, imgSector5Pawn1, imgOrangePawnSelection, imgSector5Pawn2, imgSector5Pawn3,
            imgRedPawnSelection, imgCrown, imgDisabledPurplePawn, imgSelectorSector5, imgSelectorSector4, imgSelectorSector6, imgSector4Pawn2, imgSelectorSector1, imgGreenPawnSelection, imgSector4Pawn1, imgSelectorSector3, imgSelectorSector2, imgPinkPawnSelection, imgSpinner, imgSector5Pawn4, imgDisabledGreenPawn, imgSector3Pawn1, imgDisabledRedPawn, imgGeography, imgEntertainment,
            imgSector1Pawn4, imgSector4Pawn4, imgSector4Pawn3, imgArt, imgSector1Pawn1, imgSector1Pawn2, imgSector1Pawn3, imgHistory, imgScience, imgSector2ArtBlocker, imgSector1ArtBlocker, imgSector2SciencieBlocker, imgSector1SciencieBlocker, imgSector1GeographyBlocker, imgSector2EntertainmentBlocker, imgSector2SportBlocker, imgSector2HistoryBlocker, imgSector2GeographyBlocker, imgSector1HistoryBlocker, imgSector1EntertainmentBlocker, imgSector5EntertainmentBlocker,
            imgSector3GeographyBlocker, imgSector6GeographyBlocker, imgSector5SciencieBlocker, imgSector4EntertainmentBlocker, imgSector4HistoryBlocker, imgSector6ArtBlocker, imgSector3ArtBlocker, imgSector4GeographyBlocker, imgSector3SciencieBlocker, imgSector3EntertainmentBlocker, imgSector3HistoryBlocker, imgSector4SciencieBlocker, imgSector3SportBlocker, imgSector4ArtBlocker, imgSector6HistoryBlocker, imgSector5GeographyBlocker,
            imgSector6SciencieBlocker, imgSector6EntertainmentBlocker, imgSector4SportBlocker, imgSector5HistoryBlocker, imgSector5ArtBlocker, imgSector5SportBlocker, imgSector6SportBlocker, imgSector1SportBlocker;
    @FXML
    private ImageView imgRainbowCircle;
    @FXML
    private Label lblCurrentPlayerTurn1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @Override
    public void initialize() {}

    public void setUpGameEnviroment(int playerCount, String modoJuego, String modoDuelo, int timeLimitInMinutes) {
        System.out.println("Player count: " + playerCount);
        System.out.println("Game mode: " + modoJuego);
        System.out.println("Duel mode: " + modoDuelo);
        System.out.println("Time limit: " + timeLimitInMinutes);

        hideAllNonSelectedPawnImages(playerCount);

        // initialize the players array
        players = new PregJugpartidaDto[6];
        for (int i = 0; i < 6; i++) {
            players[i] = new PregJugpartidaDto();
        }

        // initialize the partida object
        partida = new PregPrinpartidaDto();

        // convert the give time limit in minutes to a LocalDate object
        //partida.setTiempoTotal(LocalDate.now().plusMinutes(timeLimitInMinutes));

        partida.setNombrePartida("Partida de prueba");
        partida.setModoJuego("Clasico");// TODO: depend on the parameters selected by the user
        partida.setModoDuelo("A");// TODO: depend on the parameters selected by the user A activado I inactivo
        partida.setTiempoTotal(LocalDate.now());// TODO: depends on a clock that starts when the game starts
        partida.setTiempoTranscurrido(LocalDate.now());// TODO: depends on a clock that starts when the game starts
        partida.setCantidadRondas(1L);// TODO: depend on the parameters selected by the user
        partida.setEstadoPartida("A");// TODO: depends on the game state
        partida.setCantidadJugadores((long)playerCount);// TODO: depend on the parameters selected by the user
        partida.setSectorActivo(1L);// TODO: depends on the game state
        partida.setVersion(1L);// TODO: depends on the game state
        partida.setModificado(false);// TODO: depends on the game state
        //partida.setPregJugpartidaList(List.of(players));// TODO: depends on the game state
        //partida.setPregPreguntaspartidaList(List.of());// TODO: depends on the game state


        hideAllPawns();
        hideCategoryAnimation();
    }

    // ROULLETE LOGIC <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private Boolean hasSpinnerBeenClicked = false;
    @FXML
    public void onActionSpinRoulette(MouseEvent event) {

        if (hasSpinnerBeenClicked || !haveAllPlayersSelectedSectors) return;
        hasSpinnerBeenClicked = true;

        soundUtils.getInstance().playSound("roulleteClick");

        double randomDegrees = Math.random() * 360;
        int numberOfCategory = (int) Math.floor(randomDegrees / 51.4);

        imgSpinner.setRotate(27); // reset the spinner to its original position (27 degrees)
        RotateTransition rotateAnimation = new RotateTransition(javafx.util.Duration.seconds(4.5), imgSpinner);
        rotateAnimation.setByAngle(randomDegrees + 3600); // 3600 is the amount of degrees that the spinner will rotate
        rotateAnimation.play();


        // lambda expression to execute the code after the animation has finished
        rotateAnimation.setOnFinished(expression -> {

            try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                System.out.println("Error pausing thread after spinner: " + ex.getMessage());
            }

            // get the question controller instance and set the category theme
            QuestionController questionController = (QuestionController) FlowController.getInstance().getController("QuestionView");
            assert getCategoryNameByNumber(numberOfCategory) != null;
            questionController.setCategoryTheme(getCategoryNameByNumber(numberOfCategory));

            FlowController.getInstance().goView("QuestionView");
            hasSpinnerBeenClicked = false;
        });
    }

    // dda
    public void showCoin(String coinCategory, int inventoryNumber) {
        System.out.println("supuestamente al usuario ya se le asigno la moneda y ya se deberia ver en el tablero " + coinCategory + " " + inventoryNumber);

        switch(coinCategory) {
            case "sciencie": {
                players[currentSelectingPlayer - 1].setFichaCiencias("A");
                switch (inventoryNumber) {
                    case 1: imgSector1SciencieBlocker.setVisible(false); break; case 2: imgSector2SciencieBlocker.setVisible(false); break;
                    case 3: imgSector3SciencieBlocker.setVisible(false); break; case 4: imgSector4SciencieBlocker.setVisible(false); break;
                    case 5: imgSector5SciencieBlocker.setVisible(false); break; case 6: imgSector6SciencieBlocker.setVisible(false); break;
                } break;
            } case "sports": {
                players[currentSelectingPlayer - 1].setFichaDeporte("A");
                switch(inventoryNumber) {
                    case 1: imgSector1SportBlocker.setVisible(false); break; case 2: imgSector2SportBlocker.setVisible(false); break;
                    case 3: imgSector3SportBlocker.setVisible(false); break; case 4: imgSector4SportBlocker.setVisible(false); break;
                    case 5: imgSector5SportBlocker.setVisible(false); break; case 6: imgSector6SportBlocker.setVisible(false); break;
                } break;
            } case "history": {
                players[currentSelectingPlayer - 1].setFichaHistoria("A");
                switch(inventoryNumber) {
                    case 1: imgSector1HistoryBlocker.setVisible(false); break; case 2: imgSector2HistoryBlocker.setVisible(false); break;
                    case 3: imgSector3HistoryBlocker.setVisible(false); break; case 4: imgSector4HistoryBlocker.setVisible(false); break;
                    case 5: imgSector5HistoryBlocker.setVisible(false); break; case 6: imgSector6HistoryBlocker.setVisible(false); break;
                } break;
            } case "art": {
                players[currentSelectingPlayer - 1].setFichaArte("A");
                switch(inventoryNumber) {
                    case 1: imgSector1ArtBlocker.setVisible(false); break; case 2: imgSector2ArtBlocker.setVisible(false); break;
                    case 3: imgSector3ArtBlocker.setVisible(false); break; case 4: imgSector4ArtBlocker.setVisible(false); break;
                    case 5: imgSector5ArtBlocker.setVisible(false); break; case 6: imgSector6ArtBlocker.setVisible(false); break;
                } break;
            } case "entertainment": {
                players[currentSelectingPlayer - 1].setFichaEntretenimiento("A");
                switch(inventoryNumber) {
                    case 1: imgSector1EntertainmentBlocker.setVisible(false); break; case 2: imgSector2EntertainmentBlocker.setVisible(false); break;
                    case 3: imgSector3EntertainmentBlocker.setVisible(false); break; case 4: imgSector4EntertainmentBlocker.setVisible(false); break;
                    case 5: imgSector5EntertainmentBlocker.setVisible(false); break; case 6: imgSector6EntertainmentBlocker.setVisible(false); break;
                } break;
            } case "geography": {
                players[currentSelectingPlayer - 1].setFichaGeografia("A");
                switch(inventoryNumber) {
                    case 1: imgSector1GeographyBlocker.setVisible(false); break; case 2: imgSector2GeographyBlocker.setVisible(false); break;
                    case 3: imgSector3GeographyBlocker.setVisible(false); break; case 4: imgSector4GeographyBlocker.setVisible(false); break;
                    case 5: imgSector5GeographyBlocker.setVisible(false); break; case 6: imgSector6GeographyBlocker.setVisible(false); break;
                } break;
            }
        }
    }

    public void movePawnForward(int sector, int player) {
        ImageView[] sectorPawns = getPawnsBySector(sector);
        if (sectorPawns != null) {
            for (ImageView pawn: sectorPawns) {
                if (pawn.isVisible()) {
                    pawn.setVisible(false);
                    break;
                }
            }
            sectorPawns[player].setVisible(true);
            // TODO: what could happen when the player reaches the last casilla?
            players[currentSelectingPlayer - 1].setPosicionCasilla(players[currentSelectingPlayer - 1].getPosicionCasilla() + 1);
        } else throw new IllegalArgumentException("Invalid sector");
    }

    public void movePawnBackward(int sector, int player) {
        ImageView[] sectorPawns = getPawnsBySector(sector);
        if (sectorPawns != null) {
            for (int i = sectorPawns.length - 1; i >= 0; i--) {
                if (sectorPawns[i].isVisible()) {
                    sectorPawns[i].setVisible(false);
                    break;
                }
            }
            sectorPawns[player].setVisible(true);
            //players[currentSelectingPlayer - 1].setPosicionCasilla(players[currentSelectingPlayer - 1].getPosicionCasilla() - 1);
        } else throw new IllegalArgumentException("Invalid sector");
    }

    // TODO: make it actually animate and not only show the image
    public void playCategoryAnimation(int category) {
        switch (category) {
            case 0: imgScience.setVisible(true); break;
            case 1: imgGeography.setVisible(true); break;
            case 2: imgCrown.setVisible(true); break;
            case 3: imgEntertainment.setVisible(true); break;
            case 4: imgArt.setVisible(true); break;
            case 5: imgSport.setVisible(true); break;
            case 6: imgHistory.setVisible(true); break;
        }
    }

    private Image getPawnImageByColor(String color) {
        switch (color) {
            case "green": return new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnGreen.png")).toString());
            case "orange": return new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnOrange.png")).toString());
            case "purple": return new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnPurple.png")).toString());
            case "red": return new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnRed.png")).toString());
            case "pink": return new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnPink.png")).toString());
            case "blue": return new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnBlue.png")).toString());
            default: throw new IllegalArgumentException("Invalid color");
        }
    }

    public String getColorByImageId(String imageId) {
        switch (imageId) {
            case "imgGreenPawnSelection": return "green";
            case "imgOrangePawnSelection": return "orange";
            case "imgPurplePawnSelection": return "purple";
            case "imgRedPawnSelection": return "red";
            case "imgPinkPawnSelection": return "pink";
            case "imgBluePawnSelection": return "blue";
            default: throw new IllegalArgumentException("Invalid image id");
        }
    }

    // this method is called when the player selects a pawn in the selection screen
    private void CheckIfAllThePawnsHaveBeenSelected() {
        if (currentSelectingPlayer - 1 == partida.getCantidadJugadores().intValue()) {
            apSelectionScreen.setVisible(false);
            currentSelectingPlayer = 1;
            // for debug purposes make all the sectors blink
            for (int i = 1; i <= 6; i++) animationUtils.getInstance().playAnimation("constantBlink", getSectorImageIDbySector(i));

        }
    }

    // this method is called when the player selects a pawn in the selection screen
    private void handlePawnSelection(ImageView selectedPawn) {
        System.out.println(selectedPawn.getId() + " has been selected");
        System.out.println(getColorByImageId(selectedPawn.getId()) + " has been selected");
        players[currentSelectingPlayer - 1].setColorPeon(getColorByImageId(selectedPawn.getId()));

        selectedPawn.setVisible(false);
        currentSelectingPlayer++;
        lblPlayerCurrentlySelecting.setText("Player " + currentSelectingPlayer);
        CheckIfAllThePawnsHaveBeenSelected(); // checks if all the pawns have been selected, TODO: Rename this method
    }

    private void setPawnImages(ImageView[] pawns, Image pawnImage) {
        for (ImageView pawn: pawns) {
            pawn.setImage(pawnImage);
        }
    }

    private void setPawnsBySelectedColor(int sector, String color) {
        ImageView[] sectorPawns = getPawnsBySector(sector);
        Image pawnImage = getPawnImageByColor(color);

        if (sectorPawns != null) setPawnImages(sectorPawns, pawnImage);
        else throw new IllegalArgumentException("Invalid sector");
    }

    private ImageView[] getPawnsBySector(int sector) {
        switch (sector) {
            case 1: return new ImageView[] {
                        imgSector1Pawn1,
                        imgSector1Pawn2,
                        imgSector1Pawn3,
                        imgSector1Pawn4
                };
            case 2: return new ImageView[] {
                        imgSector2Pawn1,
                        imgSector2Pawn2,
                        imgSector2Pawn3,
                        imgSector2Pawn4
                };
            case 3: return new ImageView[] {
                        imgSector3Pawn1,
                        imgSector3Pawn2,
                        imgSector3Pawn3,
                        imgSector3Pawn4
                };
            case 4: return new ImageView[] {
                        imgSector4Pawn1,
                        imgSector4Pawn2,
                        imgSector4Pawn3,
                        imgSector4Pawn4
                };
            case 5: return new ImageView[] {
                        imgSector5Pawn1,
                        imgSector5Pawn2,
                        imgSector5Pawn3,
                        imgSector5Pawn4
                };
            case 6: return new ImageView[] {
                        imgSector6Pawn1,
                        imgSector6Pawn2,
                        imgSector6Pawn3,
                        imgSector6Pawn4
                };
            default: return null; // invalid sector
        }
    }

    // TODO: should depend on the database and the player's previous progress saved or the one just initialized
    private void loadPawnPositions() {
        for (int i = 0; i < partida.getCantidadJugadores().intValue(); i++) {
            // show the first pawn of the player
            switch (players[i].getPosicionSector().intValue()) {
                case 1: imgSector1Pawn1.setVisible(true); break;
                case 2: imgSector2Pawn1.setVisible(true); break;
                case 3: imgSector3Pawn1.setVisible(true); break;
                case 4: imgSector4Pawn1.setVisible(true); break;
                case 5: imgSector5Pawn1.setVisible(true); break;
                case 6: imgSector6Pawn1.setVisible(true); break;
            }
        }
    }

    private void CheckIfAllTheSectorsHaveBeenSelected() {
        if (selectedSectors == partida.getCantidadJugadores().intValue()) {
            haveAllPlayersSelectedSectors = true; // this way we can re-use the sector selection panels for signaling the player's turn
            // hide the sector selection panels
            imgSelectorSector1.setVisible(false);imgSelectorSector2.setVisible(false);imgSelectorSector3.setVisible(false);
            imgSelectorSector4.setVisible(false);imgSelectorSector5.setVisible(false);imgSelectorSector6.setVisible(false);

            loadPawnPositions(); // TODO: this should be called when the game starts but overwritten by the player's previous progress saved in the database

            // cycle through the players and show their assigned sector and color saved (DEBUG)
            for (PregJugpartidaDto player: players) System.out.println("Player has been assigned the sector " + player.getPosicionSector() + " and the color " + player.getColorPeon());

            for (int i = 0; i < partida.getCantidadJugadores().intValue(); i++) {
              players[i].setPosicionCasilla((long)1);
            }

            // reset the selected sectors, TODO: this should be done when the game starts but overwritten by the player's previous progress saved in the database
            currentSelectingPlayer = 1;

            // just to initialize the first player's turn
            lblCurrentPlayerTurn.setText("TURNO DEL JUGADOR: " + currentSelectingPlayer);

            // for debug purposes make the first player's sector blink
            animationUtils.getInstance().playAnimation("blink", getSectorImageIDbySector(players[currentSelectingPlayer - 1].getPosicionSector().intValue()));
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

    @FXML
    public void onActionSector4(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer - 1].setPosicionSector((long)4);
            imgSelectorSector4.setVisible(false);
            currentSelectingPlayer++;
            selectedSectors++;
            CheckIfAllTheSectorsHaveBeenSelected();

        }
    }

    @FXML
    public void onActionSector3(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer - 1].setPosicionSector((long)3);
            imgSelectorSector3.setVisible(false);
            currentSelectingPlayer++;
            selectedSectors++;
            CheckIfAllTheSectorsHaveBeenSelected();

        }
    }

    @FXML
    public void onActionSector6(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer - 1].setPosicionSector((long)6);
            imgSelectorSector6.setVisible(false);
            currentSelectingPlayer++;
            selectedSectors++;
            CheckIfAllTheSectorsHaveBeenSelected();

        }
    }

    @FXML
    public void onActionSector5(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer - 1].setPosicionSector((long)5);
            imgSelectorSector5.setVisible(false);
            currentSelectingPlayer++;
            selectedSectors++;
            CheckIfAllTheSectorsHaveBeenSelected();

        }
    }

    @FXML
    public void onActionSector2(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer - 1].setPosicionSector((long)2);
            imgSelectorSector2.setVisible(false);
            currentSelectingPlayer++;
            selectedSectors++;
            CheckIfAllTheSectorsHaveBeenSelected();

        }
    }

    @FXML
    public void onActionSector1(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer - 1].setPosicionSector((long)1);
            imgSelectorSector1.setVisible(false);
            currentSelectingPlayer++;
            selectedSectors++;
            CheckIfAllTheSectorsHaveBeenSelected();

        }
    }

    private void hideAllPawns() {
        imgSector1Pawn1.setVisible(false);imgSector1Pawn2.setVisible(false);imgSector1Pawn3.setVisible(false);imgSector1Pawn4.setVisible(false);imgSector2Pawn1.setVisible(false);imgSector2Pawn2.setVisible(false);imgSector2Pawn3.setVisible(false);imgSector2Pawn4.setVisible(false);
        imgSector3Pawn1.setVisible(false);imgSector3Pawn2.setVisible(false);imgSector3Pawn3.setVisible(false);imgSector3Pawn4.setVisible(false);imgSector4Pawn1.setVisible(false);imgSector4Pawn2.setVisible(false);imgSector4Pawn3.setVisible(false);imgSector4Pawn4.setVisible(false);
        imgSector5Pawn1.setVisible(false);imgSector5Pawn2.setVisible(false);imgSector5Pawn3.setVisible(false);imgSector5Pawn4.setVisible(false);imgSector6Pawn1.setVisible(false);imgSector6Pawn2.setVisible(false);imgSector6Pawn3.setVisible(false);imgSector6Pawn4.setVisible(false);
    }

    private String getCategoryNameByNumber(int category) {
        switch (category) {
            case 0: return "sciencie"; case 1: return "geography";
            case 2: return "crown"; case 3: return "entertainment";
            case 4: return "art"; case 5: return "sports";
            case 6: return "history"; default: return null;
        }
    }

    // this method hides all the pawns that are not available (just for initial setup)
    public void hideAllNonSelectedPawnImages(int playerCount) {
        imgDisabledGreenPawn.setVisible(false);imgDisabledOrangePawn.setVisible(false);
        imgDisabledPurplePawn.setVisible(false);imgDisabledRedPawn.setVisible(false);
        imgDisabledPinkPawn.setVisible(false);imgDisabledBluePawn.setVisible(false);
    }

    private void hideCategoryAnimation() {
        imgArt.setVisible(false);imgCrown.setVisible(false);imgEntertainment.setVisible(false);imgGeography.setVisible(false);
        imgHistory.setVisible(false);imgScience.setVisible(false);imgSport.setVisible(false);
    }

    public void playerCorrectAnswer(String category){
        movePawnForward(players[currentSelectingPlayer - 1].getPosicionSector().intValue(), players[currentSelectingPlayer - 1].getPosicionCasilla().intValue());
        showCoin(category, players[currentSelectingPlayer - 1].getPosicionSector().intValue());
        players[currentSelectingPlayer - 1].setPosicionCasilla(players[currentSelectingPlayer - 1].getPosicionCasilla() + 1);
    }

    public ImageView getSectorImageIDbySector(int sector){
        switch (sector) {
            case 1: return imgSelectorSector1;
            case 2: return imgSelectorSector2;
            case 3: return imgSelectorSector3;
            case 4: return imgSelectorSector4;
            case 5: return imgSelectorSector5;
            case 6: return imgSelectorSector6;
            default: return null;
        }
    }

    @FXML
    public void onActionExit(ActionEvent actionEvent) {
        // logic of saving to DB goes here
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        FlowController.getInstance().goView("MenuView");

        // completly reset the gamecontroller
        resetGame();

    }

    @FXML
    public void onActionHelp(ActionEvent actionEvent) {
            FlowController.getInstance().goView("HelpView");
    }

    private void resetGame() {
        // Reset game-related variables
        selectedSectors = 0;
        currentSelectingPlayer = 1;
        haveAllPlayersSelectedSectors = false;

        // Reset players array
        players = new PregJugpartidaDto[6];
        for (int i = 0; i < 6; i++) {
            players[i] = new PregJugpartidaDto();
        }

        // show all the coin blockers again
        imgSector1SciencieBlocker.setVisible(true);imgSector2SciencieBlocker.setVisible(true);imgSector3SciencieBlocker.setVisible(true);imgSector4SciencieBlocker.setVisible(true);imgSector5SciencieBlocker.setVisible(true);imgSector6SciencieBlocker.setVisible(true);
        imgSector1SportBlocker.setVisible(true);imgSector2SportBlocker.setVisible(true);imgSector3SportBlocker.setVisible(true);imgSector4SportBlocker.setVisible(true);imgSector5SportBlocker.setVisible(true);imgSector6SportBlocker.setVisible(true);
        imgSector1HistoryBlocker.setVisible(true);imgSector2HistoryBlocker.setVisible(true);imgSector3HistoryBlocker.setVisible(true);imgSector4HistoryBlocker.setVisible(true);imgSector5HistoryBlocker.setVisible(true);imgSector6HistoryBlocker.setVisible(true);
        imgSector1ArtBlocker.setVisible(true);imgSector2ArtBlocker.setVisible(true);imgSector3ArtBlocker.setVisible(true);imgSector4ArtBlocker.setVisible(true);imgSector5ArtBlocker.setVisible(true);imgSector6ArtBlocker.setVisible(true);
        imgSector1EntertainmentBlocker.setVisible(true);imgSector2EntertainmentBlocker.setVisible(true);imgSector3EntertainmentBlocker.setVisible(true);imgSector4EntertainmentBlocker.setVisible(true);imgSector5EntertainmentBlocker.setVisible(true);imgSector6EntertainmentBlocker.setVisible(true);
        imgSector1GeographyBlocker.setVisible(true);imgSector2GeographyBlocker.setVisible(true);imgSector3GeographyBlocker.setVisible(true);imgSector4GeographyBlocker.setVisible(true);imgSector5GeographyBlocker.setVisible(true);imgSector6GeographyBlocker.setVisible(true);

        // Reset pawn images
        hideAllPawns();
        hideAllNonSelectedPawnImages(partida.getCantidadJugadores().intValue());

        // Reset partida object
        partida = new PregPrinpartidaDto();

        // Reset UI elements
        apSelectionScreen.setVisible(true);
        lblPlayerCurrentlySelecting.setText("Player 1");
        lblCurrentPlayerTurn.setText("");



        // Reset category animation
        hideCategoryAnimation();
    }

    // this metod should be developed later
    public void loadGameData(PregPrinpartidaDto partida, PregJugpartidaDto[] players) {
        // load the game data from the database
    }
}