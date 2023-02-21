/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vol.services;
import edu.vol.entities.Avion;
import edu.vol.utils.DataSource;
import java.io.IOException;
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
public class ServiceVol implements IService<Avion> {
    Connection cnx = DataSource.getInstance().getCnx();
    
    
   public void ajouterAv(Avion a) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dd=a.getDateEntServ();
        try {
          String req = "INSERT INTO `avion` (`nomAvion`, `nbPlace` ,`modele` , `classe`, `dateEntServ`) VALUES ('" + a.getNomAvion() + "', '" +a.getNbPlace() + "','" +a.getModele()+ "','" +a.getClasse() + "','" +(dateFormat.format(dd)) + "')";
          //String req = "INSERT INTO `reclamation` (`nomC`, `description`,`dateRec`)"+" VALUES (?,?,?)";
             Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("avion created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  

    
    
    @Override
    public void supprimerAv(Avion a)  {
        try {
            String req = "DELETE FROM `avion` WHERE idAvion = " + a.getIdAvion();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Avion deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void modifierAv(Avion a)  {
        try {
            String query = "UPDATE `avion` SET `nomAvion` = '" + a.getNomAvion() + "', `nbPlace` = '" + a.getNbPlace() + "' ,`modele` = '" + a.getModele()+ "',`classe` = '" + a.getClasse() + "',`dateEntServ` = '" + a.getDateEntServ()+ "' WHERE `idAvion` = " + a.getIdAvion();
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("avion updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   @Override
    public List<Avion> getAll() {
        List<Avion> list = new ArrayList<>();
        try {
            String req = "Select * from avion";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Avion a = new Avion(rs.getInt(1), rs.getInt("nbPlace"),rs.getString("nomAvion"), rs.getString("modele"),rs.getString("classe"),rs.getDate("dateEntServ"));
                list.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;}
    
        @Override
    public Avion getOneById(int idRec) {
        Avion a = null;
        try {
            String req = "Select * from avion";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                a = new Avion(rs.getInt(1), rs.getInt("nbPlace"),rs.getString("nomAvion"), rs.getString("modele"),rs.getString("classe"),rs.getDate("dateEntServ"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return a;
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
