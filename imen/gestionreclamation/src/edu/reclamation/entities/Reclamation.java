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
    private String nomC, description,typer,image;
    private Date dateRec;

public Reclamation(){}

    public Reclamation(String nomC, String description, Date dateRec,int type,String image) {
        this.nomC = nomC;
        this.description = description;
        this.dateRec = dateRec;
        this.type = type;
        this.image=image;
    }
     public Reclamation(String nomC, String description,int type,String image) {
        this.nomC = nomC;
        this.description = description;
       this.image=image;
        this.type = type;
    }

    public Reclamation(int idRec, String nomC, String description, Date dateRec,int type,String image) {
        this.idRec = idRec;
        this.nomC = nomC;
        this.description = description;
        this.dateRec = dateRec;
        this.type = type;
        this.image=image;
    }

 
    public int getIdRec() {
        return idRec;
    }

    public void setIdRec(int idRec) {
        this.idRec = idRec;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image=image;
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
     public String gettype() {
        return typer;
    }

    public void settype(String typer) {
        this.typer = typer;
    }
    @Override
    public String toString() {
        return "Reclamation{" + "nomC=" + nomC + ", description=" + description + ", dateRec=" + dateRec +", type=" + type +", image=" + image + '}';
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
