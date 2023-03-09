 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.gui;

import static api.BadWords.checkWords;
import api.MailerAPI;
//import static api.MailerAPI.senMail;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import edu.reclamation.services.ServiceReclamation;
import edu.reclamation.entities.Reclamation;
import edu.reclamation.entities.TypeReclamation;
import edu.reclamation.services.ServiceTypeReclamation;
import java.io.File;
import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import static jdk.nashorn.internal.objects.NativeJava.type;
import org.apache.commons.io.FileUtils;


/**
 * FXML Controller class
 *
 * @author imen
 */
public class AjouterRecController implements Initializable {

    @FXML
    private Button bAnnuler;
    @FXML
    private Button bValider;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdesc;
    private DatePicker dates;
    @FXML
    private ComboBox<String> typecombo;

    File selectedFile;
    String uploadpath;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
       ServiceTypeReclamation stype = new ServiceTypeReclamation();
        List<TypeReclamation> listtype = new ArrayList<>();
       listtype = stype.getAll();
      
       for (int i = 0; i < listtype.size(); i++){
           typecombo.getItems().add(listtype.get(i).getTypeRec());
       }
    }    
  private boolean nom_valide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(tfnom.getText());
        if(m.find() && m.group().equals(tfnom.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
              //  alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Entrez un nom valide  !");
                alert.showAndWait();
           
            return false;            
        }
        
     }
   private boolean desc_valide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(tfdesc.getText());
        if(m.find() && m.group().equals(tfdesc.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Entrez une description valide !");
                alert.showAndWait();
           
            return false;            
        }
     }
    @FXML
    private void annuler(ActionEvent event) throws IOException{
     
    }
    @FXML
    private void affrec(ActionEvent event) throws IOException{
      Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    @FXML
    private void ajoutrec(ActionEvent event) throws IOException {
       
        String nomC=tfnom.getText();
        String description=tfdesc.getText();
       if(description.isEmpty() || nomC.isEmpty()){
    Alert alert =new Alert(Alert.AlertType.ERROR);
    alert.setContentText("Remplissez tt les champs");   
    alert.showAndWait();
    return;
    
}
       else if (nom_valide()&&desc_valide()){ 
          
       LocalDate d1 = LocalDate.now();
        Date dateRec = java.sql.Date.valueOf(d1);
        String combo=typecombo.getValue(); 
        ServiceReclamation se=new ServiceReclamation();
        ServiceTypeReclamation s = new ServiceTypeReclamation() ;
        TypeReclamation t=new TypeReclamation();
        t=s.getOneByName(combo);
        
        if (selectedFile != null) {
                try {
                    File source = new File(selectedFile.toString());
                    File dest = new File("C:\\Users\\imen\\Documents\\NetBeansProjects\\lastamal\\src\\edu\\reclamation\\imen");
                    
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
        
        Reclamation e=new Reclamation(nomC,description,dateRec,t.getIdTR(),uploadpath);
         if(checkWords(description).equals("false")){
        
        se.ajouterRec(e);
        
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText("Reclamation ajoutée");
    alert.showAndWait();
   /*   String username = "";
    String password = ""; 
    MailerAPI sender = new MailerAPI(username, password);

    String to = "";
    String subject = "Nouvelle Reclamation";
    String text = "Le Client , "+tfnom.getText()+" a ajouter une nouvelle reclamation avec un type ' "+typecombo.getValue()+"'";
    
    try {
        sender.sendEmail(to, subject, text);
    } catch (MessagingException b) {
        b.printStackTrace();
    }*/ }  
         else{
               
                  Alert alert = new Alert(Alert.AlertType.WARNING);
                  alert.setTitle("Worning !! ");
                  alert.setContentText("vous ne pouvez pas ajouter une reclamation avec ce mot ! ");
                  alert.show();
                  
                  
              }
    
    }
       Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterRec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    @FXML
    private void uploadimage(ActionEvent event) {
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
    private void btngerer(ActionEvent event) {
    }
    }

