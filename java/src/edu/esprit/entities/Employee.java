/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author ahmed
 */
public class Employee extends User {
   


    public Employee() {

    }

    public Employee(int id, int cin, String nom, String prenom, String email, int numtel, int salaire, String password, int resetcode, String img) {
                super(id, cin, nom, prenom, email, numtel, salaire, password, resetcode, img);
    }

    public Employee(int id, int cin, String nom, String prenom, String email, int numtel, int salaire) {
        super(id, cin, nom, prenom, email, numtel, salaire);
    }

    public Employee(int cin, String nom, String prenom, String email, int numtel, int salaire) {
        super(cin, nom, prenom, email, numtel, salaire);
    }
    
    
   
}
