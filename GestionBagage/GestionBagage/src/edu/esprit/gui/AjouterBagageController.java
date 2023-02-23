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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
        
    if((tfPoids.getText().equals("")) || (tfTaille.getText().equals("")) || (tfFrais.getText().equals("")) || (dpDateB.getValue() == null))
    {
    Alert alert =new Alert(Alert.AlertType.ERROR);
    alert.setContentText("Veuillez remplir tous les champs !");   
    alert.showAndWait();
    }
else {
        Bagage b = new Bagage(poids, taille, frais, dateB);
        ServiceBagage sb = new ServiceBagage();
        sb.ajouter(b);
        
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Bagage ajoutée avec succès");
        alert.showAndWait();
    }
        
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionBagage.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
}
