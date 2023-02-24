/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;
import java.util.Date;

/**
 *
 * @author ahmed
 */
public class Avion {
   private  int idAvion;
    private  int nbPlace;
    private String nomAvion;
    private String modele;
    private String classe;
    public  Date dateEntServ;

    public Avion() {
    }

    public Avion(int idAvion, int nbPlace, String nomAvion, String modele, String classe, Date dateEntServ) {
        this.idAvion = idAvion;
        this.nbPlace = nbPlace;
        this.nomAvion = nomAvion;
        this.modele = modele;
        this.classe = classe;
        this.dateEntServ = dateEntServ;
    }

    public Avion(int nbPlace, String nomAvion, String modele, String classe, Date dateEntServ) {
        this.nbPlace = nbPlace;
        this.nomAvion = nomAvion;
        this.modele = modele;
        this.classe = classe;
        this.dateEntServ = dateEntServ;
    }

   

   

    public int getIdAvion() {
        return idAvion;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public String getNomAvion() {
        return nomAvion;
    }

    public String getModele() {
        return modele;
    }

    public String getClasse() {
        return classe;
    }

    public Date getDateEntServ() {
        return dateEntServ;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public void setNomAvion(String nomAvion) {
        this.nomAvion = nomAvion;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setDateEntServ(Date dateEntServ) {
        this.dateEntServ = dateEntServ;
    }
    


    @Override
    public String toString() {
        return "Avion{" + "nbPlace=" + nbPlace + ", nomAvion=" + nomAvion + ", modele=" + modele +'}';
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
        final Avion other = (Avion) obj;
        if (this.idAvion != other.idAvion) {
            return false;
        }
        return true;
    }

   


   


}