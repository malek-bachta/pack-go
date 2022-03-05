/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_pack;

import Entities_pack.packs;
import Service_pack.Servicepack;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * FXML Controller class
 
 * @author MSI
 */
public class AfficherpackController implements Initializable {

    @FXML
    private TableView<packs> table;
    @FXML
    private TableColumn<packs, Integer> id;
    @FXML
    private TableColumn<packs, String> nom;
    @FXML
    private TableColumn<packs, String> texte;
    @FXML
    private TableColumn<packs, String> service;
    @FXML
    private TableColumn<packs, String> guide;
    @FXML
    private TableColumn<packs, String> destination;

    private ObservableList<packs> userData = FXCollections.observableArrayList();
    Servicepack pa = new Servicepack() {
    };
    @FXML
    private Button rout;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      try {
            // TODO
            List<packs> packs = new ArrayList<>();
            packs=pa.afficherpacks();
            userData.clear();
            userData.addAll(packs);
            table.setItems(userData);
            id.setCellValueFactory(
                    new PropertyValueFactory<>("id_pack")
            );
            nom.setCellValueFactory(
                    new PropertyValueFactory<>("nom_pack")
            );
            texte.setCellValueFactory(
                    new PropertyValueFactory<>("texte")
            );
            service.setCellValueFactory(
                    new PropertyValueFactory<>("service")
            );
            guide.setCellValueFactory(
                    new PropertyValueFactory<>("guide")
            );
            destination.setCellValueFactory(
                    new PropertyValueFactory<>("destination")
            );
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // TODO
    }

    @FXML
    private void routeur2(ActionEvent event) {
          Parent  root;
        try {
          root = FXMLLoader.load(getClass().getResource("packs.fxml"));
            Stage myWindow = (Stage) rout.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle(" ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
