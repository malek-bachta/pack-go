/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Guide;
import Service.GuideService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Soulaima ben romdhan
 */
public class Front_guideController implements Initializable {

    @FXML
    private ScrollPane scrol;
    @FXML
    private GridPane gridd;

    /**
     * Initializes the controller class.
     */
        private List<Guide> Guide = new ArrayList<>();

    private List<Guide> getData() {
        List<Guide> guideitem = new ArrayList<>();
        Guide g;
       
        for (Guide Guide : guideData) {

            g = new Guide();
            g.setNom(Guide.getNom());
            g.setPrenom(Guide.getPrenom());
            g.setType(Guide.getType());
            g.setPrix(Guide.getPrix());
           

            guideitem.add(g);

        }
        return guideitem;

    }
    public List<Guide> guideData = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GuideService gs = new GuideService();
        try {
            guideData = gs.afficheguide();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Guide.addAll(getData());

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < Guide.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item_guide.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                Item_guideController guideitem = fxmlLoader.getController();
                guideitem.setData(Guide.get(i));
                
                
                if (column == 3) {
                    column = 0;
                    row++;
                }
                gridd.add(anchorPane, column++, row);
                gridd.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridd.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridd.setMaxWidth(Region.USE_PREF_SIZE);                                                        
                gridd.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridd.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridd.setMaxHeight(Region.USE_PREF_SIZE);
                gridd.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException ex) {
          System.out.println(ex.getMessage());
        }

        // TODO
    }    
    
}
