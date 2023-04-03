package com.example.javaappesalaf;
import javafx.application.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.fxml.*;
import javafx.scene.image.*;
public class CrudApp extends Application{
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(CrudApp.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.<Parent>load(), 600, 400);
        stage.setTitle("ESALAF");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}