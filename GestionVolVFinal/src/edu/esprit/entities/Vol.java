/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author ghassen
 */
public class Vol {
    private int idVol;
    private int numVol;
    private String heureDep;
    private String heureArr;
    public  Date dateDep;
    public  Date dateArr;
    private  int dureeVol;
    private  String NomAvion;
    private int idAvion;
    public Avion avion;
    
    

    public String getIdAvion() {
        return NomAvion;
    }

    public void setIdAvion(String NomAvion) {
        this.NomAvion = NomAvion;
    }

    public Vol() {
    }

    public Vol(int numVol, String heureDep, String heureArr, Date dateDep, Date dateArr,int dureeVol,int idAvion) {
        this.numVol = numVol;
        this.heureDep = heureDep;
        this.heureArr = heureArr;
        this.dateDep = dateDep;
        this.dateArr = dateArr;
        this.dureeVol = dureeVol;
        this.idAvion = idAvion;
    }

    public Vol(int idVol, int numVol, String heureDep, String heureArr, Date dateDep, Date dateArr, int dureeVol,int idAvion) {
        this.idVol = idVol;
        this.numVol = numVol;
        this.heureDep = heureDep;
        this.heureArr = heureArr;
        this.dateDep = dateDep;
        this.dateArr = dateArr;
        this.dureeVol = dureeVol;
        this.idAvion = idAvion;
    }

    public void setidAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public int getidAvion() {
        return idAvion;
    }

    public int getIdVol() {
        return idVol;
    }

    public int getNumVol() {
        return numVol;
    }

    public String getHeureDep() {
        return heureDep;
    }

    public String getHeureArr() {
        return heureArr;
    }

    public Date getDateDep() {
        return dateDep;
    }

    public Date getDateArr() {
        return dateArr;
    }

    public int getDureeVol() {
        return dureeVol;
    }

    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }

    public void setNumVol(int numVol) {
        this.numVol = numVol;
    }

    public void setHeureDep(String heureDep) {
        this.heureDep = heureDep;
    }

    public void setHeureArr(String heureArr) {
        this.heureArr = heureArr;
    }

    public void setDateDep(Date dateDep) {
        this.dateDep = dateDep;
    }

    public void setDateArr(Date dateArr) {
        this.dateArr = dateArr;
    }

    public void setDureeVol(int dureeVol) {
        this.dureeVol = dureeVol;
    }
   
  
    
}
