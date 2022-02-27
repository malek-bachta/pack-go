/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities_hotel;

/**
 *
 * @author mbach
 */
public class Hotels {

    private int idH;
    private String nomH;
    String categorie;
    String adresse;
    String email;
    int telH;
    String equipement;

    public Hotels() {
    }

    public Hotels(String categorie, String equipement) {
        this.categorie = categorie;
        this.equipement = equipement;
    }

  

    public Hotels(int idH, String nomH, String categorie, String adresse, String email, int telH, String equipement) {
        this.idH = idH;
        this.telH = telH;
        this.nomH = nomH;
        this.categorie = categorie;
        this.email = email;
        this.equipement = equipement;
        this.adresse = adresse;
    }

    public Hotels(String nomH, String categorie, String adresse, String email, int telH, String equipement) {
        this.telH = telH;
        this.adresse =adresse;
        this.nomH = nomH;
        this.categorie = categorie;
        this.email = email;
        this.equipement = equipement;
    }

    

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getIdH() {
        return idH;
    }

    public void setIdH(int idH) {
        this.idH = idH;
    }

    public int getTelH() {
        return telH;
    }

    public void setTelh(int telh) {
        this.telH = telh;
    }

    public String getNomH() {
        return nomH;
    }

    public void setNomH(String nomH) {
        this.nomH = nomH;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEquipement() {
        return equipement;
    }

    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }

    @Override
    public String toString() {
        return "Hotels{" + "idH=" + idH + ", nomH=" + nomH + ", categorie=" + categorie + ", adresse=" + adresse + ", email=" + email + ", telH=" + telH + ", equipement=" + equipement + '}';
    }

}
