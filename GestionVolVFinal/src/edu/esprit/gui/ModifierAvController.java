/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Avion;
import edu.esprit.services.ServiceAvion;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import static javax.xml.bind.JAXBIntrospector.getValue;
import java.sql.*;
import java.util.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ghassen
 */
public class ModifierAvController implements Initializable {

    @FXML
    private TextField editNomAvion;
    @FXML
    private TextField editNbPlace;
    @FXML
    private TextField editModele;
    @FXML
    private TextField editClasse;
    @FXML
    private DatePicker editDate;
    
    static Avion a;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // idlabel.setText(String.valueOf(a.getIdAvion()));
        editNomAvion.setText(a.getNomAvion());
        editClasse.setText(a.getClasse());
        editNbPlace.setText(String.valueOf(a.getNbPlace()));
        
       editModele.setText(a.getModele());
       
       java.sql.Date d1= new java.sql.Date(a.getDateEntServ().getTime());

       //java.sql.Date d1= java.sql.Date.valueOf(a.getDateEntServ());
        editDate.setValue(d1.toLocalDate());
        // TODO
    }    

     
    
    
    @FXML
    private void btnedit(ActionEvent event)throws IOException {
        String nomavion = editNomAvion.getText();
        String classe =editClasse.getText();
      int nbplace =Integer.parseInt(editNbPlace.getText());
        String modele =editModele.getText();
        
        LocalDate d1 =  editDate.getValue();
        Date dateRec = java.sql.Date.valueOf(d1);
        ServiceAvion se=new ServiceAvion();
        Avion av=new Avion(a.getIdAvion(),nbplace,nomavion,modele,classe,dateRec);
        
        
          if((editNomAvion.getText().isEmpty()) || (editClasse.getText().isEmpty()) || (editNbPlace.getText().isEmpty())|| (editModele.getText().isEmpty())){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("Enter a valid title and content !");
                    alertType.show();}
         else if (editNomAvion.getText().matches("[0-9]+"))  {
		Alert alertType=new Alert(Alert.AlertType.ERROR);
		alertType.setTitle("Error");
                    alertType.setHeaderText("title must be string not number !");
                    alertType.show();
	 }
         else if (editClasse.getText().matches("[0-9]+"))  {
		Alert alertType=new Alert(Alert.AlertType.ERROR);
		alertType.setTitle("Error");
                    alertType.setHeaderText("title must be string  not number !");
                    alertType.show();
	 }
          else if (editModele.getText().matches("[0-9]+"))  {
		Alert alertType=new Alert(Alert.AlertType.ERROR);
		alertType.setTitle("Error");
                    alertType.setHeaderText("title must be string  not number !");
                    alertType.show();
	 }
        else
             
         {
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment modifier ce Vol ?");
        
        alert.showAndWait();
            
             se.modifierAv(av);
         }
       
        
        
        
        


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherAv.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
        // this.a=avion;
    }
    
}
