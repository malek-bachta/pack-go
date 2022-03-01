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

    
        public offre(int id, int budget) {
        this.id_of = id;
        this.budget = budget;
       
}
         public offre() {
    }
    public int getId_of() {
        return id_of;
    }

    public int getBudget() {
        return budget;
    }

    public void setId_of(int id_of) {
        this.id_of = id_of;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "offre{" + "id_of=" + id_of + ", budget=" + budget + '}';
    }
    
    
}