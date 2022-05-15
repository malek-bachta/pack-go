/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Reclamation;
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
public class ReclamationService {
  
    private final Connection cnx;
    private static ReclamationService instance;
    
    public ReclamationService() {
        cnx = DataSource.getInstance().getCnx();
    }
    
    public static ReclamationService getInstance()
    {
        if (instance == null) {
            instance = new ReclamationService();
        }
        return instance; 
    }
    
    
    public boolean Reclamation(Reclamation r) {
        int verf = 0 ;
        try{
        String req ;
        
        req="INSERT INTO `reclamation`(`sujet`,`contenue`,`id_user`,`dateenv`,`etat`) VALUES (?,?,?,?,?)";
            PreparedStatement res=cnx.prepareStatement(req);
        
        res.setString(1, r.getSujet());
        res.setString(2, r.getContenue());
        res.setInt(3, r.getIdUser());
        res.setDate(4, r.getDateenv());
        res.setString(5, r.getEtat());
        verf=res.executeUpdate();
         
        
        }
        catch(SQLException e ){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE,null,e);
        
        }
        if (verf==0)
        {return false;}
        else {return true;}
    }
    
        public List<Reclamation> getMesclamation(int id){
        
        List<Reclamation> list = new ArrayList<Reclamation>();
        int count =0;
        
        String requete="select * from reclamation where id_user ="+id;
         try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Reclamation r = new Reclamation();
                r.setIdrec(rs.getInt(1));
                r.setSujet(rs.getString(2));
                r.setContenue(rs.getString(3));
                r.setIdUser(rs.getInt(4));
                r.setDateenv(rs.getDate(5));
                r.setEtat(rs.getString(6));
 
                
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
        
        
           
        public boolean deleteReclamation(int id) throws SQLDataException {
        try {
            
            Statement st=cnx.createStatement();
            String req= "DELETE FROM `reclamation` WHERE `id_reclamation` ="+id;
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
        }
        
        
            
        public boolean modifieReclamation(Reclamation res) throws SQLDataException {
               
                String query = "UPDATE reclamation SET sujet=?,contenue=?,etat=? WHERE id_reclamation = ?";
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
                st.setString(1,res.getSujet());
                st.setString(2,res.getContenue());
                st.setString(3,res.getEtat());
                st.setInt(4,res.getIdrec());
                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
        
            
    public Reclamation findReclamationById(int id){
       
        Reclamation r = new Reclamation();
        int count =0;
        
        String requete="select * from reclamation where id_reclamation="+id;
         try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                r.setIdrec(rs.getInt(1));
                r.setSujet(rs.getString(2));
                r.setContenue(rs.getString(3));
                r.setIdUser(rs.getInt(4));
                r.setDateenv(rs.getDate(5));
                r.setEtat(rs.getString(6));          
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
    
     public List<Reclamation> Allreclamation(){
        
        List<Reclamation> list = new ArrayList<Reclamation>();
        int count =0;
        
        String requete="select * from reclamation";
         try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Reclamation r = new Reclamation();
                r.setIdrec(rs.getInt(1));
                r.setSujet(rs.getString(2));
                r.setContenue(rs.getString(3));
                r.setIdUser(rs.getInt(4));
                r.setDateenv(rs.getDate(5));
                r.setEtat(rs.getString(6));
 
                
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
     
     
  public boolean Traiter(int id) throws SQLDataException {
               
                String query = "UPDATE reclamation SET etat=? WHERE id_reclamation="+id;
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
                st.setString(1,"Traité");
                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
}
