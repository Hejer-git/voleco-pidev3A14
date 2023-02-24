/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Siege;
import edu.esprit.gui.*;
import edu.esprit.services.ServiceSiege;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MHIRI
 */
public class SiegeItemController implements Initializable {

    @FXML
    private Label idlabel;
    @FXML
    private Label numlabel;
    @FXML
    private Label etatlabel;
    @FXML
    private Label statuslabel;
    
    
    private Siege s;
    
    
    
    private Listener1 listener1;
    
    @FXML
    private void editpressed(MouseEvent mouseEvent){
        listener1.onClickListener(s);
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void setData(Siege siege,Listener1 listener1){
        this.s = siege;
        this.listener1 = listener1;  
        idlabel.setText(String.valueOf(s.getId()));
        numlabel.setText(String.valueOf(s.getNum()));
        etatlabel.setText(s.getEtat());
        statuslabel.setText(s.getStatus());

    }
  
    


@FXML
    private void btnclicked(ActionEvent event) throws IOException {
        
        
            ModifiersiegeController.s= s;
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Modifiersiege.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();

    }

    @FXML
    private void delbtn(ActionEvent event) throws IOException {

        ServiceSiege service = new ServiceSiege();
        service.delete(s);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionSiege.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();

    }
    
    

}

