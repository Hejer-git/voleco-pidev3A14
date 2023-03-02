/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.services;
//import edu.reclamation.entities.Reclamation;
import edu.reclamation.entities.TypeReclamation;
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
import java.util.Date;
/**
 *
 * @author imen
 */
public class ServiceTypeReclamation implements IServiceType<TypeReclamation> {
    Connection cnx = DataSource.getInstance().getCnx();
    
    
    @Override
   public void ajouterTypeRec(TypeReclamation t) {
      // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date dd=r.getDateRec();
        try {
           String req = "INSERT INTO `typereclamation` (`typeRec`) VALUES ('" + t.getTypeRec() + "')";
          //String req = "INSERT INTO `reclamation` (`nomC`, `description`,`dateRec`)"+" VALUES (?,?,?)";
             Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("typereclamation created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  

    

@Override
    public void supprimerTypeRec(TypeReclamation t) {
      /*  try {
            String req = "DELETE FROM `typereclamation` WHERE idTR = " + t.getIdTR();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("typerec deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
      try {
            // create a PreparedStatement to delete the event with the specified id
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM typereclamation WHERE idTR = ?");
            ps.setInt(1, t.getIdTR());

            // execute the PreparedStatement
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error dans la suppresion " + ex.getMessage());
        }    
    }
  @Override
    public void modifierTypeRec(TypeReclamation t) {
     
      try {
            String req = "UPDATE `typereclamation` SET `typeRec` = '" +t.getTypeRec() +  "' WHERE `typereclamation`.`idTR` = " + t.getIdTR();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("rec updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   @Override
    public List<TypeReclamation> getAll() {
        List<TypeReclamation> list = new ArrayList<>();
        try {
            String req = "Select * from typereclamation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                TypeReclamation t = new TypeReclamation(rs.getInt(1), rs.getString("typeRec"));
                list.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;}
    
        @Override
    public TypeReclamation getOneById(int idRTR) {
        TypeReclamation t = null;
        try {
            String req = "Select * from typereclamation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                t = new TypeReclamation(rs.getInt(1), rs.getString("typeRec"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return t;
    }
    
    
    @Override
    public int getIdt(String c) {
      
        String sql = "select idTR from typereclamation where typeRec=" + "'" + c + "'";
 
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int id = rs.getInt(1);
            return id;
          
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTypeReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
     }
  
    }
