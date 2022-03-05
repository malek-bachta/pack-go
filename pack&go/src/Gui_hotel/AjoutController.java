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
import java.util.ResourceBundle;
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
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbach
 */
public class AjoutController implements Initializable {

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
    private Button add;
    @FXML
    private Button show_list;
    @FXML
    private AnchorPane ajout;
    @FXML
    private Button add_service;
    @FXML
    private Button modify;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void add_persom(ActionEvent event) {
        if ((nameH.getText().isEmpty() == false)
                && (categoryH.getText().isEmpty() == false)
                && (adressH.getText().isEmpty() == false)
                && (verif_adress()) && (verif_phone()) && (verif_mail())
                && (equipement.getText().isEmpty() == false)) {
            String name = nameH.getText();
            String gategory = categoryH.getText();
            String adress = adressH.getText();
            String email = this.email.getText();
            int tel = Integer.parseInt(telH.getText());
            String equipment = equipement.getText();

            Hotels h = new Hotels(name, gategory, adress, email, tel, equipment);
            HotelService hs = new HotelService();

            try {
                hs.ajouter(h);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Hotel is added successfully!");
                alert.show();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("affiche.fxml"));
            Stage myWindow = (Stage) show_list.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("Uotel Data Update");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        } else {

            BoxBlur blur = new BoxBlur(3, 3, 3);
            ajout.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR ");
            alert.setContentText("Please check your fields!!");
            alert.showAndWait();
            ajout.setEffect(null);
            System.out.println("Impsible");

        }

    }

    private void initialize(ActionEvent event) {

    }

    @FXML
    private void show_list(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("affiche.fxml"));
            Stage myWindow = (Stage) show_list.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("page name");
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

    @FXML
    private void add_service(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Gui_serviceh/AddService.fxml"));
            Stage myWindow = (Stage) show_list.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("page name");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void modify(ActionEvent event) {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Modifier.fxml"));
            Stage myWindow = (Stage) modify.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("Uotel Data Update");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
