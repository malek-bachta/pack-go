/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import Entity.packs;
import Service.Servicepack;
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

import javafx.scene.control.ScrollPane;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author MSI
 */
public class Front_packsController implements Initializable {

    @FXML
    private ScrollPane scrolpacks;
    @FXML
    private GridPane Gridpacks;

    /**
     * Initializes the controller class.
     */
    private List<packs> packs = new ArrayList<>();
    @FXML
    private Button back;

    private List<packs> getData() {
        List<packs> packitem = new ArrayList<>();
        packs p;
        for (packs packs : packsData) {

            p = new packs();
            p.setNom_pack(packs.getNom_pack());
            p.setTexte(packs.getTexte());
            p.setService(packs.getService());
            p.setGuide(packs.getGuide());
            p.setDestination(packs.getDestination());
            p.setBudget_pack(packs.getBudget_pack());

            packitem.add(p);

        }
        return packitem;

    }
    public List<packs> packsData = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Servicepack sp = new Servicepack();
        try {
            packsData = sp.afficherpacks();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        packs.addAll(getData());

        int column = 0;
        int row = 0;
        try {
            for (int i = 0; i < packs.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("pack_item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                Pack_itemController pack_item = fxmlLoader.getController();
                pack_item.setData(packs.get(i));
                if (column == 1) {
                    column = 0;
                    row++;
                }
                Gridpacks.add(anchorPane, column++, row);
                Gridpacks.setMinWidth(Region.USE_COMPUTED_SIZE);
                Gridpacks.setPrefWidth(Region.USE_COMPUTED_SIZE);
                Gridpacks.setMaxWidth(Region.USE_PREF_SIZE);

                Gridpacks.setMinHeight(Region.USE_COMPUTED_SIZE);
                Gridpacks.setPrefHeight(Region.USE_COMPUTED_SIZE);
                Gridpacks.setMaxHeight(Region.USE_PREF_SIZE);
                Gridpacks.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
          System.out.println(ex.getMessage());
        }

        // TODO
    }

    @FXML
    private void back(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AcceuilClient.fxml"));
            Stage myWindow = (Stage) back.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle(" ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
