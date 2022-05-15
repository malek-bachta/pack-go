/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Soulaima ben romdhan
 */
public class Transport {
    private int id;
    private String type;
    private String nomagence;
    private float prix;
    private String duree;
    private String destination;

    public Transport(int id, String type, String nomagence, float prix, String duree, String destination) {
        this.id = id;
        this.type = type;
        this.nomagence = nomagence;
        this.prix = prix;
        this.duree = duree;
        this.destination = destination;
    }

    public Transport(String type, String nomagence, float prix, String duree, String destination) {
        this.type = type;
        this.nomagence = nomagence;
        this.prix = prix;
        this.duree = duree;
        this.destination = destination;
    }

   
    public Transport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getNomagence() {
        return nomagence;
    }

    public float getPrix() {
        return prix;
    }

    public String getDuree() {
        return duree;
    }

    public String getDestination() {
        return destination;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNomagence(String nomagence) {
        this.nomagence = nomagence;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "transport{" + "id=" + id + ", type=" + type + ", nomagence=" + nomagence + ", prix=" + prix + ", duree=" + duree + ", destination=" + destination + '}';
    }
    
    
}
