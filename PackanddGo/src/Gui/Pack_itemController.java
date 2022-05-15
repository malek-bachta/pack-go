/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.packs;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class Pack_itemController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private packs packs;
    @FXML
    private Label nomp;
    @FXML
    private Label textp;
    @FXML
    private Label servicep;
    @FXML
    private Label guidep;
    @FXML
    private Label destinationp;
    @FXML
    private Label budgetp;
    @FXML
    private Button addsiwar;

    public void setData(packs p) {

        this.packs = p;
        nomp.setText(p.getNom_pack());
        textp.setText(p.getTexte());
        servicep.setText(p.getService());
        guidep.setText(p.getGuide());
        destinationp.setText(p.getDestination());
      budgetp.setText("" +p.getBudget_pack());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ads(ActionEvent event) {
        
    }

}
