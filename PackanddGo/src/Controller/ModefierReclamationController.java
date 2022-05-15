/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.BadWords;
import Entity.Reclamation;
import Service.ReclamationService;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Rzouga
 */
public class ModefierReclamationController implements Initializable {

    @FXML
    private TextField sujet;
    @FXML
    private TextArea contenue;
    
    
    ReclamationService rs = new ReclamationService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Reclamation r =rs.findReclamationById(MesReclamationsController.idRec);
        
        sujet.setText(r.getSujet());
        contenue.setText(r.getContenue());
    }    

    @FXML
    private void envoyer(ActionEvent event) throws SQLDataException {
        
 Reclamation r = new Reclamation();
                BadWords.loadConfigs();

       if (contenue.getText().equals("") || sujet.getText().equals("") )
        {
        Notifications.create().title("warnnig").text("Vérfier Vos Coordonne").position(Pos.BOTTOM_RIGHT).showError();

        }
                        else
        
                        {
                            
                            System.out.println("Controller.AjouterReclamationController.envoyer()"+BadWords.filterText(contenue.getText()));
        if (BadWords.filterText(contenue.getText())) {
            
       Notifications notificationBuilder = Notifications.create()
               .title("Alert").text("cette application n'autorise pas ces termes").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
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
        r.setContenue(contenue.getText());
        r.setSujet(sujet.getText());
        r.setIdrec(MesReclamationsController.idRec);

        
        rs.modifieReclamation(r);
        
                                  Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/MesReclamations.fxml"));
                            Stage myWindow = (Stage) sujet.getScene().getWindow();
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
