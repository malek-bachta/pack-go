/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.ReservationHotel;
import java.sql.Connection;
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
public class ReservationHotelService {
  
    private final Connection cnx;
    private static ReservationHotelService instance;
    
    public ReservationHotelService() {
        cnx = DataSource.getInstance().getCnx();
    }
    
    public static ReservationHotelService getInstance()
    {
        if (instance == null) {
            instance = new ReservationHotelService();
        }
        return instance; 
    }
    
    
    public boolean Reservation(ReservationHotel r) {
        int verf = 0 ;
        try{
        String req ;
        
        req="INSERT INTO `reservationh`(`dated`,`datef`,`idu`,`etat_service`,`idhotel`,`etat`) VALUES (?,?,?,?,?,?)";
            PreparedStatement res=cnx.prepareStatement(req);
        
        res.setDate(1, r.getDated());
        res.setDate(2, r.getDatef());
        res.setInt(3, r.getId_user());
        res.setInt(4, r.getEtatSer());
        res.setInt(5, r.getIdhotel());
        res.setString(6, r.getEtat());
        
        verf=res.executeUpdate();
         
        
        }
        catch(SQLException e ){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE,null,e);
        
        }
        if (verf==0)
        {return false;}
        else {return true;}
    }
    
        public List<ReservationHotel> getMesReservation(int id){
        
        List<ReservationHotel> list = new ArrayList<ReservationHotel>();
        int count =0;
        
        String requete="select * from reservationh where idu ="+id;
         try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                ReservationHotel r = new ReservationHotel();
                r.setIdResH(rs.getInt(1));
                r.setDated(rs.getDate(2));
                r.setDatef(rs.getDate(3));
                r.setId_user(rs.getInt(6));
                r.setIdhotel(rs.getInt(5));
                r.setEtatSer(rs.getInt(4));
                 r.setEtat(rs.getString(7));

 
                
                list.add(r);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
               return list;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
        
        
           
        public boolean deleteReservation(int id) throws SQLDataException {
        try {
            
            Statement st=cnx.createStatement();
            String req= "DELETE FROM `reservationh` WHERE `idreh` ="+id;
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
        }
        
        
            
        public boolean modifieReservation(ReservationHotel res) throws SQLDataException {
               
                String query = "UPDATE reservationh SET dated=?,etat_service=?,datef=? WHERE idreh = ?";
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
                st.setDate(1, (java.sql.Date) res.getDated());
                st.setDate(3, (java.sql.Date) res.getDatef());
                st.setInt(2,res.getEtatSer());
                st.setInt(4,res.getIdResH());
                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
        
        
                    
        public boolean Acccepter(int id) throws SQLDataException {
               
                String query = "UPDATE reservationh SET etat=? WHERE idreh ="+id;
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
                st.setString(1,"accepter");
                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
        
                    
        public boolean Refuser(int id) throws SQLDataException {
               
                String query = "UPDATE reservationh SET etat=? WHERE idreh ="+id;
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
                st.setString(1,"refuser");
                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
        
        public boolean Payer(int id) throws SQLDataException {
               
                String query = "UPDATE reservationh SET etat=? WHERE idreh ="+id;
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
                st.setString(1,"payer");
                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
        
           public ReservationHotel findReservationById(int id){
        
        ReservationHotel r = new ReservationHotel();
        int count =0;
        
        String requete="select * from reservationh where idreh="+id;
         try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                r.setIdResH(rs.getInt(1));
                r.setDated(rs.getDate(2));
                r.setDatef(rs.getDate(3));
                r.setId_user(rs.getInt(6));
                r.setIdhotel(rs.getInt(5));
                r.setEtatSer(rs.getInt(4));   
                r.setEtat(rs.getString(7));
                count++;
            }
            if(count == 0){
                return null;
           }else{
               return r;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
           
    public List<ReservationHotel> getAllReservation(){
        
        List<ReservationHotel> list = new ArrayList<ReservationHotel>();
        int count =0;
        
        String requete="select * from reservationh";
         try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                ReservationHotel r = new ReservationHotel();
                r.setIdResH(rs.getInt(1));
                r.setDated(rs.getDate(2));
                r.setDatef(rs.getDate(3));
                r.setId_user(rs.getInt(6));
                r.setIdhotel(rs.getInt(5));
                r.setEtatSer(rs.getInt(4));
                 r.setEtat(rs.getString(7));

 
                
                list.add(r);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
               return list;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
    
  
    
    
}
