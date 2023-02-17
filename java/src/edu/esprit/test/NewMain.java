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

        List<Reservation> Reservations = new ArrayList<>();
        List<Siege> Sieges = new ArrayList<>();

        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
        
        Reservation r = new Reservation(2,"res2","sbitla", "abilia", date, 40);
        Reservation r1 = new Reservation();

        Siege s = new Siege(122,"reserve");
        Siege s2 = new Siege(1,120,"reserve");
        Siege s3 = new Siege();
        s3.setId(2);
        
        
        ServiceReservation sr = new ServiceReservation();
        ServiceSiege ss = new ServiceSiege();
        
        //r.setId(2);
        //sr.update(r);
        //r1 = sr.readById(1);
        //Reservations = sr.readAll();

        //ss.insert(s);
        //ss.update(s2);
        ss.delete(s3);
        //System.out.println(r1);
        //System.out.println(Reservations);
        
        Sieges = ss.readAll();
        System.out.println(Sieges);

        
        
        
        //Reservation r = new Reservation();

        
        
        //u.setId(3);
        
    }
    
}
