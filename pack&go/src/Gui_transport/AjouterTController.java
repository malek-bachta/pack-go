/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_transport;
import Entities_guide.Guide;
import Service_guide.GuideService;

import Entities_transport.Transport;
import Service_transport.TransportService;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
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
    @FXML
    private Button modif;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutertransport1(ActionEvent event) {
        if((type.getText().isEmpty()==false)&&
                (nom.getText().isEmpty()==false)&&
                (prix.getText().isEmpty()==false)&&
                (duree.getText().isEmpty()==false)&&
                (destination.getText().isEmpty()==false)&&
                (verif_type())&&
                (verif_name())&&
                (verif_price())&&
                (verif_duree())&&
                (verif_destination())
                ){            
        
        TransportService ts= new TransportService();
        Transport p = new Transport(type.getText(),nom.getText(),Float.parseFloat(prix.getText()),duree.getText(),destination.getText());
        
        try {
            ts.ajoutertransport(p);
            
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}
        else{
             BoxBlur blur = new BoxBlur(3, 3, 3);
            ajouter.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR ");
            alert.setContentText("Please check your fields!!");
            alert.showAndWait();
            ajouter.setEffect(null);
            System.out.println("Impossible");
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
            root = FXMLLoader.load(getClass().getResource("/Gui_guide/ajouterG.fxml"));
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



    @FXML
    private void modif(ActionEvent event) {
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("modifier.fxml"));
            Stage myWindow = (Stage) modif.getScene().getWindow();
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
        private Boolean verif_name( ) {
            Pattern p = Pattern.compile("[a-zA-Z]+");
            Matcher m = p.matcher(nom.getText());
            if (m.find() && m.group().equals(nom.getText())) {
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Imput Transport name !!");
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
                alert.setContentText("Wrong Imput Transport type !!");
                alert.showAndWait();
                return false;
            }
    }

    @FXML
    private boolean verif_price() {
         Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(prix.getText());
            if (m.find() && m.group().equals(prix.getText())) {
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Imput Transport prix !!");
                alert.showAndWait();
                return false;
            }
    }

    @FXML
    private boolean verif_duree() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
            Matcher m = p.matcher(duree.getText());
            if (m.find() && m.group().equals(duree.getText())) {
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Imput Transport duree !!");
                alert.showAndWait();
                return false;
            }
        
    }

    @FXML
    private boolean verif_destination() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
            Matcher m = p.matcher(destination.getText());
            if (m.find() && m.group().equals(destination.getText())) {
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Imput Transport destination !!");
                alert.showAndWait();
                return false;
            }
    }
    
    
}
