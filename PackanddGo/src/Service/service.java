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
 * @author mbach
 * @param <T>
 */
public interface service <T> {
    public void ajouter (T h) throws SQLException;
    public  List<T> modifier(int a, String b, String c)throws SQLException;
    public void  supprimer (int t)throws SQLException;
    public  List<T> afficher () throws SQLException;
}
