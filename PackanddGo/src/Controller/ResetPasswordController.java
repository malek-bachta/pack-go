/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.UserService;
import Entity.User;
import Entity.mail;
import java.net.URL;
import java.sql.SQLDataException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import org.mindrot.jbcrypt.BCrypt;


public class ResetPasswordController implements Initializable {

    @FXML
    private TextField email;
    
    UserService us = new UserService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void Envoyer(ActionEvent event) throws SQLDataException, Exception {
                User u= us.findUserByEmail(email.getText());
                System.err.println("sssssss"+u);

                           if(email.getText().equals("")){
           Alert alert = new Alert(Alert.AlertType.ERROR, "Complete vos cordnner", ButtonType.OK);
           alert.showAndWait();
                   }
                           else if (u.getId() == 0){
       Alert alert = new Alert(Alert.AlertType.ERROR, "User n'existe pas", ButtonType.OK);
           alert.showAndWait();
                           }
                           else{
        

        String mdp = "123456";
        mdp = BCrypt.hashpw(mdp, BCrypt.gensalt(13));
        mdp= mdp.replaceFirst("a", "y");
        u.setMdp(mdp);
                Entity.mail.envoi(u.getEmail(), "Nouveau Password", " Votre Noveaux Password est 123456");

        us.modifiePassword(u);
         System.err.println(u.getEmail());


        
    }
    }
    
}
