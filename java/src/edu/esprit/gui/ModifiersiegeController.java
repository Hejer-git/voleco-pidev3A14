/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Siege;
import edu.esprit.entities.Siege;
import static edu.esprit.gui.ModifiersiegeController.s;
import edu.esprit.services.ServiceSiege;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MHIRI
 */
public class ModifiersiegeController implements Initializable {

    @FXML
    private TextField editnum;
    @FXML
    private TextField editetat;
    @FXML
    private TextField editstatus;

    static Siege s;
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        editnum.setText(String.valueOf(s.getNum()));
        editetat.setText(s.getEtat());
        editstatus.setText(s.getStatus());
        
        
    }    

     
    
    
    @FXML
    private void btnedit(ActionEvent event)throws IOException {
        int num =Integer.parseInt(editnum.getText());
        String status = editstatus.getText();
        String etat =editetat.getText();
        
        
        ServiceSiege se=new ServiceSiege();
        Siege si=new Siege(s.getId(),num,etat,status);
        
        
        
        if((editetat.getText().isEmpty()) || (editstatus.getText().isEmpty())   ){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de modifier");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez modifier des champs valides");
                alert.showAndWait();
                                return;

          }else if ((editetat.getText().toString().matches("[0-9]+")) ){
		Alert alertType=new Alert(Alert.AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur de modifier");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez modifier un etat valide");
                alert.showAndWait();
                                return ;

          }
           else if ((editstatus.getText().toString().matches("[0-9]+")) ){
		Alert alertType=new Alert(Alert.AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur de modification");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez modifier un status valide");
                alert.showAndWait();
                                return;

                
           }
           else if (num<=0 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de modifier");
            alert.setHeaderText("Ce champ est incorrecte");
            alert.setContentText("Veuillez modifier des champs valides");
            alert.showAndWait();
            return ;
                    
                   
	 }
       
        else {
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment modifier ce Bagage ?");
        alert.setContentText("Num : " + num + "\nEtat : " + etat + "\nStatus : " + status );
        alert.showAndWait();
        se.update(si);

        
         }
        se.update(si);


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionSiege.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
        // this.a=avion;
    }
    
}


