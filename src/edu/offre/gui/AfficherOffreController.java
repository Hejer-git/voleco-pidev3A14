/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.gui;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

//import edu.esprit.gui.UserItemController;

import edu.offre.entities.Offre;
import edu.offre.services.ServiceOffre;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.xml.bind.Marshaller.Listener;
/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AfficherOffreController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Label label;
    @FXML
    private GridPane grid;

    private List<Offre> offres = new ArrayList<>();
    private Listener listener;
    @FXML
    private TextField tfrecherche;
    @FXML
    private ComboBox<String> cbdesasc;
    
  
    @FXML
    private Button recherche;
    @FXML
    private Button btntrier;
    public  ObservableList<String> options= FXCollections.observableArrayList(
        "ASC", "DESC" );

    
    
    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cbdesasc.getSelectionModel().selectFirst();
        
        for (int i = 0; i  < options.size(); i++)
        {
         cbdesasc.getItems().add(options.get(i));
        }
        
        int row = 0;

        ServiceOffre service = new ServiceOffre();
        offres = service.getAll();

        

        if (offres.size() > 0){
            listener = new Listener(){
                public void onClickListener(Offre offre){
                    System.out.println(offre);
                }
            };
        }


        for (int i = 0; i < offres.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("OffreItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                OffreItemController offreitemController = fxmlLoader.getController();
                

                offreitemController.setData(offres.get(i),listener);
                
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(AfficherOffreController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    @FXML
    private void btnrecherche(ActionEvent event) {
        try{
                     int row = 0;
         String DestinationOffre = tfrecherche.getText();
            ServiceOffre service = new ServiceOffre();
            offres = (List<Offre>) service.recherche(DestinationOffre);
            grid.getChildren().clear();
            for (int i = 0; i < offres.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("OffreItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
               
                OffreItemController OffreItemController = fxmlLoader.getController();
               

                OffreItemController.setData(offres.get(i),listener);
               
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(       AfficherOffreController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            if (offres != null) {
               
            } else {
                // handle case where Offre is not found
            }
        } catch(NumberFormatException ex){ 
            // handle case where DestinationOffre is not a valid String
                    }

    }



    @FXML
    private void btntrier(ActionEvent event) {
        try {
             int row = 0;
            ServiceOffre service = new ServiceOffre();
          
            String ordre= (String) cbdesasc.getValue();
            offres=service.Trie(ordre,offres);
            grid.getChildren().clear();
            for (int i = 0; i < offres.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("OffreItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
               
                OffreItemController OffreItemController = fxmlLoader.getController();
               

                OffreItemController.setData(offres.get(i),listener);
               
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(       AfficherOffreController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            if (offres != null) {
               
            } else {
                // handle case where Reservation is not found
            }
        } 
        catch (NumberFormatException ex) {
           // handle case where nomRes is not a valid String
        }
        
    }

    @FXML
    private void cbdesasc(ActionEvent event) {
    }

   
    

    
    
}

