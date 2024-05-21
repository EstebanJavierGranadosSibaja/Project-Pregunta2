/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntadospackage.controller;

import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;

import cr.ac.una.preguntadospackage.util.FlowController;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import static java.time.Duration.*;


/**
 * FXML Controller class
 *
 * @author Matteo2K24
 */
public class GameController extends Controller implements Initializable {

    Boolean hasSpinnerBeenClicked = false;

    @FXML
    private ImageView imgSpinner;

    /**
     * Initializes the controller class
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
    }

    @FXML
    public void onActionSpinner(MouseEvent event) {

        if (hasSpinnerBeenClicked) {
            return;
        }

        hasSpinnerBeenClicked = true;

        // if already clicked disable the abilit to click again


        System.out.println("Spinner clicked");

        // Reset the rotation of the image to its original position
        imgSpinner.setRotate(0);

        // Create a RotateTransition
        RotateTransition rt = new RotateTransition();

        // Set the duration of the transition
        rt.setDuration(javafx.util.Duration.seconds(3));

        // Set the node to be rotated
        rt.setNode(imgSpinner);

        // Create a random number between 0 and 360 for the angle of rotation
        double randomDegrees = Math.random() * 360;

        // Set the angle of rotation
        rt.setByAngle(randomDegrees + 1800);

        // Play the animation
        rt.play();

        // Add a listener to the end of the animation to get the final degrees and category
        rt.setOnFinished(e -> {
            // get the degrees of the image
            double degrees = imgSpinner.getRotate() - 1800;
            System.out.println("Degrees: " + degrees);

            // Calculate the category (there are 7 categories)
            int category = (int) (degrees / 51.42);
            System.out.println("Category: " + category);

            // Make the system wait for 3 seconds
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

            // You can now use the category to get a question and handle the player's answer
            QuestionController questionController = (QuestionController) FlowController.getInstance().getController("QuestionView");
            questionController.setCategoryTheme(category);

            FlowController.getInstance().goView("QuestionView");

        });
    }
    
    
    
}
