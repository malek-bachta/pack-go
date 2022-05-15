/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Soulaima ben romdhan
 * @param <G>
 */
public interface Iguide <G> {
    
    
    public void ajouterguide(G g) throws SQLException;
    public List<G> afficheguide() throws SQLException;
    public List<G> modifierguide(int a, String b , String c ,String d,float m)throws SQLException;
    public void  supprimerguide (int g)throws SQLException;
    
}
