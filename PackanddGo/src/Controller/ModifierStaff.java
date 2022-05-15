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
import java.sql.SQLDataException;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class ModifierStaff implements Initializable {

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
    private ChoiceBox role;
    
    UserService us =new UserService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        User u = us.findUserById(AfficheStaffController.idE);
        nom.setText(u.getNom());
        prenom.setText(u.getPrenom());
        email.setText(u.getEmail());
        age.setText(String.valueOf(u.getAge()));
        tel.setText(String.valueOf(u.getTel()));
        numpas.setText(String.valueOf(u.getNumPass()));
        
        role.getItems().add("Contact Hotel");
        role.getItems().add("Contact Transport");

    }    

    @FXML
    private void Enregistrer(ActionEvent event) throws SQLDataException {
        
                 User u = new User ();
                 u.setId(AfficheStaffController.idE);
         
                  if( nom.getText().equals("")  || prenom.getText().equals("") || email.getText().equals("") || tel.getText().equals("0") || numpas.getText().equals("") ){
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
        if (role.getValue().equals("Contact Hotel"))
        u.setRole("Contact Hotel");
        else
        u.setRole("Contact Transport");

        us.modifieStaff(u);
        
                                  Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AfficheStaff.fxml"));
                            Stage myWindow = (Stage) tel.getScene().getWindow();
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
