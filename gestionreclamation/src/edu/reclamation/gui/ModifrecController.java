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
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class ModifrecController implements Initializable {

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
private Reclamation Re;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annuler(ActionEvent event)throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("showrec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }

    @FXML
    private void modifrec(ActionEvent event) throws IOException {
       /* ServiceReclamation se= new ServiceReclamation();
        Reclamation e=new Reclamation();
        e.setNomC(tfnom.getText());
        e.setDescription(tfdesc.getText());
        e.setDateRec(java.sql.Date.valueOf(dates.getValue()));
        se.modifierRec(e);*/
     /*
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("showrec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();*/
      ServiceReclamation st = new ServiceReclamation();
        String nomC = this.tfnom.getText();
         String description = this.tfdesc.getText();
        
        Date dateRec = Date.valueOf(this.dates.getValue());
     
        Reclamation t=new Reclamation(nomC, description, dateRec);
        
        st.modifierRec(this.Re);
        
        System.out.println(t);
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("showrec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
       
    }
    
}
