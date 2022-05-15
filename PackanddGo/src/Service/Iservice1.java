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
 * @author THEOLDISBACK
 * @param <T>
 */
public interface Iservice1 <T>{
    void ajouter(T t) throws SQLException;
     List<T> modifierPack(int a, String b ,  String c,  String d,  String e,  String f )throws SQLException;
     List<T>  suprimerPack (int t)throws SQLException;
    List<T> afficherpacks ()throws SQLException;
    
}
