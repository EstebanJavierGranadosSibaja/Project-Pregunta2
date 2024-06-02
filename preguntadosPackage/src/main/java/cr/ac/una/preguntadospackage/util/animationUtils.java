package cr.ac.una.preguntadospackage.util;

import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class animationUtils {

    // singleton instance of the class that handles the animation
    private static animationUtils INSTANCE = null;

    // private constructor to prevent instantiation
    private animationUtils() {
    }

    // method to create an instance of the class
    private static void createInstance() {
        if (INSTANCE == null) {
            synchronized (animationUtils.class) {
                if (INSTANCE == null) {
                    INSTANCE = new animationUtils();
                }
            }
        }
    }

    // method to get the instance of the class
    public static animationUtils getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    // method to prevent cloning of the class
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    // method to play the animation
    public void playAnimation(String effect, ImageView imageView) {
        // depending on the effect, play the corresponding animation
        switch (effect) {
            case "blink": {
                // play the blink animation
                imageView.setVisible(true);
                FadeTransition ft = new FadeTransition(Duration.millis(900), imageView);
                ft.setFromValue(0.8);
                ft.setToValue(0.0);
                ft.setCycleCount(2);
                ft.setAutoReverse(true);
                ft.setOnFinished(event -> {
                    imageView.setVisible(false);
                    ft.stop();
                });
                ft.play();

                break;


            }
            case "constantBlink": {
                // play the constant blink animation
                imageView.setVisible(true);
                FadeTransition ft = new FadeTransition(Duration.millis(1000), imageView);
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                ft.setCycleCount(4);
                ft.setAutoReverse(true);
                ft.setOnFinished(event -> {
                    imageView.setVisible(false);
                    ft.stop();
                });
                ft.play();
                break;
            }
        }
    }

    public void stopAnimation(String effect, ImageView imageView) {
        // depending on the effect, stop the corresponding animation

    }

}
