/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_guide;

import Entities_guide.Guide;
import Gui_transport.ModifierController;
import Service_guide.GuideService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ModifierGController implements Initializable {

    @FXML
    private Button back3;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField type;
    @FXML
    private TextField prix;
    @FXML
    private Button modif;
    Guide g = new Guide();
    List<Guide> liste = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         GuideService gs = new GuideService();
        try {
            liste = gs.afficheguideid(0);
        } catch (SQLException ex) {
            Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }

        liste.forEach((l) -> {
            nom.setText(l.getNom());
            prenom.setText(l.getPrenom());
            prix.setText(Float.toString(l.getPrix()));
            type.setText(l.getType());
            

        });
    }    

    @FXML
    private void back3(ActionEvent event) {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ajouterG.fxml"));
            Stage myWindow = (Stage) back3.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("ajouter ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void modif(ActionEvent event) {
        String nom1 = nom.getText();
        String prenom1 = prenom.getText();
        Float prix1 = Float.parseFloat(prix.getText());
        String type1 = type.getText();
        
        Guide g = new Guide(nom1, prenom1,type1, prix1);
        GuideService sp = new GuideService();
        sp.modifierguide(3, nom1, prenom1, type1, prix1 );

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("afficherG.fxml"));
            Stage myWindow = (Stage) modif.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("Hotels List ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
