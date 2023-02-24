/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import edu.esprit.entities.Avion;
import edu.esprit.entities.Vol;
import edu.esprit.services.ServiceAvion;
import edu.esprit.services.ServiceVol;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;



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
public class AfficherVolController implements Initializable {
    
    
    private List<Vol> vol = new ArrayList<>();
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

        Avion v = new Avion();
        ServiceVol service = new ServiceVol();
        vol = service.getAll();

        if (vol.size() > 0){
            listener = new Listener(){
                
               /* public void onClickListener(Avion avion){
                    System.out.println(avion);
                }*/
            };
        }


        for (int i = 0; i < vol.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("VolItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                VolItemController volitemController = fxmlLoader.getController();
                

                volitemController.setData(vol.get(i),listener);
                
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(       AfficherAvController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

   

    @FXML
    private void btnAjouter1(ActionEvent event) throws IOException {
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterVol.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }

    @FXML
    private void btnMigration(ActionEvent event) throws IOException {
          Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
     
    
}
