module com.example {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    requires org.junit.jupiter.api;


    opens com.example to javafx.fxml;
    exports com.example;
    exports com.example.CRUD;
    opens com.example.CRUD to javafx.fxml;
}

