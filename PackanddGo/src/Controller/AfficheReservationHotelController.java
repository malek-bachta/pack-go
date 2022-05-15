


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.AfficheReservationController.idR;
import static Controller.LoginController.IdOfUser;
import Entity.Reservation;
import Entity.ReservationHotel;
import Service.ReservationHotelService;
import Service.ReservationService;
import Service.Sessions;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Rzouga
 */
public class AfficheReservationHotelController implements Initializable {

    @FXML
    private TableColumn<Date, ReservationHotel> dateD;
    @FXML
    private TableColumn<Date, ReservationHotel> dateF;
    @FXML
    private TableColumn<String, ReservationHotel> guide;
    @FXML
    private TableColumn<String, ReservationHotel> transport;
    
    private ObservableList<ReservationHotel> reserData = FXCollections.observableArrayList();
    
    ReservationHotelService rs = new ReservationHotelService();
    @FXML
    private TableView<ReservationHotel> tabel;
    
    public static int idRh;
    @FXML
    private TextField rechercher;
    @FXML
    private TableColumn<ReservationHotel, String> etat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            List<ReservationHotel> listReser= new ArrayList<ReservationHotel>();
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
                                new PropertyValueFactory<>("etatSer")
                        );
                   transport.setCellValueFactory
                        (
                                new PropertyValueFactory<>("idhotel")
                        );
                                      etat.setCellValueFactory
                        (
                                new PropertyValueFactory<>("etat")
                        );
    }    

    @FXML
    private void Modifier(ActionEvent event) {
        
        
                    ReservationHotel userSelec = (ReservationHotel) tabel.getSelectionModel().getSelectedItem();
                    idRh = userSelec.getIdResH();
                              if (userSelec.getEtat().equals("En Attent"))
        {
            
                          Parent root;
                        IdOfUser=0;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/ModifierReservationHotel.fxml"));
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
                   Notifications.create().title("warnnig").text("Cette Reservation est déja Traité").position(Pos.BOTTOM_RIGHT).showError();

                                }
 
        
        
    }

    @FXML
    private void Supprimer(ActionEvent event) throws SQLDataException {
        
            ReservationHotel userSelec = (ReservationHotel) tabel.getSelectionModel().getSelectedItem();
            idRh = userSelec.getIdResH();
                                          if (userSelec.getEtat().equals("En Attent"))
        {
            rs.deleteReservation(idRh);
            resetTableData();
        }else{
        Notifications.create().title("warnnig").text("Cette Reservation est déja Traité").position(Pos.BOTTOM_RIGHT).showError();

                    
                    }
    
    }
    
    public void resetTableData() throws SQLDataException
    {
        List<ReservationHotel> lisre = new ArrayList<>();
        lisre = rs.getMesReservation(Sessions.getLoggedInUser().getId());
        ObservableList<ReservationHotel> data = FXCollections.observableArrayList(lisre);
        tabel.setItems(data);
    }

    @FXML
    private void rechercher(ActionEvent event) {
          List<ReservationHotel> list = rs.getMesReservation(Sessions.getLoggedInUser().getId());
            
            //tableview.setItems(observablelist);
            
            FilteredList<ReservationHotel> filtredData= new FilteredList<>(reserData, b ->true);
            rechercher.textProperty().addListener((observable,oldValue,newValue) -> {
                Predicate<? super ReservationHotel> Reservation;
                filtredData.setPredicate((ReservationHotel dons) -> {
                    if (newValue == null || newValue.isEmpty()){
                        return true;
                    }
                 
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                     String strDate = dateFormat.format(dons.getDated());  
                     String strDate2 = dateFormat.format(dons.getDatef());  

                    System.out.print("date"+strDate);
                    String lowerCaseFilter = newValue.toLowerCase();
                    if(strDate.toLowerCase().indexOf(lowerCaseFilter) != -1 ){
                        return true;
                    }
                    else if (strDate2.toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true; // Filter matches last name.
                    }
                    
                    else
                        return false;
                } );
            });
             // 3. Wrap the FilteredList in a SortedList. 
        SortedList<ReservationHotel> sortedData = new SortedList<>(filtredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tabel.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tabel.setItems(sortedData);
  
      
  
    }

    @FXML
    private void Payer(ActionEvent event) {
        
        
                
                    ReservationHotel userSelec = (ReservationHotel) tabel.getSelectionModel().getSelectedItem();
                    idRh = userSelec.getIdResH();
                              if (userSelec.getEtat().equals("accepter"))
                    {
            
                          Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/Payment.fxml"));
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
                   Notifications.create().title("warnnig").text("Cette Reservation est déja Traité").position(Pos.BOTTOM_RIGHT).showError();

                                }
        
        
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
