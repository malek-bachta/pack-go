/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.offre;
import Service.Serviceoffre;
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
public class ModifierEtSuppOffreController implements Initializable {

    @FXML
    private TextField Mid;
    @FXML
    private TextField Mnom;
    @FXML
    private TextField Mbudget;
    @FXML
    private Button suppoffre;
    @FXML
    private Button routour1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifieroffre(ActionEvent event) {
        int id=Integer.parseInt(Mid.getText());
         String nom_offre=Mnom.getText();
                 int budget=Integer.parseInt(Mbudget.getText());
         offre f = new offre(nom_offre,budget);
         Serviceoffre So = new Serviceoffre () {};
         So.modifierOffre(id, budget, nom_offre);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Success");
         alert.setContentText("offre is update successfully!");
         alert.show();
         Mbudget.setText("");
         Mnom.setText("");
    }

    @FXML
    private void suprimeroffre(ActionEvent event) {
         int id=Integer.parseInt(Mid.getText());
       
        
         Serviceoffre So = new Serviceoffre () {};
         So.suprimerOffre(id);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Success");
         alert.setContentText("offre is delate successfully!");
         alert.show();
        
    }

    @FXML
    private void routour1(ActionEvent event) {
         try {
          Parent  root = FXMLLoader.load(getClass().getResource("offre.fxml"));
            Stage myWindow = (Stage) routour1.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("affiche ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
