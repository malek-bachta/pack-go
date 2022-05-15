/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Reclamation;
import Entity.User;
import Service.ReclamationService;
import Service.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Rzouga
 */
public class ReclamationAdminController implements Initializable {

    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<Reclamation, String> sujet;
    @FXML
    private TableColumn<Reclamation, String> contenue;
    @FXML
    private TableColumn<Reclamation,String> etat;
    @FXML
    private TableColumn<Reclamation, Date> date;
    @FXML
    private TableColumn<Reclamation, Integer> user;
    
    UserService us = new UserService();
    
    private ObservableList<Reclamation> reserData = FXCollections.observableArrayList();
    
    ReclamationService rs = new ReclamationService();    
        public static int idR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                   List<Reclamation> listReser= new ArrayList<Reclamation>();
                   listReser = rs.Allreclamation();
                   reserData.clear();
                   reserData.addAll(listReser);
                   table.setItems(reserData);
                   sujet.setCellValueFactory
                        (
                                new PropertyValueFactory<>("sujet")
                        );
                   contenue.setCellValueFactory
                        (
                                new PropertyValueFactory<>("contenue")
                        );
                   etat.setCellValueFactory
                        (
                                new PropertyValueFactory<>("etat")
                        );
                   date.setCellValueFactory
                        (
                                new PropertyValueFactory<>("dateenv")
                        );
                                      user.setCellValueFactory
                        (
                                new PropertyValueFactory<>("idUser")
                        );
                   
    }    

    @FXML
    private void Traiter(ActionEvent event) throws SQLDataException, Exception {
                    Reclamation userSelec = (Reclamation) table.getSelectionModel().getSelectedItem();
                    idR = userSelec.getIdrec();
                    
                    if (userSelec.getEtat().equals("Traité")){
                    
              Notifications.create().title("warnnig").text("Cette réclamation est déja traiter").position(Pos.BOTTOM_RIGHT).showError();

                    
                    }
                    else{
                    
                    User u = us.findUserById(userSelec.getIdUser());
            
                         rs.Traiter(idR);
                          Entity.mail.envoi(u.getEmail(), "Reclamation Traiter", "Votre Reclamation est bien Traité");
                          
                                                    Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/ReclamationAdmin.fxml"));
                            Stage myWindow = (Stage) table.getScene().getWindow();
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
