/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author mbach
 */
public class Services {
    private int idS;
    private String formule;
    private float prix;
    private String sejours;
    private String activite;
    private String etat;
    private int id_hotel;

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public Services() {
    }

    public Services(String formule, float prix, String sejours, String activite, String etat) {
        this.formule = formule;
        this.prix = prix;
        this.sejours = sejours;
        this.activite = activite;
        this.etat = etat;
    }
        public Services(String formule,  String sejours,float prix, String activite, String etat) {
        this.formule = formule;
        this.prix = prix;
        this.sejours = sejours;
        this.activite = activite;
        this.etat = etat;
    }

    public Services(int idS, String formule, float prix, String sejours, String activite, String etat) {
        this.idS = idS;
        this.formule = formule;
        this.prix = prix;
        this.sejours = sejours;
        this.activite = activite;
        this.etat = etat;
    }



    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getSejours() {
        return sejours;
    }

    public void setSejours(String sejours) {
        this.sejours = sejours;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "services{" + "idS=" + idS + ", formule=" + formule + ", prix=" + prix + ", sejours=" + sejours + ", activite=" + activite + ", etat=" + etat + '}';
    }


    
    
    
}
