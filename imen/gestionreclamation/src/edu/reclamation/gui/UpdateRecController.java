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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.xml.bind.Marshaller;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class UpdateRecController implements Initializable {

     ServiceTypeReclamation serCat = new ServiceTypeReclamation() ;
    @FXML
    private Button bAnnuler;
    @FXML
    private Button bValider;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdesc;
    private DatePicker dates;
    static Reclamation r;
    @FXML
    private ComboBox<String> typecombo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
          tfnom.setText(r.getNomC());
        tfdesc.setText(r.getDescription());
       
     
       ServiceTypeReclamation st = new ServiceTypeReclamation();
        List<TypeReclamation> listt = new ArrayList<>();
        listt = st.getAll();
      
       for (int i = 0; i < listt.size(); i++){
           typecombo.getItems().add(listt.get(i).getTypeRec());
           
           TypeReclamation tr = st.getOneById(r.getType());
        ServiceReclamation sv = new ServiceReclamation();
        Reclamation rr= sv.getOneById(r.getIdRec());
        typecombo.setValue(tr.getTypeRec());
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
    private void annuler(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        
         String nomC = tfnom.getText();
        String description =tfdesc.getText();
        String typerec=typecombo.getValue();
          if(description.isEmpty() || nomC.isEmpty()){
    Alert alert =new Alert(Alert.AlertType.ERROR);
    alert.setContentText("Remplissez tt les champs");   
    alert.showAndWait();
    return;
    
}
          else if (nom_valide()&&desc_valide()){ 
        //LocalDate d1 =  dates.getValue();
        LocalDate d1 = LocalDate.now();
        Date dateRec = java.sql.Date.valueOf(d1);
       
         ServiceReclamation se=new ServiceReclamation();
        ServiceTypeReclamation st = new ServiceTypeReclamation();
        TypeReclamation tr = new TypeReclamation();
       // tr = st.getOneByName(typecombo.getValue())
        tr=st.readBytype(typerec);
        Reclamation r1=new Reclamation(r.getIdRec(),nomC,description,dateRec,tr.getIdTR(),r.getImage());
       se.modifierRec(r1);
           
    }
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherRec.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void affrec(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    
}
