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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21629
 */

public class AjouterOffreController implements Initializable {

    @FXML
    private TextField tfDestination;
    @FXML
    private TextField tfDescription;
    @FXML
    private DatePicker tfDate2;
    @FXML
    private DatePicker  tfDate1;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrix;
    @FXML
    private Button buttonajouter;
    @FXML
    private Button bouttonAff;
    @FXML
    private TextField tfPromo;
    
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    @FXML
    private void ajouteraction(ActionEvent event) throws Exception {
         String nomOffre = tfNom.getText();
         LocalDate date1 = tfDate1.getValue();
        java.util.Date dateDebO = java.sql.Date.valueOf(date1);
        LocalDate date2 = tfDate2.getValue();
        java.util.Date dateFinO = java.sql.Date.valueOf(date2);
        String DestinationOffre = tfDestination.getText();
        String DescripOffre = tfDescription.getText();
        int PrixOffre = Integer.parseInt(tfPrix.getText());
        int idPromo =Integer.parseInt(tfPromo.getText());
        
        Offre o;
        
        o=new Offre(nomOffre, dateDebO, dateFinO,DestinationOffre,DescripOffre,PrixOffre,idPromo);
        ServiceOffre so = new ServiceOffre();
        so.ajouteroffre(o);
    }

    @FXML
    private void affO(ActionEvent event) throws Exception{
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherOffre.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    
    
}

