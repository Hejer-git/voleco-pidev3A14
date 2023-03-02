/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.entities;

import java.util.Date;

/**
 * @author 21629
 */
public class Offre {
    private int idOffre ;
    private String nomOffre;
    private Date dateDebO ;
    private Date dateFinO;
    private String DestinationOffre;
    private String DescripOffre;
    private int PrixOffre;
    private int idPromo;

    public Offre(int idOffre, String nomOffre, Date dateDebO, Date dateFinO, String DestinationOffre, String DescripOffre, int PrixOffre, int idPromo) {
        this.idOffre = idOffre;
        this.nomOffre = nomOffre;
        this.dateDebO = dateDebO;
        this.dateFinO = dateFinO;
        this.DestinationOffre = DestinationOffre;
        this.DescripOffre = DescripOffre;
        this.PrixOffre = PrixOffre;
        this.idPromo = idPromo;
    }

    public Offre(String nomOffre, Date dateDebO, Date dateFinO, String DestinationOffre, String DescripOffre, int PrixOffre, int idPromo) {
        this.nomOffre = nomOffre;
        this.dateDebO = dateDebO;
        this.dateFinO = dateFinO;
        this.DestinationOffre = DestinationOffre;
        this.DescripOffre = DescripOffre;
        this.PrixOffre = PrixOffre;
        this.idPromo = idPromo;
    }

    public Offre() {
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public String getNomOffre() {
        return nomOffre;
    }

    public void setNomOffre(String nomOffre) {
        this.nomOffre = nomOffre;
    }

    public Date getDateDebO() {
        return dateDebO;
    }

    public void setDateDebO(Date dateDebO) {
        this.dateDebO = dateDebO;
    }

    public Date getDateFinO() {
        return dateFinO;
    }

    public void setDateFinO(Date dateFinO) {
        this.dateFinO = dateFinO;
    }

    public String getDestinationOffre() {
        return DestinationOffre;
    }

    public void setDestinationOffre(String DestinationOffre) {
        this.DestinationOffre = DestinationOffre;
    }

    public String getDescripOffre() {
        return DescripOffre;
    }

    public void setDescripOffre(String DescripOffre) {
        this.DescripOffre = DescripOffre;
    }

    public int getPrixOffre() {
        return PrixOffre;
    }

    public void setPrixOffre(int PrixOffre) {
        this.PrixOffre = PrixOffre;
    }

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
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
        final Offre other = (Offre) obj;
        if (this.idOffre != other.idOffre) {
            return false;
        }
        return true;
    }

   
    
    
}
