/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Avion;
import edu.esprit.entities.Vol;
import edu.esprit.services.ServiceAvion;
import edu.esprit.services.ServiceVol;
import edu.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ghassen
 */
public class AjouterVolController implements Initializable {

    @FXML
    private TextField tfNumVol;
    @FXML
    private TextField tfDureeVol;
    @FXML
    private TextField tfHeureDep;
    @FXML
    private TextField tfHeureArr;
    @FXML
    private DatePicker tfDateDep;
    @FXML
    private Button ValiderVol;
    @FXML
    private DatePicker tfdateArr;
    @FXML
    private ComboBox<String> comborole;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @throws java.io.IOException
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        ServiceAvion savion = new ServiceAvion();
        List<Avion> listavion = new ArrayList<>();
       listavion = savion.getAll();
      
       for (int i = 0; i < listavion.size(); i++){
           comborole.getItems().add(listavion.get(i).getNomAvion());
       }
        
  
        
    }    

    @FXML
    private void btnAjouterVol(ActionEvent event)throws IOException {

        String HeureDep =tfHeureDep.getText();
        String HeureArr =tfHeureArr.getText();
        int NumVol =Integer.parseInt(tfNumVol.getText());
        int DureeVol =Integer.parseInt(tfDureeVol.getText()); 
        String combo=comborole.getValue(); 
        LocalDate d1 = tfDateDep.getValue();
        Date dateRec1 = java.sql.Date.valueOf(d1);   
        LocalDate d2 = tfdateArr.getValue();
        Date dateRec2 = java.sql.Date.valueOf(d2);
        ServiceVol se=new ServiceVol();
        ServiceAvion savion = new ServiceAvion();
        Avion avion = new Avion();
        avion = savion.getOneByName(combo);

        
        Vol v=new Vol(NumVol,HeureDep,HeureArr,dateRec1,dateRec2,DureeVol,avion.getIdAvion());
        
        
           if((tfHeureDep.getText().isEmpty()) || (tfHeureArr.getText().isEmpty()) || (tfNumVol.getText().isEmpty())|| (tfDureeVol.getText().isEmpty())){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("Enter a valid title and content !");
                    alertType.show();}
         else if (tfHeureDep.getText().matches("[0-9]+"))  {
		Alert alertType=new Alert(Alert.AlertType.ERROR);
		alertType.setTitle("Error");
                    alertType.setHeaderText("title must be string not number !");
                    alertType.show();
	 }
         else if (tfHeureArr.getText().matches("[0-9]+"))  {
		Alert alertType=new Alert(Alert.AlertType.ERROR);
		alertType.setTitle("Error");
                    alertType.setHeaderText("title must be string  not number !");
                    alertType.show();
	 }
        else
             
         {
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment ajouter ce Vol ?");
        alert.setContentText("NumVol: " + NumVol + "\nHeureDep : " + HeureDep + "\nHeureArr : " + HeureArr +"\nDateDep : " + dateRec1 + "\nDateArr : " + dateRec2 + "\nDuree : " + DureeVol );
        alert.showAndWait();
            
            se.ajouterVol(v); 
         }
        
        
        
        
           

        
        
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherVol.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    @FXML
    private void btnretour(ActionEvent event)throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherVol.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }
    
}
