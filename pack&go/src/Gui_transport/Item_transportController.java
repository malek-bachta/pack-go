/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_transport;

import Entities_transport.Transport;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Soulaima ben romdhan
 */
public class Item_transportController implements Initializable {
private Transport transport;
    @FXML
    private Label typ;
    @FXML
    private Label nom;
    @FXML
    private Label prix;
    @FXML
    private Label dest;
    
    public void setData(Transport t) {

        this.transport = t;
        typ.setText(t.getType());
        nom.setText(t.getNomagence());
      prix.setText("" +t.getPrix());
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
