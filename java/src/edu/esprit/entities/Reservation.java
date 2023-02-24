/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;

/**
 *
 * @author ismail
 */
public class Reservation {
   
    private int id;
    private String nom;
    private String depart;
    private String destination;
    private Date date;
    private int bagage;
    private int idsiege;
    

    

    public Reservation() {
    }

    public Reservation(int id, String nom, String depart, String destination, Date date, int bagage,int idsiege) {
        this.id = id;
        this.nom = nom;
        this.depart = depart;
        this.destination = destination;
        this.date = date;
        this.bagage = bagage;
        this.idsiege = idsiege;
       
    }

    public Reservation(String nom, String depart, String destination, Date date, int bagage,int idsiege) {
        this.nom = nom;
        this.depart = depart;
        this.destination = destination;
        this.date = date;
        this.bagage = bagage; 
        this.idsiege = idsiege;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String Destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBagage() {
        return bagage;
    }

    public void setBagage(int bagage) {
        this.bagage = bagage;
    }
    public int getIdSiege() {
        return idsiege;
    }

    public void setIdSiege(int idsiege) {
        this.idsiege = idsiege;
    }
    
    
   @Override
    public String toString() {
        return "Reservation{" +
                ", nom='" + nom + '\'' +
                ", depart='" + depart + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", bagage='" + bagage + '\'' +
                 ", idsiege='" + idsiege + '\'' +
                '}';
    }
}
