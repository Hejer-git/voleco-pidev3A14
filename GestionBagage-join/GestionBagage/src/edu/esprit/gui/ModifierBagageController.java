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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    @FXML
    private TextField tfFrais;
    @FXML
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
        
        tfPoids.setText(String.valueOf(b.getPoids()));
        tfTaille.setText(String.valueOf(b.getTaille()));
        tfFrais.setText(String.valueOf(b.getFrais()));       
       java.sql.Date d1= new java.sql.Date(b.getDateB().getTime());
       //java.sql.Date d1= java.sql.Date.valueOf(a.getDateEntServ());
        dpDateB.setValue(d1.toLocalDate());
        
        StatutBagage sb  = new StatutBagage();
        sb = ssb.getSBById(b.getIdStatBag());
        cbstat.setValue(sb.getStatutB());
    }    
   
    @FXML
    private void btnmodif(ActionEvent event) throws IOException {
        float poids =Float.parseFloat(tfPoids.getText());
        float taille =Float.parseFloat(tfTaille.getText());
        float frais =Float.parseFloat(tfFrais.getText());
        java.sql.Date dateB = java.sql.Date.valueOf(this.dpDateB.getValue());
        
        String statutB=cbstat.getValue(); 
        
        ServiceStatBag ssb = new ServiceStatBag();
        StatutBagage sb = new StatutBagage();
        sb = ssb.readByStat(statutB);

        
         if (  poids>32 || poids<=0 || taille<=0 || taille>203 || frais < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("Certains champs sont incorrects");
            alert.setContentText("Veuillez saisir des champs valides");
            alert.showAndWait();
            return;
        }
        
        ServiceBagage s1=new ServiceBagage();
        Bagage b1=new Bagage(b.getIdBagage(),poids,taille,frais,dateB,sb.getIdStatBag());
        s1.modifier(b1);
        
         // Confirmation de la modification
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment modifier ce Bagage ?");
        alert.showAndWait();


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionBagage.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }
    
}
