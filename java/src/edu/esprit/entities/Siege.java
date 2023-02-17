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
public class Siege {
   
    private int id;
    private int num;
    private String etat;

    public Siege() {
    }

    public Siege(int id, int num, String etat) {
        this.id = id;
        this.num = num;
        this.etat = etat;
       
    }

    public Siege(int num, String etat) {
        this.num = num;
        this.etat = etat; 
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    
   @Override
    public String toString() {
        return "Siege{" +
                " num='" + num + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }
}
