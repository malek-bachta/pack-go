/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_guide;

import Entities_guide.Guide;
import Service_guide.GuideService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    
}
