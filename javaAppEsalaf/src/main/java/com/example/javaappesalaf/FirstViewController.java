package com.example.javaappesalaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstViewController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void afficheProduits(ActionEvent event)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(CrudApp.class.getResource("Produits-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 720, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void afficheClient(ActionEvent event)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(CrudApp.class.getResource("client-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 720, 600);
        stage.setScene(scene);
        stage.show();
    }
}
