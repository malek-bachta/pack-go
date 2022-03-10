/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_transport;
import Entities_transport.Transport;
import Service_transport.TransportService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




/**
 * FXML Controller class
 *
 * @author Soulaima ben romdhan
 */
public class Front_transportController implements Initializable {

    
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
   
    @FXML
    private Button guide1;

    /**
     * Initializes the controller class.
     */
  
   private List<Transport> Transport = new ArrayList<>();
    @FXML
    private Button back5;
  
   
   
    private List<Transport> getData() {
        List<Transport> transportitem = new ArrayList<>();
        Transport t;
        for (Transport Transport : transportData) {

            t = new Transport();
            t.setType(Transport.getType());

            t.setNomagence(Transport.getNomagence());
            t.setPrix(Transport.getPrix());
            t.setDuree(Transport.getDuree());
            t.setDestination(Transport.getDestination());

            transportitem.add(t);

        }
        return transportitem;

    }
 public List<Transport> transportData = new ArrayList<>();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // TODO
            TransportService tp = new TransportService();
            try {
                transportData = tp.affichertransport1();
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
            }
      
        //Transport.addAll(getT());
        Transport.addAll(getData());
     //   Transport.addAll(getData());
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < Transport.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item_transport.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                Item_transportController transport_item = fxmlLoader.getController();
                transport_item.setData(Transport.get(i));
                if (column == 5) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                grid.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       
    }

    @FXML
    private void guide1(ActionEvent event) {
          Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Gui_guide/front_guide.fxml"));
            Stage myWindow = (Stage) guide1.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("ajouter guide ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void back5(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(".fxml"));
            Stage myWindow = (Stage) back5.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle(" return ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    


}




