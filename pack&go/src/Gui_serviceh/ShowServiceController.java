/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_serviceh;

import Service_serviceh.Serviceservice;
import Entities_serviceh.Services;
import static Gui_hotel.AfficheController.idho;
import Services_hotel.HotelService;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbach
 */
public class ShowServiceController implements Initializable {

    @FXML
    private TableView<Services> table;
    @FXML
    private TableColumn<Services, Integer> idS;
    @FXML
    private TableColumn<Services, String> formileS;
    @FXML
    private TableColumn<Services, String> sejourS;
    @FXML
    private TableColumn<Services, String> activityS;
    @FXML
    private TableColumn<Services, Float> priceS;
    @FXML
    private TableColumn<Services, String> disponibility;
    @FXML
    private Button add;
    @FXML
    private Button deleteS;

     private ObservableList<Services> userData = FXCollections.observableArrayList();
    Serviceservice hs = new Serviceservice();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            // TODO
            List<Services> s = new ArrayList<Services>();
            s = hs.afficher();
            userData.clear();
            userData.addAll(s);
            table.setItems(userData);
            idS.setCellValueFactory(
                    new PropertyValueFactory<>("idS")
            );
            formileS.setCellValueFactory(
                    new PropertyValueFactory<>("formule")
            );
            sejourS.setCellValueFactory(
                    new PropertyValueFactory<>("sejours")
            );
            activityS.setCellValueFactory(
                    new PropertyValueFactory<>("activite")
            );
            priceS.setCellValueFactory(
                    new PropertyValueFactory<>("prix")
            );
            disponibility.setCellValueFactory(
                    new PropertyValueFactory<>("etat")
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
            root = FXMLLoader.load(getClass().getResource("AjoutService.fxml"));
            Stage myWindow = (Stage) add.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("add service ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
public static int idho;
    @FXML
    private void deleteS(ActionEvent event) throws SQLException {
         Services h = (Services) table.getSelectionModel().getSelectedItem();
        idho = h.getIdS();
        hs.supprimer(idho);
        resetTableData();
    }
     public void resetTableData() throws SQLDataException, SQLException {
        List<Services> h = new ArrayList<>();
        h = hs.afficher();
        ObservableList<Services> data = FXCollections.observableArrayList(h);
        table.setItems(data);
    }

}
