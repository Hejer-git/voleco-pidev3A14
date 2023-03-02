/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.tests;
import edu.reclamation.entities.Reclamation;
import edu.reclamation.services.ServiceReclamation;
import edu.reclamation.utils.DataSource;
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
      //  Reclamation r1 = new Reclamation ("Abdelaziz", "M",dateRec);
        //Reclamation r2 = new Reclamation("Tarak", "Ayari",dateRec1);
       
        ServiceReclamation sp = new ServiceReclamation();
        
       // sp.ajouterRec(r1);
       //sp.ajouterRec(r2);
      
        // sp.supprimerRec(9);
       /* sp.getOneById(3);
        sp.getAll();*/
//       sp.modifierRec(r2);
        
    }
}
