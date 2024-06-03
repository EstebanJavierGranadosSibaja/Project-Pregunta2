package cr.ac.una.preguntadospackage.controller;

import cr.ac.una.preguntadospackage.model.PregJugpartidaDto;
import cr.ac.una.preguntadospackage.model.PregPrinpartidaDto;
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
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

/*
    * Main game controller class
 */

public class GameController extends Controller implements Initializable {

    private int selectedSectors = 0;
    int currentSelectingPlayer = 0;
    private Boolean haveAllPlayersSelectedSectors = false, hasFirstTurnBeenAssigned = false;
    private Boolean hasSpinnerBeenClicked = false;

    @FXML
    public Label lblCurrentPlayerTurn, lblCurrentPlayerTurn1;

    @FXML
    private ImageView imgSector2Pawn2, imgSector2Pawn1, imgSector2Pawn4, imgSector2Pawn3, imgSector5EntertainmentBlocker, imgHistory,
            imgSector2ArtBlocker, imgSector3GeographyBlocker, imgSector6GeographyBlocker, imgSector5SciencieBlocker, imgSector6Pawn2,
            imgSector4EntertainmentBlocker, imgSector6Pawn1, imgSector6Pawn4, imgSector6Pawn3, imgSector4HistoryBlocker, imgSport,
            imgSector1ArtBlocker, imgSector6ArtBlocker, imgSector3Pawn4, imgSector2SciencieBlocker, imgSector3Pawn2, imgSector3Pawn3,
            imgSector3ArtBlocker, imgSector1SciencieBlocker, imgSector5Pawn1, imgSector5Pawn2, imgSector5Pawn3, imgSector4GeographyBlocker,
            imgSector3SciencieBlocker, imgSector3EntertainmentBlocker, imgSector1GeographyBlocker, imgCrown, imgSector3HistoryBlocker,
            imgSelectorSector5, imgSelectorSector4, imgSelectorSector6, imgSector4Pawn2, imgSelectorSector1, imgSector4Pawn1, imgScience,
            imgSelectorSector3, imgSector4SciencieBlocker, imgSelectorSector2, imgSpinner, imgSector3SportBlocker, imgSector2EntertainmentBlocker,
            imgSector5Pawn4, imgSector4ArtBlocker, imgSector6HistoryBlocker, imgSector2SportBlocker, imgSector1SportBlocker, imgSector3Pawn1,
            imgSector2HistoryBlocker, imgGeography, imgSector1EntertainmentBlocker, imgSector2GeographyBlocker, imgSector5GeographyBlocker,
            imgSector6SciencieBlocker, imgSector6EntertainmentBlocker, imgEntertainment, imgSector4SportBlocker, imgSector5HistoryBlocker,
            imgSector1HistoryBlocker, imgSector5ArtBlocker, imgSector5SportBlocker, imgSector1Pawn4, imgSector4Pawn4, imgSector4Pawn3,
            imgSector6SportBlocker, imgArt, imgSector1Pawn1, imgSector1Pawn2, imgSector1Pawn3, imgRainbowCircle;

    public PregJugpartidaDto[] players;
    PregPrinpartidaDto partida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @Override
    public void initialize() {}

