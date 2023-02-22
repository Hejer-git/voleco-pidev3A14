/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bagage.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import edu.bagage.entities.Bagage;
import edu.bagage.services.ServiceBagage;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class BagageItemController implements Initializable {
    
    @FXML
    private Label poidslabel;
    @FXML
    private Label taillelabel;
    @FXML
    private Label fraislabel;
    @FXML
    private Label datelabel;
   
    private Bagage b;
    @FXML
    private Button btnmodif;
    @FXML
    private Button btnsupp;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
     public void setData(Bagage bagage){
        this.b = bagage;
        poidslabel.setText(String.valueOf(b.getPoids()));
        taillelabel.setText(String.valueOf(b.getTaille()));
        fraislabel.setText(String.valueOf(b.getFrais()));
        //datelabel.setText(String.valueOf(b.getDateB()));
        
}
}
