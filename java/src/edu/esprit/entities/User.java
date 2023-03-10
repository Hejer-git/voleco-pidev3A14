/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Objects;

/**
 *
 * @author ahmed
 */
public class User {
   
    private  int id;
    private  int cin;
    private String nom;
    private String prenom;
    private String email;
    private  int numtel;
    private  int salaire;
    private String password;
    private int resetcode;
    private String img;

    public User() {
    }
    public User(int id, int cin, String nom, String prenom, String email, int numtel, int salaire, String password, int resetcode, String img) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numtel = numtel;
        this.salaire = salaire;
        this.password = password;
        this.resetcode = resetcode;
        this.img = img;
    }
    public User(int id, int cin, String nom, String prenom, String email, int numtel, int salaire) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numtel = numtel;
        this.salaire = salaire;
    }

    public User(int cin, String nom, String prenom, String email, int numtel, int salaire) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numtel = numtel;
        this.salaire = salaire; 
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getResetcode() {
        return resetcode;
    }

    public void setResetcode(int resetcode) {
        this.resetcode = resetcode;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", numtel=" + numtel + ", salaire=" + salaire + ", password=" + password + ", resetcode=" + resetcode + ", img=" + img + '}';
    }
    
   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        return hash;
    }

    
    
}
