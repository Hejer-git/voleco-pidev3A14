/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vol.gui;

import edu.vol.entities.Avion;
import edu.vol.services.ServiceVol;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class ModiferAvionController implements Initializable {

    @FXML
    private Button bAnnuler;
    @FXML
    private Button bValider;
   
private Avion Av;
    @FXML
    private TextField tfNbplaceModif;
    @FXML
    private TextField tfNomAvionModif;
    @FXML
    private DatePicker tfdateModif;
    @FXML
    private TextField tfclasseModif;
    @FXML
    private TextField tfModeleModif;
    @FXML
    private TextField tfIdModif;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annuler(ActionEvent event)throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }

    

    @FXML
    private void btnValiderModifAv(ActionEvent event) throws IOException {
        ServiceVol st = new ServiceVol();
       String nomavion =tfNomAvionModif.getText();
        String classe =tfclasseModif.getText();
         int nbplace =Integer.parseInt(tfNbplaceModif.getText());
      int idAvion =Integer.parseInt(tfIdModif.getText());
        String modele =tfModeleModif.getText();
        
        LocalDate d1 = tfdateModif.getValue();
        Date dateRec = java.sql.Date.valueOf(d1);
     
        Avion a = new Avion(idAvion,nbplace,nomavion,modele,classe,dateRec);
        
        st.modifierAv(a);
        
        System.out.println(a);
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    
}
