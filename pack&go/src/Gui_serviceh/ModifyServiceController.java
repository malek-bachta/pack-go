/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_serviceh;

import Entities_serviceh.Services;
import Gui_hotel.ModifierController;
import Service_serviceh.Serviceservice;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbach
 */
public class ModifyServiceController implements Initializable {

    @FXML
    private TextField formuleS;
    @FXML
    private TextField sejourS;
    @FXML
    private TextField priceS;
    @FXML
    private TextField activityS;
    @FXML
    private Button show_service;
    @FXML
    private Button modif;
    @FXML
    private TextField disponibility;

    Services s = new Services();
    List<Services> liste = new ArrayList<>();
    @FXML
    private Button add_service;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Serviceservice sp = new Serviceservice();
        try {
            liste = sp.afficherid(0);
        } catch (SQLException ex) {
            Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }

        liste.forEach((l) -> {
            formuleS.setText(l.getFormule());
            sejourS.setText(l.getSejours());
            priceS.setText(Float.toString(l.getPrix()));
            activityS.setText(l.getActivite());
            disponibility.setText(l.getEtat());

        });
    }

    @FXML
    private void show_service(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ShowService.fxml"));
            Stage myWindow = (Stage) show_service.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("Service List");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void modif(ActionEvent event) {
        String formule = formuleS.getText();
        String sejour = sejourS.getText();
        Float prix = Float.parseFloat(priceS.getText());
        String activity = activityS.getText();
        String dispo = disponibility.getText();

        Services p = new Services(formule, sejour, prix, activity, dispo);
        Serviceservice sp = new Serviceservice();
        sp.modifier(9, formule, prix, sejour, activity, dispo);

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ShowService.fxml"));
            Stage myWindow = (Stage) show_service.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("Hotels List ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
@FXML
  
    private void add_service(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AddService.fxml"));
            Stage myWindow = (Stage) add_service.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("Service List");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private boolean verif_formule() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(formuleS.getText());
        if (m.find() && m.group().equals(formuleS.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Imput in Service Formula !!");
            alert.showAndWait();
            return false;
        }
    }

    @FXML
    private boolean verif_sejours() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(sejourS.getText());
        if (m.find() && m.group().equals(sejourS.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Imput in stay !!");
            alert.showAndWait();
            return false;
        }
    }

    @FXML
    private boolean verif_prix() {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(priceS.getText());

        if (m.find() && m.group().equals(priceS.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Imput in Price !!");
            alert.showAndWait();
            return false;
        }
    }

    @FXML
    private boolean verif_activity() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(activityS.getText());
        if (m.find() && m.group().equals(activityS.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Imput in Activity !!");
            alert.showAndWait();
            return false;
        }
    }

    @FXML
    private boolean verif_disponibility() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(disponibility.getText());
        if (m.find() && m.group().equals(disponibility.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Imput in Service disponibility !!");
            alert.showAndWait();
            return false;
        }
    }

    
    }
