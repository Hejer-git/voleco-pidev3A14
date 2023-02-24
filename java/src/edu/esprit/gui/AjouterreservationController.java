/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.services.ServiceReservation;
import edu.esprit.entities.Reservation;
import edu.esprit.entities.Siege;
import edu.esprit.services.ServiceSiege;
import edu.esprit.utils.DataSource;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MHIRI
 */
public class AjouterreservationController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfDepart;
    @FXML
    private TextField tfDestination;
    @FXML
    private DatePicker dpDate;
    @FXML
    private TextField tfBagage;
    @FXML
    private ComboBox<String> cbetat;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnafficher;

    /**
     * initialises the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         ServiceSiege ssiege = new ServiceSiege();
        List<Siege> listsiege = new ArrayList<>();
       listsiege = ssiege.readAll();
     
       for (int i = 0; i < listsiege.size(); i++){
           cbetat.getItems().add(listsiege.get(i).getEtat());
       }


    }    


    @FXML
    private void ajouter(ActionEvent event) throws IOException {
      
        String nom = tfNom.getText();
        String depart = tfDepart.getText();
        String destination = tfDestination.getText();
        int bagage = Integer.parseInt(tfBagage.getText());
        LocalDate date = dpDate.getValue();
        Date dateres = java.sql.Date.valueOf(date);
        String etat=cbetat.getValue(); 
        ServiceSiege ssiege = new ServiceSiege();
        Siege siege  = new Siege();
        siege = ssiege.readByEtat(etat);
        Reservation r;
        r=new Reservation(nom, depart, destination,dateres, bagage,siege.getId());
        ServiceReservation pc = new ServiceReservation();
        
        
        if((tfNom.getText().isEmpty()) || (tfDepart.getText().isEmpty()) || (tfDestination.getText().isEmpty())  ){
                Alert alertType=new Alert(AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez saisir des champs valides");
                alert.showAndWait();
                                return;

          }else if ((tfNom.getText().toString().matches("[0-9]+")) ){
		Alert alertType=new Alert(AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur de saisie");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez saisir un nom valide");
                alert.showAndWait();
                                return ;

          }
           else if ((tfDestination.getText().toString().matches("[0-9]+")) ){
		Alert alertType=new Alert(AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur de saisie");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez saisir une Destination valide");
                alert.showAndWait();
                                return;

                
           }
                   else if ((tfDepart.getText().toString().matches("[0-9]+")) ){
		Alert alertType=new Alert(AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur de saisie");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez saisir un Depart valide");
                alert.showAndWait();
                return;
                    
                   
	 }
         else if (bagage<=0 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("Ce champ est incorrecte");
            alert.setContentText("Veuillez saisir des champs valides");
            alert.showAndWait();
            return ;
                    
                   
	 }
       
        else {
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment ajouter ce Bagage ?");
        alert.setContentText("Nom : " + nom + "\nDepart : " + depart + "\nDestination : " + destination + "\nDate : " + date + "\nBagage : " + bagage );
        alert.showAndWait();
        pc.insert(r);
        
         }
        
           
            
           
        
        
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
         
        
        
       
    }

    @FXML
    private void btnaffRes(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
        
}
