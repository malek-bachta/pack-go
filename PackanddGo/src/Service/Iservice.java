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
public interface Iservice <T>{
    void ajouter(T t) throws SQLException;
    void modifier(T t)throws SQLException;
    void  supprimer (int t)throws SQLException;
    List<T> afficher ()throws SQLException;
    
}
