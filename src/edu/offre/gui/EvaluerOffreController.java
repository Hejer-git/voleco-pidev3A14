/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.gui;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import edu.offre.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author 21629
 */
public class EvaluerOffreController implements Initializable {
     Connection cnx = DataSource.getInstance().getCnx();

    @FXML
    private Label notreat;
    @FXML
    private RadioButton gr1;
    @FXML
    private ToggleGroup grating;
    @FXML
    private RadioButton gr3;
    @FXML
    private RadioButton gr2;
    @FXML
    private RadioButton gr4;
    @FXML
    private RadioButton gr5;
    @FXML
    private TextArea idc;
    @FXML
    private ListView<String> listcom;
    String notte;

    /**
     * Initializes the controller class.
     */
 
    @FXML
    private void clickbtn(ActionEvent event) throws SQLException {
        calcul();
        if(gr1.isSelected()){
            notte="1";
        }else if(gr2.isSelected()){
            notte="2";
        }else if(gr3.isSelected()){
            notte="3";
        }else if(gr4.isSelected()){
            notte="4";
        }else if(gr5.isSelected()){
            notte="5";
        }
        
        
        
        System.out.println("hey");
         
            
           Statement st = cnx.createStatement(); 
    	String query = "INSERT INTO `evaluation` ( `idUser`, `idOffre`, `Contenu`, `Note`) VALUES ('1', '15', '"+idc.getText()+"','"+notte.toString()+"')";
      

      try {
            PreparedStatement pst = cnx.prepareStatement(query);
  
           
            pst.executeUpdate();
           System.out.println("evaluation  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   

    }
   
 
    
        
     public void executeQuery(String query) throws SQLException {
    	  Statement st = cnx.createStatement(); 
    	    
    	try {
		
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    int note=0;
    int cmpt=0;
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             calcul();
         } catch (SQLException ex) {
             Logger.getLogger(EvaluerOffreController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    

    
    public void calcul() throws SQLException{
        listcom.getItems().clear();
Statement st = cnx.createStatement();

    	String query = "SELECT * FROM evaluation where idUser=1";
    	   ResultSet rs;

    	
    	try {
			st = cnx.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
                            
                            listcom.getItems().add("Comnt: "+rs.getString("Contenu")+" -  note:"+rs.getString("Note"));
				cmpt++;
				if(rs.getString("Note").toString().equals("1"))
                                   note=note+1;
                                if(rs.getString("Note").toString().equals("2"))
                                   note=note+2;
                                if(rs.getString("Note").toString().equals("3"))
                                   note=note+3;
                                if(rs.getString("Note").toString().equals("4"))
                                   note=note+4;
                                if(rs.getString("Note").toString().equals("5"))
                                   note=note+5;
                                    
         
                
				}
                 
                          if(cmpt!=0)
                                {
                                    System.out.println(note/cmpt);
                                    notreat.setText(String.valueOf(note/cmpt) );
                                }else{
                                    notreat.setText("0");
                                }       
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
                  
        
    }
    
}
