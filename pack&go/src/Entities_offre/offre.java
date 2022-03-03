/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities_offre;

/**
 *
 * @author MSI
 */
public class offre {
    private  int id_of,budget;
    private String nom_offre ;

    public offre(int id_of) {
        this.id_of = id_of;
    }

    public offre(String nom_offre ,int budget) {
        this.budget = budget;
        this.nom_offre = nom_offre;
    }

    public offre(int id_of, int budget, String nom_offre) {
        this.id_of = id_of;
        this.budget = budget;
        this.nom_offre = nom_offre;
    }

   

    public int getId_of() {
        return id_of;
    }

    public void setId_of(int id_of) {
        this.id_of = id_of;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getNom_offre() {
        return nom_offre;
    }

    public void setNom_offre(String nom_offre) {
        this.nom_offre = nom_offre;
    }
    

    @Override
    public String toString() {
        return "offre{" + "id_of=" + id_of + ", budget=" + budget + ", nom_offre=" + nom_offre + '}';
    }

}
       