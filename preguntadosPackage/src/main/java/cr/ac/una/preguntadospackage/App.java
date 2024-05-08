package cr.ac.una.preguntadospackage;

import cr.ac.una.preguntadospackage.util.FlowController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/*
 
    Dev notes:

    - Graphics:
        * Max screen res: 1280x720

    ----------------------------------------------------------------------------
    
    - User information
        * Max user tag lenght: 15 letters



 */

public class App extends Application {
    
    
    
    @Override
    public void start(Stage stage) throws IOException {
        
        FlowController.getInstance().InitializeFlow(stage, null);
        
        FlowController.getInstance().goViewInWindow("LoginView");
       
    }

    public static void main(String[] args) {
        launch();
    }

}