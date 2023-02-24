/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.StatutBagage;
import edu.esprit.services.ServiceStatBag;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class GestionStatBagController implements Initializable {

    @FXML
    private GridPane grid;

    private List<StatutBagage> statbags = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         int row = 0;

        StatutBagage sb = new StatutBagage();
        ServiceStatBag s2 = new ServiceStatBag();
        statbags = s2.getAllSB();

        for (int i = 0; i < statbags.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("StatBagItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                StatBagItemController statbagitemController = fxmlLoader.getController();
                
                statbagitemController.setData(statbags.get(i));
                grid.add(anchorPane,0 ,row++);

            } catch (IOException ex) {
                Logger.getLogger(GestionBagageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    @FXML
    private void btnajouter(ActionEvent event) throws IOException {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterStatBag.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }
    
}
