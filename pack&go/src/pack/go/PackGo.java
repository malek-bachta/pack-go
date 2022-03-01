


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.go;

import Entities_offre.offre;
import Entities_pack.packs;
import Service_offre.Serviceoffre;
import Service_pack.Servicepack;
import java.sql.SQLException;
import utils.MyDB;


/**
 *
 * @author THEOLDISBACK
 */
public class PackGo {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
                MyDB db1 =MyDB.getInstance();

          System.out.println(db1.hashCode());
          

          offre f1=new offre(1,1000);
                    offre f3=new offre(1,6600);

         packs p1=new packs(2,"mmmmm","ammmaa","snnnnsss","dddd","wwwwww");
          

         Servicepack Pa = new Servicepack() {};
     
          Serviceoffre of = new Serviceoffre() {};
          
          try {
           of.modifierOffre( 32,1919);
             of.suprimerOffre(39);
                          System.out.println(of.afficheroffre());
             
                          System.out.println(of.Tri());
                          Pa.ajouter(p1);
                        Pa.suprimerPack(25);
                         Pa.modifierPack( 221,"aziz","aziz","bachta","bachta","aziz");
                      System.out.println(Pa.afficherpacks());
              

        } catch (SQLException e) {
              System.out.println(e.getMessage());
        }
    }
    
}
