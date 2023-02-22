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
import java.util.Date;
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
           String req = "INSERT INTO `reclamation` (`nomC`, `description`,`dateRec`) VALUES ('" + r.getNomC() + "', '" + r.getDescription() + "', '"+(r.getDateRec())+"')";
          //String req = "INSERT INTO `reclamation` (`nomC`, `description`,`dateRec`)"+" VALUES (?,?,?)";
             Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  

    

@Override
    public void supprimerRec(Reclamation r) {
       /* try {
            String req = "DELETE FROM `reclamation` WHERE idRec = " + r.getIdRec();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("rec deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } */
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
            String req = "UPDATE `reclamation` SET `nomC` = '" + r.getNomC() + "', `description` = '" + r.getDescription() + "', `dateRec` = '" + r.getDateRec() + "' WHERE `reclamation`.`idRec` = " + r.getIdRec();
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
                Reclamation r = new Reclamation(rs.getInt(1), rs.getString("nomC"), rs.getString("description"),rs.getDate("dateRec"));
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
                r = new Reclamation(rs.getInt(1), rs.getString("nomC"), rs.getString("description"),rs.getDate("dateRec"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return r;
    }
   /* public List<Reclamation> afficherRec() {

        List<Reclamation> list = new ArrayList<>();

        String req = "select * from reclamation";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reclamation r = new Reclamation();
                r.setIdRec(rs.getInt(1));
                r.setType_vet_stock(rs.getString(2));
                r.setNombre_articles(rs.getString(3));
                r.setDepot(depotDAO.findDepotById(rs.getDate(4)));

                listedepots.add(stock);
            }
            return listedepots;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }*/
    }
