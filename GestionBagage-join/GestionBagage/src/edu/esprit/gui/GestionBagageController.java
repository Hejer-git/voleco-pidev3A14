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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class GestionBagageController implements Initializable {

    /**
     * Initializes the controller class.
     */
     private Label label;
    @FXML
    private GridPane grid;

    private List<Bagage> bagages = new ArrayList<>();
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
    
        
    }    
    

