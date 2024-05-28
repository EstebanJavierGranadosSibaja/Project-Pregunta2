module cr.ac.una.preguntadospackage {
    
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;
    requires MaterialFX;
    requires java.base;
    requires jakarta.persistence;
    requires javafx.media;

    opens cr.ac.una.preguntadospackage to javafx.fxml, jakarta.persistence;
    opens cr.ac.una.preguntadospackage.controller to javafx.fxml, jakarta.persistence;
    opens cr.ac.una.preguntadospackage.model to jakarta.persistence;
    
    exports cr.ac.una.preguntadospackage;
    
}
