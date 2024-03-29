/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Reservation;
import Entity.ReservationHotel;
import Service.ReservationHotelService;
import Service.ReservationService;
import Service.Sessions;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Rzouga
 */
public class ModifierReservationHotelController implements Initializable {

    @FXML
    private DatePicker dateD;
    @FXML
    private DatePicker dateF;
    @FXML
    private ChoiceBox<String> guide;
    @FXML
    private Button Ajouter;

    ReservationHotelService rs = new ReservationHotelService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        guide.getItems().add("ponsion Complet");
        guide.getItems().add("demi-ponsion");
        ReservationHotel r = rs.findReservationById(AfficheReservationHotelController.idRh);

        dateD.setValue(r.getDated().toLocalDate());
        dateF.setValue(r.getDatef().toLocalDate());
        
        
    }    

    @FXML
    private void Ajouter(ActionEvent event) throws SQLDataException {
        
    
                if (dateF.getValue()==null || dateD.getValue() ==null ||guide.getValue()==null)
        {
        Notifications.create().title("warnnig").text("Vérfier Vos Coordonne").position(Pos.BOTTOM_RIGHT).showError();

        }
        else{              
        ReservationHotel r =  new ReservationHotel();
        
         LocalDate d = LocalDate.now();
        Date date = java.sql.Date.valueOf(d);

        java.sql.Date dd = java.sql.Date.valueOf(dateD.getValue());
       
        java.sql.Date df = java.sql.Date.valueOf(dateF.getValue());
       long diff = dd.getTime() - date.getTime();
       long diff1 = df.getTime() - dd.getTime();

       float res1 = (diff / (1000*60*60*24));
       float res2 = (diff1 / (1000*60*60*24));
       
       if (res1<0){
       
                   Notifications notificationBuilder = Notifications.create()
               .title("Alert").text("Aujourd'hui est "+date).graphic(null).hideAfter(javafx.util.Duration.seconds(5))
               .position(Pos.CENTER_LEFT)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {
                       System.out.println("clicked ON ");
               }});
       notificationBuilder.darkStyle();
       notificationBuilder.show();
          }
       
       else if(res2<0){
       
                          Notifications notificationBuilder = Notifications.create()
               .title("Alert").text("vérifier votre date").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
               .position(Pos.CENTER_LEFT)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {
                       System.out.println("clicked ON ");
               }});
       notificationBuilder.darkStyle();
       notificationBuilder.show();
       
       
       
       }
       else{
       
       
        r.setDatef((java.sql.Date) df);
        r.setDated(dd);
        r.setIdResH(AfficheReservationHotelController.idRh);
        
        if(guide.getValue().equals("ponsion Complet"))
            r.setEtatSer(0);
        else
            r.setEtatSer(1);
        
            rs.modifieReservation(r);
            
            
                      Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AfficheReservationHotel.fxml"));
                            Stage myWindow = (Stage) guide.getScene().getWindow();
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
    
}
