/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.services;
import edu.offre.entities.Promo; 
import edu.offre.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 21629
 */
public class ServicePromo implements IPromo<Promo>{
 Connection cnx = DataSource.getInstance().getCnx();
        
@Override
        public void ajouterpromo(Promo p) throws Exception{
 
           try {
     String query = "INSERT INTO Promotion( codePromo,Reduction) VALUES (?, ?)";
   
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setString(1, p.getCodePromo());
             statement.setInt(2, p.getReduction());
              statement.executeUpdate();
             System.out.println("Promo created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 @Override
   public void supprimerpromo(Promo p) {
        try {
        String req = "DELETE FROM `promotion` WHERE idPromo = " + p.getIdPromo() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Promo deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
  
    
      @Override
    public List<Promo> getAll() {
        List<Promo> list = new ArrayList<>();
        try {
            String req = "Select * from promotion";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
               Promo p= new Promo(rs.getInt(1), rs.getString(2),rs.getInt(3));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Promo getOneById(int idPromo,int idoffre) {
        Promo p= null;
        try {
            String req = "Select * from promotion where idPromo="+idPromo+" and idOffre="+idoffre;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
              p= new Promo(rs.getInt(1), rs.getString(2),rs.getInt(3));  
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p;
    }

    @Override
    public void modifierpromo(Promo p) {
        try {
         
             String req = "UPDATE `promotion` SET `codePromo` = '" + p.getCodePromo() + "', `Reduction` = '" + p.getReduction() +  "' WHERE `idPromo` = " + p.getIdPromo();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Promo updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        

    

   


}
