/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.StatutBagage;
import edu.esprit.services.ServiceBagage;
import edu.esprit.services.ServiceStatBag;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class ModifierStatBagController implements Initializable {

    @FXML
    private TextField tfCom;
    @FXML
    private TextField tfStatut;
    
    static StatutBagage sb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfStatut.setText(String.valueOf(sb.getStatutB()));
        tfCom.setText(String.valueOf(sb.getComB()));
    }    

    @FXML
    private void btnmodif(ActionEvent event) throws IOException {
        String statutB =tfStatut.getText();
        String comB =tfCom.getText();
        ServiceStatBag ss2=new ServiceStatBag();
        StatutBagage sb1=new StatutBagage(sb.getIdStatBag(),statutB,comB);

          // Confirmation de la modification
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment modifier ce Statut ?");
        alert.setContentText("Statut : " + statutB + "\nCommentaire : " + comB);
         Optional<ButtonType> result=alert.showAndWait();
        
         if(result.get()==ButtonType.OK){
            ss2.modifierSB(sb1);
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionStatBag.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
         }
         else if(result.get()==ButtonType.CANCEL){
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionStatBag.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }
  }

    @FXML
    private void btnretour(ActionEvent event) throws IOException {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionStatBag.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }
   
}
