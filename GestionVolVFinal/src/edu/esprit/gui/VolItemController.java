/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import edu.esprit.entities.Avion;
import edu.esprit.entities.Vol;
import edu.esprit.services.ServiceAvion;
import edu.esprit.services.ServiceVol;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.xml.bind.Marshaller.Listener;

/**
 * FXML Controller class
 *
 * @author ghassen
 */
public class VolItemController implements Initializable {

    
    
    private Vol v;
      private Listener listener;
    @FXML
    private Label numVollabel;
    @FXML
    private Label heureDeplabel;
    @FXML
    private Label dateDeplabel;
    @FXML
    private Label dateArrlabel;
    @FXML
    private Label DureeVollabel;
    @FXML
    private Label heureArrlabel;
    @FXML
    private Label NomAvionlabel;
    @FXML
    private Button btnsupp;
    @FXML
    private Label AdrDeplabel;
    @FXML
    private Label AdrArrlabel;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    public void setData(Vol vol,Listener listener){
        this.v = vol;
        this.listener = listener;  
         
        numVollabel.setText(String.valueOf(v.getNumVol()));
         DureeVollabel.setText(String.valueOf(v.getDureeVol()));
        heureDeplabel.setText(String.valueOf(v.getTimeDep()));
        heureArrlabel.setText(String.valueOf(v.getTimeArr()));
        ServiceAvion savion = new ServiceAvion();
        Avion avion = savion.getOneById(v.getidAvion());

        AdrDeplabel.setText(v.getAdrDep());
        AdrArrlabel.setText(v.getAdrArr());
        
        NomAvionlabel.setText(avion.getNomAvion());
        dateDeplabel.setText(String.valueOf(v.getDateDep()));
        dateArrlabel.setText(String.valueOf(v.getDateArr()));
    }
/*
    @FXML
    private void btnModifier(ActionEvent event)throws IOException {
        ModifierVolController.v= v;
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("ModifierAv.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    } */

    @FXML
    private void editpressed(MouseEvent event) throws IOException {
        ModifierVolController.v = v;
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("ModifierVol.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

   
    @FXML
    private void btnSupprimer(MouseEvent event)throws IOException {
        
        ServiceVol sv = new ServiceVol();
      
              sv.supprimerVol(v);
      
       
              
          
        
      
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherVol.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    @FXML
    private void editpressed(ActionEvent event) {
    }

    @FXML
    private void btnSupprimer(ActionEvent event) {
    }

   
    
}
