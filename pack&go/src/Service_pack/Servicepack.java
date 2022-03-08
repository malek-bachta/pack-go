/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entities_pack.packs;
import utils.MyDB;

/**
 *
 * @author THEOLDISBACK
 */
public  class Servicepack implements Iservice<packs> {

    private final Connection cnx;

    public Servicepack() {
        cnx = MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajouter(packs p) throws SQLException {
        String req = "INSERT INTO `packs`(`nom_pack`,`texte`,`service`,`guide`,`destination`) VALUES ('" + p.getNom_pack() + "',"
                + "'" + p.getTexte() + "','" + p.getService() + "','" + p.getGuide() + "','" + p.getDestination() + "');";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);

    }
/*public void ajouter(Services s) throws SQLException {
        String req = "INSERT INTO services ( formule, prix, sejours, activite, etat)" + " VALUES(?,?,?,?,?)";

        String req1 = "UPDATE servicess , hotelsh SET s.id_hotel = h.idH WHERE s.etat = h.equipement ";
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
    }*/
    public void ajouter1(packs p) throws SQLException {
  String req = "INSERT INTO packs (nom_pack, texte, service, guide, destination)"+" VALUES (?,?,?,?,?)";
        String req1 = "UPDATE packs , offre  SET packs.budget_pack = offre.budget WHERE packs.nom_pack =offre.nom_offre";
        PreparedStatement pre = cnx.prepareStatement(req);
        PreparedStatement pre1 = cnx.prepareStatement(req1);
        pre.setString(1, p.getNom_pack());
        pre.setString(2,  p.getTexte());
        pre.setString(3, p.getService());
        pre.setString(4, p.getGuide() );
        pre.setString(5, p.getDestination());

        pre.executeUpdate();
        pre1.executeUpdate();
        System.out.println("success!");
          Statement st = cnx.createStatement();
        st.executeUpdate(req);

    }

    @Override
    public List<packs> modifierPack(int id_pack, String nom_pack, String texte, String service, String guide, String destination) {
        List<packs> packs = new ArrayList<>();
        try {
            String req = "UPDATE packs SET nom_pack ='" + nom_pack
                    + "', texte='" + texte
                    + "', service='" + service
                    + "', guide='" + guide
                    + "', destination='" + destination
                    + "' WHERE id_pack =" + id_pack;

            PreparedStatement pre = cnx.prepareStatement(req);
            pre.executeUpdate();
            System.out.println("pack Modifiée");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return packs;
    }

    @Override

    public List<packs> suprimerPack(int id_pack) {
        List<packs> message = new ArrayList<>();
        String req = "DELETE FROM packs WHERE id_pack=" + id_pack;
        try {
            PreparedStatement pre = cnx.prepareStatement(req);
            pre.executeUpdate();
            System.out.println("pack supprimée");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return message;
    }

    @Override

    public List<packs> afficherpacks() throws SQLException {

        List<packs> packs = new ArrayList<>();
        String req = "select * from packs";
        Statement st = cnx.createStatement();

        //ensemble de resultat
        ResultSet rst = st.executeQuery(req);

        while (rst.next()) {
            packs p = new packs(rst.getInt("id_pack"),//or rst.getInt(1)
                    rst.getString("nom_pack"),
                    rst.getString("texte"),
                    rst.getString("service"),
                    rst.getString("guide"),
                    rst.getString("destination"),
                    rst.getInt("budget_pack")
            );
            packs.add(p);
        }
        return packs;
    }

}
