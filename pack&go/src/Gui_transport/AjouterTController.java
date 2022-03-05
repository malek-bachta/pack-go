/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_transport;

import Entities_transport.Transport;
import Service_guide.TransportService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Soulaima ben romdhan
 */
public class AjouterTController implements Initializable {

    @FXML
    private TextField type;
    @FXML
    private TextField nom;
    @FXML
    private TextField prix;
    @FXML
    private TextField duree;
    @FXML
    private TextField destination;
    @FXML
    private Button ajouter;
    @FXML
    private Button afficherA;
    @FXML
    private Button guide;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutertransport1(ActionEvent event) {
        TransportService ts= new TransportService();
        Transport p = new Transport(type.getText(),nom.getText(),Float.parseFloat(prix.getText()),duree.getText(),destination.getText());
        
        try {
            ts.ajoutertransport(p);
            
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void afficherA(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("afficherT.fxml"));
            Stage myWindow = (Stage) afficherA.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("affiche ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
     @FXML
     private void guide(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ajouterG.fxml"));
            Stage myWindow = (Stage) guide.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("ajouter guide ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
  
   
}
