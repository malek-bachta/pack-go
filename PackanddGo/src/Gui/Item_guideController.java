/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Guide;
import static Entity.Guide.add;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Soulaima ben romdhan
 */
public class Item_guideController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label type;
    @FXML
    private Label prix;
    private Guide Guide;
    @FXML
    private Button add;
    /**
     * Initializes the controller class.
     */
      public void setData(Guide g) {

        this.Guide = g;
        nom.setText(g.getNom());
        prenom.setText(g.getPrenom());
        type.setText(g.getType());
         prix.setText("" +g.getPrix());
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AjoutReservation.fxml"));
            Stage myWindow = (Stage) add.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("modifier ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    
    }
    
}
