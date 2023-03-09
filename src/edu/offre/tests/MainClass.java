/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.tests;
import edu.offre.entities.Offre;
import edu.offre.entities.Promo;
import edu.offre.services.ServiceOffre;
import edu.offre.services.ServicePromo;
import edu.offre.utils.DataSource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 21629
 */
public class MainClass {
    
     public static void main(String[] args) throws Exception {
                 List<Offre> Offres = new ArrayList<>();
    

        long millis=System.currentTimeMillis();  
        java.sql.Date date1=new java.sql.Date(millis); 
        
          
        java.sql.Date date2=new java.sql.Date(millis);
        
        Offre o1 = new Offre("offre8",date1,date2,"Egypt","offre pour couple",50,12);
        
      
        
        
      

        //Offre o2 = new Offre("offre2",d3,d4,"Maroc","offre pour amis",1000);
            
         //so.ajouteroffre(o1);
         //so.ajouteroffre(o2);
         // so.supprimeroffre(16);
       
    /* Promo p1 = new Promo("Amira20",20);
      ServicePromo sp = new ServicePromo();
         //sp.ajouterpromo(p1);
      sp.supprimerpromo(p1);*/
  /*  ServiceOffre so = new ServiceOffre();
   ServicePromo sp = new ServicePromo();
    Promo p = sp.getOneById(6,39);
    int prix=so.getOneById().getPrixOffre();
    float red = p.getReduction();
         System.out.println(prix-(red/100*prix));*/
    }
} 
