/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.gui;

import edu.reclamation.entities.Reclamation;
import edu.reclamation.entities.TypeReclamation;
import edu.reclamation.services.ServiceReclamation;
import edu.reclamation.services.ServiceTypeReclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.xml.bind.Marshaller.Listener;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class AfficherTypeRecController implements Initializable {

   private List<TypeReclamation> trec = new ArrayList<>();
     private Listener listener;
    @FXML
    private GridPane grid;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int row = 0;

        TypeReclamation tr = new TypeReclamation();
        ServiceTypeReclamation service = new ServiceTypeReclamation();
        trec = service.getAll();

        if (trec.size() > 0){
            listener = new Listener(){
               // @Override
                public void onClickListener(TypeReclamation tre){
                    System.out.println(tre);
                }
            };
        }


        for (int i = 0; i < trec.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("TypeRecItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                TypeRecItemController useritemController = fxmlLoader.getController();
                

                useritemController.setData(trec.get(i),listener);
                
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(AfficherTypeRecController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    @FXML
    private void retourbutt(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterTypeRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    
    
}
