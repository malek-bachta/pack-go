/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Transport;
import Service.TransportService;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Soulaima ben romdhan
 */
public class ModifierController implements Initializable {

  
    @FXML
    private TextField type;
    @FXML
    private TextField duree;
    @FXML
    private TextField destination;
    @FXML
    private Button modify;
    @FXML
    private TextField name;
    @FXML
    private TextField price;
    @FXML
    private Button back2;
    @FXML
    private Text nom;
    @FXML
    private Text prix;

    /**
     * Initializes the controller class.
     */
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    

    @FXML
    private void modify(ActionEvent event) throws IOException {
       
        
}

    @FXML
    private void back2(ActionEvent event) {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ajouterT.fxml"));
            Stage myWindow = (Stage) back2.getScene().getWindow();
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
