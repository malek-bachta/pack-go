/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_hotel;

import Entities_hotel.Hotels;
import Services_hotel.HotelService;
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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author mbach
 */
public class ModifierController implements Initializable {

    @FXML
    private TextField nameH;
    @FXML
    private TextField categoryH;
    @FXML
    private TextField adressH;
    @FXML
    private TextField email;
    @FXML
    private TextField telH;
    @FXML
    private TextField equipement;
    @FXML
    private Button show_list;
    @FXML
    private Button modify;
    @FXML
    private Button add_service;
    @FXML
    private AnchorPane ajout;
    Hotels pdetails = new Hotels();
    List<Hotels> liste = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        HotelService sp = new HotelService();
        try {
            liste = sp.afficherid(0);
        } catch (SQLException ex) {
            Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }

        liste.forEach((l) -> {
            nameH.setText(l.getNomH());
            categoryH.setText(l.getCategorie());
            email.setText(l.getEmail());
            equipement.setText(l.getEquipement());
            telH.setText(Integer.toString(l.getTelH()));
            adressH.setText(l.getAdresse());

        });

    }

    @FXML
    private void show_list(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("affiche.fxml"));
            Stage myWindow = (Stage) show_list.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("Hotels List");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void modify(ActionEvent event) {

        String category = categoryH.getText();
        String equipemen = equipement.getText();

        Hotels p = new Hotels(category, equipemen);
        HotelService sp = new HotelService();
        sp.modifier(40, category, equipemen);

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("affiche.fxml"));
            Stage myWindow = (Stage) modify.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("Service List ");
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
            root = FXMLLoader.load(getClass().getResource("/Gui_serviceh/AjoutService.fxml"));
            Stage myWindow = (Stage) show_list.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("Add Hotel Service");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private Boolean verif_name(ActionEvent event) {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(adressH.getText());
        if (m.find() && m.group().equals(adressH.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Imput Hotel name !!");
            alert.showAndWait();
            return false;
        }

    }

    @FXML
    private Boolean verif_category(ActionEvent event) {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(adressH.getText());
        if (m.find() && m.group().equals(adressH.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Imput in Category!!");
            alert.showAndWait();
            return false;
        }
    }

    @FXML

    private boolean verif_adress() {

        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(adressH.getText());
        if (m.find() && m.group().equals(adressH.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Imput in Adress !!");
            alert.showAndWait();
            return false;
        }
    }

    @FXML

    private boolean verif_mail() {
        Pattern p = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher m = p.matcher(email.getText());

        if (m.find() && m.group().equals(email.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Imput in Email!!");
            alert.showAndWait();
            return false;
        }
    }

    @FXML
    private boolean verif_phone() {
        Pattern p = Pattern.compile("[2-9]{1}[0-9]{7}$");
        Matcher m = p.matcher(telH.getText());

        if (m.find() && m.group().equals(telH.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Imput in Phone Number !!");
            alert.showAndWait();
            return false;
        }
    }

}
