/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;


import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import edu.esprit.entities.Reservation;
import edu.esprit.entities.Siege;
import edu.esprit.services.ServiceReservation;
import edu.esprit.services.ServiceSiege;
import edu.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MHIRI
 */
public class ModifierreservationController implements Initializable {

    @FXML
    private TextField editnom;
    @FXML
    private TextField editdepart;
    @FXML
    private TextField editdestination;
    @FXML
    private TextField editbagage;
    @FXML
    private DatePicker editdate;
    @FXML
    private ComboBox<String> editetat;

   static Reservation r;
     

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceSiege ssiege = new ServiceSiege();
        List<Siege> listsiege = new ArrayList<>();
       listsiege = ssiege.readAll();
     
       for (int i = 0; i < listsiege.size(); i++){
           editetat.getItems().add(listsiege.get(i).getEtat());
       }


        // idlabel.setText(String.valueOf(a.getIdAvion()));
        
        
        editnom.setText(r.getNom());
        editdepart.setText(r.getDepart());
        editdestination.setText(r.getDestination());
        
        editbagage.setText(String.valueOf(r.getBagage()));
        
        Siege siege  = new Siege();
        siege = ssiege.readById(r.getIdSiege());
        
        
        editetat.setValue(siege.getEtat());
        
       java.sql.Date d1= new java.sql.Date(r.getDate().getTime());

        editdate.setValue(d1.toLocalDate());
         Connection conn = DataSource.getInstance().getCnx();
      
        
        
    }    

     
    
    
    @FXML
    private void btnedit(ActionEvent event)throws IOException {
        String nom = editnom.getText();
        String depart =editdepart.getText();
        int bagage =Integer.parseInt(editbagage.getText());
        
        String etat=editetat.getValue(); 
        
        ServiceSiege ssiege = new ServiceSiege();
        Siege siege  = new Siege();
        siege = ssiege.readByEtat(etat);       
        String destination =editdestination.getText();   
        LocalDate d1 =  editdate.getValue();
        java.util.Date dateRes = java.sql.Date.valueOf(d1);
        ServiceReservation se=new ServiceReservation();
        Reservation re=new Reservation(r.getId(),nom,depart,destination,dateRes,bagage,siege.getId());
        
        if((editnom.getText().isEmpty()) || (editdepart.getText().isEmpty()) || (editdestination.getText().isEmpty())  ){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de modification");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez modifier des champs valides");
                alert.showAndWait();
                                return;

          }else if ((editnom.getText().toString().matches("[0-9]+")) ){
		Alert alertType=new Alert(Alert.AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur de modification");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez saisir un nom valide");
                alert.showAndWait();
                                return ;

          }
           else if ((editdestination.getText().toString().matches("[0-9]+")) ){
		Alert alertType=new Alert(Alert.AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur de modification");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez modifier une Destination valide");
                alert.showAndWait();
                                return;

                
           }
                   else if ((editdepart.getText().toString().matches("[0-9]+")) ){
		Alert alertType=new Alert(Alert.AlertType.ERROR);
                Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur de modification");
                alert.setHeaderText("Ce champ est incorrecte");
                alert.setContentText("Veuillez modifier un Depart valide");
                alert.showAndWait();
                return;
                    
                   
	 }
         else if (bagage<=0 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de modification");
            alert.setHeaderText("Ce champ est incorrecte");
            alert.setContentText("Veuillez modifier des champs valides");
            alert.showAndWait();
            return ;
                    
                   
	 }
       
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Voulez-vous vraiment Modifier ce Bagage ?");
            alert.showAndWait();
            se.update(re);
            
        
         }
        
        
        
        


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
        // this.a=avion;
    }
    
}

