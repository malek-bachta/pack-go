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

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AdminFirstPageController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private Button off_p;
    @FXML
    private Button tg;
    @FXML
    private Button off_p1;
    @FXML
    private Button hs;
    @FXML
    private Button hs1;
    @FXML
    private Button hs2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AllUser(ActionEvent event) {
        
          Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AllUser.fxml"));
                            Stage myWindow = (Stage) btn.getScene().getWindow();
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
    private void addStaff(ActionEvent event) {
                
          Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AjouterStaff.fxml"));
                            Stage myWindow = (Stage) btn.getScene().getWindow();
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
    private void AfficheStaff(ActionEvent event) {
        
                      Parent root;
                        IdOfUser=0;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AfficheStaff.fxml"));
                            Stage myWindow = (Stage) btn.getScene().getWindow();
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
    private void off_p(ActionEvent event) {
        
        Parent  root;
        try {
          root = FXMLLoader.load(getClass().getResource("/Gui/offre.fxml"));
            Stage myWindow = (Stage) off_p.getScene().getWindow();
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
    private void tg(ActionEvent event) {
          
        Parent  root;
        try {
          root = FXMLLoader.load(getClass().getResource("/Gui/ajouterT.fxml"));
            Stage myWindow = (Stage) tg.getScene().getWindow();
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
    private void Reservation(ActionEvent event) {
        
        
                  Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AfficheAdminReservationHotel.fxml"));
                            Stage myWindow = (Stage) btn.getScene().getWindow();
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
    private void hs(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Gui/ajout_Hotel.fxml"));
            Stage myWindow = (Stage) hs.getScene().getWindow();
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
    private void logout(ActionEvent event) {
        
                Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Gui/Login.fxml"));
            Stage myWindow = (Stage) hs.getScene().getWindow();
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
    private void reclamer(ActionEvent event) {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Gui/ReclamationAdmin.fxml"));
            Stage myWindow = (Stage) hs.getScene().getWindow();
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
    

