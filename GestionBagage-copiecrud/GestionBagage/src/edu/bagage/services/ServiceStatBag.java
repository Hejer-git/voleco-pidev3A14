/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bagage.services;

import edu.bagage.entities.StatutBagage;
import edu.bagage.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServiceStatBag implements IService2<StatutBagage> {
    
     Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    public void ajouterSB(StatutBagage sb) {
           try {
            String req = "INSERT INTO `statutbagage` (`statActuel`, `comB`) VALUES ('" + sb.getStatActuel() + "', '" + sb.getComB() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("StatutBagage created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    
    @Override
    public void supprimerSB(int idStatBag) {
        try {
            String req = "DELETE FROM `statutbagage` WHERE idStatBag = " + idStatBag;
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
            String req = "UPDATE `statutbagage` SET `statActuel` = '" + sb.getStatActuel()+ "', `comB` = '" + sb.getComB()+ "' WHERE `statutbagage`.`idStatBag` = " + sb.getIdStatBag();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("StatutBagage updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<StatutBagage> getAll() {
        List<StatutBagage> list = new ArrayList<>();
        try {
            String req = "Select * from statutbagage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                StatutBagage sb = new StatutBagage(rs.getString(1), rs.getString(2));
                list.add(sb);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public StatutBagage getOneById(int idStatBag) {
        StatutBagage sb = null;
        try {
            String req = "Select * from statutbagage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                sb = new StatutBagage(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return sb;
    }

    
}


