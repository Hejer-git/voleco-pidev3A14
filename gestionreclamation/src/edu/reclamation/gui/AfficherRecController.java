/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.gui;

import edu.reclamation.entities.Reclamation;
import edu.reclamation.services.ServiceReclamation;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.xml.bind.Marshaller.Listener;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class AfficherRecController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private List<Reclamation> rec = new ArrayList<>();
     private Listener listener;
    @FXML
    private GridPane grid;
    
    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int row = 0;

        Reclamation r = new Reclamation();
        ServiceReclamation service = new ServiceReclamation();
        rec = service.getAll();

        if (rec.size() > 0){
            listener = new Listener(){
               // @Override
                public void onClickListener(Reclamation re){
                    System.out.println(re);
                }
            };
        }


        for (int i = 0; i < rec.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("RecItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                RecItemController useritemController = fxmlLoader.getController();
                

                useritemController.setData(rec.get(i),listener);
                
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(AfficherRecController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
      @FXML
    private void retourbutt(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }
    


    
}
