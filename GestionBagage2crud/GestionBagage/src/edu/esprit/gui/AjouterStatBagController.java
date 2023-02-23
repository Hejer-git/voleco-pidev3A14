/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.StatutBagage;
import edu.esprit.services.ServiceStatBag;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class AjouterStatBagController implements Initializable {

    @FXML
    private TextField tfCom;
    @FXML
    private TextField tfStatut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void btnajouter(ActionEvent event) throws IOException {
        
       String statutB =tfStatut.getText();
       String comB =tfCom.getText();
  
        StatutBagage sb = new StatutBagage(statutB, comB);
        ServiceStatBag ssb = new ServiceStatBag();
        ssb.ajouterSB(sb);
        
        
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionStatBag.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    
}
