/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;
import edu.esprit.entities.Admin;
import edu.esprit.entities.Client;
import edu.esprit.entities.Employee;
import edu.esprit.entities.User;
import edu.esprit.utils.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
    private User user;
    private String role;
    public ServiceUser() {
        conn = DataSource.getInstance().getCnx();
    }

    
    @Override
    public void insert(User u) {
        try {
            String role = "Admin";
            String query = "INSERT INTO utilisateur ( nom, prenom, cin, salaire, numtel, email, role, password, resetcode, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, u.getNom());
            statement.setString(2, u.getPrenom());
            statement.setInt(3, u.getCin());
            statement.setInt(4, u.getSalaire());
            statement.setInt(5, u.getNumtel());
            statement.setString(6, u.getEmail());
            if (u instanceof Admin ){
                role = "Admin";
            }else if (u instanceof Client ){
                role = "Client";
            }else if (u instanceof Employee ){
                role = "Employee";
            }
            statement.setString(7, role);
            statement.setString(8, u.getPassword());
            statement.setInt(9, 0);
            statement.setString(10, u.getImg());

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
            
            String query = "UPDATE utilisateur SET nom = ?, prenom = ?, cin = ?, salaire = ?, numtel = ?, email = ?, role = ?, password = ?, resetcode = ?,img = ? WHERE iduser = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, u.getNom());
            statement.setString(2, u.getPrenom());
            statement.setInt(3, u.getCin());
            statement.setInt(4, u.getSalaire());
            statement.setInt(5, u.getNumtel());
            statement.setString(6, u.getEmail());
            
            if (u instanceof Admin ){
                role = "Admin";
            }else if (u instanceof Client ){
                role = "Client";
            }else if (u instanceof Employee ){
                role = "Employee";
            }
            statement.setString(7, role);
            statement.setString(8, u.getPassword());
            statement.setInt(9, u.getResetcode());
            statement.setString(10, u.getImg());
            statement.setInt(11, u.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void setLock(User u,LocalDateTime ldt) {
        try {
            long epochSecond = ldt.toEpochSecond(ZoneOffset.UTC);
            String query = "UPDATE utilisateur SET enabled = ? WHERE iduser = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setLong(1, epochSecond);
            statement.setInt(2, u.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public Long getLock(User u) {
        try {
            String query = "SELECT * FROM utilisateur WHERE iduser = ? ";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, u.getId());
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                long epochSecond = rs.getLong("enabled");
                
                return epochSecond;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void setresetcode(int code,String mail) {
        try {
            
            String query = "UPDATE utilisateur SET resetcode = ? WHERE email = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, code);
            statement.setString(2, mail);    
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<User> readAll() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT *  FROM utilisateur";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery() ;
            while (rs.next()) {
                int id = rs.getInt("iduser");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                int cin = rs.getInt("cin");
                int numtel = rs.getInt("numtel");
                int salaire = rs.getInt("salaire");
                String role = rs.getString("role");
                String password = rs.getString("password");
                int resetcode = rs.getInt("resetcode");
                String img = rs.getString("img");
                if (role.equals("Admin")){
                    Admin admin = new Admin(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) admin;
                }else if (role.equals("Client")){
                    Client client = new Client(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) client;
                }else if (role.equals("Employee")){
                    Employee employee = new Employee(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img); 
                    user = (User) employee;
                }
                users.add(user);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public List<User> getClients() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT *  FROM utilisateur where role = 'Client'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery() ;
            while (rs.next()) {
                int id = rs.getInt("iduser");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                int cin = rs.getInt("cin");
                int numtel = rs.getInt("numtel");
                int salaire = rs.getInt("salaire");
                String role = rs.getString("role");
                String password = rs.getString("password");
                int resetcode = rs.getInt("resetcode");
                String img = rs.getString("img");
                if (role.equals("Admin")){
                    Admin admin = new Admin(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) admin;
                }else if (role.equals("Client")){
                    Client client = new Client(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) client;
                }else if (role.equals("Employee")){
                    Employee employee = new Employee(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img); 
                    user = (User) employee;
                }
                users.add(user);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public List<User> getEmployees() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT *  FROM utilisateur where role = 'Employee'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery() ;
            while (rs.next()) {
                int id = rs.getInt("iduser");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                int cin = rs.getInt("cin");
                int numtel = rs.getInt("numtel");
                int salaire = rs.getInt("salaire");
                String role = rs.getString("role");
                String password = rs.getString("password");
                int resetcode = rs.getInt("resetcode");
                String img = rs.getString("img");
                if (role.equals("Admin")){
                    Admin admin = new Admin(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) admin;
                }else if (role.equals("Client")){
                    Client client = new Client(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) client;
                }else if (role.equals("Employee")){
                    Employee employee = new Employee(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img); 
                    user = (User) employee;
                }
                user.setImg(rs.getString("img"));

                users.add(user);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
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
                String role = rs.getString("role");
                String password = rs.getString("password");
                int resetcode = rs.getInt("resetcode");
                String img = rs.getString("img");
                if (role.equals("Admin")){
                    Admin admin = new Admin(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) admin;
                }else if (role.equals("Client")){
                    Client client = new Client(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) client;
                }else if (role.equals("Employee")){
                    Employee employee = new Employee(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img); 
                    user = (User) employee;
                }
                user.setImg(rs.getString("img"));
                return user;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public User readByEmailPass(String mail,String pass) {
    
        try {
            String query = "SELECT * FROM utilisateur WHERE email = ? and password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, mail);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("iduser");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                int cin = rs.getInt("cin");
                int numtel = rs.getInt("numtel");
                int salaire = rs.getInt("salaire");
                String role = rs.getString("role");
                String password = rs.getString("password");
                int resetcode = rs.getInt("resetcode");
                String img = rs.getString("img");
                if (role.equals("Admin")){
                    Admin admin = new Admin(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) admin;
                }else if (role.equals("Client")){
                    Client client = new Client(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) client;
                }else if (role.equals("Employee")){
                    Employee employee = new Employee(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img); 
                    user = (User) employee;
                }
                user.setImg(rs.getString("img"));
                return user;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User checkByEmail(String mail) {
    
        try {
            String query = "SELECT * FROM utilisateur WHERE email = ? ";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, mail);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("iduser");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                int cin = rs.getInt("cin");
                int numtel = rs.getInt("numtel");
                int salaire = rs.getInt("salaire");
                String role = rs.getString("role");
                String password = rs.getString("password");
                int resetcode = rs.getInt("resetcode");
                String img = rs.getString("img");
                if (role.equals("Admin")){
                    Admin admin = new Admin(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) admin;
                }else if (role.equals("Client")){
                    Client client = new Client(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img);
                    user = (User) client;
                }else if (role.equals("Employee")){
                    Employee employee = new Employee(id,cin,nom,prenom,email,numtel,salaire,password,resetcode,img); 
                    user = (User) employee;
                }
                user.setResetcode(rs.getInt("resetcode"));
                user.setImg(rs.getString("img"));
                return user;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
  
    
   
}
