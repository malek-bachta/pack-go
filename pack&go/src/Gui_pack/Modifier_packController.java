/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_pack;

import Entities_pack.packs;
import Service_pack.Servicepack;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class Modifier_packController implements Initializable {

    @FXML
    private TextField Pnom;
    @FXML
    private TextField Ptexte;
    @FXML
    private TextField Pguide;
    @FXML
    private TextField Pdestination;
    @FXML
    private TextField Pservice;
    @FXML
    private Button rout1;
    @FXML
    private TextField Pid;
    packs p = new packs();
    List<packs> liste = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    @FXML
    private void modifier_pack(ActionEvent event) {
        int id=Integer.parseInt(Pid.getText());
         String Nom_pack=Pnom.getText();
                       String texte=Ptexte.getText();
         String service=Pservice.getText();
         String guide=Pguide.getText();
         String destination=Pdestination.getText();
  
         packs p = new packs(Nom_pack, texte, service, guide, destination);
         Servicepack pa = new Servicepack () {};
         pa.modifierPack(id, Nom_pack, texte, service, guide, destination);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Success");
         alert.setContentText("offre is update successfully!");
         alert.show();
         Pnom.setText("");
         Ptexte.setText("");
         Pservice.setText("");
         Pguide.setText("");
         Pdestination.setText("");

    }

    @FXML
    private void rout1(ActionEvent event) {
          Parent  root;
        try {
          root = FXMLLoader.load(getClass().getResource("packs.fxml"));
            Stage myWindow = (Stage) rout1.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle(" ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }

