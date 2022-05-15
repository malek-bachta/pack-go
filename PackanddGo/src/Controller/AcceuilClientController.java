/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.LoginController.IdOfUser;
import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;


public class AcceuilClientController implements Initializable {

    @FXML
    private Button rec;
    @FXML
    private Button pack;
    
    @FXML
    private Button ReserverTransport1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ReserverHotel(ActionEvent event) {
        
        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AjoutReservationHotel.fxml"));
                            Stage myWindow = (Stage) rec.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }

   

    @FXML
    private void Reclamation(ActionEvent event) {
        
                      Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AjouterReclamation.fxml"));
                            Stage myWindow = (Stage) rec.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }

    @FXML
    private void Packs(ActionEvent event) {
         Parent  root;
        try {
          root = FXMLLoader.load(getClass().getResource("/Gui/front_packs.fxml"));
            Stage myWindow = (Stage) pack.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle(" ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ReserverTransport1(ActionEvent event) {
         Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/front_transport.fxml"));
                            Stage myWindow = (Stage) ReserverTransport1.getScene().getWindow();
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
