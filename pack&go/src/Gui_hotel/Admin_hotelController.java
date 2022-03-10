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
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author mbach
 */
public class Admin_hotelController implements Initializable {

    private PackListener packListener;
    @FXML
    private ScrollPane scrollHotel;
    @FXML
    private GridPane gridHotel;
    @FXML
    private TextField search_bar;
    @FXML
    private StackPane stackPane;

    private List<Hotels> hotel = new ArrayList<>();

    private List<Hotels> getData() {
        List<Hotels> hotelitem = new ArrayList<>();
        Hotels h;
        for (Hotels hotel : hotelData) {

            h = new Hotels();
            h.setNomH(hotel.getNomH());
            h.setCategorie(hotel.getCategorie());
            h.setAdresse(hotel.getAdresse());
            h.setEquipement(hotel.getEquipement());
            h.setImage(hotel.getImage());

            hotelitem.add(h);

        }
        return hotelitem;

    }
    public List<Hotels> hotelData = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HotelService sp = new HotelService();
        try {
            hotelData = sp.afficher();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        hotel.addAll(getData());

        int column = 0;
        int row = 0;
        try {
            for (int i = 0; i < hotel.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item_hotel.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                Item_hotelController hotel_item = fxmlLoader.getController();
                hotel_item.setData(hotel.get(i));
                if (column == 1) {
                    column = 0;
                    row++;
                }
                gridHotel.add(anchorPane, column++, row);
                gridHotel.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridHotel.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridHotel.setMaxWidth(Region.USE_PREF_SIZE);

                gridHotel.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridHotel.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridHotel.setMaxHeight(Region.USE_PREF_SIZE);
                gridHotel.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // TODO
    }

    @FXML
    private void Search(ActionEvent event) {
    }

}
