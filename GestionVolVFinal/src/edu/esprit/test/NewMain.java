/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.test;

import edu.esprit.entities.Avion;
import edu.esprit.services.ServiceAvion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Avion> users = new ArrayList<>();
        //User u = new User(11111111, "mhiri", "ismail", "esprit.tn", 96388611, 30000);
        Avion u = new Avion();

        //u.setId(3);
        ServiceAvion service = new ServiceAvion();
        //service.update(u);
        //u = service.readById(1);
        System.out.println(u);
    }
    
}
