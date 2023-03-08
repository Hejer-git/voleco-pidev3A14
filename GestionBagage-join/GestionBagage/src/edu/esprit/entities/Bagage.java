/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;


/**
 *
 * @author 21654
 */
public class Bagage {
    
    private int idBagage;
    private float poids, taille, frais;
    private Date dateB;
    private int idStatBag;
    private String statut;

    public Bagage() {
    }

    public Bagage(int idBagage, float poids, float taille, float frais, Date dateB, int idStatBag) {
        this.idBagage = idBagage;
        this.poids = poids;
        this.taille = taille;
        this.frais = frais;
        this.dateB = dateB;
        this.idStatBag = idStatBag;
    }

    public Bagage(float poids, float taille, float frais, Date dateB, int idStatBag) {
        this.poids = poids;
        this.taille = taille;
        this.frais = frais;
        this.dateB = dateB;
        this.idStatBag = idStatBag;
    }


    public int getIdBagage() {
        return idBagage;
    }

    public void setIdBagage(int idBagage) {
        this.idBagage = idBagage;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getFrais() {
        return frais;
    }

    public void setFrais(float frais) {
        this.frais = frais;
    }

    public Date getDateB() {
        return dateB;
    }

    public void setDateB(Date dateB) {
        this.dateB = dateB;
    }

    /* public int getIdStatBag() {
        return idStatBag;
    }

    public void setIdStatBag(int idStatBag) {
        this.idStatBag = idStatBag;
    }*/
    
    public int getidStatBag() {
        return idStatBag;
    }

    public void setidStatBag(int idStatBag) {
        this.idStatBag = idStatBag;
    }
    
    public String getIdStatBag() {
        return statut;
    }

    public void setIdStatBag(String statut) {
        this.statut = statut;
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
        final Bagage other = (Bagage) obj;
        if (this.idBagage != other.idBagage) {
            return false;
        }
        return true;
    }
    
    
    
}
