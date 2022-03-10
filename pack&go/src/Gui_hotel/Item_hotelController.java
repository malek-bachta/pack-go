/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_hotel;

import Entities_hotel.Hotels;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbach
 */
public class Item_hotelController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label cat;
    @FXML
    private Label equ;
    @FXML
    private Label adr;
    @FXML
    private Button details;
    @FXML
    private Button hire;
    @FXML
    private ImageView photo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void details(ActionEvent event) {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("affiche_adminH.fxml"));
            Stage myWindow = (Stage) details.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("page name");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

     private Hotels hotel;
    private PackListener  packListener;
    public void setData(Hotels p ) {
        this.hotel = p;
        name.setText(p.getNomH());
        cat.setText(p.getCategorie());
        equ.setText(p.getEquipement());
        adr.setText(p.getAdresse());
        
//   
     Image imagePack = new Image(getClass().getResourceAsStream("/Utils/"+hotel.getImage()));
       photo.setImage(imagePack);
//        
        

    }

    @FXML
    private void hire(ActionEvent event) {
    }

  
}
