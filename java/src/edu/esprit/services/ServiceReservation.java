/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Reservation;
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
public class ServiceReservation implements IReservation<Reservation> {

    private Connection conn;

    public ServiceReservation() {
        conn = DataSource.getInstance().getCnx();
    }

    
    @Override
    public void insert(Reservation r) {
        try {
            String query = "INSERT INTO reservation ( nomres, depart, destination, dateres, bagage) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, r.getNom());
            statement.setString(2, r.getDepart());
            statement.setString(3, r.getDestination());
            statement.setDate(4, (Date) r.getDate());
            statement.setInt(5, r.getBagage());
            
            statement.executeUpdate();
             System.out.println("Reservation created !");
        } catch (SQLException ex) {
            System.out.println("Error while inserting the event: " + ex.getMessage());
        }   
        
        
    }

    @Override
    public void delete(Reservation r) {
        try {
            // create a PreparedStatement to delete the event with the specified id
            PreparedStatement ps = conn.prepareStatement("DELETE FROM reservation WHERE idRes  = ?");
            ps.setInt(1, r.getId());

            // execute the PreparedStatement
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error dans la suppresion " + ex.getMessage());
        }    
    }

    @Override
    public void update(Reservation r) {
        try {
            String query = "UPDATE reservation SET nomres = ?, depart = ?, destination = ?, dateres = ?, bagage = ? WHERE idRes = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, r.getNom());
            statement.setString(2, r.getDepart());
            statement.setString(3, r.getDestination());
            statement.setDate(4, (Date) r.getDate());
            statement.setInt(5, r.getBagage());
            statement.setInt(6, r.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<Reservation> readAll() {
        List<Reservation> Reservations = new ArrayList<>();
        String sql = "SELECT *  FROM reservation";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idRes");
                String nom = rs.getString("nomres");
                String depart = rs.getString("depart");
                String destination = rs.getString("destination");
                Date date = rs.getDate("dateres");
                int bagage = rs.getInt("bagage");
                Reservation r = new Reservation(id,nom,depart,destination,date,bagage);
                Reservations.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Reservations;
    }

    @Override
    public Reservation readById(int id) {
    try {
            String query = "SELECT * FROM reservation WHERE idRes = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int idd = rs.getInt("idRes");
                String nom = rs.getString("nomres");
                String depart = rs.getString("depart");
                String destination = rs.getString("destination");
                Date date = rs.getDate("dateres");
                int bagage = rs.getInt("bagage");

                return new Reservation(idd,nom,depart,destination,date,bagage);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    
  
    
   
}
