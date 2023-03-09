/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.services;
import edu.reclamation.entities.Reclamation;
import edu.reclamation.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
/**
 *
 * @author imen
 */
public class ServiceReclamation implements IService<Reclamation> {
    Connection cnx = DataSource.getInstance().getCnx();
    
    
    @Override
   public void ajouterRec(Reclamation r) {
      // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date dd=r.getDateRec();
        try {
           String req = "INSERT INTO `reclamation` (`nomC`, `description`,`dateRec`,`type`,`image`) VALUES ('" + r.getNomC() + "', '" + r.getDescription() + "', '"+(r.getDateRec())+"', '"+(r.getType())+"', '"+(r.getImage())+"')";
             Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  

    

@Override
    public void supprimerRec(Reclamation r) {
     
        try {
            // create a PreparedStatement to delete the event with the specified id
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM reclamation WHERE idRec = ?");
            ps.setInt(1, r.getIdRec());

            // execute the PreparedStatement
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error dans la suppresion " + ex.getMessage());
        }    
    }
  @Override
    public void modifierRec(Reclamation r) {
        try {
              String req = "UPDATE `reclamation` SET `nomC` = '" + r.getNomC() + "', `description` = '" + r.getDescription() + "', `dateRec` = '" + r.getDateRec()+"', `type` = '" + r.getType()+ "',`image`='"+r.getImage()+"' WHERE `reclamation`.`idRec` = " + r.getIdRec();

            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("rec updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   @Override
    public List<Reclamation> getAll() {
        List<Reclamation> list = new ArrayList<>();
        try {
            String req = "Select * from reclamation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reclamation r = new Reclamation(rs.getInt(1), rs.getString("nomC"), rs.getString("description"),rs.getDate("dateRec"),rs.getInt("type"),rs.getString("image"));
                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;}
    
        @Override
    public Reclamation getOneById(int idRec) {
        Reclamation r = null;
        try {
            String req = "Select * from reclamation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                r = new Reclamation(rs.getInt(1), rs.getString("nomC"), rs.getString("description"),rs.getDate("dateRec"),rs.getInt("type"),rs.getString("image"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return r;
    }
  public List<Reclamation> recherche(String nomRec ) {
        List<Reclamation> list = new ArrayList<>();
          try {
            String req = "Select * from reclamation";
            PreparedStatement statement = cnx.prepareStatement(req);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Reclamation s = new Reclamation(rs.getInt(1), rs.getString("nomC"),rs.getString("description"),rs.getDate("dateRec"),rs.getInt("type"),rs.getString("image"));
                list.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        list=list.stream().filter(e -> e.getNomC().contains(nomRec)).collect(Collectors.toList());
        return list;
    }
    
    public List<Reclamation> Trie(String sortOrder , List<Reclamation> list) {
       if(sortOrder=="ASC"){         
       list = list.stream().sorted((o1, o2)->o1.getNomC().
                                   compareTo(o2.getNomC())).
                                   collect(Collectors.toList());
       }
       else{     list = list.stream()
                                        .sorted(Comparator.comparing(Reclamation::getNomC).reversed())
                                         .collect(Collectors.toList());
       }
  
           
               
        return list;
    } 
    
      /*  public String bad_words(String badWord) {

        List<String> badListW = Arrays.asList("fuck","fuck u","shit");
        String badNew = "";
        List<String> newList = new ArrayList<>();
        for (String str : badListW) {
            if (badWord.contains(str)) {
                badNew += "" + str;
                if (str.length() >= 1) {
                    StringBuilder result = new StringBuilder();
                    result.append(str.charAt(0));
                    for (int i = 0; i < str.length() - 2; ++i) {
                        result.append("*");
                    }
                    result.append(str.charAt(str.length() - 1));
                    str = result.toString();
                    if (!str.isEmpty()) {
                        System.out.println("ATTENTION !! Vous avez écrit un gros mot  : " + result + " .C'est un avertissement ! Priére d'avoir un peu de respect ! Votre description sera envoyée comme suit :");
                        System.out.println(badWord.replace(badNew, "") + " ");
                    }
                }
            }
        }
        return (badWord.replace(badNew, "") + " ");
    }*/
    }
