/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Bagage;
import edu.esprit.services.ServiceBagage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    @FXML
    private TextField tfFrais;
    @FXML
    private DatePicker dpDateB;
    
     @FXML
    private Button btnajouter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void btnajouter(ActionEvent event) throws IOException {
        float poids = Float.parseFloat(tfPoids.getText());
        float taille = Float.parseFloat(tfTaille.getText());
        float frais = Float.parseFloat(tfFrais.getText());
        LocalDate date = dpDateB.getValue();
        Date dateB = java.sql.Date.valueOf(date);
       
        // Vérification des champs
        if (poids<=0 || taille<=0 || frais < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("Certains champs sont incorrects");
            alert.setContentText("Veuillez saisir des champs valides");
            alert.showAndWait();
            return;
        }
     
        Bagage b = new Bagage(poids, taille, frais, dateB);
        ServiceBagage sb = new ServiceBagage();
             
       /* b.setPoids(poids);
        b.setTaille(taille);

        if (b.getPoids() > 23 && b.getTaille() > 158) {
            float frais;
            frais = b.getFrais() + 150;
            b.setFrais(frais);
        }
             tfFrais.setText(String.valueOf(b.getFrais()));*/
             sb.ajouter(b); 
             
        // Confirmation de l'ajout
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment ajouter ce Bagage ?");
        alert.setContentText("Poids : " + poids + "\nTaille : " + taille + "\nFrais : " + frais + "\nDate : " + dateB );
        alert.showAndWait();
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionBagage.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    
    
}
