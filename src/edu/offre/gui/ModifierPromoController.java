/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.gui;

import edu.offre.entities.Promo;
import static edu.offre.gui.ModifierOffreController.o;
import edu.offre.services.ServicePromo;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21629
 */
public class ModifierPromoController implements Initializable {
 static Promo p;
    @FXML
    private TextField tfCodeP;
    @FXML
    private TextField tfR;
    @FXML
    private Button bouttonmodif;
    @FXML
    private Button bouttonretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              tfCodeP.setText(p.getCodePromo());
        tfR.setText(String.valueOf(p.getReduction()));
    }    

    @FXML
    private void modifieraction(ActionEvent event)throws IOException {
         String codePromo = tfCodeP.getText();
           
         int Reduction =Integer.parseInt(tfR.getText());
        ServicePromo sp=new ServicePromo();
       Promo po=new Promo(p.getIdPromo(),codePromo,Reduction);
       sp.modifierpromo(po);


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherPromo.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void retouraction(ActionEvent event) throws IOException {
             Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherPromo.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    
}
