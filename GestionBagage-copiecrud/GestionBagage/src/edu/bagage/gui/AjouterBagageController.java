/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bagage.gui;

import edu.bagage.entities.Bagage;
import edu.bagage.services.ServiceBagage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Date;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
        
/**
 * FXML Controller class
 *
 * @author 21654
 */
public class AjouterBagageController implements Initializable {

    @FXML
    private Button btnValider;
    @FXML
    private TextField tfPoids;
    @FXML
    private TextField tfTaille;
    @FXML
    private TextField tfFrais;
    @FXML
    private DatePicker dpDateB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        float poids = Float.parseFloat(tfPoids.getText());
        float taille = Float.parseFloat(tfTaille.getText());
        float frais = Float.parseFloat(tfFrais.getText());
        LocalDate date = dpDateB.getValue();
        Date dateB = java.sql.Date.valueOf(date);
        
        Bagage b = new Bagage(poids, taille, frais, dateB);
        ServiceBagage sb = new ServiceBagage();
        sb.ajouter(b);
    }
    
}
