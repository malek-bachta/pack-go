/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author MSI
 */
public class calendarController implements Initializable {

    @FXML
    private JFXDatePicker dtPicker;
    @FXML
    private Button btnDate;
    @FXML
    private Label lblDate;
    @FXML
    private Button rout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onDate(ActionEvent event) {
        LocalDate lDate = dtPicker.getValue();
        lblDate.setText(formatDate(lDate.toString()));
    }
    
   
    
    
    
    public String formatDate(String Date) {
        SimpleDateFormat sdf =null ;
        Date d = null ;
        try {
            sdf = new SimpleDateFormat("yy-MM-dd");
            d = sdf.parse(Date);
            sdf.applyPattern("EEEE d MMM YYYY");
         }catch (ParseException e){
             System.out.println(e);
         }
        return sdf.format(d);
    }

    @FXML
    private void rout(ActionEvent event) {
          Parent  root;
        try {
          root = FXMLLoader.load(getClass().getResource("/Gui_offre/offre.fxml"));
            Stage myWindow = (Stage) rout.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle(" ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


