/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_hotel;

import Entities_hotel.Hotels;
import Services_hotel.HotelService;
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
 * @author mbach
 */
public class AjoutController implements Initializable {

    @FXML
    private TextField nameH;
    @FXML
    private TextField categoryH;
    @FXML
    private TextField adressH;
    @FXML
    private TextField email;
    @FXML
    private TextField telH;
    @FXML
    private TextField equipement;
    @FXML
    private Button add;
    @FXML
    private Button show_list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add_persom(ActionEvent event) {
         String name = nameH.getText();
        String gategory = categoryH.getText();
        String adress = adressH.getText();
        String email = this.email.getText();
        int tel = Integer.parseInt(telH.getText());
        String equipment = equipement.getText();

        Hotels h = new Hotels(name, gategory, adress, email, tel, equipment);
        HotelService hs = new HotelService();

        try {
            hs.ajouter(h);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void initialize(ActionEvent event) {
       
    }

    @FXML
    private void show_list(ActionEvent event) {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("affiche.fxml"));
            Stage myWindow = (Stage) show_list.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("page name");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
