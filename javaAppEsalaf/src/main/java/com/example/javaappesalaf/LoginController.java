package com.example.javaappesalaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    public TextField tfLoginUsername;
    public TextField tfLoginPassword;
    public Label LabelLoginUsername;
    public Label LabelLoginPassword;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void logIn(ActionEvent event)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(CrudApp.class.getResource("first-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 670, 400);
        stage.setScene(scene);
        stage.show();
    }
}
