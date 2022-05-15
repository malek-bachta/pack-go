/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.User;
import Service.UserService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AcceuilAdminController implements Initializable {

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

    UserService us = new UserService();
    private ObservableList<User> userData = FXCollections.observableArrayList();
    
    public static int idE;
    @FXML
    private TableView<User> table;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                   List<User> listUser= new ArrayList<User>();
                   listUser = us.getAllUser();
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
    }    
    
}
