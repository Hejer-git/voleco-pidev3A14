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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class StatBagItemController implements Initializable {

    @FXML
    private Label idlabel;
    @FXML
    private Label statutlabel;
    @FXML
    private Label comlabel;
    
     private StatutBagage sb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setData(StatutBagage sb){
        this.sb = sb;
        statutlabel.setText(String.valueOf(sb.getStatutB()));
        comlabel.setText(String.valueOf(sb.getComB()));
        
}

    @FXML
    private void btnmodif(ActionEvent event) throws IOException {
            ModifierStatBagController.sb= sb;
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("ModifierStatBag.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void btnsupp(ActionEvent event) throws IOException {
        ServiceStatBag ssb = new ServiceStatBag();
        ssb.supprimerSB(sb);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionStatBag.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    
}
