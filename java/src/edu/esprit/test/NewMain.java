/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.test;

import edu.esprit.entities.Reservation;
import edu.esprit.services.ServiceReservation;
import edu.esprit.entities.Siege;
import edu.esprit.services.ServiceSiege;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ismail
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Siege> sieges = new ArrayList<>();
        //User u = new User(11111111, "mhiri", "ismail", "esprit.tn", 96388611, 30000);
        Siege s = new Siege();

        //u.setId(3);
        ServiceSiege service = new ServiceSiege();
        //service.update(u);
        //u = service.readById(1);
        System.out.println(s);
    }
    
}
