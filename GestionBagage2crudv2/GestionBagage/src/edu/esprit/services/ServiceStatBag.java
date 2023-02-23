/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Bagage;
import edu.esprit.entities.StatutBagage;
import edu.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 21654
 */
public class ServiceStatBag implements IServiceSB<StatutBagage>{
    
     Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
     public void ajouterSB(StatutBagage sb) {

           try {
            String req = "INSERT INTO `statutbagage` (`statutB`, `comB`) VALUES ('" + sb.getStatutB()+ "','" + sb.getComB()+ "' )";

         Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("StatutBagage created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
     
      @Override
    public void supprimerSB(StatutBagage sb) {
        try {
            String req = "DELETE FROM `statutbagage` WHERE idStatBag = " + sb.getIdStatBag();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("StatutBagage deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void modifierSB(StatutBagage sb) {
        try {
            String req = "UPDATE `statutbagage` SET `statutB` = '" + sb.getStatutB()+ "', `comB` = '" + sb.getComB()+ "' WHERE `statutbagage`.`idStatBag` = " + sb.getIdStatBag();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("StatutBagage updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override
    public List<StatutBagage> getAllSB() {
        List<StatutBagage> listsb = new ArrayList<>();
        try {
            String req = "Select * from statutbagage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                StatutBagage sb = new StatutBagage(rs.getInt(1), rs.getString(2), rs.getString(3));
                listsb.add(sb);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listsb;
    }

    @Override
    public StatutBagage getSBById(int idStatBag) {
        StatutBagage sb = null;
        try {
            String req = "Select * from statutbagage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                sb = new StatutBagage(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return sb;
    }
}
