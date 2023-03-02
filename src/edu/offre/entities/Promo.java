/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.entities;

/**
 *
 * @author 21629
 */
public class Promo {
    private int idPromo;
    private String codePromo;
    private int Reduction;
   

    public Promo(int idPromo, String codePromo, int Reduction){
        this.idPromo = idPromo;
        this.codePromo = codePromo;
        this.Reduction = Reduction;
        
    }

    public Promo(String codePromo, int Reduction) {
        this.codePromo = codePromo;
        this.Reduction = Reduction;

    }

    public Promo() {
    }

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public String getCodePromo() {
        return codePromo;
    }

    public void setCodePromo(String codePromo) {
        this.codePromo = codePromo;
    }

    public int getReduction() {
        return Reduction;
    }

    public void setReduction(int Reduction) {
        this.Reduction = Reduction;
    }

   

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Promo other = (Promo) obj;
        if (this.idPromo != other.idPromo) {
            return false;
        }
        return true;
    }
   
}


    
