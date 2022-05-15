/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author Rzouga
 */
public class ReservationHotel {
    
    private int id_user , idResH ,etatSer,idhotel ;
    private Date dated , datef ;
    String etat ;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getIdResH() {
        return idResH;
    }

    public void setIdResH(int idResH) {
        this.idResH = idResH;
    }

    public int getEtatSer() {
        return etatSer;
    }

    public void setEtatSer(int etatSer) {
        this.etatSer = etatSer;
    }

    public Date getDated() {
        return dated;
    }

    public void setDated(Date dated) {
        this.dated = dated;
    }

    public Date getDatef() {
        return datef;
    }

    public void setDatef(Date datef) {
        this.datef = datef;
    }

    public int getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(int idhotel) {
        this.idhotel = idhotel;
    }

    public ReservationHotel() {
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
    
    
}
