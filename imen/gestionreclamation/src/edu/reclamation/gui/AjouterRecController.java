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
import edu.reclamation.entities.TypeReclamation;
import edu.reclamation.services.ServiceTypeReclamation;
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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author imen
 */
public class AjouterRecController implements Initializable {

    ServiceTypeReclamation serCat = new ServiceTypeReclamation() ;
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
    @FXML
    private ComboBox<String> typecombo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<TypeReclamation> arrayList =  (ArrayList) serCat.getAll();
          for (int i=0;i<arrayList.size();i++){
               typecombo.getItems().addAll(arrayList.get(i).getTypeRec());
          }
    }    
  private boolean nom_valide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(tfnom.getText());
        if(m.find() && m.group().equals(tfnom.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
              //  alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Entrez un nom valide  !");
                alert.showAndWait();
           
            return false;            
        }
        
     }
   private boolean desc_valide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(tfdesc.getText());
        if(m.find() && m.group().equals(tfdesc.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Entrez une description valide !");
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
       /* if(nom_recvalide()&&descp_recvalide()){
        String nomC =tfnom.getText();
        String description =tfdesc.getText();
        LocalDate d1 = dates.getValue();
        Date dateRec = java.sql.Date.valueOf(d1);*/
        
       if((tfnom.getText().equals("")) || (tfdesc.getText().equals(""))
                || (dates.getValue() == null)){
    Alert alert =new Alert(Alert.AlertType.ERROR);
    alert.setContentText("Remplissez tt les champs");   
    alert.showAndWait();
    
}
       else if (nom_valide()&&desc_valide()){
           String fil = typecombo.getValue().toString() ;
                int typeid = serCat.getIdt(fil) ;
        String nomC =tfnom.getText();
        String description =tfdesc.getText();
       // LocalDate d1 = dates.getValue();
       LocalDate d1 = LocalDate.now();
        Date dateRec = java.sql.Date.valueOf(d1);
        ServiceReclamation se=new ServiceReclamation();
        Reclamation e=new Reclamation(nomC,description,dateRec,typeid);
        se.ajouterRec(e);   
      
      Alert alert =new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText("Reservation ajouter");
    alert.showAndWait();
    }
       Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    }

