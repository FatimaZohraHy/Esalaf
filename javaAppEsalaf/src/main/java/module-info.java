module com.example.javaappesalaf {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.javaappesalaf to javafx.fxml;
    exports com.example.javaappesalaf;
}