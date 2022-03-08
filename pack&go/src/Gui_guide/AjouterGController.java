/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_guide;

import Entities_guide.Guide;
import Service_guide.GuideService;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Soulaima ben romdhan
 */
public class AjouterGController implements Initializable {

   
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField type;
    @FXML
    private TextField prix;
    @FXML
    private Button ajoutg;
    @FXML
    private Button afficherg;
    @FXML
    private Button modify;
    @FXML
    private Button back4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutg(ActionEvent event) {
     GuideService gs= new GuideService();
        Guide g = new Guide(nom.getText(),prenom.getText() ,type.getText(),Float.parseFloat(prix.getText()));
        
        try {
            gs.ajouterguide(g);
            
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

    @FXML
    private void afficherg(ActionEvent event) {
            Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("afficherG.fxml"));
            Stage myWindow = (Stage) afficherg.getScene().getWindow();
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
    private void modify(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("modifierG.fxml"));
            Stage myWindow = (Stage) modify.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("modifier ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    
}

    @FXML
    private void back4(ActionEvent event) {
           Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Gui_transport/ajouterT.fxml"));
            Stage myWindow = (Stage) back4.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("ajouter ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
