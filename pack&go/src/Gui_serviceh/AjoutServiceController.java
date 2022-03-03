/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_serviceh;

import Service_serviceh.Serviceservice;
import Entities_serviceh.Services;
import Services_hotel.HotelService;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbach
 */
public class AjoutServiceController implements Initializable {

    @FXML
    private Button add;
    @FXML
    private Button show_service;
    @FXML
    private Button modify;
    @FXML
    private Button add_hotel;
    @FXML
    private TextField formuleS;
    @FXML
    private TextField sejourS;
    @FXML
    private TextField priceS;
    @FXML
    private TextField activityS;
    @FXML
    private TextField disponibility;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void add_service(ActionEvent event) {
        String formula = formuleS.getText();
        String sejours = sejourS.getText();
        float prix = Float.parseFloat(priceS.getText());
        String activite = activityS.getText();
        String dispoo = disponibility.getText();

        Services s = new Services(formula, sejours, prix, activite, dispoo);
        Serviceservice hs = new Serviceservice();

        try {
            hs.ajouter(s);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("service is added successfully!");
            alert.show();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void show_service(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ShowService.fxml"));
            Stage myWindow = (Stage) add.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("list service ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void modify(ActionEvent event) {
    }

    @FXML
    private void add_hotel(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Gui_hotel/ajout.fxml"));
            Stage myWindow = (Stage) add.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("add hotel ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
