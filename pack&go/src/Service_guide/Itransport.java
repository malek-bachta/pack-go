/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_guide;

import Entities_transport.Transport;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Soulaima ben romdhan
 * @param <T>
 */
public interface Itransport <T> {
    
    
    
     public void ajoutertransport(T t) throws SQLException;
     public List<T> affichertransport() throws SQLException;
    
     public void  supprimertransport (int t)throws SQLException;
      public void modifiertransport(T t) throws SQLException;
}
