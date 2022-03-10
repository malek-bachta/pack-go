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
    private int id_contactH;
    private String nomH;
    String categorie;
    String adresse;
    String email;
    int telH;
    String equipement;
    String image;

    public Hotels() {
    }

    public Hotels(String categorie, String equipement) {
        this.categorie = categorie;
        this.equipement = equipement;
    }

    public Hotels(int idH, int id_contactH, String nomH, String categorie, String adresse, String email, int telH, String equipement) {
        this.idH = idH;
        this.id_contactH = id_contactH;
        this.telH = telH;
        this.nomH = nomH;
        this.categorie = categorie;
        this.email = email;
        this.equipement = equipement;
        this.adresse = adresse;
    }

    public Hotels(int id_contactH, String nomH, String categorie, String adresse, String email, int telH, String equipement) {
        this.id_contactH = id_contactH;
        this.telH = telH;
        this.adresse = adresse;
        this.nomH = nomH;
        this.categorie = categorie;
        this.email = email;
        this.equipement = equipement;
    }

    public Hotels(String nomH, String categorie, String adresse, String email, int telH, String equipement, String image) {
        this.nomH = nomH;
        this.categorie = categorie;
        this.adresse = adresse;
        this.email = email;
        this.telH = telH;
        this.equipement = equipement;
        this.image = image;
    }

    
    public Hotels(int idH, int id_contactH, String nomH, String categorie, String adresse, String email, int telH, String equipement, String image) {
        this.idH = idH;
        this.id_contactH = id_contactH;
        this.nomH = nomH;
        this.categorie = categorie;
        this.adresse = adresse;
        this.email = email;
        this.telH = telH;
        this.equipement = equipement;
        this.image = image;
    }

    public Hotels(int idH, String nomH, String categorie, String adresse, String email, int telH, String equipement, String image) {
        this.idH = idH;
        this.nomH = nomH;
        this.categorie = categorie;
        this.adresse = adresse;
        this.email = email;
        this.telH = telH;
        this.equipement = equipement;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    public int getId_contactH() {
        return id_contactH;
    }

    public void setId_contactH(int id_contactH) {
        this.id_contactH = id_contactH;
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
