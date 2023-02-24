/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;
import edu.esprit.entities.Avion;
import edu.esprit.entities.Vol;
import edu.esprit.utils.DataSource;
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

/**
 *
 * @author ghassen
 */
public class ServiceVol implements IServiceVol<Vol> {
    Connection cnx = DataSource.getInstance().getCnx();
    
   
    @Override
   public void ajouterVol(Vol v) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dd1=v.getDateDep();
        Date dd2=v.getDateDep();
        try {
          String req = "INSERT INTO `vol` (`numVol`, `heureDep` ,`heureArr` , `dateDep`, `dateArr`, `dureeVol`, `idAvion`) VALUES ('" + v.getNumVol() + "', '" +v.getHeureDep() + "','" +v.getHeureArr()+ "','" +(dateFormat.format(dd1))  + "','" +(dateFormat.format(dd2)) + "','" +v.getDureeVol() + "','" +v.getidAvion() +"')" ;
          //String req = "INSERT INTO `reclamation` (`nomC`, `description`,`dateRec`)"+" VALUES (?,?,?)";
             Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("vol created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  

    
    
    @Override
    public void supprimerVol(Vol v)  {
        try {
            String req = "DELETE FROM `vol` WHERE idVol = " + v.getIdVol();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("vol deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void modifierVol(Vol v)  {
        try {
            String query = "UPDATE `vol` SET `numVol` = '" + v.getNumVol() + "', `heureDep` = '" + v.getHeureDep() + "' ,`heureArr` = '" + v.getHeureArr()+ "',`dateArr` = '" + v.getDateDep() + "',`dateDep` = '" +  v.getDateArr()+ "',`dureeVol` = '" +  v.getDureeVol()+ "',`idAvion` = '" +  v.getidAvion()+ "' WHERE `idVol` = " + v.getIdVol();
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("vol updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public List<Vol> getAll() {
        List<Vol> list = new ArrayList<>();
        try {
            String req = "Select * from vol";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Vol v = new Vol(rs.getInt(1), rs.getInt("numVol"),rs.getString("heureDep"), rs.getString("heureArr"),rs.getDate("dateArr"),rs.getDate("dateDep"), rs.getInt("dureeVol"), rs.getInt("idAvion"));
                list.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;}
    
    @Override
    public Vol getOneById(int idRec) {
        Vol v = null;
        try {
            String req = "Select * from vol";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                v = new Vol(rs.getInt(1), rs.getInt("numVol"),rs.getString("heureDep"), rs.getString("heureArr"),rs.getDate("dateArr"),rs.getDate("dateDep"), rs.getInt("dureeVol"), rs.getInt("idAvion"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return v;
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
