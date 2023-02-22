/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bagage.services;

import edu.bagage.entities.Bagage;
import edu.bagage.entities.StatutBagage;
import edu.bagage.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceBagage implements IService<Bagage> {
    
    Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
     public void ajouter(Bagage b) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date1 = simpleDateFormat.format(new Date());

           try {
            String req = "INSERT INTO `bagage` (`poids`, `taille`, `frais`, `dateB`) VALUES ('" + b.getPoids()+ "','" + b.getTaille()+ "', '" + b.getFrais()+ "', '" +date1 + "')";

         Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Bagage created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    
    @Override
    public void supprimer(int idBagage) {
        try {
            String req = "DELETE FROM `bagage` WHERE idBagage = " + idBagage;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Bagage deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void modifier(Bagage b) {
        try {
            String req = "UPDATE `bagage` SET `poids` = '" + b.getPoids()+ "', `taille` = '" + b.getTaille()+ "', `frais` = '" + b.getFrais()+ "', `dateB` = '" + b.getDateB()+ "' WHERE `bagage`.`idBagage` = " + b.getIdBagage();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Bagage updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
 
    
    @Override
    public List<Bagage> getAll() {
        List<Bagage> list = new ArrayList<>();
        try {
            String req = "Select * from bagage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Bagage b = new Bagage(rs.getInt(1), rs.getFloat(2), rs.getFloat(3),rs.getFloat(4), rs.getDate(5));
                list.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Bagage getOneById(int idBagage) {
        Bagage b = null;
        try {
            String req = "Select * from bagage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                b = new Bagage(rs.getInt(1), rs.getFloat(2), rs.getFloat(3),rs.getFloat(4), rs.getDate(5));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return b;
    }

}


