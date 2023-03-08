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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class ModifierBagageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField tfPoids;
    @FXML
    private TextField tfTaille;
    private TextField tfFrais;
    private DatePicker dpDateB;
    
    static Bagage b;
    @FXML
    private ComboBox<String> cbstat;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ServiceStatBag ssb = new ServiceStatBag();
         List<StatutBagage> lsb = new ArrayList<>();
         lsb = ssb.getAllSB();
     
       for (int i = 0; i < lsb.size(); i++){
           cbstat.getItems().add(lsb.get(i).getStatutB());
       }
       
        StatutBagage sb = ssb.getSBById(b.getidStatBag());
        ServiceBagage sbag = new ServiceBagage();
        Bagage bag= sbag.getBagById(b.getIdBagage());
        cbstat.setValue(sb.getStatutB());
        
        tfPoids.setText(String.valueOf(b.getPoids()));
        tfTaille.setText(String.valueOf(b.getTaille()));
    }    
   
    @FXML
    private void btnmodif(ActionEvent event) throws IOException {
        float poids =Float.parseFloat(tfPoids.getText());
        float taille =Float.parseFloat(tfTaille.getText());
       
        String statutB=cbstat.getValue(); 
        ServiceStatBag ssb = new ServiceStatBag();
        StatutBagage sb = new StatutBagage();
        sb = ssb.readByStat(statutB);
        
        // Vérification des champs
        
         if (  poids>32 || poids<=0 || taille<=0 || taille>203 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("Certains champs sont incorrects");
            alert.setContentText("Veuillez saisir des champs valides");
            alert.showAndWait();
            return;
        }
       
        ServiceBagage s1=new ServiceBagage();
        Bagage b1=new Bagage(b.getIdBagage(),poids,taille,b.getFrais(),b.getDateB(),sb.getIdStatBag());
        
          float frais = 0;
        if (b1.getPoids() > 23 ) 
        {
            frais += (b1.getPoids() - 23) * 15; // Augmenter les frais de 15dt par kilo supplémentaire
            b1.setFrais(frais);
        }
        if ( b1.getTaille() > 158)
        {
            frais += (b1.getTaille() - 158) * 10;  // Augmenter les frais de 10dt par cm supplémentaire
            b1.setFrais(frais);
        }
         // Confirmation de la modification
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment modifier ce Bagage ?");
        Optional<ButtonType> result=alert.showAndWait();
        
         if(result.get()==ButtonType.OK){
        s1.modifier(b1);
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
