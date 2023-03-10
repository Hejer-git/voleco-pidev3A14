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
import edu.esprit.entities.ActiveUser;
//import edu.esprit.gui.UserItemController;
import edu.esprit.entities.Admin;
import edu.esprit.entities.Client;
import edu.esprit.entities.Employee;
import edu.esprit.entities.User;
import edu.esprit.services.ServiceUser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class GestionUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Label label;
    @FXML
    private GridPane grid;

    private List<User> users = new ArrayList<>();
    private List<User> clients = new ArrayList<>();
    private List<User> employees = new ArrayList<>();

    @FXML
    private Label welcomelabel;
    @FXML
    private Text totalclients;
    @FXML
    private Text totalemployees;
    @FXML
    private Text newclients;
    @FXML
    private Pane homeusepane;
    @FXML
    private Pane employeepane;
    @FXML
    private Pane clientpane;
    @FXML
    private GridPane grid1;

    @FXML
    private ImageView activeuserimg;

    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        homeusepane.toFront();
        welcomelabel.setText("Bienvenue " + ActiveUser.activeuser.getPrenom());
        Image image = new Image(getClass().getResourceAsStream("../uploads/"+ActiveUser.activeuser.getImg()));
        activeuserimg.setImage(image);
        int row = 0;

        User u = new User();
        ServiceUser service = new ServiceUser();
        //users = service.readAll();
        clients = service.getClients();
        employees = service.getEmployees();
        totalclients.setText(String.valueOf(clients.size()));
        totalemployees.setText(String.valueOf(employees.size()));

        for (int i = 0; i < clients.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("UserItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                UserItemController useritemController = fxmlLoader.getController();

                useritemController.setData(clients.get(i));
                grid1.add(anchorPane, 0, row++);

            } catch (IOException ex) {
                Logger.getLogger(GestionUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < employees.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("UserItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                UserItemController useritemController = fxmlLoader.getController();

                useritemController.setData(employees.get(i));
                grid.add(anchorPane, 0, row++);

            } catch (IOException ex) {
                Logger.getLogger(GestionUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnaddhome(ActionEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterUser.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    @FXML
    private void editactiveuserbtn(MouseEvent event) {
    }

    @FXML
    private void clientbox(MouseEvent event) {
        clientpane.toFront();
    }

    @FXML
    private void employeebox(MouseEvent event) {
        employeepane.toFront();
    }

    @FXML
    private void backhomeuser(ActionEvent event) {
        homeusepane.toFront();
    }
    @FXML
    private void logout(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    
}
