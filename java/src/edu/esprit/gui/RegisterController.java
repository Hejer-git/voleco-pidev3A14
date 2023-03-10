/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.*;
import edu.esprit.services.ServiceUser;
import io.jsonwebtoken.SignatureAlgorithm;
import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.stage.FileChooser;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.FileUtils;
import io.jsonwebtoken.Jwts;  
import io.jsonwebtoken.SignatureAlgorithm;  
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsunsoft.http.HttpRequest;
import java.util.List;
import javafx.scene.control.ProgressBar;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField cin;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField tel;
    @FXML
    private PasswordField password;
    
    private static final int EXPIRATION = 1;
    private JSONObject payload = new JSONObject();
    private String tokk;
    private float p;

    File selectedFile;
    String uploadpath;
    @FXML
    private ProgressBar progressbar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UnaryOperator<Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9]*)?")) { 
                return change;
            }
            return null;
            };
        UnaryOperator<Change> integerFilter2 = change2 -> {
            String newText2 = change2.getControlNewText();
            if (newText2.matches("-?([0-9]*)?")) { 
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
            
            
            nom.setTextFormatter(new TextFormatter<String> (doubleFilter));
            prenom.setTextFormatter(new TextFormatter<String> (doubleFilter));

                cin.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter2));
                cin.setText("");
                tel.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
                tel.setText("");
                addTextLimiter(cin,8);
                addTextLimiter(tel,8);
                progressListener(password);
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
            public void progressListener(final TextField tf) {
                tf.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                    
                    if (tf.getText().length() > 0) {
                        p = passwordstrength(newValue);
                        progressbar.setProgress(p);
                    }
                }
            });
            }
            
                    
                    
    @FXML
    private void uploadimage(ActionEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            uploadpath = selectedFile.getName();
            System.out.println(uploadpath);
        }
    }
    @FXML
    private void btnsignin(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnsignup(ActionEvent event) throws Exception {
        if (nom.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Nom est vide");
            alertType.show();
            return;
        }
        if (prenom.getText().isEmpty()){
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
        if (cin.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Cin est vide");
            alertType.show();
            return;
        }
        if (tel.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Tel est vide");
            alertType.show();
            return;
        }
        if (tel.getText().length()!=8){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Tel doit etre 8 chiffres");
            alertType.show();
            return;
        }
        if (cin.getText().length()!=8){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("CIN doit etre 8 chiffres");
            alertType.show();
            return;
        }
        if(passwordstrength(password.getText())!=1){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Votre mot de passe est faible");
            alertType.show();
            return;
        }
        
        if (email.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Email est vide");
            alertType.show();
            return;
        }
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";  
        Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(email.getText());  
        if (!matcher.matches()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Email non valide");
            alertType.show();
            return;
        }
        ServiceUser service = new ServiceUser();
        User user = service.checkByEmail(email.getText());
        
        if (user != null){
           
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Mail deja existe");
            alertType.show();
            
        }else{
            String hashed = PasswordEncryption.generatehash(password.getText());
            User client = new Client(
            Integer.parseInt(cin.getText()),
            nom.getText(),
            prenom.getText(),
            email.getText(),
            Integer.parseInt(tel.getText()),
            0);
            client.setPassword(hashed);
            if (selectedFile != null) {
                try {
                    File source = new File(selectedFile.toString());
                    File dest = new File("\\\\Mac\\Home\\Documents\\PI\\projpi\\src\\edu\\esprit\\uploads\\");
                    
                    System.out.println(dest);
                    FileUtils.copyFileToDirectory(source, dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
    
            }else{
                Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Image n'existe pas");
            alertType.show();
            return;
            }
            
            client.setImg(uploadpath);

            Alert alertType=new Alert(Alert.AlertType.CONFIRMATION);
            alertType.setTitle("INFO");
            alertType.setHeaderText("Veuillez verifier votre boit mail");
            alertType.show();

            tokenrequest(client.getEmail());
            String token = tokenreceive();
            System.out.println(token);

            token = token.replace("/", "");
            JWebToken incomingToken = new JWebToken(token);
            if (incomingToken.isValid()) {
                String subject = incomingToken.getSubject();                
            }else{
                Alert alertType3=new Alert(Alert.AlertType.ERROR);
                alertType3.setTitle("Error");
                alertType3.setHeaderText("Probleme de verification de compte");
                alertType3.show();
                return;
            }
            service.insert(client);
            Alert alertType2=new Alert(Alert.AlertType.CONFIRMATION);
            alertType2.setTitle("INFO");
            alertType2.setHeaderText("Bienvenue a VOLECO");
            alertType2.show();
            ActiveUser.activeuser = client;
            try {
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
    public String tokenreceive() throws Exception {
        TokenVerification  socket = new TokenVerification();
        socket.tokenrequest();
        return socket.getToken();
    }
    public void tokenrequest(String email){
    int EXPIRY_MIN = 1;

    JSONObject jwtPayload = new JSONObject();
    jwtPayload.put("status", 0);
    jwtPayload.put("sub", email);
    JSONArray audArray = new JSONArray();
    audArray.put("client"); 
    jwtPayload.put("aud", audArray);
    LocalDateTime ldt = LocalDateTime.now().plusMinutes(EXPIRY_MIN);
    jwtPayload.put("exp", ldt.toEpochSecond(ZoneOffset.UTC)); //this needs to be configured

    String token = new JWebToken(jwtPayload).toString();
    Tokenmail tokenmail = new Tokenmail();
    String url = "http://localhost:8081/"+token;
    System.out.println(url);
    tokenmail.sendtoken(url,email);
    }
    public float passwordstrength(String password){
    int passwordLength=8, upChars=0, lowChars=0;
      int special=0, digits=0;
      char ch;    
      float progress=0;
      int total = password.length();
      if(total>passwordLength)
      {
        progress+=0.2;
      }
         for(int i=0; i<total; i++)
         {
            ch = password.charAt(i);
            if(Character.isUpperCase(ch))
               {upChars = 1;}
            else if(Character.isLowerCase(ch))
               {lowChars = 1;}
            else if(Character.isDigit(ch))
               {digits = 1;}
            else
               {special = 1;}
         }
       if(upChars==1)
           progress+=0.2;
       if (lowChars==1) 
           progress+=0.2;
       if (digits==1) 
           progress+=0.2;
       if (special==1)
           progress+=0.2;
      /*if(upChars==1 && lowChars==1 && digits==1 && special==1)
         System.out.println("\nThe Password is Strong.");
      else
         System.out.println("\nThe Password is Weak.");*/

         return progress;
    }
    
}
