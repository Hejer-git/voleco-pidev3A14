/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.gui;

import edu.offre.entities.Promo;
import edu.offre.services.ServicePromo;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21629
 */
public class PromoItemController implements Initializable {

    @FXML
    private Label idlabel;
      private Promo p;
    @FXML
    private Button bouttonModif;
    @FXML
    private Button bouttonsup;
    @FXML
    private Label Codelabel;
    @FXML
    private Label Reductionlabel;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  public void setData(Promo promo){
        this.p= promo;
        idlabel.setText(String.valueOf(p.getIdPromo()));
        Codelabel.setText(p.getCodePromo());
       Reductionlabel.setText(String.valueOf(p.getReduction()));
    }
    
    
    @FXML
    private void btnclicked(ActionEvent event) throws IOException {
        ModifierPromoController.p = p ;
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ModifierPromo.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();

    }

    @FXML
    private void delbtn(ActionEvent event) throws IOException {
          ServicePromo sp = new ServicePromo();
        sp.supprimerpromo(p);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherPromo.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    
}
