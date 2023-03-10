/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.ActiveUser;
import edu.esprit.entities.Admin;
import edu.esprit.entities.Client;
import edu.esprit.entities.Employee;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import edu.esprit.entities.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import edu.esprit.services.ServiceUser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class UserItemController implements Initializable {

    @FXML
    private Label nomlabel;
    @FXML
    private Label prenomlabel;
    @FXML
    private Label cinlabel;
    @FXML
    private Label numlabel;
    @FXML
    private Label emaillabel;
    @FXML
    private Label salairelabel;

    private User u;
    
    
    @FXML
    private ImageView imgitem;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    
    public void setData(User user){
        
        
        
        this.u = user;
        nomlabel.setText(u.getNom());
        prenomlabel.setText(u.getPrenom());
        cinlabel.setText(String.valueOf(u.getCin()));
        numlabel.setText(String.valueOf(u.getNumtel()));
        emaillabel.setText(u.getEmail());
        salairelabel.setText(String.valueOf(u.getSalaire()));
        if (user instanceof Admin ){
        }else if (user instanceof Client ){
            salairelabel.setVisible(false);
            salairelabel.setPrefWidth(0);
        }else if (user instanceof Employee ){
        }
        Image image = new Image(getClass().getResourceAsStream("../uploads/"+u.getImg()));
        imgitem.setImage(image);
    }

    @FXML
    private void btnedit(MouseEvent event) throws IOException {
        ModifierUserController.u= u;
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("ModifierUser.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void btndel(MouseEvent event) throws IOException {
        ServiceUser service = new ServiceUser();
        service.delete(u);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }
    
    

}
