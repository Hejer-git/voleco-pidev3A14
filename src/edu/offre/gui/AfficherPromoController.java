/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.gui;

import edu.offre.entities.Promo;
import edu.offre.services.ServiceOffre;
import edu.offre.services.ServicePromo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author 21629
 */
public class AfficherPromoController implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private Label label;
    private List<Promo> promos = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int row = 0;

        ServicePromo service = new ServicePromo();
        promos = service.getAll();

        


        for (int i = 0; i < promos.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("PromoItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                PromoItemController promoitemController = fxmlLoader.getController();
                

                promoitemController.setData(promos.get(i));
                
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(AfficherOffreController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    }    
    

