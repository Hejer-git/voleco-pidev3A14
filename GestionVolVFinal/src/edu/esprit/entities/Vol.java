/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.sql.Time;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author ghassen
 */
public class Vol {
    private int idVol;
    private int numVol;
   
    public  Date dateDep;
    public  Date dateArr;
    private  int dureeVol;
    private  String NomAvion;
    private int idAvion;
    
    public Time timeDep;
    public Time timeArr;
    public String adrDep;
     public String adrArr;
     public int prix;
     
     public String aeoDep;
     public String aeoArr;

    public String getAeoDep() {
        return aeoDep;
    }

    public String getAeoArr() {
        return aeoArr;
    }

    public void setAeoDep(String aeoDep) {
        this.aeoDep = aeoDep;
    }

    public void setAeoArr(String aeoArr) {
        this.aeoArr = aeoArr;
    }
     

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    

    public String getAdrDep() {
        return adrDep;
    }

    public String getAdrArr() {
        return adrArr;
    }

    public void setAdrDep(String adrDep) {
        this.adrDep = adrDep;
    }

    public void setAdrArr(String adrArr) {
        this.adrArr = adrArr;
    }

    
    
    
    
    
    
    
    public Time getTimeArr() {
        return timeArr;
    }

    public void setTimeArr(Time timeArr) {
        this.timeArr = timeArr;
    }

   

    public Time getTimeDep() {
        return timeDep;
    }

    
   

    
    public Vol(int idVol, int numVol, Time timeDep,Time timeArr, Date dateDep, Date dateArr, int dureeVol, int idAvion,String adrDep,String adrArr,int prix,String aeoDep,String aeoArr) {
        this.idVol = idVol;
        this.numVol = numVol;
        this.timeDep = timeDep;
         this.timeArr = timeArr;
        this.dateDep = dateDep;
        this.dateArr = dateArr;
        this.dureeVol = dureeVol;
        this.idAvion = idAvion;
         this.adrDep = adrDep;
          this.adrArr = adrArr;
          this.prix = prix;
          
          this.aeoDep = aeoDep;
          this.aeoArr = aeoArr;
       
    }

    public Vol(int numVol, Time timeDep,Time timeArr, Date dateDep, Date dateArr, int dureeVol, int idAvion,String adrDep,String adrArr,int prix,String aeoDep,String aeoArr) {
        this.numVol = numVol;
        this.timeDep = timeDep;
         this.timeArr = timeArr;
        this.dateDep = dateDep;
        this.dateArr = dateArr;
        this.dureeVol = dureeVol;
        this.idAvion = idAvion;
        this.adrDep = adrDep;
          this.adrArr = adrArr;
          this.prix = prix;
          
          this.aeoDep = aeoDep;
          this.aeoArr = aeoArr;
    }

    public void setTimeDep(Time timeDep) {
        this.timeDep = timeDep;
    }
    
    

    public String getIdAvion() {
        return NomAvion;
    }

    public void setIdAvion(String NomAvion) {
        this.NomAvion = NomAvion;
    }

    public Vol() {
    }
//
//    public Vol(int numVol, String heureDep, String heureArr, Date dateDep, Date dateArr,int dureeVol,int idAvion) {
//        this.numVol = numVol;
//        this.heureDep = heureDep;
//        this.heureArr = heureArr;
//        this.dateDep = dateDep;
//        this.dateArr = dateArr;
//        this.dureeVol = dureeVol;
//        this.idAvion = idAvion;
//    }

//    public Vol(int idVol, int numVol, String heureDep, String heureArr, Date dateDep, Date dateArr, int dureeVol,int idAvion) {
//        this.idVol = idVol;
//        this.numVol = numVol;
//        this.heureDep = heureDep;
//        this.heureArr = heureArr;
//        this.dateDep = dateDep;
//        this.dateArr = dateArr;
//        this.dureeVol = dureeVol;
//        this.idAvion = idAvion;
//    }

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
