/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;



import Entity.Transport;
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
public class Item_transportController implements Initializable {
    @FXML
    private Label typ;
    @FXML
    private Label nom;
    @FXML
    private Label prix;
    @FXML
    private Label dest;
    @FXML
    private Label duree;
    private Transport Transport;
    
    public void setData(Transport t) {

        this.Transport = t;
        typ.setText(t.getType());
        nom.setText(t.getNomagence());
        prix.setText("" +t.getPrix());
              duree.setText(t.getDuree());

        dest.setText(t.getDestination());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
