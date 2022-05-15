/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Guide;
import Entity.Transport;
import Service.GuideService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Soulaima ben romdhan
 */
public class AfficherGController implements Initializable {

    @FXML
    private Button back1;
    @FXML
    private Button supprimer;
    @FXML
    private TableView<Guide> table;
    @FXML
    private TableColumn<Guide, Integer> id;
    @FXML
    private TableColumn<Guide, String> nom;
    @FXML
    private TableColumn<Guide, String> prenom;
    @FXML
    private TableColumn<Guide, String> type;
    @FXML
    private TableColumn<Guide, Float> prix;

    private ObservableList<Guide> userData = FXCollections.observableArrayList();
    GuideService gs = new GuideService();

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            // TODO
            List<Guide> g = new ArrayList<Guide>();
            g = gs.afficheguide();
            userData.clear();
            userData.addAll(g);
            table.setItems(userData);
            id.setCellValueFactory(
                    new PropertyValueFactory<>("id")
            );
            nom.setCellValueFactory(
                    new PropertyValueFactory<>("nom")
            );
            prenom.setCellValueFactory(
                    new PropertyValueFactory<>("prenom")
            );
            type.setCellValueFactory(
                    new PropertyValueFactory<>("type")
            );

            prix.setCellValueFactory(
                    new PropertyValueFactory<>("prix")
            );

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   

    @FXML
    private void back1(ActionEvent event) {
         Parent root;

    
        try {
            root = FXMLLoader.load(getClass().getResource("ajouterG.fxml"));
        Stage myWindow = (Stage) back1.getScene().getWindow();
        Scene sc = new Scene(root);
        myWindow.setScene(sc);
        myWindow.setTitle("ajouter ");
        //myWindow.setFullScreen(true);
        myWindow.show();
    }
    catch (IOException ex

    
        ) {
            System.out.println(ex.getMessage());
    }
    }
 
        public static int idg;
    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
        
        Guide g = (Guide) table.getSelectionModel().getSelectedItem();
        idg = g.getId();
        gs.supprimerguide(idg);
        resetTableData();
    }
     public void resetTableData() throws SQLDataException, SQLException {
        List<Guide> g = new ArrayList<>();
        g = gs.afficheguide();
        ObservableList<Guide> data = FXCollections.observableArrayList(g);
        table.setItems(data);
    }
  
        
    }





