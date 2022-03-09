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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Soulaima ben romdhan
 */
public class Front_transportController implements Initializable {

    @FXML
    private Button search;
    @FXML
    private Button add;
    @FXML
    private VBox choose;
    @FXML
    private Label type;
    @FXML
    private Label prix;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     */
    private List<Transport> transport = new ArrayList<>();

    private List<Transport> getData() {
        List<Transport> transportitem = new ArrayList<>();
        Transport t;
        for (Transport transport : transportData) {

            t = new Transport();
            t.setType(transport.getType());

            t.setNomagence(transport.getNomagence());
            t.setPrix(transport.getPrix());

            t.setDestination(transport.getDestination());

            transportitem.add(t);

        }
        return transportitem;

    }
    public List<Transport> transportData = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TransportService tp = new TransportService();
        try {
            transportData = tp.affichertransport();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        transport.addAll(getData());

        int column = 0;
        int row = 0;
        try {
            for (int i = 0; i < transport.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item_transport.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                Item_transportController trasportitem = fxmlLoader.getController();
                trasportitem.setData(transport.get(i));
                if (column == 1) {
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
        // TODO
    }

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void add(ActionEvent event) {
    }

}
