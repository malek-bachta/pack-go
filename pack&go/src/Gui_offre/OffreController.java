/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_offre;

import Entities_offre.offre;
import Service_offre.Serviceoffre;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author MSI
 */
public class OffreController implements Initializable {

    @FXML
    private TextField tfbudget;
    @FXML
    private Button btnajouter;
    @FXML
    private TextField tfnom;
    @FXML
    private TextArea listp;
    @FXML
    private Button updateoffre;
    @FXML
    private Button packs;
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
    private void ajouter(ActionEvent event) throws SQLException {
         int budget=Integer.parseInt(tfbudget.getText());
         String nom_offre=tfnom.getText();
         offre f = new offre(nom_offre,budget);
         Serviceoffre So = new Serviceoffre () {};
         try {
         So.ajouter(f);
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("offre is added successfully!");
            alert.show();
            tfbudget.setText("");
            tfnom.setText("");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
         
    }

    @FXML
    private void afficheroffre(ActionEvent event) {
        Serviceoffre So = new Serviceoffre () {};
        try {
           
                    
            listp.setText(So.Tri().toString());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void gotoupdate(ActionEvent event) throws IOException {
        try {
          Parent  root = FXMLLoader.load(getClass().getResource("modifier_supp_offre.fxml"));
            Stage myWindow = (Stage) updateoffre.getScene().getWindow();
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
    private void gotopacks(ActionEvent event) {
        try {
          Parent  root = FXMLLoader.load(getClass().getResource("/Gui_pack/packs.fxml"));
            Stage myWindow = (Stage) packs.getScene().getWindow();
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
    




