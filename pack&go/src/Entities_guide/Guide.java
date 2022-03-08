/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities_guide;

import javafx.scene.control.TextField;

/**
 *
 * @author Soulaima ben romdhan
 */
public class Guide {

    public static void add(Guide g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int id;
    private String nom;
    private String prenom;
    private String type;
    private float prix;

    public Guide(int id, String nom, String prenom, String type, float prix) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.prix = prix;
    }

    public Guide(String nom, String prenom, String type, float prix) {
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.prix = prix;
    }

  

    public Guide() {
    }

    public Guide(int i, TextField nom, TextField prenom, TextField type, TextField prix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getType() {
        return type;
    }
    
     public float getPrix() {
        return prix;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setType(String type) {
        this.type = type;
    }
    
     public void setPrix(float prix) {
        this.prix = prix;
    }
    

    @Override
    public String toString() {
        return "guide{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", type=" + type + ", prix=" + prix + '}';
    }
   
    
    
}
