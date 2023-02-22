/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bagage.gui;

import java.net.URL;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import edu.bagage.entities.Bagage;
import edu.bagage.services.ServiceBagage;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.AnchorPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class GestionBagageFXMLController implements Initializable {

    private Label label;
    @FXML
    private GridPane grid;

    private List<Bagage> lb = new ArrayList<>();

    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int row = 0;

        Bagage b = new Bagage();
        ServiceBagage service = new ServiceBagage();
        lb = service.getAll();
        //System.out.println(lb);
       for (int i = 0; i < lb.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("BagageItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                BagageItemController bagageitemController = fxmlLoader.getController();
                

                bagageitemController.setData(lb.get(i));
                
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(GestionBagageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        }

}



        
     
    

