package com.example.javaappesalaf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

public class ProduitController implements Initializable {
    @FXML
    public Button deleteButtonC;
    @FXML
    public Button insertButtonC;
    @FXML
    public Button updateButtonC;
    @FXML
    public TableColumn<Produits, Integer> colId;
    @FXML
    public TableColumn<Produits,String> colNom;

    @FXML
    public TableColumn<Produits,Integer> colPrix;
    @FXML
    public TextField tfId;
    @FXML
    public TextField tfNom;

    @FXML
    public TextField tfPrix;
    @FXML
    public TableView<Produits> tvProduit;

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

        showProduits();

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




    public ObservableList<Produits> getProduitList(){
        ObservableList<Produits> produitList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String req = "SELECT * FROM produit";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(req);
            Produits p;
            while (rs.next()) {
                p = new Produits(rs.getInt("id"), rs.getString("nom"),rs.getInt("prix"));
                produitList.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return produitList;
    }


    public void showProduits()  {
        ObservableList<Produits> list = getProduitList();
        colId.setCellValueFactory(new PropertyValueFactory<Produits , Integer>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<Produits , String>("nom"));
        colPrix .setCellValueFactory(new PropertyValueFactory<Produits , Integer>("prix"));

        tvProduit.setItems(list);
    }




    public void deleteRecord() {
        String req = "DELETE FROM produit WHERE id =" + tfId.getText() + " ";
        executeQuery(req);
        showProduits();
    }

    public void insertRecord() throws Exception {
        String req = "INSERT INTO produit VALUES ("+tfId.getText()+", '"+
                tfNom.getText()+"' ,"+tfPrix.getText()+")";
        executeQuery(req);
        showProduits();
    }

    public void updateRecord() {
        String req = "UPDATE produit SET nom = '"+tfNom.getText()+"' , prix = "+
                tfPrix.getText()+" WHERE id = "+tfId.getText()+" ";
        executeQuery(req);
        showProduits();
    }

    @FXML
    public void handleMouseAction(javafx.scene.input.MouseEvent event) {
        Produits p  = tvProduit.getSelectionModel().getSelectedItem();
        tfId.setText(""+p.getId());
        tfNom.setText(p.getNom());
        tfPrix.setText(""+p.getPrix());
    }

    public void ClearTF(ActionEvent event) {
        tfId.setText("");
        tfNom.setText("");
        tfPrix.setText("");
    }

    public void BackHome(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CrudApp.class.getResource("first-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 670, 400);
        stage.setScene(scene);
        stage.show();
    }
}
