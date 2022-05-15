/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author msi
 */
public class Reservation {
    
    
    private int id_user , idRes , idTr, etatGuide ;
    private Date dated , datef ;
    private String etat ;

    public Reservation() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getIdRes() {
        return idRes;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    public int getIdTr() {
        return idTr;
    }

    public void setIdTr(int idTr) {
        this.idTr = idTr;
    }


    public int getEtatGuide() {
        return etatGuide;
    }

    public void setEtatGuide(int etatGuide) {
        this.etatGuide = etatGuide;
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

    @Override
    public String toString() {
        return "Reservation{" + "id_user=" + id_user + ", idRes=" + idRes + ", idTr=" + idTr + ", etatGuide=" + etatGuide + ", dated=" + dated + ", datef=" + datef + '}';
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    
    
    
}
