/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Reservation;
import Entity.User;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author msi
 */
public class ReservationService {

    private final Connection cnx;
    private static ReservationService instance;

    public ReservationService() {
        cnx = DataSource.getInstance().getCnx();
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    public boolean Reservation(Reservation r) {
        int verf = 0;
        try {
            String req;

            req = "INSERT INTO `reservation`(`date_deb`,`date_fin`,`id_u`,`etat_guide`,`id_trasp`,`etat`) VALUES (?,?,?,?,?,?)";
            PreparedStatement res = cnx.prepareStatement(req);

            res.setDate(1, r.getDated());
            res.setDate(2, r.getDatef());
            res.setInt(3, r.getId_user());
            res.setInt(4, r.getEtatGuide());
            res.setInt(5, r.getIdTr());
            res.setString(6, r.getEtat());

            verf = res.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);

        }
        if (verf == 0) {
            return false;
        } else {
            return true;
        }
    }

    public List<Reservation> getMesReservation(int id) {

        List<Reservation> list = new ArrayList<Reservation>();
        int count = 0;

        String requete = "select * from reservation where id_u =" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {

                Reservation r = new Reservation();
                r.setIdRes(rs.getInt(1));
                r.setDated(rs.getDate(2));
                r.setDatef(rs.getDate(3));
                r.setId_user(rs.getInt(4));
                r.setIdTr(rs.getInt(6));
                r.setEtatGuide(rs.getInt(5));
                r.setEtat(rs.getString(6));
                list.add(r);

                count++;
            }
            if (count == 0) {
                return null;
            } else {
                return list;

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean deleteReservation(int id) throws SQLDataException {
        try {

            Statement st = cnx.createStatement();
            String req = "DELETE FROM `reservation` WHERE `id_res` =" + id;
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean modifieReservation(Reservation res) throws SQLDataException {

        String query = "UPDATE reservation SET date_deb=?,etat_guide=?,date_fin=? WHERE id_res = ?";
        PreparedStatement st;
        try {
            st = cnx.prepareStatement(query);
            st.setDate(1, (java.sql.Date) res.getDated());
            st.setDate(3, (java.sql.Date) res.getDatef());
            st.setInt(2, res.getEtatGuide());
            st.setInt(4, res.getIdRes());
            st.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Reservation findReservationById(int id) {

        Reservation r = new Reservation();
        int count = 0;

        String requete = "select * from reservation where id_res=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {

                r.setIdRes(rs.getInt(1));
                r.setDated(rs.getDate(2));
                r.setDatef(rs.getDate(3));
                r.setId_user(rs.getInt(4));
                r.setIdTr(rs.getInt(6));
                r.setEtatGuide(rs.getInt(5));
                r.setEtat(rs.getString(7));
                count++;
            }
            if (count == 0) {
                return null;
            } else {
                return r;

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public List<Reservation> getAllReservation(){
        List<Reservation> list = new ArrayList<Reservation>();
        int count = 0;

        String requete = "select * from reservationh";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {

                Reservation r = new Reservation();
                r.setIdRes(rs.getInt(1));
                r.setDated(rs.getDate(2));
                r.setDatef(rs.getDate(3));
                r.setId_user(rs.getInt(4));
                r.setEtatGuide(rs.getInt(5));
                r.setIdTr(rs.getInt(6));
                r.setEtat(rs.getString(7));

                list.add(r);

                count++;
            }
            if (count == 0) {
                return null;
            } else {
                return list;

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    

}
