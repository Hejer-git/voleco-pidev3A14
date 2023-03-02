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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author 21629
 */
public class UserItemController implements Initializable {

    @FXML
    private Label idlabel;
    @FXML
    private Label nomlabel;
    @FXML
    private Label numlabel;
    @FXML
    private Label emaillabel;
    @FXML
    private Label salairelabel;
    @FXML
    private Label ddlabel;
    @FXML
    private Label prixlabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnclicked(ActionEvent event) {
    }

    @FXML
    private void editpressed(MouseEvent event) {
    }
    
}
