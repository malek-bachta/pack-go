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
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author mbach
 */
public class AfficheController implements Initializable {

    @FXML
    private TableView<Hotels> table;
    @FXML
    private TableColumn<Hotels, Integer> idH;
    @FXML
    private TableColumn<Hotels, String> nomH;
    @FXML
    private TableColumn<Hotels, String> categoryH;
    @FXML
    private TableColumn<Hotels, String> adressH;
    @FXML
    private TableColumn<Hotels, String> email;
    @FXML
    private TableColumn<Hotels, Integer> tel;
    @FXML
    private TableColumn<Hotels, String> equipment;
    @FXML
    private Button add;
    @FXML
    private Button delete;

    private ObservableList<Hotels> userData = FXCollections.observableArrayList();
    HotelService hs = new HotelService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            List<Hotels> hotels = new ArrayList<Hotels>();
            hotels = hs.afficher();
            userData.clear();
            userData.addAll(hotels);
            table.setItems(userData);
            idH.setCellValueFactory(
                    new PropertyValueFactory<>("idH")
            );
            nomH.setCellValueFactory(
                    new PropertyValueFactory<>("nomH")
            );
            categoryH.setCellValueFactory(
                    new PropertyValueFactory<>("categorie")
            );
            adressH.setCellValueFactory(
                    new PropertyValueFactory<>("adresse")
            );
            email.setCellValueFactory(
                    new PropertyValueFactory<>("email")
            );
            tel.setCellValueFactory(
                    new PropertyValueFactory<>("telH")
            );
            equipment.setCellValueFactory(
                    new PropertyValueFactory<>("equipement")
            );
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // TODO
    }

    @FXML
    private void back_to_add(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ajout.fxml"));
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

    public static int idho;

    @FXML
    private void delete(ActionEvent event) throws SQLException {

        Hotels h = (Hotels) table.getSelectionModel().getSelectedItem();
        idho = h.getIdH();
        hs.supprimer(idho);
        resetTableData();

    }

    public void resetTableData() throws SQLDataException, SQLException {
        List<Hotels> h = new ArrayList<>();
        h = hs.afficher();
        ObservableList<Hotels> data = FXCollections.observableArrayList(h);
        table.setItems(data);
    }

    @FXML
    private void pdf(MouseEvent event) {
        System.out.println("To Printer!");
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            Window primaryStage = null;
            job.showPrintDialog(primaryStage);
            table.setVisible(true);
            Node root = table;
            job.printPage(root);
            job.endJob();
        }
    }

}