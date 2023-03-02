/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.gui;

import edu.reclamation.entities.TypeReclamation;
import edu.reclamation.services.ServiceTypeReclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class AjouterTypeRecController implements Initializable {

    @FXML
    private Button bAnnuler;
    @FXML
    private Button bValider;
    @FXML
    private TextField tftype;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

      private boolean type_valide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(tftype.getText());
        if(m.find() && m.group().equals(tftype.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
              //  alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Entrez un type valide  !");
                alert.showAndWait();
           
            return false;            
        }
        
     }
    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void ajoutrec(ActionEvent event) throws IOException {
        
            if((tftype.getText().equals("")) ){
    Alert alert =new Alert(Alert.AlertType.ERROR);
    alert.setContentText("Remplissez tt les champs");   
    alert.showAndWait();
    
}
        else if (type_valide()){
        String typeRec =tftype.getText();
       
        ServiceTypeReclamation se=new ServiceTypeReclamation();
        TypeReclamation e=new TypeReclamation(typeRec);
        se.ajouterTypeRec(e);   
      
       Alert alert =new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText("TypeReservation ajouter");
    alert.showAndWait();
    }
    
     Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherTypeRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    
    }

    @FXML
    private void affrec(ActionEvent event) throws IOException {
          Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherTypeRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    
}
