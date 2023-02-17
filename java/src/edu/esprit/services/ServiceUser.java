/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.User;
import edu.esprit.utils.DataSource;
import java.sql.Connection;
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
 * @author ahmed
 */
public class ServiceUser implements IUser<User> {

    private Connection conn;

    public ServiceUser() {
        conn = DataSource.getInstance().getCnx();
    }

    
    @Override
    public void insert(User u) {
        try {
            String query = "INSERT INTO utilisateur ( nom, prenom, cin, salaire, numtel, email) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, u.getNom());
            statement.setString(2, u.getPrenom());
            statement.setInt(3, u.getCin());
            statement.setInt(4, u.getSalaire());
            statement.setInt(5, u.getNumtel());
            statement.setString(6, u.getEmail());
            
            statement.executeUpdate();
             System.out.println("Personne created !");
        } catch (SQLException ex) {
            System.out.println("Error while inserting the event: " + ex.getMessage());
        }   
        
        
    }

    @Override
    public void delete(User u) {
        try {
            // create a PreparedStatement to delete the event with the specified id
            PreparedStatement ps = conn.prepareStatement("DELETE FROM utilisateur WHERE iduser = ?");
            ps.setInt(1, u.getId());

            // execute the PreparedStatement
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error dans la suppresion " + ex.getMessage());
        }    
    }

    @Override
    public void update(User u) {
        try {
            String query = "UPDATE utilisateur SET nom = ?, prenom = ?, cin = ?, salaire = ?, numtel = ?, email = ? WHERE iduser = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, u.getNom());
            statement.setString(2, u.getPrenom());
            statement.setInt(3, u.getCin());
            statement.setInt(4, u.getSalaire());
            statement.setInt(5, u.getNumtel());
            statement.setString(6, u.getEmail());
            statement.setInt(7, u.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<User> readAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT *  FROM utilisateur";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("iduser");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                int cin = rs.getInt("cin");
                int numtel = rs.getInt("numtel");
                int salaire = rs.getInt("salaire");
                User u = new User(id,cin,nom,prenom,email,numtel,salaire);
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User readById(int id) {
    try {
            String query = "SELECT * FROM utilisateur WHERE iduser = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int idd = rs.getInt("iduser");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                int cin = rs.getInt("cin");
                int numtel = rs.getInt("numtel");
                int salaire = rs.getInt("salaire");

                return new User(idd,cin,nom,prenom,email,numtel,salaire);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    
  
    
   
}
