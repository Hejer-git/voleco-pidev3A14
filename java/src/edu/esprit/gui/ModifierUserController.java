/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Admin;
import edu.esprit.entities.Client;
import edu.esprit.entities.Employee;
import edu.esprit.entities.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import edu.esprit.services.ServiceUser;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class ModifierUserController implements Initializable {

    @FXML
    private TextField editnom;
    @FXML
    private TextField editprenom;
    @FXML
    private TextField editcin;
    @FXML
    private TextField editnumtel;
    @FXML
    private TextField editemail;
    @FXML
    private TextField editsalaire;

    static User u;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        editnom.setText(u.getNom());
        editprenom.setText(u.getPrenom());
        editcin.setText(String.valueOf(u.getCin()));
        editnumtel.setText(String.valueOf(u.getNumtel()));
        editemail.setText(u.getEmail());
        editsalaire.setText(String.valueOf(u.getSalaire()));

        
    }

    public void setData(User user) {

        this.u = user;
        System.out.println(user.getClass());

        editnom.setText(user.getNom());
        editprenom.setText(user.getPrenom());
        editcin.setText(String.valueOf(user.getCin()));
        editnumtel.setText(String.valueOf(user.getNumtel()));
        editemail.setText(user.getEmail());
        editsalaire.setText(String.valueOf(user.getSalaire()));
    }

    @FXML
    private void btnedit(ActionEvent event) throws IOException {
        ServiceUser service = new ServiceUser();
        if ((!editcin.getText().matches("[0-9]+")) || editcin.getText().isEmpty()) {
            Alert alertType = new Alert(AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Verifier CIN");
            alertType.show();
            return;
        }
        if ((!editsalaire.getText().matches("[0-9]+")) || editsalaire.getText().isEmpty()) {
            Alert alertType = new Alert(AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Verifier Salaire");
            alertType.show();
            return;
        }
        if ((!editnumtel.getText().matches("[0-9]+")) || editnumtel.getText().isEmpty()) {
            Alert alertType = new Alert(AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Verifier Numtel");
            alertType.show();
            return;
        }

        int cin = Integer.parseInt(editcin.getText());
        String nom = editnom.getText();
        String prenom = editprenom.getText();
        String email = editemail.getText();
        int numtel = Integer.parseInt(editnumtel.getText());
        int salaire = Integer.parseInt(editsalaire.getText());
        if (nom.isEmpty() || prenom.isEmpty() || nom.matches("[0-9]+") || prenom.matches("[0-9]+")) {
            Alert alertType = new Alert(AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Verifier Nom et prenom");
            alertType.show();
            return;
        }
        if (email.isEmpty() || email.matches("[0-9]+")) {
            Alert alertType = new Alert(AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Mail manquant");
            alertType.show();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment Modifier cet utilisateur ?");
        alert.showAndWait();
        System.out.println(alert.getResult());
        if (alert.getResult() == ButtonType.OK) {
            if ( u instanceof Admin ) {
                User user = new Admin(
                        u.getId(),
                        cin,
                        nom,
                        prenom,
                        email,
                        numtel,
                        salaire,
                        u.getPassword(),
                        u.getResetcode(),
                        u.getImg()
                );
                service.update(user);
                
            } else if ( u instanceof Client ) {
                User user = new Client(
                        u.getId(),
                        cin,
                        nom,
                        prenom,
                        email,
                        numtel,
                        salaire,
                        u.getPassword(),
                        u.getResetcode(),
                        u.getImg()
                );
                service.update(user);
            } else if ( u instanceof Employee ) {
                User user = new Employee(
                        u.getId(),
                        cin,
                        nom,
                        prenom,
                        email,
                        numtel,
                        salaire,
                        u.getPassword(),
                        u.getResetcode(),
                        u.getImg()
                );
                service.update(user);
            }

        }

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
}
