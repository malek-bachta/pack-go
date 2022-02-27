/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services_hotel;

import Entities_hotel.Hotels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author mbach
 */
public class HotelService implements service<Hotels> {

    Connection connexion;
    Statement stm;

    public HotelService() {
        connexion = MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajouter(Hotels h) throws SQLException {
        
        String req = "INSERT INTO `hotels` ( `nomH`, `categorie`, `adresse`, `email`, `telH`, `equipement`) VALUES"
                + " ('" + h.getNomH() + "', '" + h.getCategorie() + "', '" + h.getAdresse() + "', '" + h.getEmail()
                + "', '" + h.getTelH() + "', '" + h.getEquipement() + "');";
        stm = connexion.createStatement();
        stm.executeUpdate(req);

    }

    @Override
    public List<Hotels> afficher() throws SQLException {
        List<Hotels> hotels = new ArrayList<>();
        String req = "select * from hotels";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Hotels h = new Hotels(rst.getInt("idH"),
                    rst.getString("nomH"),
                    rst.getString("categorie"),
                    rst.getString("adresse"),
                    rst.getString("email"),
                    rst.getInt("telH"),
                    rst.getString("equipement"));
            hotels.add(h);
        }
        return hotels;
    }
public List<Hotels> modifier( int id , String categorie ,String equipement ){
        List<Hotels> packs = new ArrayList<>();
         try {
             String req="UPDATE hotels SET categorie='"+categorie
                     +"', equipement='"+equipement
                     +"' WHERE idH ="+id;
          
             PreparedStatement pre=connexion.prepareStatement(req);
            pre.executeUpdate();
            System.out.println("hotel Modifiée");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return packs;
}
   /* @Override
    public List<Hotels> modifier(String nom) throws SQLException {
        List<Hotels> hotels = new ArrayList<>();
        String aff = "SELECT `nomH`, `categorie`, `equipement` FROM `hotels`";
        stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(aff);
        String categorie = "", equipement = "";

        while (rst.next()) {
            Hotels h = new Hotels(
                    categorie = rst.getString("categorie"),
                    equipement = rst.getString("equipement"));
            hotels.add(h);
        }
        String req = "UPDATE hotels SET  categorie= ?, equipement= ?  , WHERE nomH = " + nom;
        try {
            PreparedStatement pre = connexion.prepareStatement(req);
            pre.setString(2, categorie);
            pre.setString(3, equipement);

            pre.executeUpdate();
            System.out.println("hotel Modifiée");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotels;
    }
*/
    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM hotels WHERE  idH=" + id;
        try {
            stm = connexion.createStatement();
            stm.executeUpdate(req);
            System.out.println("hotel Supprimé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*hedhi normalemnt t9oul li lid deja supprimer ou nexiste pas 
        List<Hotels> hotels = new ArrayList<>();
        String verif = "SELECT * FROM hotels " ;
        stm = connexion.createStatement();
        
        ResultSet rst = stm.executeQuery(verif);
        
        while (rst.next()) {
            Hotels h = new Hotels(rst.getInt("idH"),
            hotels.add(h));
        }
        System.out.println("hotel deja supprimer ou n'existe pas");
     */
    public List<Hotels> recherche(String nom) throws SQLException {
        List<Hotels> list = new ArrayList<>();

        String sql = "SELECT * FROM hotels WHERE nomH =" + nom;
        try {
            Statement st = connexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Hotels(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Hotels> recherchee(int id) throws SQLException {
        List<Hotels> hotels = new ArrayList<>();
        String selectSQL = "SELECT * FROM hotels WHERE idH = " + id;
        ResultSet rst = stm.executeQuery(selectSQL);

        try {
            while (rst.next()) {
                Hotels h = new Hotels(rst.getInt("idH"),
                        rst.getString("nomH"),
                        rst.getString("categorie"),
                        rst.getString("adresse"),
                        rst.getString("email"),
                        rst.getInt("telH"),
                        rst.getString("equipement"));
                hotels.add(h);
            }

        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return null;
    }

}
