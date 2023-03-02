/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.services; 

import edu.offre.entities.Offre; 
import edu.offre.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
/**
 *
 * @author 21629
 */

public class ServiceOffre implements IOffre<Offre>{
    Connection cnx = DataSource.getInstance().getCnx();
    
      @Override
       public void ajouteroffre (Offre o)throws Exception {
        //  SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd");
        //  Date dd1= o.getDateDebO();
         // Date dd2= o.getDateFinO();
          
  /*        System.out.println("service : "+o.getDateDebO());
String pattern = "yyyy-MM-dd";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

String date1 = simpleDateFormat.format(new Date());
String date2 = simpleDateFormat.format(new Date());
  System.out.println("service : "+date1+"   --------> "+simpleDateFormat.format(new Date()));
  */
           try {
     String query = "INSERT INTO Offre ( nomOffre, dateDebO, dateFinO, DestinationOffre,DescripOffre,PrixOffre,idPromo) VALUES (?, ?, ?, ?, ?,?,?)";
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setString(1, o.getNomOffre());
             statement.setDate(2, (java.sql.Date) o.getDateDebO());
              statement.setDate(3, (java.sql.Date) o.getDateFinO());
            statement.setString(4,o.getDestinationOffre());
            statement.setString(5,o.getDescripOffre());
             statement.setInt(6, o.getPrixOffre());
              statement.setInt(7,o.getIdPromo());
            
            statement.executeUpdate();
             System.out.println("Offre created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   public void supprimerOffre(Offre o) {
        try {
        String req = "DELETE FROM `offre` WHERE idOffre = " + o.getIdOffre() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Offre deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
      @Override
    public void modifieroffre(Offre o) {
        try {
            //  String req = "UPDATE `offre` SET `nomOffre` = '" + o.getNomOffre() + "', `dateDebO` = '" + o.getDateDebO() + "' ,`dateFinO` = '" + o.getDateFinO()+ "',`DestinationOffre` = '" + o.getDestinationOffre() + "',`DescripOffre` = '" + o.getDescripOffre()+ "',`PrixOffre` = '" + o.getPrixOffre()+ " WHERE `idOffre` = " + o.getIdOffre();
             String req = "UPDATE `offre` SET `nomOffre` = '" + o.getNomOffre() + "', `dateDebO` = '" + o.getDateDebO() + "' ,`dateFinO` = '" + o.getDateFinO()+ "',`DestinationOffre` = '" + o.getDestinationOffre() + "',`DescripOffre` = '" + o.getDescripOffre()+ "',`PrixOffre` = '" + o.getPrixOffre()+ "',`idPromo` = '" + o.getIdPromo()+ "' WHERE `idOffre` = " + o.getIdOffre();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Offre updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
      @Override
    public List<Offre> getAll() {
        List<Offre> list = new ArrayList<>();
        try {
            String req = "Select * from offre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
               Offre o = new Offre(rs.getInt(1), rs.getString(2), rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
                list.add(o);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

   
    public Offre getOneById2(int idOffre) {
        Offre o= null;
        try {
            String req = "Select * from offre where idOffre="+idOffre;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            rs.next();
                o = new Offre(rs.getInt(1), rs.getString(2), rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return o;
    }
    

    public Offre getOneById() {
        Offre o= null;
        try {
            String req = "Select * from offre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            rs.next();
                o = new Offre(rs.getInt(1), rs.getString(2), rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return o;
    }
public List<Offre> recherche(String DestinationOffre ) {
        List<Offre> list = new ArrayList<>();
          try {
            String req = "Select * from offre";
            PreparedStatement statement = cnx.prepareStatement(req);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Offre o = new Offre(rs.getInt(1), rs.getString(2), rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
                list.add(o);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        list=list.stream().filter(e -> e.getDestinationOffre().contains(DestinationOffre)).collect(Collectors.toList());
        return list;
    }
    
    public List<Offre> Trie(String sortOrder , List<Offre> list) {
       if(sortOrder=="ASC"){         
       list = list.stream().sorted((o1, o2)->o1.getNomOffre().
                                   compareTo(o2.getNomOffre())).
                                   collect(Collectors.toList());
       }
       else{     list = list.stream()
                                        .sorted(Comparator.comparing(Offre::getNomOffre).reversed())
                                         .collect(Collectors.toList());
       }
  
           
               
        return list;
    }
    
    

   


}
