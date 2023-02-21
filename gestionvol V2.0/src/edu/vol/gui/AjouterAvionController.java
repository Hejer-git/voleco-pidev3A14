/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vol.gui;

//import com.sun.istack.internal.logging.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import edu.vol.services.ServiceVol;
import edu.vol.entities.Avion;
import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author imen
 */
public class AjouterAvionController implements Initializable {

    @FXML
    private Button bAnnuler;
    @FXML
    private Button bValider;
   
    @FXML
    private TextField tfNbPlace;
    @FXML
    private TextField tfNomAvion;
    @FXML
    private DatePicker tfdateEntServ;
    @FXML
    private TextField tfclasse;
    @FXML
    private TextField tfmodele;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annuler(ActionEvent event) throws IOException{
      /*   Parent tableViewParent = FXMLLoader.load(getClass().getResource("showrec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();*/
    }
    @FXML
    private void affrec(ActionEvent event) throws IOException{
      Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    @FXML
    private void  btnAjouterAvion(ActionEvent event) throws IOException  {
        String nomavion =tfNomAvion.getText();
        String classe =tfclasse.getText();
      int nbplace =Integer.parseInt(tfNbPlace.getText());
        String modele =tfmodele.getText();
        
        LocalDate d1 = tfdateEntServ.getValue();
        Date dateRec = java.sql.Date.valueOf(d1);
        ServiceVol se=new ServiceVol();
        Avion a=new Avion(nbplace,nomavion,modele,classe,dateRec);
        se.ajouterAv(a);   
      //FXMLLoader loader= new FXMLLoader(getClass().getResource("showrec.fxml"));
      /*((Node)event.getSource()).getScene().getWindow().hide();
      FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("showrec.fxml"));
      try{
          Parent root =loader.load();
          ShowrecController dwc =loader.getController();
         
      }catch(IOException ex){
         System.out.println(ex.getMessage());
      }*/
       Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    
    
}
