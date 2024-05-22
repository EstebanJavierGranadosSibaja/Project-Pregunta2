package cr.ac.una.preguntadospackage.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import cr.ac.una.preguntadospackage.util.FlowController;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class GameController extends Controller implements Initializable {

    Boolean hasSpinnerBeenClicked = false;
    ArrayList<Integer> activePlayersList = new ArrayList<>();
    @FXML private HBox hboxInventory2, hboxInventory1, hboxInventory4, hboxInventory3, hboxInventory6, hboxInventory5;
    @FXML private ImageView imgSportShadow, imgHistory, imgScience, imgArtShadow, imgEntertainment, imgScienceShadow, imgCrownShadow, imgEntertainmentShadow, imgHistoryShadow, imgGeographyShadow, imgArt, imgSport, imgGeography, imgCrown, imgPawnRedSlot4, imgPawnRedSlot2, imgPawnRedSlot3, imgPawnRedSlot1, imgPawnPurpleSlot2, imgPawnPurpleSlot1, imgPawnOrangeSlot4, imgPawnPurpleSlot4, imgPawnOrangeSlot3, imgPawnPurpleSlot3, imgPawnOrangeSlot2, imgPawnOrangeSlot1, imgPawnGreenSlot1, imgPawnGreenSlot3, imgPawnGreenSlot2, imgPawnGreenSlot4;
    @FXML private ImageView imgSpinner;

    public void setupPlayerCount(int playerCount, int helpAssistanceLevel) {
        switch(playerCount) {
            case 2: hboxInventory1.setVisible(true); hboxInventory6.setVisible(true); break;
            case 3: hboxInventory1.setVisible(true); hboxInventory6.setVisible(true); hboxInventory4.setVisible(true); break;
            case 4: hboxInventory1.setVisible(true); hboxInventory6.setVisible(true); hboxInventory3.setVisible(true); hboxInventory4.setVisible(true); break;
            case 5: hboxInventory1.setVisible(true); hboxInventory6.setVisible(true); hboxInventory3.setVisible(true); hboxInventory4.setVisible(true); hboxInventory2.setVisible(true); break;
            case 6: hboxInventory1.setVisible(true); hboxInventory6.setVisible(true); hboxInventory3.setVisible(true); hboxInventory4.setVisible(true); hboxInventory5.setVisible(true); hboxInventory2.setVisible(true); break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hboxInventory1.setVisible(false); hboxInventory2.setVisible(false); hboxInventory3.setVisible(false); hboxInventory4.setVisible(false); hboxInventory5.setVisible(false); hboxInventory6.setVisible(false);
        hideCategoryAnimation();
    }

    @Override
    public void initialize() {
    }

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

    private void hideCategoryAnimation() {
        imgArt.setVisible(false); imgArtShadow.setVisible(false); imgCrown.setVisible(false); imgCrownShadow.setVisible(false); imgEntertainment.setVisible(false); imgEntertainmentShadow.setVisible(false); imgGeography.setVisible(false); imgGeographyShadow.setVisible(false); imgHistory.setVisible(false); imgHistoryShadow.setVisible(false); imgScience.setVisible(false); imgScienceShadow.setVisible(false); imgSport.setVisible(false); imgSportShadow.setVisible(false);
    }

    @FXML
    public void onActionSpinner(MouseEvent event) {
        if (hasSpinnerBeenClicked) {
            return;
        }
        System.out.println("Spinner clicked");
        imgSpinner.setRotate(27);
        RotateTransition rt = new RotateTransition();
        rt.setDuration(javafx.util.Duration.seconds(4.5));
        rt.setNode(imgSpinner);
        double randomDegrees = Math.random() * 360;
        System.out.println("Random degrees: " + randomDegrees);
        int category = (int) Math.floor(randomDegrees / 51.4);
        playCategoryAnimation(category);
        rt.setByAngle(randomDegrees + 3600);
        rt.play();
        rt.setOnFinished(e -> {
            System.out.println("SetonFinished");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            QuestionController questionController = (QuestionController) FlowController.getInstance().getController("QuestionView");
            questionController.setCategoryTheme(category);
            FlowController.getInstance().goView("QuestionView");
            hasSpinnerBeenClicked = false;
            hideCategoryAnimation();
        });
    }
}
