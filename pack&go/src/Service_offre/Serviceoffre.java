/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_offre;

import Entities_offre.offre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import utils.MyDB;

/**
 *
 * @author THEOLDISBACK
 */
public abstract class Serviceoffre implements Iservice<offre> {
    private Connection cnx;
    
    public Serviceoffre()
    {
        cnx= MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajouter(offre O) throws SQLException{
       String req="INSERT INTO `offre`( `budget`) VALUES ("+O.getBudget()+");";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
      
    }

       public void ajouter1(offre O) throws SQLException{
       String req="INSERT INTO `offre`(`offre`) VALUES ( ?);";
         PreparedStatement pre=cnx.prepareStatement(req);
         pre.setInt(1, O.getBudget());
         pre.executeUpdate(req);
           System.out.println("success!");
        
    }
   
       
          
   @Override
    public void supprimer(int O) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<offre> suprimerOffre( int id_of){
        List<offre> offre = new ArrayList<>();
        try {
                    String req="DELETE FROM offre WHERE id_of="+id_of;

           PreparedStatement  pre=cnx.prepareStatement(req);
             pre.executeUpdate();
             System.out.println("offre supprimée");
          
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return offre;
    }
       
     @Override
                    public List<offre> afficher() throws SQLException {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
       
     
    
    
       public List<offre> afficheroffre() throws SQLException {

        List<offre >offre = new ArrayList<>();
        String req = "select * from offre";
        Statement st=cnx.createStatement();
        
        //ensemble de resultat
        ResultSet rst = st.executeQuery(req);

        while (rst.next()) {
            offre f = new offre(rst.getInt("id_of"),//or rst.getInt(1)
                    rst.getInt("budget"));
            offre.add(f);
        }
        return offre;
    }
       
       
       
       
       
       
       
       
       
       
      @Override
    public void modifier(offre O) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
public List<offre> modifierOffre(int id_of , int budget ){
        List<offre> offre = new ArrayList<>();
         try {
             String req="UPDATE offre SET budget='"+budget
                     +"' WHERE id_of =" +id_of;
             
             PreparedStatement pre=cnx.prepareStatement(req);          
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

  
  
  /*public List<offre> Recherche(offre o) throws SQLException {
        List<offre> offre = afficheroffre();
        return offre.stream().filter(b -> b.getBudget().equals(o.getBudget())).collect(Collectors.toList());
    }
 */
}
