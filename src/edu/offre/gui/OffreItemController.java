/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import edu.offre.entities.Offre;
import edu.offre.services.ServiceOffre;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Marshaller.Listener;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class OffreItemController implements Initializable {

    @FXML
    private Label nomlabel;

    private Offre o;
     private Listener listener;
    
    @FXML
    private Label idlabel;
    
    @FXML
    private Label ddlabel;
    @FXML
    private Label dflabel;
    @FXML
    private Label destlabel;
    @FXML
    private Label desclabel;
    @FXML
    private Label prixlabel;
    @FXML
    private Button bouttonModif;
    @FXML
    private Button bouttonsup;
    @FXML
    private Label promolabel;
    @FXML
    private Button buttonevaluer;
    
    
    /**
     * Initializes the controller class.
     * @param url
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void setData(Offre offre,Listener listener){
        this.o = offre;
        this.listener = listener;
        idlabel.setText(String.valueOf(o.getIdOffre()));
        nomlabel.setText(o.getNomOffre());
        ddlabel.setText(String.valueOf(o.getDateDebO()));
        dflabel.setText(String.valueOf(o.getDateFinO()));
        destlabel.setText(o.getDestinationOffre());
        desclabel.setText(o.getDescripOffre());
        prixlabel.setText(String.valueOf(o.getPrixOffre()));
        promolabel.setText(String.valueOf(o.getIdPromo()));
    }

    @FXML
    private void btnclicked(ActionEvent event) throws IOException {
        ModifierOffreController.o = o;
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ModifierOffre.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
       
    }

    @FXML
    private void delbtn(ActionEvent event) throws IOException {
       ServiceOffre so = new ServiceOffre();
        so.supprimerOffre(o);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherOffre.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

   

    @FXML
    private void evaluer(ActionEvent event) throws IOException {
         ServiceOffre so = new ServiceOffre();
  
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("EvaluerOffre.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

   

}
