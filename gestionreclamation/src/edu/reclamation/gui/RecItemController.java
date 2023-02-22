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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.xml.bind.Marshaller.Listener;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class RecItemController implements Initializable {

   
    @FXML
    private Label tfnom;
    @FXML
    private Label tfdesc;
    @FXML
    private Label dates;
    

     private Reclamation r;
     private Listener listener;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void setData(Reclamation rec,Listener listener){
        this.r = rec;
        this.listener = listener;  
        
        tfnom.setText(r.getNomC());
        tfdesc.setText(r.getDescription());
        dates.setText(String.valueOf(r.getDateRec()));
    }
    @FXML
    private void btnclicked(ActionEvent event) throws IOException {
         UpdateRecController.r=r;
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("UpdateRec.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }
  
    @FXML
    private void suppclicked(ActionEvent event) throws IOException {
       /* ServiceReclamation sr=new ServiceReclamation();
        sr.supprimerRec(r);
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();*/
       ServiceReclamation service = new ServiceReclamation();
        service.supprimerRec(r);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    @FXML
    private void editpressed(MouseEvent event) {
    }
    
}
