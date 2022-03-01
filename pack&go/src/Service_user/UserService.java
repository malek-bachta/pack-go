/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_user;
import Entities_user.User;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.MyDB;

/**
 *
 * @author ASUS
 */
public class UserService {
 
    private final Connection cnx;
    private static UserService instance;
    
    public UserService() {
        cnx = MyDB.getInstance().getConnexion();
    }
    
    public static UserService getInstance()
    {
        if (instance == null) {
            instance = new UserService();
        }
        return instance; 
    }

    
    
        public boolean Registre(User user) {
        int verf = 0 ;
        try{
        String req ;
        
        req="INSERT INTO `user`(`nom_c`,`prenom_c`,`mail_c`,`role`,`mdp_c`,`age_c`,`num_pass`,`tel_c`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement res=cnx.prepareStatement(req);
        
        res.setString(1, user.getNom());
        res.setString(2, user.getPrenom());
        res.setString(3, user.getEmail());
        res.setString(4, user.getRole());
        res.setString(5, user.getMdp());
        res.setInt(6, user.getAge());
        res.setLong(7, user.getNumPass());  
        res.setLong(8, user.getTel());
  
        verf=res.executeUpdate();
         
        
        }
        catch(SQLException e ){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE,null,e);
        
        }
        if (verf==0)
        {return false;}
        else {return true;}
    }
        
   public User Login(String email) {

        User user = new User();

        try {
            String requete = "select * from user where mail_c='"+email+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            int count = 0;
            while(rs.next()){
                count ++;
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(4));
                user.setPrenom(rs.getString(5));
                user.setEmail(rs.getString(7));
                user.setRole(rs.getString(9));
                user.setAge(rs.getInt(3));
                user.setMdp(rs.getString(6));
                user.setTel(rs.getInt(2));
                user.setNumPass(rs.getInt(8));
            }
            
            if(count == 0){
             return null ;
            }else{
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
   
    public boolean checkEmailExist(String email)
    {
        
        int count = 0;
           
        String requete="select * from user where mail_c='"+email+"' ";
        try{
            Statement st = cnx.createStatement();
            ResultSet rsl = st.executeQuery(requete);
            while(rsl.next())
            {
                count++;
            }
           if(count == 0){
                return false;
           }else{
               return true;
           }  
        }
        catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
   }
    
    
   public boolean validerEmail(String s){
    Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
    Matcher m = p.matcher(s);
    if (m.find() && m.group().equals(s)){
        return false;
    }
    else 
    {
      
        return true;
    
        
}
   }
   
    public List<User> getAllUser(){
        
        List<User> list = new ArrayList<User>();
        int count =0;
        
        String requete="select * from user where role ='Client'";
         try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                User user = new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(4));
                user.setPrenom(rs.getString(5));
                user.setEmail(rs.getString(7));
                user.setRole(rs.getString(9));
                user.setMdp(rs.getString(6));
                user.setTel(rs.getInt(2));
                user.setAge(rs.getInt(3));
                user.setNumPass(rs.getInt(8));
 
                
                list.add(user);
                
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
    
       public List<User> getStaff(){
        
        List<User> list = new ArrayList<User>();
        int count =0;
        
        String requete="select * from user where role ='Contact Hotel' or role ='Contact Transport'";
         try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                User user = new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(4));
                user.setPrenom(rs.getString(5));
                user.setEmail(rs.getString(7));
                user.setRole(rs.getString(9));
                user.setMdp(rs.getString(6));
                user.setTel(rs.getInt(2));
                user.setAge(rs.getInt(3));
                user.setNumPass(rs.getInt(8));
 
                
                list.add(user);
                
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
       
              public User findUserById(int id){
        
        User user = new User();
        int count =0;
        
        String requete="select * from user where id_c="+id;
         try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(4));
                user.setPrenom(rs.getString(5));
                user.setEmail(rs.getString(7));
                user.setRole(rs.getString(9));
                user.setMdp(rs.getString(6));
                user.setTel(rs.getInt(2));
                user.setAge(rs.getInt(3));
                user.setNumPass(rs.getInt(8));                
                count++;
            }
            if(count == 0){
                return null;
           }else{
               return user;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
       
           
        public boolean deleteUser(int id) throws SQLDataException {
        try {
            
            Statement st=cnx.createStatement();
            String req= "DELETE FROM `user` WHERE `id_c` ="+id;
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
        }
        
        public boolean modifieStaff(User u) throws SQLDataException {
               
                String query = "UPDATE user SET tel_c=?,age_c=?,num_pass=?,nom_c=?,prenom_c=?,mail_c=?,role=? WHERE id_c = ?";
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
                st.setInt(2,u.getAge());
                st.setInt(1,u.getTel());
                st.setInt(3,u.getNumPass());
                st.setString(4,u.getNom());
                st.setString(5,u.getPrenom());
                st.setString(6,u.getEmail());
                st.setString(7,u.getRole());
                st.setInt(8,u.getId());
                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
   
        
        
}
