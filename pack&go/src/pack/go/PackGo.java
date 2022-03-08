/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.go;

import Entities_transport.Transport;
import Service_transport.TransportService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mbach
 */
public class PackGo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TransportService ts= new TransportService();
        Transport p = new Transport("s","s",22f,"s","s");
        
        try {
            ts.ajoutertransport(p);
        } catch (SQLException ex) {
            System.out.println("ollaa");        }
        
    }
    
}
