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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    private Label type;
    @FXML
    private ImageView imageview;
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
        
        ServiceTypeReclamation s=new ServiceTypeReclamation();
        TypeReclamation t=s.getOneById(r.getType());
        //type.setText(String.valueOf(r.getType()));
        type.setText(t.getTypeRec());
       Image image = new Image(getClass().getResourceAsStream("../imen/"+r.getImage()));
        imageview.setImage(image);
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
       
       
       ServiceReclamation service = new ServiceReclamation();
       Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are u sure?"); 
        Optional<ButtonType> result=alert.showAndWait();
        if(result.get()==ButtonType.OK){ 
      
        service.supprimerRec(r);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        }
        else if(result.get()==ButtonType.CANCEL){
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherRec.fxml"));
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
