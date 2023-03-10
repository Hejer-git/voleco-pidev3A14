/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the addor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Admin;
import edu.esprit.entities.Client;
import edu.esprit.entities.Employee;
import edu.esprit.entities.PasswordEncryption;
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
import static java.lang.Character.getNumericValue;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AjouterUserController implements Initializable {

    @FXML
    private TextField addnom;
    @FXML
    private TextField addprenom;
    @FXML
    private TextField addcin;
    @FXML
    private TextField addnumtel;
    @FXML
    private TextField addemail;
    @FXML
    private TextField addsalaire;

    private User user;
    static User u;
    @FXML
    private PasswordField password;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UnaryOperator<Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d+")) { 
                return change;
            }
            return null;
            };
        UnaryOperator<Change> integerFilter2 = change2 -> {
            String newText2 = change2.getControlNewText();
            if (newText2.matches("\\d+")) { 
                return change2;
            }
            return null;
            };
            UnaryOperator<TextFormatter.Change> doubleFilter = change -> {
                String input = change.getText();
            
                if ((input.matches("[\\sa-zA-Z]")) || change.isDeleted()) {
                    return change;
                }
                return null;
            };
            
            
            addnom.setTextFormatter(new TextFormatter<String> (doubleFilter));
            addprenom.setTextFormatter(new TextFormatter<String> (doubleFilter));

                addcin.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter2));
                addcin.setText("");
                addnumtel.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
                addnumtel.setText("");
                addsalaire.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
                addsalaire.setText("");
                addTextLimiter(addcin,8);
                addTextLimiter(addnumtel,8);
    }

    public void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
            
            if (tf.getText().length() > maxLength) {
                String s = tf.getText().substring(0, maxLength);
                tf.setText(s);
            }
        }
    });
    }
    @FXML
    private void btnadd(ActionEvent event) throws IOException {
        if (addnom.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Nom est vide");
            alertType.show();
            return;
        }
        if (addprenom.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("prenom est vide");
            alertType.show();
            return;
        }
        if (password.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Mot de passe est vide");
            alertType.show();
            return;
        }
        if (addcin.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Cin est vide");
            alertType.show();
            return;
        }
        if (addnumtel.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Tel est vide");
            alertType.show();
            return;
        }
        if (addnumtel.getText().length()!=8){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Tel doit etre 8 chiffres");
            alertType.show();
            return;
        }
        if (addcin.getText().length()!=8){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("CIN doit etre 8 chiffres");
            alertType.show();
            return;
        }

        
        if (addemail.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Email est vide");
            alertType.show();
            return;
        }
        if (addsalaire.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Email est vide");
            alertType.show();
            return;
        }
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";  
        Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(addemail.getText());  
        if (!matcher.matches()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Email non valide");
            alertType.show();
            return;
        }        
        ServiceUser service = new ServiceUser();
        User checkuser = service.checkByEmail(addemail.getText());
        
        if (checkuser != null){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Mail deja existe");
            alertType.show();
            return;
        }
        

        int cin = Integer.parseInt(addcin.getText());
        String nom = addnom.getText();
        String prenom = addprenom.getText();
        String email = addemail.getText();
        int numtel = Integer.parseInt(addnumtel.getText());
        int salaire = Integer.parseInt(addsalaire.getText());
        

        user = new Employee(cin,nom,prenom,email,numtel,salaire);
        String hashed = PasswordEncryption.generatehash(password.getText());

        user.setPassword(hashed);
        user.setImg("employee.png");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment ajouter cet utilisateur ?");
        alert.showAndWait();

        service.insert(user);

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }
    
    
}
