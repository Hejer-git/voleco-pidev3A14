/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Bagage;
import edu.esprit.entities.StatutBagage;
import edu.esprit.services.ServiceBagage;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.xml.bind.Marshaller.Listener;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class BagageItemController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label poidslabel;
    @FXML
    private Label taillelabel;
    @FXML
    private Label fraislabel;
    @FXML
    private Label datelabel;
    @FXML
    private Label idlabel;
    @FXML
    private Label statlabel;
   
    private Bagage b;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      public void setData(Bagage bagage){
        this.b = bagage;
        poidslabel.setText(String.valueOf(b.getPoids()));
        taillelabel.setText(String.valueOf(b.getTaille()));
        fraislabel.setText(String.valueOf(b.getFrais()));
        datelabel.setText(String.valueOf(b.getDateB()));
        ServiceStatBag ssb = new ServiceStatBag();
        StatutBagage sb = new StatutBagage();
        sb = ssb.getSBById(b.getIdStatBag());
        statlabel.setText(sb.getStatutB());

        
}

    @FXML
    private void btnmodif(ActionEvent event) throws IOException {
            ModifierBagageController.b= b;
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("ModifierBagage.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void btnsupp(ActionEvent event) throws IOException {
        ServiceBagage sb = new ServiceBagage();
        sb.supprimer(b);
        
         // Confirmation de la modification
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment supprimer ce Bagage ?");
        alert.setContentText("" );
        alert.showAndWait();
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionBagage.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
}
