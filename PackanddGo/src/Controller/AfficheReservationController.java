/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.AfficheStaffController.idE;
import static Controller.LoginController.IdOfUser;
import Entity.Reservation;
import Entity.User;
import Service.ReservationService;
import Service.Sessions;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.Date;
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
public class AfficheReservationController implements Initializable {

    @FXML
    private TableColumn<Date, Reservation> dateD;
    @FXML
    private TableColumn<Date, Reservation> dateF;
    @FXML
    private TableColumn<String, Reservation> guide;
    @FXML
    private TableColumn<String, Reservation> transport;
    
    private ObservableList<Reservation> reserData = FXCollections.observableArrayList();
    
    ReservationService rs = new ReservationService();
    @FXML
    private TableView<Reservation> tabel;
    
        public static int idR;
    @FXML
    private TableColumn<String,Reservation> etat;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                   List<Reservation> listReser= new ArrayList<Reservation>();
                   listReser = rs.getMesReservation(Sessions.getLoggedInUser().getId());
                   reserData.clear();
                   reserData.addAll(listReser);
                   tabel.setItems(reserData);
                   dateD.setCellValueFactory
                        (
                                new PropertyValueFactory<>("dated")
                        );
                   dateF.setCellValueFactory
                        (
                                new PropertyValueFactory<>("datef")
                        );
                   guide.setCellValueFactory
                        (
                                new PropertyValueFactory<>("etatGuide")
                        );
                   transport.setCellValueFactory
                        (
                                new PropertyValueFactory<>("idTr")
                        );
                                      etat.setCellValueFactory
                        (
                                new PropertyValueFactory<>("etat")
                        );
                   
    }    

    @FXML
    private void Modifier(ActionEvent event) {
  
                    Reservation userSelec = (Reservation) tabel.getSelectionModel().getSelectedItem();
                    idR = userSelec.getIdRes();
            
                          Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/ModifierReservation.fxml"));
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

    @FXML
    private void Supprimer(ActionEvent event) throws SQLDataException {
        
            Reservation userSelec = (Reservation) tabel.getSelectionModel().getSelectedItem();
            idR = userSelec.getIdRes();
            rs.deleteReservation(idR);
            resetTableData();
    
    }
    
    public void resetTableData() throws SQLDataException
    {
        List<Reservation> lisre = new ArrayList<>();
        lisre = rs.getMesReservation(Sessions.getLoggedInUser().getId());
        ObservableList<Reservation> data = FXCollections.observableArrayList(lisre);
        tabel.setItems(data);
    }

    @FXML
    private void back(ActionEvent event) {
        
                    
                          Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AcceuilClient.fxml"));
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
}
