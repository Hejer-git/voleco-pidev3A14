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
import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class GestionBagageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private List<Bagage> bagages = new ArrayList<>();
    @FXML
    private GridPane grid;
    @FXML
    private TextField tfrech;
    @FXML
    private ComboBox<String> cbtri;
    
     public  ObservableList<String> options = FXCollections.observableArrayList( "ASC", "DESC" );
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbtri.getSelectionModel().selectFirst();
        for (int i = 0; i < options.size(); i++){
        cbtri.getItems().add(options.get(i) );
       }
        int row = 0;
        Bagage b = new Bagage();
        ServiceBagage s1 = new ServiceBagage();
        bagages = s1.getAllB();
        
        

        for (int i = 0; i < bagages.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("BagageItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                BagageItemController bagageitemController = fxmlLoader.getController();
                
                bagageitemController.setData(bagages.get(i));
                grid.add(anchorPane,0 ,row++);

            } catch (IOException ex) {
                Logger.getLogger(GestionStatBagController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }    

    @FXML
    private void btnajouter(ActionEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterBagage.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void btnstatbag(ActionEvent event) throws IOException {
        
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionStatBag.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void btnrech(ActionEvent event) {
         try {
             int row = 0;
            int statut = Integer.parseInt(tfrech.getText());
            ServiceBagage service = new ServiceBagage();
            bagages = (List<Bagage>) service.rechercher(statut);
            grid.getChildren().clear();
            for (int i = 0; i < bagages.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("BagageItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
               
                BagageItemController BagageItemController = fxmlLoader.getController();
               

                BagageItemController.setData(bagages.get(i));
               
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(       GestionBagageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            if (bagages != null) {
               
            } else {
                // handle case where Reservation is not found
            }
        } catch (NumberFormatException ex) {
           // handle case where nomRes is not a valid String
        }
    }

    @FXML
    private void btnstat(ActionEvent event) throws IOException {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Statistique.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
       
    }

    @FXML
    private void btntri(ActionEvent event) {
        try {
             int row = 0;
        String sortOrder = cbtri.getValue();
       // List<Vol> sortedList =  Trie(sortOrder);
       ServiceBagage service = new ServiceBagage();
       bagages= (List<Bagage>) service.TriParPoids(sortOrder,bagages);
        
        grid.getChildren().clear();
            for (int i = 0; i < bagages.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("BagageItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                BagageItemController bagageitemController = fxmlLoader.getController();
                

                bagageitemController.setData(bagages.get(i));
                
                grid.add(anchorPane,0 ,row++);
                
            } catch (IOException ex) {
                Logger.getLogger(GestionBagageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            if (bagages != null) {
               
            } else {
                // handle case where Vol is not found
            }
        } catch (NumberFormatException ex) {
            // handle case where idVol is not a valid integer
        }
}
       
    @FXML
    private void btnretour(ActionEvent event) throws IOException {
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionBagage.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void btnnotif(MouseEvent event) {
          //notification bagage retrouvé
        ServiceBagage s1 = new ServiceBagage();
         int nbRetrouves = s1.countRetrouves();
        String message = " " + nbRetrouves + " bagages ont été retrouvés.";
         Notifications notificationBuilder = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder.show();
           
        //notification bagage perdu
         int nbPerdus = s1.countPerdus();
        String message1 = " " + nbPerdus + " bagages ont été perdus.";
        Notifications notificationBuilder1 = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message1)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder1.show();
           //notification bagage volé
         int nbVoles = s1.countVoles();
        String message2 = " " + nbVoles + " bagages ont été volés.";
        Notifications notificationBuilder2 = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message2)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder2.show();   
             //notification bagage suspect
         int nbSusps = s1.countSuspect();
        String message3 = " " + nbSusps + " bagages ont été suspectés.";
        Notifications notificationBuilder3 = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message3)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder3.show();   
           
    }
   
        
}    
    

