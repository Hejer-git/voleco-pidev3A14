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
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class ModifierBagageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField tfPoids;
    @FXML
    private TextField tfTaille;
    @FXML
    private TextField tfFrais;
    @FXML
    private DatePicker dpDateB;
    
    static Bagage b;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfPoids.setText(String.valueOf(b.getPoids()));
        tfTaille.setText(String.valueOf(b.getTaille()));
        tfFrais.setText(String.valueOf(b.getFrais()));       
       java.sql.Date d1= new java.sql.Date(b.getDateB().getTime());

       //java.sql.Date d1= java.sql.Date.valueOf(a.getDateEntServ());
        dpDateB.setValue(d1.toLocalDate());
    }    
   
    @FXML
    private void btnmodif(ActionEvent event) throws IOException {
        float poids =Float.parseFloat(tfPoids.getText());
        float taille =Float.parseFloat(tfTaille.getText());
        float frais =Float.parseFloat(tfFrais.getText());
        java.sql.Date dateB = java.sql.Date.valueOf(this.dpDateB.getValue());
        
        ServiceBagage s1=new ServiceBagage();
        Bagage b1=new Bagage(b.getIdBagage(),poids,taille,frais,dateB);
        s1.modifier(b1);


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionBagage.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }
    
}
