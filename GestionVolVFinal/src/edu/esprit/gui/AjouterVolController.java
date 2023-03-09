/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import com.jfoenix.controls.JFXTimePicker;
import edu.esprit.entities.Avion;
import edu.esprit.entities.Vol;
import edu.esprit.services.ServiceAvion;
import edu.esprit.services.ServiceVol;
import edu.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author ghassen
 */
public class AjouterVolController implements Initializable {

    @FXML
    private TextField tfNumVol;
    @FXML
    private TextField tfDureeVol;
    @FXML
    private DatePicker tfDateDep;
    @FXML
    private Button ValiderVol;
    @FXML
    private DatePicker tfdateArr;
    @FXML
    private ComboBox<String> comborole;
    
    @FXML
    private JFXTimePicker tfHeureArr1;
    @FXML
    private JFXTimePicker tfHeureDep1;
    
   
    @FXML
    private TextField tfMapDep;
    @FXML
    private Button btnlocDep;
    @FXML
    private Button btnlocArr;
    @FXML
    private TextField tfMapArr;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfAeoDep;
    @FXML
    private TextField tfAeoArr;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        ServiceAvion savion = new ServiceAvion();
        List<Avion> listavion = new ArrayList<>();
       listavion = savion.getAll();
      
       for (int i = 0; i < listavion.size(); i++){
           comborole.getItems().add(listavion.get(i).getNomAvion());
       }
        
  
        
    }    

    @FXML
    private void btnAjouterVol(ActionEvent event)throws IOException {

        
         LocalTime t1 = tfHeureArr1.getValue();
         Time timeArr = java.sql.Time.valueOf(t1);
         
          LocalTime t2 = tfHeureDep1.getValue();
         Time timedep= java.sql.Time.valueOf(t2);
         
        
        int NumVol =Integer.parseInt(tfNumVol.getText());
        
        int DureeVol =Integer.parseInt(tfDureeVol.getText()); 
        
        String combo=comborole.getValue(); 
        
        LocalDate d1 = tfDateDep.getValue();
        Date dateRec1 = java.sql.Date.valueOf(d1);   
        
        LocalDate d2 = tfdateArr.getValue();
        Date dateRec2 = java.sql.Date.valueOf(d2);
        
        int Result =dateRec1.compareTo(dateRec2);
        
        
        int result = timedep.compareTo(timeArr);
        
        String  mapdep = tfMapDep.getText(); 
        String maparr = tfMapArr.getText(); 
        
       int Prix =Integer.parseInt(tfPrix.getText());
       
       
       String  aeodep = tfAeoDep.getText(); 
        String aeoarr = tfAeoArr.getText(); 
        
        ServiceVol se=new ServiceVol();
        ServiceAvion savion = new ServiceAvion();
        Avion avion = new Avion();
        avion = savion.getOneByName(combo);

        
        Vol v=new Vol(NumVol,timedep,timeArr,dateRec1,dateRec2,DureeVol,avion.getIdAvion(),mapdep,maparr,Prix,aeodep,aeoarr);
        
        
           if( (tfNumVol.getText().isEmpty())|| (tfDureeVol.getText().isEmpty())){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("Enter a valid title and content !");
                    alertType.show();}
           else if((Result > 0))
                            {
                            Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("dDateDep is after DateArr !");
                    alertType.show();}
           else if((String.valueOf(Integer.parseInt(tfNumVol.getText())).length()!=8))
                            {
                            Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("Entrez un numero de vol de 8 chiffres !");
                    alertType.show();}
            else if((result > 0))
                            {
                            Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("TimeDep is after TimeArr !");
                    alertType.show();}
                            
                            
        
        else
             
         {
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment ajouter ce Vol ?");
        alert.setContentText("NumVol: " + NumVol + "\nHeureDep : " + timedep + "\nHeureArr : " + timeArr +"\nDateDep : " + dateRec1 + "\nDateArr : " + dateRec2 + "\nDuree : " + DureeVol );
        alert.showAndWait();
            
            se.ajouterVol(v); 
         }
        
        
        
        
           

        
        
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherVol.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    @FXML
    private void btnretour(ActionEvent event)throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherVol.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }

   
    @FXML
    private void btnlocaliserDep(ActionEvent event) throws Exception {
        //try {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("map.fxml"));
            Parent root = loader.load();
            MapController cr = loader.getController();*/
        WebViewCaptureMap w = new WebViewCaptureMap();
        Stage stage = new Stage();
        w.start(stage);
        /*stage.setScene(new Scene(root));
            MainGUICategorie m = new MainGUICategorie();
            m.Map(stage);
            stage.show();*/

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing");
                TestMapController mp = new TestMapController();
                tfMapDep.setText(TestMapController.getMap_value());
                if (!"".equals(tfMapDep.getText())) {
                    btnlocDep.setDisable(true);
                    //System.out.println("done");
                }
            }
        });

        /*} catch (IOException ex) {
            Logger.getLogger(Version_3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @FXML
    private void btnlocaliserArr(ActionEvent event) throws Exception {
        //try {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("map.fxml"));
            Parent root = loader.load();
            MapController cr = loader.getController();*/
        WebViewCaptureMap w = new WebViewCaptureMap();
        Stage stage = new Stage();
        w.start(stage);
        /*stage.setScene(new Scene(root));
            MainGUICategorie m = new MainGUICategorie();
            m.Map(stage);
            stage.show();*/

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing");
                TestMapController mp = new TestMapController();
                tfMapArr.setText(TestMapController.getMap_value());
                if (!"".equals(tfMapArr.getText())) {
                    btnlocArr.setDisable(true);
                    //System.out.println("done");
                }
            }
        });

        /*} catch (IOException ex) {
            Logger.getLogger(Version_3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
