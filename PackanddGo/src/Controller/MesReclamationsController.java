/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.AfficheReservationHotelController.idRh;
import Entity.Reclamation;
import Entity.ReservationHotel;
import Service.ReclamationService;
import Service.ReservationHotelService;
import Service.ReservationService;
import Service.Sessions;
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
public class MesReclamationsController implements Initializable {

    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<Reclamation, String> sujet;
    @FXML
    private TableColumn<Reclamation, String> contenue;
    @FXML
    private TableColumn<Reclamation, String> date;
    @FXML
    private TableColumn<Reclamation, String> etat;
    
    ReclamationService rs = new ReclamationService();
    
    private ObservableList<Reclamation> reserData = FXCollections.observableArrayList();
    
    public  static int idRec ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                   List<Reclamation> listReser= new ArrayList<Reclamation>();
                   listReser = rs.getMesclamation(Sessions.getLoggedInUser().getId());
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
                   date.setCellValueFactory
                        (
                                new PropertyValueFactory<>("date")
                        );
                   etat.setCellValueFactory
                        (
                                new PropertyValueFactory<>("etat")
                        );
    }    

    @FXML
    private void supprimer(ActionEvent event) throws SQLDataException {
        
            Reclamation userSelec = (Reclamation) table.getSelectionModel().getSelectedItem();
            idRec = userSelec.getIdrec();
                                
                    if (userSelec.getEtat().equals("Traité")){
                    
              Notifications.create().title("warnnig").text("Cette réclamation est déja traiter").position(Pos.BOTTOM_RIGHT).showError();

                    
                    }else{
            rs.deleteReclamation(idRec);
            resetTableData();
                    }
        
    }

    @FXML
    private void Modifier(ActionEvent event) {
            Reclamation userSelec = (Reclamation) table.getSelectionModel().getSelectedItem();
            idRec = userSelec.getIdrec();
                                
                    if (userSelec.getEtat().equals("Traité")){
                    
              Notifications.create().title("warnnig").text("Cette réclamation est déja traiter").position(Pos.BOTTOM_RIGHT).showError();

                    
                    }else{
              Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/ModefierReclamation.fxml"));
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
    
        
    public void resetTableData() throws SQLDataException
    {
        List<Reclamation> lisre = new ArrayList<>();
        lisre = rs.getMesclamation(Sessions.getLoggedInUser().getId());
        ObservableList<Reclamation> data = FXCollections.observableArrayList(lisre);
        table.setItems(data);
    }

    @FXML
    private void back(ActionEvent event) {
        
        
             
              Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AcceuilClient.fxml"));
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
