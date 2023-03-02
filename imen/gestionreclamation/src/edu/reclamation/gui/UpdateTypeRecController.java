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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class UpdateTypeRecController implements Initializable {

    @FXML
    private Button bAnnuler;
    @FXML
    private Button bValider;
    @FXML
    private TextField tftype;
static TypeReclamation tr;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tftype.setText(tr.getTypeRec());
    }    

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void modifierrec(ActionEvent event) throws IOException {
        String typeRec = tftype.getText();
        
        ServiceTypeReclamation st=new ServiceTypeReclamation();
        TypeReclamation t1=new TypeReclamation(tr.getIdTR(),typeRec);
        st.modifierTypeRec(t1);
 

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherTypeRec.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void affrec(ActionEvent event) {
    }
    
}
