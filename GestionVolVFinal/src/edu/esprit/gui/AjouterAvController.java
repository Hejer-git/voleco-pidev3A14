/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import edu.esprit.services.ServiceAvion;
import edu.esprit.entities.Avion;
import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ghassen
 */
public class AjouterAvController implements Initializable {

    @FXML
    private TextField tfNbPlace;
    @FXML
    private TextField tfclasse;
    @FXML
    private TextField tfNomAvion;
    @FXML
    private TextField tfmodele;
    @FXML
    private DatePicker tfdateEntServ;
    @FXML
    private Button ValiderAv;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }    
    
    
    /*
    
    if((tfTitreForum.getText().isEmpty()) || (tfContenu.getText().isEmpty())){
                Alert alertType=new Alert(AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("Enter a valid title and content !");
                    alertType.show();
          }else if (tfTitreForum.getText().toString().matches("[0-9]+")){
		Alert alertType=new Alert(AlertType.ERROR);
		alertType.setTitle("Error");
                    alertType.setHeaderText("title must be string not number !");
                    alertType.show();
	 }else {
       // kamel bkeyet el code eli yekhdem
}
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @FXML
    private void btnAjouterAvion(ActionEvent event)throws IOException {
        
         String nomavion =tfNomAvion.getText();
         
         
         
        String classe =tfclasse.getText();
      int nbplace =Integer.parseInt(tfNbPlace.getText());
        String modele =tfmodele.getText();
        
        LocalDate d1 = tfdateEntServ.getValue();
        Date dateRec = java.sql.Date.valueOf(d1);
        
        
        
        
        
        ServiceAvion se=new ServiceAvion();
        Avion a=new Avion(nbplace,nomavion,modele,classe,dateRec);
        
        
         if((tfNomAvion.getText().isEmpty()) || (tfclasse.getText().isEmpty()) || (tfmodele.getText().isEmpty())){
                Alert alertType=new Alert(AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("Enter a valid title and content !");
                    alertType.show();}
         else if (tfNomAvion.getText().matches("[0-9]+"))  {
		Alert alertType=new Alert(AlertType.ERROR);
		alertType.setTitle("Error");
                    alertType.setHeaderText("title must be string not number !");
                    alertType.show();
	 }
         else if (tfclasse.getText().matches("[0-9]+"))  {
		Alert alertType=new Alert(AlertType.ERROR);
		alertType.setTitle("Error");
                    alertType.setHeaderText("title must be string  not number !");
                    alertType.show();
	 }
         else if (tfclasse.getText().matches("[0-9]+"))  {
		Alert alertType=new Alert(AlertType.ERROR);
		alertType.setTitle("Error");
                    alertType.setHeaderText("title must be string  not number !");
                    alertType.show();
         }else
             
         {
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment ajouter cet Avion ?");
        alert.setContentText("NbPlace: " + nbplace + "\nomavion : " + nomavion + "\nmodele : " + modele + "\nclasse : " + classe + "\ndateRec : " + dateRec );
        alert.showAndWait();
             se.ajouterAv(a);
             
         }
              
          
       
           
      //FXMLLoader loader= new FXMLLoader(getClass().getResource("showrec.fxml"));
      /*((Node)event.getSource()).getScene().getWindow().hide();
      FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("showrec.fxml"));
      try{
          Parent root =loader.load();
          ShowrecController dwc =loader.getController();
         
      }catch(IOException ex){
         System.out.println(ex.getMessage());
      }*/
       Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
        
    }

    /* private void btnRetour(ActionEvent event)  {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    } */

    @FXML
    private void btnretour(ActionEvent event)throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    
}
