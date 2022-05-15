/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.LoginController.IdOfUser;
import Entity.User;
import Service.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import org.controlsfx.control.Notifications;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AjouterStaff implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField age;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private TextField numpas;
    @FXML
    private PasswordField mdp;
    @FXML
    private ChoiceBox role;
    
    UserService us = new UserService();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        role.getItems().add("Contact Hotel");
        role.getItems().add("Contact Transport");
                        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?")) { 
                return change;
            }
            return null;
        };
            tel.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
            age.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
            numpas.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
        
    }    

    @FXML
    private void Enregistrer(ActionEvent event) {
        
                 User u = new User ();
         
                  if( nom.getText().equals("")  || prenom.getText().equals("") || role.getValue() == null || email.getText().equals("") || mdp.getText().equals("") || tel.getText().equals("0") || numpas.getText().equals("") ){
                                        Notifications.create().title("warnnig").text("Vérifier vos Cordonnée").position(Pos.BOTTOM_RIGHT).showError();
;}
             else if(us.checkEmailExist(email.getText())){
                                            Notifications.create().title("warnnig").text("l'email exite déja").position(Pos.BOTTOM_RIGHT).showError();
;
            }
             else if (us.validerEmail(email.getText())) {
                                         Notifications.create().title("warnnig").text("valider Email").position(Pos.BOTTOM_RIGHT).showError();
;
             }
                          else if (tel.getText().length()!=8) {
                                         Notifications.create().title("warnnig").text("valider Votre numéro").position(Pos.BOTTOM_RIGHT).showError();
;
             }
             else{
        
        u.setNom(nom.getText());
        u.setAge(Integer.parseInt(age.getText()));
        u.setEmail(email.getText());
        u.setPrenom(prenom.getText());
        u.setNumPass(Integer.parseInt(numpas.getText()));
        u.setTel(Integer.parseInt(tel.getText()));

        u.setEmail(email.getText());
        String pass = mdp.getText();
        pass = BCrypt.hashpw(pass, BCrypt.gensalt(13));
        pass= pass.replaceFirst("a", "y");
        u.setMdp(pass);
        if (role.getValue().equals("Contact Hotel"))
        u.setRole("Contact Hotel");
        else
        u.setRole("Contact Transport");

        us.Registre(u);
        
                 Parent root;
                        IdOfUser=0;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AfficheStaff.fxml"));
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
  
    
}
