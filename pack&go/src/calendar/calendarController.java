/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import com.jfoenix.controls.JFXDatePicker;
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
}


