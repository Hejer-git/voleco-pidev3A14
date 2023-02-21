/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vol.tests;
import edu.vol.entities.Avion;
import edu.vol.services.ServiceVol;
import edu.vol.utils.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author imen
 */
public class MainClass {
    public static void main(String[] args) {
        Date dateRec =new Date(2000,10,02); 
        Date dateRec1 =new Date(2001,10,02); 
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
       // Avion 1 = new Reclamation ("Abdelaziz", "M",dateRec);
       // Reclamation r2 = new Reclamation("Tarak", "Ayari",dateRec1);
       
        ServiceVol sp = new ServiceVol();
        
       // sp.ajouterRec(r1);
       //sp.ajouterRec(r2);
      
        // sp.supprimerRec(9);
       /* sp.getOneById(3);
        sp.getAll();*/
//       sp.modifierRec(r2);
        
    }
}
