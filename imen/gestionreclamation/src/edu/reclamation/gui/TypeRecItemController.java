/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.gui;

import edu.reclamation.entities.TypeReclamation;
import edu.reclamation.services.ServiceTypeReclamation;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.xml.bind.Marshaller.Listener;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class TypeRecItemController implements Initializable {

   
    @FXML
    private Label tftype;
   
     private TypeReclamation r;
     private Listener listener;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void setData(TypeReclamation rec,Listener listener){
        this.r = rec;
        this.listener = listener;  
        
        tftype.setText(r.getTypeRec());
        
    }
    @FXML
    private void btnclicked(ActionEvent event) throws IOException {
         UpdateTypeRecController.tr=r;
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("UpdateTypeRec.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }
  
    @FXML
    private void suppclicked(ActionEvent event) throws IOException {
       
       ServiceTypeReclamation service = new ServiceTypeReclamation();
       Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are u sure?"); 
        Optional<ButtonType> result=alert.showAndWait();
        if(result.get()==ButtonType.OK){
        service.supprimerTypeRec(r);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherTypeRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        }
        else if(result.get()==ButtonType.CANCEL){
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherTypeRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        } 
    }
    @FXML
    private void editpressed(MouseEvent event) {
    }
    
}
