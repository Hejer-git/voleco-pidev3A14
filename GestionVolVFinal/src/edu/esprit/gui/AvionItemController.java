/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Avion;
import edu.esprit.services.ServiceAvion;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.xml.bind.Marshaller.Listener;

/**
 * FXML Controller class
 *
 * @author ghassen
 */
public class AvionItemController implements Initializable {

    @FXML
    private Label idlabel;
    @FXML
    private Label NomAvionlabel;
    @FXML
    private Label NbPlacelabel;
    @FXML
    private Label Classelabel;
    @FXML
    private Label Modelelabel;
    @FXML
    private Label Datelabel;
    
      private Avion a;
      private Listener listener;
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setData(Avion avion,Listener listener){
        this.a = avion;
        this.listener = listener;  
        idlabel.setText(String.valueOf(a.getIdAvion()));
        NomAvionlabel.setText(a.getNomAvion());
        Classelabel.setText(a.getClasse());
        NbPlacelabel.setText(String.valueOf(a.getNbPlace()));
        
       Modelelabel.setText(a.getModele());
        Datelabel.setText(String.valueOf(a.getDateEntServ()));
    }


    @FXML
    private void editpressed(MouseEvent event) {
    }

    @FXML
    private void btnModifier(ActionEvent event) throws IOException {
         ModifierAvController.a= a;
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("ModifierAv.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void btnSupprimer(ActionEvent event)throws IOException {
         ServiceAvion st = new ServiceAvion();
        st.supprimerAv(a);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }
    
}
