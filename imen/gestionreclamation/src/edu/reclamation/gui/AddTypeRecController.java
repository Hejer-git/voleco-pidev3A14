/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.gui;

import edu.reclamation.entities.TypeReclamation;
import edu.reclamation.services.ServiceTypeReclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class AddTypeRecController implements Initializable {

    @FXML
    private Button bAnnuler;
    @FXML
    private Button bValider;
    @FXML
    private TextField tftype;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annulertr(ActionEvent event) {
    }

    @FXML
    private void ajouttyperec(ActionEvent event) throws IOException {
        
        String typeTR =tftype.getText();
       
        ServiceTypeReclamation se=new ServiceTypeReclamation();
        TypeReclamation e=new TypeReclamation(typeTR);
        se.ajouterTypeRec(e);   
      
      
    
      /* Parent tableViewParent = FXMLLoader.load(getClass().getResource("showrec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();*/
    
    }


    @FXML
    private void afftyperec(ActionEvent event) {
        
    }
    
}
