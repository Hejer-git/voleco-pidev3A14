/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


import edu.esprit.entities.Reservation;
import edu.esprit.services.ServiceReservation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 */
public class GestionReservationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Label label;
    @FXML
    private GridPane grid;

    private List<Reservation> reservations = new ArrayList<>();

    
    private Listener listener;
    
    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int row = 0;

        Reservation r = new Reservation();
        ServiceReservation service = new ServiceReservation();
        reservations = service.readAll();

        if (reservations.size() > 0){
            listener = new Listener(){
                @Override
                public void onClickListener(Reservation reservation){
                    System.out.println(reservation);
                }
            };
        }


        for (int i = 0; i < reservations.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ReservationItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                ReservationItemController reservationitemController = fxmlLoader.getController();
                

                reservationitemController.setData(reservations.get(i),listener);
                
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(GestionSiegeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
   @FXML
    private void btnaddhome(ActionEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Ajouterreservation.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void btnmig(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Gestionsiege.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }
    
    
     
}
