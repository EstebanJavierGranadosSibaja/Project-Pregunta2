module cr.ac.una.preguntadospackage {
    
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;
    requires MaterialFX;
    requires java.base;
    requires jakarta.persistence;
    requires javafx.media;
    requires eclipselink;
    requires jakarta.activation;

    opens cr.ac.una.preguntadospackage to javafx.fxml, jakarta.persistence;
    opens cr.ac.una.preguntadospackage.controller to javafx.fxml, jakarta.persistence;
    opens cr.ac.una.preguntadospackage.model to jakarta.persistence, eclipselink;
    
    
    exports cr.ac.una.preguntadospackage;
    
    // COSAS POR HACER MAÑANA
    //
    // 1 -> Revisar las consultas JPQL para ver como pedir una preguntas desde la categoria.
    // 2 -> Refactorizar los services para que funcionen mucho mejor y con mayor logica.
    // 3 -> Entender la logica de las tablas intermedias no puras y como se relaionan realmente entre sí con las demas y el programa.
    // 4 -> Añadir alguna que otra vista simple que sea necesaria (PROBABLEMENTE LA DE MANEJO DE PREGUNTAS).
    // 5 -> Continuar con la documentación.
    // IMPORTANTE ->            Collections.shuffle(empleados);

    
}
