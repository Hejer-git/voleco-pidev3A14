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
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    static Reclamation r;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         /*tfnom.setText(r.getNomC());
        tfdesc.setText(r.getDescription());
        dates.setText(String.valueOf(r.getDateRec()));*/
          tfnom.setText(r.getNomC());
        tfdesc.setText(r.getDescription());
       
       java.sql.Date d1= new java.sql.Date(r.getDateRec().getTime());

       //java.sql.Date d1= java.sql.Date.valueOf(a.getDateEntServ());
        dates.setValue(d1.toLocalDate());
    }    
   /* public void setData(Reclamation rec,Marshaller.Listener listener){
        this.r = rec;
        
        tfnom.setText(r.getNomC());
        tfdesc.setText(r.getDescription());
        dates.setText(String.valueOf(r.getDateRec()));
    }*/

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
         /* ServiceReclamation sr = new ServiceReclamation();
        String nomC =tfnom.getText();
        String description =tfdesc.getText();
        LocalDate d1 = dates.getValue();
        Date dateRec = java.sql.Date.valueOf(d1);*/
         String nomC = tfnom.getText();
        String description =tfdesc.getText();
     
        
        LocalDate d1 =  dates.getValue();
        Date dateRec = java.sql.Date.valueOf(d1);
        ServiceReclamation sr=new ServiceReclamation();
        Reclamation r1=new Reclamation(r.getIdRec(),nomC,description,dateRec);
        sr.modifierRec(r1);
 

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherRec.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void affrec(ActionEvent event) {
    }
    
}
