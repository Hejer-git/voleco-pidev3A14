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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Pos;
import java.util.EventObject;
import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author 21629
 */
public class AjouterPromoController implements Initializable {

    @FXML
    private TextField tdCodeP;
    @FXML
    private TextField tfReduction;
    @FXML
    private Button buttonajouter;
    @FXML
    private Button bouttonAff;
       
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
  

    @FXML
    private void ajouteraction(ActionEvent event)throws Exception {
        
        String codePromo = tdCodeP.getText();
       int Reduction = Integer.parseInt(tfReduction.getText());
   
        Promo p;
        
        p=new Promo(codePromo, Reduction);
        ServicePromo so = new ServicePromo();
        
        if (((tdCodeP.getText().isEmpty()))||((tfReduction.getText().isEmpty()))){
       Notifications notificationBuilder = Notifications.create()
                    .title("champs vide")
                    .text("veuillez remplir les champs vide")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.showWarning();
    }else{
      so.ajouterpromo(p); 
            Notifications notificationBuilder = Notifications.create()
                    .title("stage ajouté")
                    .text("vous pouvez ajouté d'autre stage")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.show();
  }
    } 
    @FXML
    private void affP(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../gui/AfficherPromo.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

  
    
    
}
   