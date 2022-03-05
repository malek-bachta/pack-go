/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_transport;

import Entities_transport.Transport;
import Service_guide.TransportService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Soulaima ben romdhan
 */
public class AfficherTController implements Initializable {

    @FXML
    private TableColumn<Transport, Integer> id;
    @FXML
    private TableColumn<Transport, String> type;
    @FXML
    private TableColumn<Transport, String> nom;
    @FXML
    private TableColumn<Transport, Float> prix;
    @FXML
    private TableColumn<Transport, String> duree;
    @FXML
    private TableColumn<Transport, String> destination;
    @FXML
    private TableView<Transport> table;
    @FXML
    private Button back;

    
    
    private ObservableList<Transport> userData = FXCollections.observableArrayList();
    TransportService ts = new TransportService();
    
    
    @FXML
    private Button delete;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
         try {
            // TODO
            List<Transport> t = new ArrayList<Transport>();
            t = ts.affichertransport();
            userData.clear();
            userData.addAll(t);
            table.setItems(userData);
            id.setCellValueFactory(
                    new PropertyValueFactory<>("id")
            );
            type.setCellValueFactory(
                    new PropertyValueFactory<>("type")
            );
            nom.setCellValueFactory(
                    new PropertyValueFactory<>("nomagence")
            );
            prix.setCellValueFactory(
                    new PropertyValueFactory<>("prix")
            );
            duree.setCellValueFactory(
                    new PropertyValueFactory<>("duree")
            );
            destination.setCellValueFactory(
                    new PropertyValueFactory<>("destination")
            );
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    
    
    
   /* private void affichertranspo(ActionEvent event) {
        TransportService sp= new TransportService();
        try {
            listT.setText(sp.affichertransport().toString());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
    
    
    

    @FXML
    private void affichertranspo(ActionEvent event) {
    }
    
     private void back(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ajouterT.fxml"));
            Stage myWindow = (Stage) back.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("ajouter ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
public static int idt;
    @FXML
    private void delete(ActionEvent event) throws SQLException {
        
        Transport t = (Transport) table.getSelectionModel().getSelectedItem();
        idt = t.getId();
        ts.supprimertransport(idt);
        resetTableData();
    }
     public void resetTableData() throws SQLDataException, SQLException {
        List<Transport> t = new ArrayList<>();
        t = ts.affichertransport();
        ObservableList<Transport> data = FXCollections.observableArrayList(t);
        table.setItems(data);
    }
  
 
}
