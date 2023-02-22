/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bagage.entities;


public class StatutBagage {
    private int idStatBag;
    private String statActuel, comB;

    public StatutBagage() {
    }

    public StatutBagage(int idStatBag, String statActuel, String comB) {
        this.idStatBag = idStatBag;
        this.statActuel = statActuel;
        this.comB = comB;
    }

    public StatutBagage(String statActuel, String comB) {
        this.statActuel = statActuel;
        this.comB = comB;
    }

    public int getIdStatBag() {
        return idStatBag;
    }

    public void setIdStatBag(int idStatBag) {
        this.idStatBag = idStatBag;
    }

    public String getStatActuel() {
        return statActuel;
    }

    public void setStatActuel(String statActuel) {
        this.statActuel = statActuel;
    }

    public String getComB() {
        return comB;
    }

    public void setComB(String comB) {
        this.comB = comB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StatutBagage other = (StatutBagage) obj;
        if (this.idStatBag != other.idStatBag) {
            return false;
        }
        return true;
    }

    
    
   



   
    
    
     
}
