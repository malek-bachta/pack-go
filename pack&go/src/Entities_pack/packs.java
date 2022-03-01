/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities_pack;

/**
 *
 * @author MSI
 */
public class packs { 
    private  int id_pack ;
    public String nom_pack,texte,service,guide,destination ; 

    public packs(int id_pack, String nom_pack, String texte, String service, String guide, String destination) {
        this.id_pack = id_pack;
        this.nom_pack = nom_pack;
        this.texte = texte;
        this.service = service;
        this.guide = guide;
        this.destination = destination;
    }
     public packs() {
    }



   
    public int getId_pack() {
        return id_pack;
    }

    public String getNom_pack() {
        return nom_pack;
    }

    public String getTexte() {
        return texte;
    }

    public String getService() {
        return service;
    }

    public String getGuide() {
        return guide;
    }

    public String getDestination() {
        return destination;
    }

    public void setId_pack(int id_pack) {
        this.id_pack = id_pack;
    }

    public void setNom_pack(String nom_pack) {
        this.nom_pack = nom_pack;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "packs{" + "id_pack=" + id_pack + ", nom_pack=" + nom_pack + ", text=" + texte + ", service=" + service + ", guide=" + guide + ", destination=" + destination + '}';
    }
     
}
