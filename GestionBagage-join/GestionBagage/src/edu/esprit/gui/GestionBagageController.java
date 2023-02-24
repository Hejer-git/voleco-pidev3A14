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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        
    }    
    

