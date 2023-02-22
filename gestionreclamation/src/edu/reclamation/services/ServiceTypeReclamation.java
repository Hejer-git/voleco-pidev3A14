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
        try {
            String req = "DELETE FROM `typereclamation` WHERE idTR = " + t.getIdTR();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("typerec deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  @Override
    public void modifierTypeRec(TypeReclamation t) {
        try {
            String req = "UPDATE `typereclamation` SET `typeRec` = '" + t.getTypeRec()+  "' WHERE `typereclamation`.`idTR` = " + t.getClass();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("typerec updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   @Override
    public List<TypeReclamation> getAll() {
        List<TypeReclamation> list = new ArrayList<>();
        try {
            String req = "Select * from reclamation";
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
