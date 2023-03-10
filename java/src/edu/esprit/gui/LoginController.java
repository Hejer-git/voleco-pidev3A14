/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import com.github.sarxos.webcam.Webcam;
import edu.esprit.entities.Resetmail;
import edu.esprit.entities.User;
import edu.esprit.entities.ActiveUser;
import edu.esprit.entities.Admin;
import edu.esprit.entities.Client;
import edu.esprit.entities.PasswordEncryption;
import edu.esprit.services.ServiceUser;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.function.UnaryOperator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.util.converter.IntegerStringConverter;
import javax.imageio.ImageIO;
import java.util.UUID;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class LoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    private String resetmail;


    @FXML
    private TextField mailreset;
    @FXML
    private Pane mailresetpane;
    @FXML
    private Pane codecheckpane;
    @FXML
    private TextField codecheck;
    @FXML
    private Pane editpasswordpane;
    
    @FXML
    private Pane signinpane;
    @FXML
    private PasswordField newpassword;
    
    private int failed = 0;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

            signinpane.toFront();
            UnaryOperator<Change> integerFilter = change -> {
                String newText = change.getControlNewText();
                if (newText.matches("-?([1-9][0-9]*)?")) {
                    return change;
                }
                return null;
            };
            codecheck.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
            codecheck.setText("");
            addTextLimiter(codecheck,6);

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
    private void btnsignin(ActionEvent event) throws IOException {
        
        ServiceUser service = new ServiceUser();
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";  
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regex);  

        if (email.getText().isEmpty()||password.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Un des champs est vide");
            alertType.show();
            return;
        }
        Matcher matcher = pattern.matcher(email.getText());  
        if (!matcher.matches()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Email non valide");
            alertType.show();
            return;
        }

        String mail = email.getText();
        String pass = password.getText();
        User user = service.checkByEmail(mail);
        if (user != null){
            String hashed = user.getPassword();
            boolean check = PasswordEncryption.checkpassword(pass, hashed);
            System.out.println(check);
            if (service.getLock(user) > (LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Votre compte est encore desactive");
            alertType.show(); 
            return;
            }
            if (!check){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("coordonnées incorrectes");
            alertType.show(); 
            failed+=1;
            if (failed==3){
                webcam(user.getNom());
                Alert alertType5=new Alert(Alert.AlertType.ERROR);
                alertType5.setTitle("Error");
                alertType5.setHeaderText("Votre compte a ete desactive pendant 15 min");
                alertType5.show();
                LocalDateTime ldt = LocalDateTime.now().plusMinutes(15);
                service.setLock(user,ldt);
                return;
            }
            return;
            }
        }
        if (user == null){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("coordonnées incorrectes");
            alertType.show();
            return;
        }else{
            try {
                ActiveUser.activeuser = user;
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
                Scene tabbleViewScene = new Scene(tableViewParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tabbleViewScene);
                window.show();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnsignup(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Register.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void resetpassbtn(MouseEvent event) {
        mailresetpane.toFront();
    }

    @FXML
    private void sendcodebtn(ActionEvent event) {
        if (mailreset.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Email est vide");
            alertType.show();
            return;
        }
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";  
        Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(mailreset.getText());  
        if (!matcher.matches()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Email non valide");
            alertType.show();
            return;
        }
        ServiceUser service = new ServiceUser();
        User user = service.checkByEmail(mailreset.getText());
        
        if (user != null){
            if (user instanceof Client) {
                Resetmail res = new Resetmail();
                Random rnd = new Random();
                int number = rnd.nextInt(999999);
                String code =  String.format("%06d", number);
                service.setresetcode(Integer.parseInt(code),mailreset.getText());
                res.resetpass(code,mailreset.getText());
                Alert alertType=new Alert(Alert.AlertType.CONFIRMATION);
                alertType.setTitle("Info");
                alertType.setHeaderText("Email envoye");
                alertType.show();
                codecheckpane.toFront();
            }else{
                Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Non autorise");
            alertType.show();
            }
        }else{
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Email non existant");
            alertType.show();
        }
    }

    @FXML
    private void checkcodebtn(ActionEvent event) {
        if (codecheck.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Code est vide");
            alertType.show();
            return;
        }
        ServiceUser service = new ServiceUser();
        User user = service.checkByEmail(mailreset.getText());
        int codee = user.getResetcode();
        //System.out.println(codee);
        if(Integer.parseInt(codecheck.getText())==codee){
            editpasswordpane.toFront();

        }else{
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Code Incorrect");
            alertType.show();
            return;
        }
    }

    @FXML
    private void editpasswordbtn(ActionEvent event) {
        ServiceUser service = new ServiceUser();
        if (newpassword.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Mot de passe est vide");
            alertType.show();
            return;
        }
        User user = service.checkByEmail(mailreset.getText());
        user.setPassword(newpassword.getText());
        user.setResetcode(0);
        service.update(user);
        Alert alertType=new Alert(Alert.AlertType.CONFIRMATION);
            alertType.setTitle("info");
            alertType.setHeaderText("Mot de passe change");
            alertType.show();
            signinpane.toFront();

    }
    
    private void webcam(String name){
        try {
            Webcam webcam = Webcam.getWebcams().get(0);
            webcam.open();
            String name2 = UUID.randomUUID().toString()+name;
            ImageIO.write(webcam.getImage(), "PNG", new File(name2));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
