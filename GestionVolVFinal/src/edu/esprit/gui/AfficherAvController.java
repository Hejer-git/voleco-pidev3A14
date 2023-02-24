/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import edu.esprit.entities.Avion;
import edu.esprit.services.ServiceAvion;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

//import edu.esprit.gui.AvionItemController;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.xml.bind.Marshaller.Listener;

/**
 * FXML Controller class
 *
 * @author ghassen
 */
public class AfficherAvController implements Initializable {

    
    
    private List<Avion> avion = new ArrayList<>();
    private Listener listener;
    @FXML
    private GridPane grid;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         int row = 0;

        Avion a = new Avion();
        ServiceAvion service = new ServiceAvion();
        avion = service.getAll();

        if (avion.size() > 0){
            listener = new Listener(){
                
               /* public void onClickListener(Avion avion){
                    System.out.println(avion);
                }*/
            };
        }


        for (int i = 0; i < avion.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("AvionItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                AvionItemController avionitemController = fxmlLoader.getController();
                

                avionitemController.setData(avion.get(i),listener);
                
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(       AfficherAvController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

   

    @FXML
    private void btnAjouter1(ActionEvent event) throws IOException {
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }

    @FXML
    private void btnMigration1(ActionEvent event) throws IOException {
          Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherVol.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }
       
    
}
