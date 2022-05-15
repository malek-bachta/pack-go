/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.packs;
import Service.Servicepack;
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
 * @author MSI
 */
public class PacksController implements Initializable {

    @FXML
    private TextField Pnom;
    @FXML
    private TextField Ptexte;
    @FXML
    private TextField Pguide;
    @FXML
    private TextField Pdestination;
    @FXML
    private TextField Pservice;
    
    @FXML
    private Button afficher;
    @FXML
    private Button rout1;
    @FXML
    private Button calendar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterpack(ActionEvent event) {
                     String nom_pack=Pnom.getText();
                     String texte=Ptexte.getText();
                     String service=Pservice.getText();
                     String guide=Pguide.getText();

                     String destination=Pdestination.getText();

         packs p = new packs( nom_pack, texte, service, guide, destination);
         Servicepack pa = new Servicepack () {};
         try {
         pa.ajouter1(p);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("offre is added successfully!");
            alert.show();
            Ptexte.setText("");
            Pnom.setText("");
             Pservice.setText("");
              Pguide.setText("");
               Pdestination.setText("");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void afficher(ActionEvent event) {
        Parent  root;
        
        try {
          root = FXMLLoader.load(getClass().getResource("afficherpack.fxml"));
            Stage myWindow = (Stage) afficher.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle(" ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
      
    }

    @FXML
    private void rout1(ActionEvent event) {
         Parent  root;
        try {
          root = FXMLLoader.load(getClass().getResource("/Gui/offre.fxml"));
            Stage myWindow = (Stage) rout1.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle(" ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void aff_calendar(ActionEvent event) {
        Parent  root;
        try {
          root = FXMLLoader.load(getClass().getResource("/calendar/calendar.fxml"));
            Stage myWindow = (Stage) calendar.getScene().getWindow();
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
    

    
    
 
    
   

  
    
    

