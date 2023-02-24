/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Reservation;
import edu.esprit.entities.Siege;
import edu.esprit.gui.*;
import edu.esprit.services.ServiceReservation;
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
public class ReservationItemController implements Initializable {

    @FXML
    private Label idlabel;
    @FXML
    private Label nomlabel;
    @FXML
    private Label departlabel;
    @FXML
    private Label destinationlabel;
    @FXML
    private Label datelabel;
    @FXML
    private Label bagagelabel;
    @FXML
    private Label etatlabel;

    
    
    private Reservation r;
    
    
    
    private Listener listener;
    
    @FXML
    private void editpressed(MouseEvent mouseEvent){
        listener.onClickListener(r);
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void setData(Reservation reservation,Listener listener){
        this.r = reservation;
        this.listener = listener;  
        idlabel.setText(String.valueOf(r.getId()));
        nomlabel.setText(r.getNom());
        departlabel.setText(r.getDepart());
        destinationlabel.setText(r.getDestination());
        datelabel.setText(String.valueOf(r.getDate()));
        bagagelabel.setText(String.valueOf(r.getBagage()));
        ServiceSiege ssiege = new ServiceSiege();
        Siege siege = new Siege();
        siege = ssiege.readById(r.getIdSiege());
        
        
        etatlabel.setText(siege.getEtat());
    }
  
    


@FXML
    private void btnclicked(ActionEvent event) throws IOException {
        
        
            ModifierreservationController.r= r;
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Modifierreservation.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();

    }

    @FXML
    private void delbtn(ActionEvent event) throws IOException {

        ServiceReservation service = new ServiceReservation();
        service.delete(r);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();

    }
    
    

}

