/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.entities;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author imen
 */
public class Reclamation {
    private int idRec,type;
    private String nomC, description;
    private Date dateRec;

public Reclamation(){}

    public Reclamation(String nomC, String description, Date dateRec,int type) {
        this.nomC = nomC;
        this.description = description;
        this.dateRec = dateRec;
        this.type = type;
    }

    public Reclamation(int idRec, String nomC, String description, Date dateRec,int type) {
        this.idRec = idRec;
        this.nomC = nomC;
        this.description = description;
        this.dateRec = dateRec;
        this.type = type;
    }

 
    public int getIdRec() {
        return idRec;
    }

    public void setIdRec(int idRec) {
        this.idRec = idRec;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateRec() {
        return dateRec;
    }

    public void setDateRec(Date dateRec) {
        this.dateRec = dateRec;
    }
     public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Reclamation{" + "nomC=" + nomC + ", description=" + description + ", dateRec=" + dateRec +", type=" + type + '}';
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
        final Reclamation other = (Reclamation) obj;
        if (this.idRec != other.idRec) {
            return false;
        }
        return true;
    }

   


   


}
