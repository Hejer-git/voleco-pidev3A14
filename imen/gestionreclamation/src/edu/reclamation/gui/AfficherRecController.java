/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.gui;

import api.Pdf;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import edu.reclamation.entities.Reclamation;
import edu.reclamation.services.ServiceReclamation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField tfrecherche;
    @FXML
    private Button chercher;
    @FXML
    private Button pdf;
    @FXML
    private ComboBox<String> cbdesasc;
    @FXML
    private Button btntrier;
     public  ObservableList<String> options = FXCollections.observableArrayList(
        "ASC", "DESC");
    
    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cbdesasc.getSelectionModel().selectFirst();
        for (int i = 0; i < options.size(); i++){
        cbdesasc.getItems().add(options.get(i) );
       }
        
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

    @FXML
    private void typeRec(ActionEvent event) throws IOException {
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterTypeRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    @FXML
    private void recherche(ActionEvent event) {
   try {
             int row = 0;
            String nom = tfrecherche.getText();
            ServiceReclamation service = new ServiceReclamation();
            rec = (List<Reclamation>) service.recherche(nom);
            grid.getChildren().clear();
            for (int i = 0; i < rec.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("RecItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
               
                RecItemController RecItemController = fxmlLoader.getController();
               

                RecItemController.setData(rec.get(i),listener);
               
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(       AfficherRecController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            if (rec != null) {
               
            } else {
                // handle case where Reservation is not found
            }
        } catch (NumberFormatException ex) {
           // handle case where nomRes is not a valid String
        }
     
    }
    

 @FXML
    private void pdf(ActionEvent event) throws DocumentException, BadElementException, IOException, FileNotFoundException, InterruptedException, SQLException {
        Pdf p = new Pdf();
        p.GeneratePdf("Mes reclamations");
        
     
    }

    @FXML
    private void cbdesasc(ActionEvent event) {
    }

    @FXML
    private void btntrier(ActionEvent event) {
        try {
             int row = 0;
            ServiceReclamation service = new ServiceReclamation();
            String ordre= cbdesasc.getValue();
            rec=service.Trie(ordre, rec);
            grid.getChildren().clear();
            for (int i = 0; i < rec.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("RecItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
               
                RecItemController RecItemController = fxmlLoader.getController();
               

                RecItemController.setData(rec.get(i),listener);
               
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(       AfficherRecController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            if (rec != null) {
               
            } else {
                // handle case where Reservation is not found
            }
        } catch (NumberFormatException ex) {
           // handle case where nomRes is not a valid String
        }
    }
    
}
