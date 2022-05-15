/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Payment;
import Entity.Reservation;
import Entity.ReservationHotel;
import Entity.Services;
import Service.PaymentService;
import Service.ReservationHotelService;
import Service.Serviceservice;
import Service.Sessions;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Rzouga
 */
public class PaymentController implements Initializable {

    @FXML
    private Label somme;
    @FXML
    private ChoiceBox<String> type;

    ReservationHotelService rs = new ReservationHotelService();
    Serviceservice ss = new Serviceservice();
    @FXML
    private Label nbrj;
    @FXML
    private Label nbrnui;
    
        ReservationHotel r=rs.findReservationById(AfficheReservationHotelController.idRh);
        Services s = ss.findServiceByIdHotel(r.getIdhotel());
        PaymentService ps = new PaymentService();
        long diff = r.getDatef().getTime() - r.getDated().getTime();
	
        float res = (diff / (1000*60*60*24));
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
 
        

               System.out.println("Controller.PaymentController.initialize()"+res);
               nbrj.setText(String.valueOf(res));
               nbrnui.setText(String.valueOf(s.getPrix()));
               somme.setText(String.valueOf(s.getPrix()*res));
        
        type.getItems().add("Par cheque");
        type.getItems().add("Sue Place");
        type.getItems().add("En ligne");
        
        
    }    

    @FXML
    private void payer(ActionEvent event) throws SQLDataException, FileNotFoundException, DocumentException {
        
               if (type.getValue().equals("") )
        {
        Notifications.create().title("warnnig").text("Vérfier Vos Coordonne").position(Pos.BOTTOM_RIGHT).showError();

        }
               else{
                   Payment p = new Payment();
                   p.setSomme(s.getPrix()*res);
                   p.setType(type.getValue());
                   p.setIdUser(Sessions.getLoggedInUser().getId());
                   p.setIdH(r.getIdhotel());
                   pdf(p);
                   ps.Payer(p);
                   rs.Payer(AfficheReservationHotelController.idRh);
                   
                   
                  Notifications.create().title("Success").text("Payment Avec success").position(Pos.BOTTOM_RIGHT).showError();

                              Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AfficheReservationHotel.fxml"));
                            Stage myWindow = (Stage) type.getScene().getWindow();
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
    
    public void pdf (Payment py) throws FileNotFoundException, DocumentException{
    
    
        String file_name="C:\\Users\\msi\\Desktop\\Final\\pdf\\pdfpayment.pdf";
        Document document = new Document();
        
        PdfWriter.getInstance(document, new FileOutputStream(file_name));
        document.open();
        
        Paragraph p =new Paragraph("Somme est egale :"+py.getSomme()+"type est:"+py.getType());
        document.add(p);
        
        document.close();
    
    
    }
    
}
