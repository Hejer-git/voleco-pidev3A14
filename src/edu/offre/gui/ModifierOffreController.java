/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.gui;

import edu.offre.entities.Offre;
import edu.offre.services.ServiceOffre;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21629
 */
public class ModifierOffreController implements Initializable {

    static Offre o;

    @FXML
    private TextField tfDestination;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfNom;
    @FXML
    private DatePicker tfDate1;
    @FXML
    private DatePicker tfDate2;
    
    @FXML
    private TextField tfPrix;
   
    @FXML
    private Button bouttonmodif;
    @FXML
    private TextField tfpromo;
    @FXML
    private Button bouttonretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      tfNom.setText(o.getNomOffre());
        java.sql.Date d1= new java.sql.Date(o.getDateDebO().getTime());  
    tfDate1.setValue(d1.toLocalDate());
   java.sql.Date d2= new java.sql.Date(o.getDateFinO().getTime());  


        tfDate2.setValue(d2.toLocalDate());
        tfDestination.setText(o.getDestinationOffre());
        tfDescription.setText(o.getDescripOffre());
        tfPrix.setText(String.valueOf(o.getPrixOffre()));
        
     
            }   
   

    @FXML
    private void retouraction(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherOffre.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }

    @FXML
    private void modifieraction(ActionEvent event) throws IOException {
   String nomOffre = tfNom.getText();
   LocalDate d1 =  tfDate1.getValue();
        Date dateDebO = java.sql.Date.valueOf(d1);
        LocalDate d2 =  tfDate2.getValue();
        Date dateFinO = java.sql.Date.valueOf(d2);
        String DestinationOffre   =tfDestination.getText();
        String DescripOffre   =tfDescription.getText();
        int PrixOffre =Integer.parseInt(tfPrix.getText());
        int idPromo =Integer.parseInt(tfpromo.getText());
        ServiceOffre so=new ServiceOffre();
       Offre of=new Offre(o.getIdOffre(),nomOffre,dateDebO,dateFinO,DestinationOffre,DescripOffre,PrixOffre,idPromo);
       so.modifieroffre(of);


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherOffre.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    
}
