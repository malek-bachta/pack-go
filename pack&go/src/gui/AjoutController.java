/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mbach
 */
public class AjoutController implements Initializable {

    @FXML
    private Button add;
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
    }

    @FXML
    private void initialize(ActionEvent event) {
    }
    
}
