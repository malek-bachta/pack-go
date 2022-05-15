/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Reservation;
import Entity.ReservationHotel;
import Entity.User;
import Service.ReservationHotelService;
import Service.ReservationService;
import Service.Sessions;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AfficheAdminReservationHotelController implements Initializable {

    @FXML
    private TableColumn<Date, String> dated;
    @FXML
    private TableColumn<Date, String> datef;
    @FXML
    private TableColumn<Integer, String> user;
    @FXML
    private TableColumn<Integer, String> hotel;
    @FXML
    private TableColumn<String, String> etat;

    private ObservableList<ReservationHotel> reserData = FXCollections.observableArrayList();
    
    ReservationHotelService rs = new ReservationHotelService();
    @FXML
    private TableView<ReservationHotel> tabel;
    
    UserService us = new UserService();
    
    public static int idRes;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                    List<ReservationHotel> listReser= new ArrayList<ReservationHotel>();
                   listReser = rs.getAllReservation();
                   reserData.clear();
                   reserData.addAll(listReser);

                   tabel.setItems(reserData);
                   dated.setCellValueFactory
                        (
                                new PropertyValueFactory<>("dated")
                        );
                   datef.setCellValueFactory
                        (
                                new PropertyValueFactory<>("datef")
                        );
                   etat.setCellValueFactory
                        (
                                new PropertyValueFactory<>("etat")
                        );
                   hotel.setCellValueFactory
                        (
                                new PropertyValueFactory<>("idhotel")
                        );
                   user.setCellValueFactory
                        (
                                new PropertyValueFactory<>("id_user")
                        );
                   
                   
                   
                   
    }    

    @FXML
    private void Refuser(ActionEvent event) throws SQLDataException, Exception {
          ReservationHotel userSelec = (ReservationHotel) tabel.getSelectionModel().getSelectedItem();
          idRes = userSelec.getIdResH();
                          if (userSelec.getEtat().equals("En Attent"))
        {
                 User u = us.findUserById(userSelec.getId_user());

                   Entity.mail.envoi(u.getEmail(), "Reservation ", "Votre Reservation est Refuser");
                   rs.Refuser(idRes);
                                  Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AfficheAdminReservationHotel.fxml"));
                            Stage myWindow = (Stage) tabel.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        }

      
        else{    
            Notifications.create().title("warnnig").text("Vérfier Vos Coordonne").position(Pos.BOTTOM_RIGHT).showError();

 
    }
    }

    @FXML
    private void Accepter(ActionEvent event) throws SQLDataException, Exception {
        
        
          ReservationHotel userSelec = (ReservationHotel) tabel.getSelectionModel().getSelectedItem();
          idRes = userSelec.getIdResH();
                          if (userSelec.getEtat().equals("En Attent"))
        {
               User u = us.findUserById(userSelec.getId_user());

                   Entity.mail.envoi(u.getEmail(), "Reservation ", "Votre Reservation est Accepter");
                   rs.Refuser(idRes);
                   rs.Acccepter(idRes);
                                  Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AfficheAdminReservationHotel.fxml"));
                            Stage myWindow = (Stage) tabel.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        }

      
        else{    
            Notifications.create().title("warnnig").text("Vérfier Vos Coordonne").position(Pos.BOTTOM_RIGHT).showError();

 
    }
    }
    
}
