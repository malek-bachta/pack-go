/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entities_hotel.Hotels;
import Entities_serviceh.Services;
import Service_serviceh.Serviceservice;
import Services_hotel.HotelService;
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
    public static void main(String[] args) throws SQLException {
   
        Hotels h1 = new Hotels("c", "c", "c", "c", 111, "c");
        HotelService sh = new HotelService();
        
        Services s = new Services("aaaaaaaaaa", 111111, "bbbbbbbbbb", "cccccccccccc", "ddddddddd");
        Services s1 = new Services("aaaaaaaaaa", 111111, "bbbbbbbbbb", "cccccccccccc", "ddddddddd");
        Serviceservice ss = new Serviceservice();
        
        
        
       /* 
        try {
            sh.ajouter(h1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        try {
            System.out.println(sh.afficher());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        try {
            sh.recherche("malek");
            sh.supprimer(5);
            System.out.println(sh.afficher());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        try {
            System.out.println(sh.afficher());
            sh.modifier(20,"aa","xx");
            System.out.println(sh.afficher());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        */
        
         System.out.println("************************************");
        
        /*
        try {
            ss.ajouter(s);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            System.out.println(ss.afficher());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        try {
            ss.supprimer(2);
            System.out.println(ss.afficher());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            ss.modifier(3, "a", 4f, "a", "a", "a");
            System.out.println(ss.afficher());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    */
    }
}
        
        
        
        
       
    

