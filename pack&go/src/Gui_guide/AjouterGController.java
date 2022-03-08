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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
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
         if(
                (nom.getText().isEmpty()==false)&&
                (prenom.getText().isEmpty()==false)&&
                (type.getText().isEmpty()==false)&&
                (prix.getText().isEmpty()==false)&&
                (verif_name())&&
                (verif_lastname())&&
                (verif_type())&&
                (verif_prix())
                )
         {
        
        
        
     GuideService gs= new GuideService();
        Guide g = new Guide(nom.getText(),prenom.getText() ,type.getText(),Float.parseFloat(prix.getText()));
        
        try {
            gs.ajouterguide(g);
            
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
         else{
             BoxBlur blur = new BoxBlur(3, 3, 3);
            ajoutg.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR ");
            alert.setContentText("Please check your fields!!");
            alert.showAndWait();
            ajoutg.setEffect(null);
            System.out.println("Impossible");
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

    @FXML
    private boolean verif_name() {
         Pattern p = Pattern.compile("[a-zA-Z]+");
            Matcher m = p.matcher(nom.getText());
            if (m.find() && m.group().equals(nom.getText())) {
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Imput guide name !!");
                alert.showAndWait();
                return false;
            }
    }

    @FXML
    private boolean verif_lastname() {
         Pattern p = Pattern.compile("[a-zA-Z]+");
            Matcher m = p.matcher(prenom.getText());
            if (m.find() && m.group().equals(prenom.getText())) {
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Imput guide last name !!");
                alert.showAndWait();
                return false;
            }
    }

    @FXML
    private boolean verif_type() {
         Pattern p = Pattern.compile("[a-zA-Z]+");
            Matcher m = p.matcher(type.getText());
            if (m.find() && m.group().equals(type.getText())) {
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Imput guide type !!");
                alert.showAndWait();
                return false;
            }
    }

    @FXML
    private boolean verif_prix() {
     Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(prix.getText());
            if (m.find() && m.group().equals(prix.getText())) {
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Imput guide prix !!");
                alert.showAndWait();
                return false;
            }
    
    }
    
}
