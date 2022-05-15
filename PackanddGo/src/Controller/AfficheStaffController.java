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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AfficheStaffController implements Initializable {

    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, String> prenom;
    @FXML
    private TableColumn<User, String> tel;
    @FXML
    private TableColumn<User, String> mail;
    @FXML
    private TableColumn<User, String> age;
    @FXML
    private TableColumn<User, String> pasport;
    @FXML
    private TableColumn<User, String> role;
    
    public static int idE;

    
    private ObservableList<User> userData = FXCollections.observableArrayList();
    UserService us = new UserService();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                     List<User> listUser= new ArrayList<User>();
                   listUser = us.getStaff();
                   userData.clear();
                   userData.addAll(listUser);
                   table.setItems(userData);
                   nom.setCellValueFactory
                        (
                                new PropertyValueFactory<>("nom")
                        );
                   prenom.setCellValueFactory
                        (
                                new PropertyValueFactory<>("prenom")
                        );
                   mail.setCellValueFactory
                        (
                                new PropertyValueFactory<>("email")
                        );
                   age.setCellValueFactory
                        (
                                new PropertyValueFactory<>("age")
                        );
                   pasport.setCellValueFactory
                        (
                                new PropertyValueFactory<>("numPass")
                        );
                    tel.setCellValueFactory
                        (
                                new PropertyValueFactory<>("tel")
                        );
                   role.setCellValueFactory
                        (
                                new PropertyValueFactory<>("role")
                        );
    }    
    
        

    @FXML
    private void Supprimer(ActionEvent event) throws SQLDataException {
        
            User userSelec = (User) table.getSelectionModel().getSelectedItem();
            idE = userSelec.getId();
            us.deleteUser(idE);
            resetTableData();
        
    }

    @FXML
    private void Modifier(ActionEvent event) {
        
            User userSelec = (User) table.getSelectionModel().getSelectedItem();
            idE = userSelec.getId();
            
                          Parent root;
                        IdOfUser=0;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/ModifierStaff.fxml"));
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
    
              public void resetTableData() throws SQLDataException
    {
        List<User> listUser = new ArrayList<>();
        listUser = us.getStaff();
        ObservableList<User> data = FXCollections.observableArrayList(listUser);
        table.setItems(data);
    }

    
}
