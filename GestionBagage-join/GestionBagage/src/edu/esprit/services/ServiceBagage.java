/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Bagage;
import edu.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
/**
 *
 * @author 21654
 */
public class ServiceBagage implements IServiceB<Bagage> {
    
     Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
     public void ajouter(Bagage b) {
        LocalDate dateB = LocalDate.now();

           try {
            String req = "INSERT INTO `bagage` (`poids`, `taille`, `frais`, `dateB`,`idStatBag`) VALUES ('" + b.getPoids()+ "','" + b.getTaille()+ "', '" + b.getFrais()+ "', '" + b.getDateB() + "', '" + b.getidStatBag()+ "')";

         Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Bagage created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    @Override
    public void supprimer(Bagage b) {
        try {
            String req = "DELETE FROM `bagage` WHERE idBagage = " + b.getIdBagage();
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
            String req = "UPDATE `bagage` SET `poids` = '" + b.getPoids()+ "', `taille` = '" + b.getTaille()+ "', `frais` = '" + b.getFrais()+ "', `dateB` = '" + b.getDateB()+ "', `idStatBag` = '" + b.getidStatBag()+ "' WHERE `bagage`.`idBagage` = " + b.getIdBagage();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Bagage updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override
    public List<Bagage> getAllB() {
        List<Bagage> list = new ArrayList<>();
        try {
            String req = "Select * from bagage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Bagage b = new Bagage(rs.getInt(1), rs.getFloat(2), rs.getFloat(3),rs.getFloat(4), rs.getDate(5), rs.getInt(6));
                list.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Bagage getBagById(int idBagage) {
        Bagage b = null;
        try {
            String req = "Select * from bagage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                b = new Bagage(rs.getInt(1), rs.getFloat(2), rs.getFloat(3),rs.getFloat(4), rs.getDate(5), rs.getInt(6));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return b;
    }
    
    
    public List<Bagage> rechercher(int poids) {
        List<Bagage> list = new ArrayList<>();
          try {
            String req = "Select * from bagage ";
            PreparedStatement statement = cnx.prepareStatement(req);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Bagage b = new Bagage(rs.getInt(1), rs.getFloat(2), rs.getFloat(3),rs.getFloat(4), rs.getDate(5), rs.getInt(6));
                list.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        list=list.stream().filter(e -> String.valueOf(e.getPoids()).contains(String.valueOf(poids))).collect(Collectors.toList());
        return list;
    }
    
    public List<Bagage> TriParPoids(String sortOrder , List<Bagage> list) {
    Comparator<Bagage> bagComparator = Comparator.comparing(Bagage::getPoids);
    if(sortOrder.equalsIgnoreCase("ASC")){         
        list = list.stream().sorted(bagComparator).collect(Collectors.toList());
    } else {
        list = list.stream().sorted(bagComparator.reversed()).collect(Collectors.toList());
    }
    return list;
}
    
    
    public int countRetrouves() {
        int nbRetrouves = 0;
        try {
            String req = "SELECT COUNT(*) AS nbRetrouves FROM bagage "
                       + "JOIN statutbagage ON bagage.idStatBag = statutbagage.idStatBag "
                       + "WHERE statutbagage.statutB = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, "Bagage retrouvé");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nbRetrouves = rs.getInt("nbRetrouves");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nbRetrouves;
    }
    
    public int countPerdus() {
        int nbPerdus = 0;
        try {
            String req = "SELECT COUNT(*) AS nbPerdus FROM bagage "
                       + "JOIN statutbagage ON bagage.idStatBag = statutbagage.idStatBag "
                       + "WHERE statutbagage.statutB = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, "Bagage perdu");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nbPerdus = rs.getInt("nbPerdus");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nbPerdus;
    }
    
    public int countVoles() {
        int nbVoles = 0;
        try {
            String req = "SELECT COUNT(*) AS nbVoles FROM bagage "
                       + "JOIN statutbagage ON bagage.idStatBag = statutbagage.idStatBag "
                       + "WHERE statutbagage.statutB = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, "Bagage volé");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nbVoles = rs.getInt("nbVoles");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nbVoles;
    }
    
     public int countSuspect() {
        int nbSusps = 0;
        try {
            String req = "SELECT COUNT(*) AS nbSusps FROM bagage "
                       + "JOIN statutbagage ON bagage.idStatBag = statutbagage.idStatBag "
                       + "WHERE statutbagage.statutB = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, "Bagage suspect");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nbSusps = rs.getInt("nbSusps");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nbSusps;
    }
     
}
