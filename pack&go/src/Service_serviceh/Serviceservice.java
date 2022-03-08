/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_serviceh;

import Entities_serviceh.Services;
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
public class Serviceservice implements service<Services> {

    Connection connexion;
    Statement stm;

    public Serviceservice() {
        connexion = MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajouter(Services s) throws SQLException {
        String req = "INSERT INTO `services` ( `formule`, `prix`, `sejours`, `activite`, `etat`)" + " VALUES(?,?,?,?,?)";

        String req1 = "UPDATE `services`s , `hotels`h SET s.id_hotel = h.idH WHERE s.etat = h.equipement ";
        PreparedStatement pst = connexion.prepareStatement(req);
        PreparedStatement pst1 = connexion.prepareStatement(req1);

        pst.setString(1, s.getFormule());
        pst.setFloat(2, s.getPrix());
        pst.setString(3, s.getSejours());
        pst.setString(4, s.getActivite());
        pst.setString(5, s.getEtat());

        pst.executeUpdate();
        pst1.executeUpdate();
        System.out.println(" Votre service  est Ajoutee ++ ");

        stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public List afficher() throws SQLException {
        List<Services> services = new ArrayList<>();
        String req = "select * from services ";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Services s = new Services(rst.getInt("idS"),
                    rst.getString("formule"),
                    rst.getFloat("prix"),
                    rst.getString("sejours"),
                    rst.getString("activite"),
                    rst.getString("etat"));
            services.add(s);
        }
        return services;
    }

    public List afficherid(int id) throws SQLException {
        List<Services> services = new ArrayList<>();
        String req = "select * from services where idS = 19";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Services s = new Services(rst.getInt("idS"),
                    rst.getString("formule"),
                    rst.getFloat("prix"),
                    rst.getString("sejours"),
                    rst.getString("activite"),
                    rst.getString("etat"));
            services.add(s);
        }
        return services;
    }

    @Override
    public List<Services> modifier(int id, String formule, float prix, String sejours, String activite, String etat) {
        List<Services> s = new ArrayList<>();
        try {
            String req = "UPDATE `services`s , `hotels`h SET formule='" + formule
                    + "', prix='" + prix
                    + "', sejours='" + sejours
                    + "', activite='" + activite
                    + "', etat='" + etat
                    + "' WHERE s.id_hotel=h.idH AND s.idS =" + id;

            PreparedStatement pre = connexion.prepareStatement(req);
            pre.executeUpdate();
            System.out.println("service Modifiée");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM services WHERE  idS=" + id;
        try {
            stm = connexion.createStatement();
            stm.executeUpdate(req);
            System.out.println("service Supprimé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
