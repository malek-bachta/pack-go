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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbach
 */
public class AddServiceController implements Initializable {

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
        if ((formuleS.getText().isEmpty() == false)
                && (sejourS.getText().isEmpty() == false)
                && (priceS.getText().isEmpty() == false)
                && (activityS.getText().isEmpty() == false)
                && (disponibility.getText().isEmpty() == false)
                && (verif_formule())
                && (verif_sejours())
                && (verif_prix())
                && (verif_disponibility())
                && (verif_activity())) {
            Services s = new Services(formuleS.getText(), sejourS.getText(), Float.parseFloat(priceS.getText()), activityS.getText(), disponibility.getText());
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
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("ShowService.fxml"));
                Stage myWindow = (Stage) add.getScene().getWindow();
                Scene sc = new Scene(root);
                myWindow.setScene(sc);
                myWindow.setTitle("page name");
                //myWindow.setFullScreen(true);
                myWindow.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            BoxBlur blur = new BoxBlur(3, 3, 3);
            add.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR ");
            alert.setContentText("Please check your fields!!");
            alert.showAndWait();
            add.setEffect(null);
            System.out.println("Imposible");
        }
    }

    @FXML
    private void show_service(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ShowService.fxml"));
            Stage myWindow = (Stage) show_service.getScene().getWindow();
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

    @FXML
    private void modify(ActionEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ModifyService.fxml"));
            Stage myWindow = (Stage) modify.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("Modify Service");
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
