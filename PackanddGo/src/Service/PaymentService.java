/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Payment;
import Entity.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Rzouga
 */
public class PaymentService {
    
    
    private final Connection cnx;
    private static PaymentService instance;
    
    public PaymentService() {
        cnx = DataSource.getInstance().getCnx();
    }
    
    public static PaymentService getInstance()
    {
        if (instance == null) {
            instance = new PaymentService();
        }
        return instance; 
    }
    
    
    
    
    
        public boolean Payer(Payment r) {
        int verf = 0 ;
        try{
        String req ;
        
        req="INSERT INTO `payment`(`type`,`somme`,`id_user`,`id_hotel`) VALUES (?,?,?,?)";
            PreparedStatement res=cnx.prepareStatement(req);
        
        res.setString(1, r.getType());
        res.setFloat(2, r.getSomme());
        res.setInt(3, r.getIdUser());
        res.setInt(4, r.getIdH());

        verf=res.executeUpdate();
         
        
        }
        catch(SQLException e ){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE,null,e);
        
        }
        if (verf==0)
        {return false;}
        else {return true;}
    }
    
}
