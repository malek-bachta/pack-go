/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.offre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import utils.DataSource;

/**
 *
 * @author THEOLDISBACK
 */
public abstract class Serviceoffre implements Iservice<offre> {

    private Connection cnx;

    public Serviceoffre() {
        cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public void ajouter(offre O) throws SQLException {
        String req = "INSERT INTO `offre`( `budget`,`nom_offre`) VALUES (" + O.getBudget() + ",'" + O.getNom_offre() + "');";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);

    }

    public void ajouter1(offre O) throws SQLException {
        String req = "INSERT INTO `offre`(`offre`) VALUES ( ?);";
        PreparedStatement pre = cnx.prepareStatement(req);
        pre.setString(1, O.getNom_offre());
        pre.setInt(2, O.getBudget());
        pre.executeUpdate(req);
        System.out.println("success!");

    }

    @Override
    public void supprimer(int O) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<offre> suprimerOffre(int id_of) {
        List<offre> offre = new ArrayList<>();
        try {
            String req = "DELETE FROM offre WHERE id_of=" + id_of;

            PreparedStatement pre = cnx.prepareStatement(req);
            pre.executeUpdate();
            System.out.println("offre supprimée");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return offre;
    }

    @Override
    public List<offre> afficher() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<offre> afficheroffre() throws SQLException {

        List<offre> offre = new ArrayList<>();
        String req = "select * from offre";
        Statement st = cnx.createStatement();

        //ensemble de resultat
        ResultSet rst = st.executeQuery(req);

        while (rst.next()) {
            offre f = new offre(rst.getInt("id_of"),
                    rst.getInt("budget"),
                    rst.getString("nom_offre")
                                );
            offre.add(f);
        }
        return offre;
    }

    @Override
    public void modifier(offre O) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<offre> modifierOffre(int id_of, int budget, String nom_offre) {
        List<offre> offre = new ArrayList<>();
        try {
            String req = "UPDATE offre SET budget='" + budget
                    + "' , nom_offre='" + nom_offre
                    + "'WHERE id_of =" + id_of;

            PreparedStatement pre = cnx.prepareStatement(req);
            pre.executeUpdate();
            System.out.println("offre Modifiée");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return offre;
    }

    public List<offre> Tri() throws SQLException {
        Comparator<offre> comparator = Comparator.comparing(offre::getBudget);
        List<offre> offre = afficheroffre();
        return offre.stream().sorted(comparator).collect(Collectors.toList());
    }

}
