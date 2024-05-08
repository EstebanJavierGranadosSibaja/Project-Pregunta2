module cr.ac.una.preguntadospackage {
    
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;
    
    requires MaterialFX;
    requires java.base;

    opens cr.ac.una.preguntadospackage to javafx.fxml;
    exports cr.ac.una.preguntadospackage;
    
}
