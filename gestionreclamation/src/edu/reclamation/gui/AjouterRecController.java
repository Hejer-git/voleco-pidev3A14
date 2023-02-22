 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import edu.reclamation.services.ServiceReclamation;
import edu.reclamation.entities.Reclamation;
import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author imen
 */
public class AjouterRecController implements Initializable {

    @FXML
    private Button bAnnuler;
    @FXML
    private Button bValider;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdesc;
    @FXML
    private DatePicker dates;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  private boolean nom_recvalide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(tfnom.getText());
        if(m.find() && m.group().equals(tfnom.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
              //  alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez entrer un nom valide  !");
                alert.showAndWait();
           
            return false;            
        }
        
     }
   private boolean descp_recvalide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(tfdesc.getText());
        if(m.find() && m.group().equals(tfdesc.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez entrer une description valide !");
                alert.showAndWait();
           
            return false;            
        }
     }
    @FXML
    private void annuler(ActionEvent event) throws IOException{
     
    }
    @FXML
    private void affrec(ActionEvent event) throws IOException{
      Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    @FXML
    private void ajoutrec(ActionEvent event) throws IOException {
        if(nom_recvalide()&&descp_recvalide()){
        String nomC =tfnom.getText();
        String description =tfdesc.getText();
        LocalDate d1 = dates.getValue();
        Date dateRec = java.sql.Date.valueOf(d1);
        
        
      
       if((tfnom.getText().equals("")) || (tfdesc.getText().equals(""))
                || (dates.getValue() == null)){
    Alert alert =new Alert(Alert.AlertType.ERROR);
    alert.setContentText("remplir tt les champs");   
    alert.showAndWait();
    
}
else {
        
        ServiceReclamation se=new ServiceReclamation();
        Reclamation e=new Reclamation(nomC,description,dateRec);
        se.ajouterRec(e);   
      //FXMLLoader loader= new FXMLLoader(getClass().getResource("showrec.fxml"));
      /*((Node)event.getSource()).getScene().getWindow().hide();
      FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("showrec.fxml"));
      try{
          Parent root =loader.load();
          ShowrecController dwc =loader.getController();
         
      }catch(IOException ex){
         System.out.println(ex.getMessage());
      }*/
      
      Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
    alert.setContentText("Reservation ajouter");
    alert.showAndWait();
    }
       Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    }
}