    public void setUpGameEnviroment(int playerCount, String[] playerColors, String[] playerIDs, String modoJuego, String modoDuelo, int timeLimitInMinutes) {
        // initialize the players array
        players = new PregJugpartidaDto[playerCount];
        for (int i = 0; i < playerCount; i++) players[i] = new PregJugpartidaDto();

        // cycle through the players and assign the colors and IDs to each PregJugpartidaDto
        for (int i = 0; i < playerCount; i++) {
            players[i].setColorPeon(playerColors[i]);
            players[i].setNombreJugador(playerIDs[i]);
        }

        // DEBUG
        System.out.println("Player count: " + playerCount);
        System.out.println("Game mode: " + modoJuego);
        System.out.println("Duel mode: " + modoDuelo);
        System.out.println("Time limit: " + timeLimitInMinutes);

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


    @FXML
    public void onActionSpinRoulette(MouseEvent event) {
        // if the spinner has already been clicked or not all players have selected their sectors, return
        if (hasSpinnerBeenClicked || !haveAllPlayersSelectedSectors) return;
        hasSpinnerBeenClicked = true;

        imgSpinner.setRotate(27); // reset the spinner to its original position (27 degrees)
        soundUtils.getInstance().playSound("roulleteClick");

        double randomDegrees = Math.random() * 360;
        int numberOfCategory = (int) Math.floor(randomDegrees / 51.4);

        RotateTransition rotateAnimation = new RotateTransition(javafx.util.Duration.seconds(4.5), imgSpinner);
        rotateAnimation.setByAngle(randomDegrees + 3600); // 3600 is the amount of degrees that the spinner will rotate
        rotateAnimation.play();

        rotateAnimation.setOnFinished(_event -> {
            // pause the thread for half a second to show the spinner result
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ex) {
                System.out.println("Error pausing thread after spinner: " + ex.getMessage());
            }

            // as the spinner has multiple uses, we need to check if the first turn has been assigned to a player
            // to then show the category crown selection view or the question view
            if(!hasFirstTurnBeenAssigned){
                if(numberOfCategory == 2) hasFirstTurnBeenAssigned = true;
                else {
                    currentSelectingPlayer++;
                    // to avoid an index out of bounds exception
                    if(currentSelectingPlayer == players.length) currentSelectingPlayer = 0;
                }
                // reset the spinner click functionality
                hasSpinnerBeenClicked = false;
                // show the current player's turn (even works if he won the first turn)
                animationUtils.getInstance().playAnimation("blink", getSectorImageIDbySector(players[currentSelectingPlayer].getPosicionSector().intValue()), 0, 0, 0, 0);
            } else {
                if(numberOfCategory == 2){
                    FlowController.getInstance().goView("PlayerCategoryCrownSelectionView");
                    hasSpinnerBeenClicked = false;
                } else {
                    // get the question controller instance and set the category theme
                    QuestionController questionController = (QuestionController) FlowController.getInstance().getController("QuestionView");
                    questionController.setCategoryTheme(Objects.requireNonNull(getCategoryNameByNumber(numberOfCategory)));
                    FlowController.getInstance().goView("QuestionView");
                    hasSpinnerBeenClicked = false;
                    rotateAnimation.stop(); // stop the animation (bugfix try)
                }
            }
        }); // end of rotateAnimation.setOnFinished
    }

