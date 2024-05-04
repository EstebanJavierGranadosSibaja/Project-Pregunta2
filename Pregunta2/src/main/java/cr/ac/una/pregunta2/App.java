package cr.ac.una.pregunta2;

import cr.ac.una.pregunta2.util.FlowController;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        FlowController.getInstance().InitializeFlow(stage, null);
        FlowController.getInstance().goViewInWindow("LoginView");
    }

    public static void main(String[] args) {
        launch();
    }

    
    
}