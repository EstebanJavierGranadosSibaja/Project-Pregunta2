module cr.ac.una.preguntadospackage {
    
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;
    
    requires MaterialFX;

    opens cr.ac.una.preguntadospackage to javafx.fxml;
    exports cr.ac.una.preguntadospackage;
    
}
