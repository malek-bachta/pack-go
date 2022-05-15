/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.User;
import Service.UserService;
import Service.Sessions;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class LoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField psw;
    static int IdOfUser;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) {
                                        System.out.println(email.getText());

                 if(email.getText().equals("") || psw.getText().equals("")){
           Alert alert = new Alert(Alert.AlertType.ERROR, "Complete vos cordnner", ButtonType.OK);
           alert.showAndWait();
                   }else {
       
                       User U = new User();
                       UserService daoU = new UserService();
                       User result = daoU.Login(email.getText());
                          System.out.println(result);
                       if (result == null){

                                  Alert alert = new Alert(Alert.AlertType.ERROR, "vérifier vos cordoe", ButtonType.OK);

                                  alert.showAndWait();
                       }
                       
                       else{
                         //       System.out.println(result.getBanned());
               

        if (BCrypt.checkpw(psw.getText(), result.getMdp().replaceFirst("y","a")))
        {    
   
                                System.out.println(result.getRole().equals("[\"ROLE_USER\"]"));

                if(result.getRole().equals("[\"ROLE_USER\"]")){
                        Sessions.setLoggedInUser(result);
                        System.out.println(result.getRole());
                        // TODO: Proceed to other page
                        Parent root;
                        IdOfUser=result.getId();
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AcceuilClient.fxml"));
                            Stage myWindow = (Stage) email.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else if(result.getRole().equals("[\"ROLE_ADMIN\"]")){
                        Sessions.setLoggedInUser(result);
                        // TODO: Proceed to other page
                        Parent root;
                        IdOfUser=0;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AdminFirstPage.fxml"));
                            Stage myWindow = (Stage) email.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else if(result.getRole().equals("[\"ROLE_AGENT\"]")){
                        Sessions.setLoggedInUser(result);
                        System.out.println(result.getRole());
                        // TODO: Proceed to other page
                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AcceuilAgent.fxml"));
                            Stage myWindow = (Stage) email.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("Admin");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                else if(result.getRole().equals("[\"ROLE_AGENT\"]")){
                        Sessions.setLoggedInUser(result);
                        System.out.println(result.getRole());
                        // TODO: Proceed to other page
                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AcceuilAgent.fxml"));
                            Stage myWindow = (Stage) email.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("Admin");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                
        
            
            
        }
        

        else{

           Alert alert22 = new Alert(Alert.AlertType.ERROR, "vérifier vos cordoe", ButtonType.OK);
               alert22.showAndWait();

        }
        
                       }
                 }
    }
        

    @FXML
    private void registerPage(ActionEvent event) {
                 Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/RegisterFXML.fxml"));
                            Stage myWindow = (Stage) email.getScene().getWindow();
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
    private void forgetPassword(ActionEvent event) {
        
                                Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/ResetPassword.fxml"));
                            Stage myWindow = (Stage) email.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }
    
}