    public void showCoin(String coinCategory, int inventoryNumber) {
        switch(coinCategory) {
            case "sciencie": {
                players[currentSelectingPlayer].setFichaCiencias("A");
                switch (inventoryNumber) {
                    case 1: imgSector1SciencieBlocker.setVisible(false); break; case 2: imgSector2SciencieBlocker.setVisible(false); break;
                    case 3: imgSector3SciencieBlocker.setVisible(false); break; case 4: imgSector4SciencieBlocker.setVisible(false); break;
                    case 5: imgSector5SciencieBlocker.setVisible(false); break; case 6: imgSector6SciencieBlocker.setVisible(false); break;
                } break;
            } case "sports": {
                players[currentSelectingPlayer].setFichaDeporte("A");
                switch(inventoryNumber) {
                    case 1: imgSector1SportBlocker.setVisible(false); break; case 2: imgSector2SportBlocker.setVisible(false); break;
                    case 3: imgSector3SportBlocker.setVisible(false); break; case 4: imgSector4SportBlocker.setVisible(false); break;
                    case 5: imgSector5SportBlocker.setVisible(false); break; case 6: imgSector6SportBlocker.setVisible(false); break;
                } break;
            } case "history": {
                players[currentSelectingPlayer].setFichaHistoria("A");
                switch(inventoryNumber) {
                    case 1: imgSector1HistoryBlocker.setVisible(false); break; case 2: imgSector2HistoryBlocker.setVisible(false); break;
                    case 3: imgSector3HistoryBlocker.setVisible(false); break; case 4: imgSector4HistoryBlocker.setVisible(false); break;
                    case 5: imgSector5HistoryBlocker.setVisible(false); break; case 6: imgSector6HistoryBlocker.setVisible(false); break;
                } break;
            } case "art": {
                players[currentSelectingPlayer].setFichaArte("A");
                switch(inventoryNumber) {
                    case 1: imgSector1ArtBlocker.setVisible(false); break; case 2: imgSector2ArtBlocker.setVisible(false); break;
                    case 3: imgSector3ArtBlocker.setVisible(false); break; case 4: imgSector4ArtBlocker.setVisible(false); break;
                    case 5: imgSector5ArtBlocker.setVisible(false); break; case 6: imgSector6ArtBlocker.setVisible(false); break;
                } break;
            } case "entertainment": {
                players[currentSelectingPlayer].setFichaEntretenimiento("A");
                switch(inventoryNumber) {
                    case 1: imgSector1EntertainmentBlocker.setVisible(false); break; case 2: imgSector2EntertainmentBlocker.setVisible(false); break;
                    case 3: imgSector3EntertainmentBlocker.setVisible(false); break; case 4: imgSector4EntertainmentBlocker.setVisible(false); break;
                    case 5: imgSector5EntertainmentBlocker.setVisible(false); break; case 6: imgSector6EntertainmentBlocker.setVisible(false); break;
                } break;
            } case "geography": {
                players[currentSelectingPlayer ].setFichaGeografia("A");
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
            for (ImageView sectorPawn : sectorPawns) {
                if (sectorPawn.isVisible()) {
                    sectorPawn.setVisible(false); // hide the old pawn
                    sectorPawns[player].setVisible(true); // show the new pawn
                    break;
                }
            }
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
            players[currentSelectingPlayer].setPosicionCasilla(players[currentSelectingPlayer].getPosicionCasilla() - 1);
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
        return switch (color) {
            case "green" -> new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnGreen.png")).toString());
            case "orange" -> new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnOrange.png")).toString());
            case "purple" -> new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnPurple.png")).toString());
            case "red" -> new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnRed.png")).toString());
            case "pink" -> new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnPink.png")).toString());
            case "blue" -> new Image(Objects.requireNonNull(getClass().getResource("/cr/ac/una/preguntadospackage/resources/PawnBlue.png")).toString());
            default -> throw new IllegalArgumentException("Invalid color");
        };
    }

    public String getColorByImageId(String imageId) {
        return switch (imageId) {
            case "imgGreenPawnSelection" -> "green";
            case "imgOrangePawnSelection" -> "orange";
            case "imgPurplePawnSelection" -> "purple";
            case "imgRedPawnSelection" -> "red";
            case "imgPinkPawnSelection" -> "pink";
            case "imgBluePawnSelection" -> "blue";
            default -> throw new IllegalArgumentException("Invalid image id");
        };
    }

    private void setPawnImages(ImageView[] pawns, Image pawnImage) {
        for (ImageView pawn: pawns) pawn.setImage(pawnImage);
    }

    private void setPawnsBySelectedColor(int sector, String color) {
        ImageView[] sectorPawns = getPawnsBySector(sector);
        Image pawnImage = getPawnImageByColor(color);

        if (sectorPawns != null) setPawnImages(sectorPawns, pawnImage);
        else throw new IllegalArgumentException("Invalid sector");
    }

    private ImageView[] getPawnsBySector(int sector) {
        return switch (sector) {
            case 1 -> new ImageView[]{
                    imgSector1Pawn1,
                    imgSector1Pawn2,
                    imgSector1Pawn3,
                    imgSector1Pawn4
            };
            case 2 -> new ImageView[]{
                    imgSector2Pawn1,
                    imgSector2Pawn2,
                    imgSector2Pawn3,
                    imgSector2Pawn4
            };
            case 3 -> new ImageView[]{
                    imgSector3Pawn1,
                    imgSector3Pawn2,
                    imgSector3Pawn3,
                    imgSector3Pawn4
            };
            case 4 -> new ImageView[]{
                    imgSector4Pawn1,
                    imgSector4Pawn2,
                    imgSector4Pawn3,
                    imgSector4Pawn4
            };
            case 5 -> new ImageView[]{
                    imgSector5Pawn1,
                    imgSector5Pawn2,
                    imgSector5Pawn3,
                    imgSector5Pawn4
            };
            case 6 -> new ImageView[]{
                    imgSector6Pawn1,
                    imgSector6Pawn2,
                    imgSector6Pawn3,
                    imgSector6Pawn4
            };
            default -> null; // invalid sector
        };
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

            // TODO: this should be overwritten by the player's previous progress saved in the database
            for (int i = 0; i < partida.getCantidadJugadores().intValue(); i++) {
                setPawnsBySelectedColor(players[i].getPosicionSector().intValue(), players[i].getColorPeon());
              players[i].setPosicionCasilla((long)1);
            }

            // reset the selected sectors, TODO: this should be done when the game starts but overwritten by the player's previous progress saved in the database
            currentSelectingPlayer = 0;

            // just to initialize the first player's turn
            lblCurrentPlayerTurn.setText("TURNO DEL JUGADOR: " + (currentSelectingPlayer+1) );

            // for debug purposes make the first player's sector blink
            animationUtils.getInstance().playAnimation("blink", getSectorImageIDbySector(players[currentSelectingPlayer].getPosicionSector().intValue()), 0, 0, 0, 0);
        }
    }

    @FXML
    public void onActionSector4(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer].setPosicionSector((long)4);
            imgSelectorSector4.setVisible(false);
            currentSelectingPlayer++;
            selectedSectors++;
            CheckIfAllTheSectorsHaveBeenSelected();
        }
    }

    @FXML
    public void onActionSector3(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer].setPosicionSector((long)3);
            imgSelectorSector3.setVisible(false);
            currentSelectingPlayer++;
            selectedSectors++;
            CheckIfAllTheSectorsHaveBeenSelected();
        }
    }

    @FXML
    public void onActionSector6(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer].setPosicionSector((long)6);
            imgSelectorSector6.setVisible(false);
            currentSelectingPlayer++;
            selectedSectors++;
            CheckIfAllTheSectorsHaveBeenSelected();
        }
    }

    @FXML
    public void onActionSector5(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer].setPosicionSector((long)5);
            imgSelectorSector5.setVisible(false);
            currentSelectingPlayer++;
            selectedSectors++;
            CheckIfAllTheSectorsHaveBeenSelected();
        }
    }

    @FXML
    public void onActionSector2(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer].setPosicionSector((long)2);
            imgSelectorSector2.setVisible(false);
            currentSelectingPlayer++;
            selectedSectors++;
            CheckIfAllTheSectorsHaveBeenSelected();
        }
    }

    @FXML
    public void onActionSector1(Event event) {
        if(!haveAllPlayersSelectedSectors){
            players[currentSelectingPlayer].setPosicionSector((long)1);
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
        return switch (category) {
            case 0 -> "sciencie";
            case 1 -> "geography";
            case 2 -> "crown";
            case 3 -> "entertainment";
            case 4 -> "art";
            case 5 -> "sports";
            case 6 -> "history";
            default -> null;
        };
    }



    private void hideCategoryAnimation() {
        imgArt.setVisible(false);imgCrown.setVisible(false);imgEntertainment.setVisible(false);imgGeography.setVisible(false);
        imgHistory.setVisible(false);imgScience.setVisible(false);imgSport.setVisible(false);
    }

    public void playerCorrectAnswer(String category){
        movePawnForward(players[currentSelectingPlayer].getPosicionSector().intValue(), players[currentSelectingPlayer].getPosicionCasilla().intValue());
        players[currentSelectingPlayer].setPosicionCasilla((players[currentSelectingPlayer].getPosicionCasilla() + 1));
        showCoin(category, players[currentSelectingPlayer].getPosicionSector().intValue());
    }

    public ImageView getSectorImageIDbySector(int sector){
        return switch (sector) {
            case 1 -> imgSelectorSector1;
            case 2 -> imgSelectorSector2;
            case 3 -> imgSelectorSector3;
            case 4 -> imgSelectorSector4;
            case 5 -> imgSelectorSector5;
            case 6 -> imgSelectorSector6;
            default -> null;
        };
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
    public void onActionHelp(ActionEvent actionEvent) { FlowController.getInstance().goView("HelpView"); }

    private void resetGame() {
        // Reset game-related variables
        selectedSectors = 0;
        currentSelectingPlayer = 0;
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

        // Reset partida object
        partida = new PregPrinpartidaDto();

        // Reset UI elements
        lblCurrentPlayerTurn.setText("");

        // Reset category animation
        hideCategoryAnimation();
    }


    // this method could be used to load the game data from the database
    public void recieveParameters(String[] playerColors, String[] playerNames, int amountOfPlayers, String gameMode, String duelMode, int timeLimitInMinutes) {
        // here we should make a way to differentiate between loading from the database or just creating a new game
        // TODO
        setUpGameEnviroment(amountOfPlayers, playerColors, playerNames, gameMode, duelMode, timeLimitInMinutes);
    }
}