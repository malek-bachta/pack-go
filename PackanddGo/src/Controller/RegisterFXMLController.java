/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.User;
import Service.UserService;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;
import org.controlsfx.control.Notifications;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RegisterFXMLController implements Initializable {

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

    UserService us = new UserService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
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
         
                  if( nom.getText().equals("")  || prenom.getText().equals("") || email.getText().equals("") || mdp.getText().equals("") || tel.getText().equals("0") || numpas.getText().equals("") ){
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
        u.setRole("Client");
        us.Registre(u);
        
                          }
        
    }
    
}
