/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Bagage;
import edu.esprit.entities.StatutBagage;
import edu.esprit.services.ServiceBagage;
import edu.esprit.services.ServiceStatBag;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author 21654
 */
public class AjouterBagageController implements Initializable {

    @FXML
    private TextField tfPoids;
    @FXML
    private TextField tfTaille;
    private TextField tfFrais;
    private DatePicker dpDateB;
    
    @FXML
    private ComboBox<String> cbstat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ServiceStatBag ssb = new ServiceStatBag();
         List<StatutBagage> lsb = new ArrayList<>();
         lsb = ssb.getAllSB();
     
       for (int i = 0; i < lsb.size(); i++){
           cbstat.getItems().add(lsb.get(i).getStatutB());
       }
        
    }
    
    @FXML
    private void btnajouter(ActionEvent event) throws IOException {
       // float poids = Float.parseFloat(tfPoids.getText());
       // float taille = Float.parseFloat(tfTaille.getText());
        
        String poidsStr = tfPoids.getText();
        String tailleStr = tfTaille.getText();
          if (poidsStr.isEmpty() || tailleStr.isEmpty()) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Erreur de saisie");
         alert.setHeaderText("Certains champs sont vides");
         alert.setContentText("Veuillez saisir un poids et une taille valides");
         alert.showAndWait();
         return;
        }
        float poids = Float.parseFloat(poidsStr);
        float taille = Float.parseFloat(tailleStr);
        LocalDate date = LocalDate.now();
        Date dateB = java.sql.Date.valueOf(date);
        
        String statutB=cbstat.getValue();
        ServiceBagage b1 = new ServiceBagage();
        ServiceStatBag ssb = new ServiceStatBag();
        StatutBagage sb = new StatutBagage();
        sb = ssb.getOneByStat(statutB);
        
        float frais = 0;
        Bagage b;
        b = new Bagage(poids, taille, frais, dateB, sb.getIdStatBag());
  
        // Vérification des champs
        if (b.getPoids() > 23 ) 
        {
            frais += (b.getPoids() - 23) * 15; // Augmenter les frais de 15dt par kilo supplémentaire
            b.setFrais(frais);
        }
        
        if ( b.getTaille() > 158)
        {
            frais += (b.getTaille() - 158) * 10;  // Augmenter les frais de 10dt par cm supplémentaire
            b.setFrais(frais);
        }
        

        
        
          if (  b.getPoids()>32 || b.getPoids()<=0 || b.getTaille()<=0 || b.getTaille()>203 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("Certains champs sont incorrects");
            alert.setContentText("Veuillez saisir des champs valides");
            alert.showAndWait();
            return;
        }
           
           // Confirmation de l'ajout
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment ajouter ce Bagage ?");
        alert.setContentText("Poids : " + poids + "\nTaille : " + taille + "\nFrais : " + frais + "\nDate : " + dateB + "\nStatut : " + statutB);
         Optional<ButtonType> result=alert.showAndWait();
        
         
         if(result.get()==ButtonType.OK){
        b1.ajouter(b);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionBagage.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
          }
          else if(result.get()==ButtonType.CANCEL){
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionBagage.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show(); 
         }   
           
  }

    @FXML
    private void btnretour(ActionEvent event) throws IOException {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionBagage.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void btnnotif(MouseEvent event) {
         //notification bagage retrouvé
        ServiceBagage s1 = new ServiceBagage();
         int nbRetrouves = s1.countRetrouves();
        String message = " " + nbRetrouves + " bagages ont été retrouvés.";
         Notifications notificationBuilder = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder.show();
           
        //notification bagage perdu
         int nbPerdus = s1.countPerdus();
        String message1 = " " + nbPerdus + " bagages ont été perdus.";
        Notifications notificationBuilder1 = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message1)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder1.show();
           //notification bagage volé
         int nbVoles = s1.countVoles();
        String message2 = " " + nbVoles + " bagages ont été volés.";
        Notifications notificationBuilder2 = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message2)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder2.show();   
             //notification bagage suspect
         int nbSusps = s1.countSuspect();
        String message3 = " " + nbSusps + " bagages ont été suspectés.";
        Notifications notificationBuilder3 = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message3)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder3.show();   
    }
    
      
}
