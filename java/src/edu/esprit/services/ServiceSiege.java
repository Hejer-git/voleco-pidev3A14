/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Siege;
import edu.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismail
 */
public class ServiceSiege implements ISiege<Siege> {

    private Connection conn;

    public ServiceSiege() {
        conn = DataSource.getInstance().getCnx();
    }

    
    @Override
    public void insert(Siege s) {
        try {
            String query = "INSERT INTO siege ( numSiege, etat) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, s.getNum());
            statement.setString(2, s.getEtat());    
            statement.executeUpdate();
             System.out.println("Reservation created !");
        } catch (SQLException ex) {
            System.out.println("Error while inserting the event: " + ex.getMessage());
        }   
        
        
    }

    @Override
    public void delete(Siege s) {
        try {
            // create a PreparedStatement to delete the event with the specified id
            PreparedStatement ps = conn.prepareStatement("DELETE FROM siege WHERE idSiege   = ?");
            ps.setInt(1, s.getId());

            // execute the PreparedStatement
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error dans la suppresion " + ex.getMessage());
        }    
    }

    @Override
    public void update(Siege s) {
        try {
            String query = "UPDATE siege SET numSiege = ?, etat = ? WHERE idSiege  = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, s.getNum());
            statement.setString(2, s.getEtat());
            statement.setInt(3, s.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<Siege> readAll() {
        List<Siege> Sieges = new ArrayList<>();
        String sql = "SELECT *  FROM siege";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idSiege");
                int num = rs.getInt("numSiege");
                String etat = rs.getString("etat");
                Siege s = new Siege(id,num,etat);
                Sieges.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Sieges;
    }

    @Override
    public Siege readById(int id) {
    try {
            String query = "SELECT * FROM siege WHERE idSiege = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int idd = rs.getInt("idSiege");
                int num = rs.getInt("numSiege");
                String etat = rs.getString("etat");

                return new Siege(idd,num,etat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    
  
    
   
}

