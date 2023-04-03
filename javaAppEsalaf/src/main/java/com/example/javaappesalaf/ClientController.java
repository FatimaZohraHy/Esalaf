package com.example.javaappesalaf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    public Button deleteButtonC;
    @FXML
    public Button insertButtonC;
    @FXML
    public Button updateButtonC;
    @FXML
    public TableColumn<Client, Integer> colId;
    @FXML
    public TableColumn<Client,String> colNom;
    @FXML
    public TableColumn<Client,String> colprenom;
    @FXML
    public TableColumn<Client,String> colTel;
    @FXML
    public TableColumn<Client,Integer> colCredit;
    @FXML
    public TextField tfId;
    @FXML
    public TextField tfNom;
    @FXML
    public TextField tfPrenom;
    @FXML
    public TextField tfTel;
    @FXML
    public TextField tfCredit;
    @FXML
    public TableView<Client> tvClient;

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/esalaf","root","" );

            return conn;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    private void executeQuery(String req) {
        Connection cnx = getConnection();
        Statement st;
        try{
            st = cnx.createStatement();
            st.executeUpdate(req);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            showClients();

    }
    public void handleButtonAction(ActionEvent event) throws Exception {
        if (event.getSource() == insertButtonC) {
            insertRecord();
        }
        if (event.getSource() == updateButtonC) {
            updateRecord();
        }
        if (event.getSource() == deleteButtonC) {
            deleteRecord();
        }
    }




    public ObservableList<Client> getClientList(){
        ObservableList<Client> clientList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String req = "SELECT * FROM client";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(req);
            Client c;
            while (rs.next()) {
                c = new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("tel"), rs.getInt("credit"));
                clientList.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return clientList;
    }


    public void showClients()  {
        ObservableList<Client> list = getClientList();
        colId.setCellValueFactory(new PropertyValueFactory<Client , Integer>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<Client , String>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<Client , String>("prenom"));
        colTel.setCellValueFactory(new PropertyValueFactory<Client , String>("tel"));
        colCredit.setCellValueFactory(new PropertyValueFactory<Client , Integer>("credit"));
        tvClient.setItems(list);
    }




    public void deleteRecord() {
        String req = "DELETE FROM client WHERE id =" + tfId.getText() + " ";
        executeQuery(req);
        showClients();
    }

    public void insertRecord() throws Exception {
        String req = "INSERT INTO CLIENT VALUES ("+tfId.getText()+", '"+
                tfNom.getText()+"' , '"+tfPrenom.getText()+"' ,'"+
                tfTel.getText()+"' ,"+tfCredit.getText()+")";
        executeQuery(req);
        showClients();
    }

    public void updateRecord() {
        String req = "UPDATE client SET nom = '"+tfNom.getText()+"' , prenom = '"+
                tfPrenom.getText()+"' , tel = '"+tfTel.getText()+"', credit = "
                +tfCredit.getText()+" WHERE id = "+tfId.getText()+" ";
        executeQuery(req);
        showClients();
    }

    public void handleMouseAction(MouseEvent event) {
        Client c  = tvClient.getSelectionModel().getSelectedItem();
        tfId.setText(""+c.getId());
        tfNom.setText(c.getNom());
        tfPrenom.setText(c.getPrenom());
        tfTel.setText(c.getTel());
        tfCredit.setText(""+c.getCredit());
    }

    public void clearTF(ActionEvent event) {
        tfId.setText("");
        tfNom.setText("");
        tfPrenom.setText("");
        tfTel.setText("");
        tfCredit.setText("");
    }

    public void BackHome(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CrudApp.class.getResource("first-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
