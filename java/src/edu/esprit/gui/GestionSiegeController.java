/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Siege;
import edu.esprit.services.ServiceSiege;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MHIRI
 */
public class GestionSiegeController implements Initializable {

    private Label label;
    @FXML
    private GridPane grid;

    private List<Siege> sieges = new ArrayList<>();

    
    private Listener1 listener1;
    
    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int row = 0;

        Siege s = new Siege();
        ServiceSiege service = new ServiceSiege();
        sieges = service.readAll();

        if (sieges.size() > 0){
            listener1 = new Listener1(){
                @Override
                public void onClickListener(Siege siege){
                    System.out.println(siege);
                }
            };
        }


        for (int i = 0; i < sieges.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("SiegeItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                SiegeItemController siegeitemController = fxmlLoader.getController();
                

                siegeitemController.setData(sieges.get(i),listener1);
                
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(GestionSiegeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
   @FXML
    private void btnaddhome(ActionEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Ajoutersiege.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void btnreser(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }
     
}
