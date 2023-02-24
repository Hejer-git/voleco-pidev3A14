/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.services.ServiceSiege;
import edu.esprit.entities.Siege;

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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MHIRI
 */
public class AjoutersiegeController implements Initializable {

    @FXML
    private TextField tfNum;
    @FXML
    private TextField tfEtat;
    @FXML
    private TextField tfStatus;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnafficher;

    /**
     * initialises the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        //int id = Integer.parseInt(tfId.getText());
        int num = Integer.parseInt(tfNum.getText());
        String etat = tfEtat.getText();
        String status = tfStatus.getText();
        Siege s;
        s=new Siege(num, etat, status);
        ServiceSiege pc = new ServiceSiege();
        
        if((tfEtat.getText().isEmpty()) || (tfStatus.getText().isEmpty())   ){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez saisir des champs valides");
                alert.showAndWait();
                                return;

          }else if ((tfEtat.getText().toString().matches("[0-9]+")) ){
		Alert alertType=new Alert(Alert.AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur de saisie");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez saisir un etat valide");
                alert.showAndWait();
                                return ;

          }
           else if ((tfStatus.getText().toString().matches("[0-9]+")) ){
		Alert alertType=new Alert(Alert.AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur de saisie");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez saisir un status valide");
                alert.showAndWait();
                                return;

                
           }
           else if (num<=0 ) {
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
        alert.setContentText("Num : " + num + "\nEtat : " + etat + "\nStatus : " + status );
        alert.showAndWait();
        pc.insert(s);
        
         }
        
        
        
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionSiege.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
       
    }

    @FXML
    private void btnaffSiege(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionSiege.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    
}
