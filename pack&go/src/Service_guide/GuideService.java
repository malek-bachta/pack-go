/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_guide;

import Entities_guide.Guide;
import Entities_transport.Transport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javafx.scene.input.KeyCode.G;

import utils.MyDB;

/**
 *
 * @author Soulaima ben romdhan
 */
public class GuideService implements Iguide<Guide> {

    Connection connexion;
    Statement stm;

    public GuideService() {
        connexion = MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajouterguide(Guide g) throws SQLException {

        String req = "INSERT INTO `guide` (`nom`,`prenom`,`type`,`prix`) VALUES ( '"
                + g.getNom()+ "', '" + g.getPrenom() + "', '" + g.getType() + "' ,'" + g.getPrix() + "') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);

    }

    @Override
    public List<Guide> afficheguide() throws SQLException {

        List<Guide> Guide = new ArrayList<>();
        String req = "select * from guide";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Guide g = new Guide(rst.getInt("id"),//or rst.getInt(1)
                    rst.getString("nom"),
                    rst.getString("prenom"),
                    rst.getString("type"),
                    rst.getFloat("prix"));
            Guide.add(g);
        }
        return Guide;
    }

    @Override
    public void supprimerguide(int id) throws SQLException {
        String req = "DELETE FROM guide WHERE  id=" + id;
        try {
            stm = connexion.createStatement();
            stm.executeUpdate(req);
            System.out.println("guide Supprimé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     @Override
    public List<Guide> modifierguide(int id, String nom, String prenom, String type, float prix)
    {
        List<Guide> Guide = new ArrayList<>();
         try {
             String req= "UPDATE guide SET nom='" + nom + "',prenom='" +prenom+ "' ,type='" + type+ "',prix='" +prix+ "' WHERE id=" +id;
             
             PreparedStatement pre=connexion.prepareStatement(req);          
            pre.executeUpdate();
            System.out.println("transport Modifiée");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Guide;
}  
       
    
/*
    public ObservableList<Guide> search(String input) {
        ObservableList<Guide> Guide = FXCollections.observableArrayList();

        try {
            Statement stm;
            stm = connexion.createStatement();
            String query = "SELECT * "
                    + "FROM guide "
                    + " where nom like '%" + input + "%' ";
            ResultSet rst = stm.executeQuery(query);
            while (rst.next()) {
                Guide g = new Guide();
                g.setNom(rst.getString("nom"));
                g.setPrenom(rst.getString("prenom"));
                g.setType(rst.getString("type"));
                g.setPrix(rst.getFloat("prix"));

                Guide.add(g);

            }

        } catch (SQLException ex) {
            Logger.getLogger(TransportService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Guide;
    }

    
    */
    
    
     public List<Guide> Tri() throws SQLException {
        Comparator<Guide> comparator = Comparator.comparing(Guide::getPrix);
        List<Guide> Guide = afficheguide();
          return Guide.stream().sorted(comparator).collect(Collectors.toList());
  }  

    
    
    
    public List<Guide> afficheguideid(int id) throws SQLException {

        List<Guide> Guide = new ArrayList<>();
        String req = "select * from guide where id=3";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Guide g = new Guide(rst.getInt("id"),//or rst.getInt(1)
                    rst.getString("nom"),
                    rst.getString("prenom"),
                    rst.getString("type"),
                    rst.getFloat("prix"));
            Guide.add(g);
        }
        return Guide;
    }

    public void modifiertransport(int i, String type1, String nom, Float prix1, String duree1, String destination1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
}
