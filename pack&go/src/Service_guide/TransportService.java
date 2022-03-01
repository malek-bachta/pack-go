/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_guide;

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
import javafx.scene.control.Alert;

import utils.MyDB;

/**
 *
 * @author Soulaima ben romdhan
 */
public class TransportService implements Itransport<Transport> {

    Connection connexion;
    Statement stm;

    public TransportService() {
        connexion = MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajoutertransport(Transport t) throws SQLException {
        String req = "INSERT INTO `transport` (`type`, `nomagence`, `prix`, `duree`, `destination`) VALUES ( '"
                + t.getType() + "', '" + t.getNomagence() + "', '" + t.getPrix() + "', '" + t.getDuree() + "', '" + t.getDestination() + "') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);

    }

    @Override
    public List<Transport> affichertransport() throws SQLException {

        List<Transport> Transport = new ArrayList<>();
        String req = "select * from transport";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Transport t = new Transport(rst.getInt("id"),//or rst.getInt(1)
                    rst.getString("type"),
                    rst.getString("nomagence"),
                    rst.getFloat("prix"),
                    rst.getString("duree"),
                    rst.getString("destination"));
            Transport.add(t);
        }
        return Transport;
    }

    @Override
    public void supprimertransport(int id) throws SQLException {
        String req = "DELETE FROM transport WHERE  id=" + id;
        try {
            stm = connexion.createStatement();
            stm.executeUpdate(req);
            System.out.println("transport Supprimé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 
     
     
     
    public List<Transport> search(String input) {
         List<Transport> Transport = new ArrayList<>();
        try {
            Statement stm;
            stm = connexion.createStatement();
            String query = "SELECT * "
                    + "FROM transport "
                    + " where nomagence like '%" + input + "%' ";
            ResultSet rst = stm.executeQuery(query);
            while (rst.next()) {
              Transport t = new Transport(rst.getInt("id"),//or rst.getInt(1)
                    rst.getString("type"),
                    rst.getString("nomagence"),
                    rst.getFloat("prix"),
                    rst.getString("duree"),
                    rst.getString("destination"));
            Transport.add(t);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Transport;
    }
    
    
     @Override
    public void modifiertransport(Transport t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Transport> modifiertransport(int id, String type ,String  nomagence , float prix ,String duree , String destination ){
        List<Transport> Transport = new ArrayList<>();
         try {
             String req="UPDATE transport SET type='"+type
                     +"',nomagence='"+nomagence
                     +"', prix='"+prix
                     +"',duree='"+duree
                     +"',destination='"+destination+"' "
                     + "WHERE id=" +id;
             
             PreparedStatement pre=connexion.prepareStatement(req);          
            pre.executeUpdate();
            System.out.println("transport Modifiée");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Transport;
}  
       
       
       
       
       
       
    

  public List<Transport> Tri() throws SQLException {
        Comparator<Transport> comparator = Comparator.comparing(Transport::getPrix);
        List<Transport> Transport = affichertransport();
          return Transport.stream().sorted(comparator).collect(Collectors.toList());
  }  
        
          
    public int counttransport() throws SQLException
    {
        
       
               int total = 0;
               
               Statement stm;
            stm = connexion.createStatement();
            ResultSet rst = stm.executeQuery("Select count(*) from transport ");
            
             while (rst.next())
            {
               total  = rst.getInt("count(*)");
            }
            
            return total;
    }
    
    /*
    public ObservableList<Transport> chercherParticipants(String input) throws SQLException
    {
        
            Statement stm;
            stm = connexion.createStatement();
            ResultSet rst = stm.executeQuery("Select * from participants Inner Join utilisateurs ON utilisateurs.id=participants.id WHERE utilisateurs.nom like '%"+input+"%'");
            Transport t = new Participants();
            ObservableList<Utilisateurs>comformations = FXCollections.observableArrayList();
            
            
             while (rst.next())
            {
                
                
                
                p.setId(rst.getInt(1));
                p.setNom(rst.getString(7));
                p.setPrenom(rst.getString(8));
                p.setDateNaissance(rst.getDate(9));
                p.setCin(rst.getString(10));
                p.setEmail(rst.getString(11));
                p.setLogin(rst.getString(12));
                p.setPassword(rst.getString(13));
                p.setNum(rst.getString(14));
                p.setNiveauEtude(rst.getString(2));
                p.setCertificatsObtenus(rst.getInt(3));
                p.setInterssePar(rst.getString(4));
                p.setNombreDeFormation(rst.getInt(5));
                comformations.add(p);
                   
               
            }
     
                     
        return comformations;    
        
    }
        */
        
        
   

}
