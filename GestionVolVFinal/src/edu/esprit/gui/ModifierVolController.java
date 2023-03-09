/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import com.jfoenix.controls.JFXTimePicker;
import edu.esprit.entities.Avion;
import edu.esprit.entities.Vol;
import static edu.esprit.gui.ModifierAvController.a;
import edu.esprit.services.ServiceAvion;
import edu.esprit.services.ServiceVol;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author ghassen
 */
public class ModifierVolController implements Initializable {

    @FXML
    private TextField editDureeVol;
   
    @FXML
    private DatePicker editDateDep;
    @FXML
    private DatePicker editDateArr;
    @FXML
    private TextField editNunVol;

    static Vol v;
    @FXML
    private ComboBox<String> editcombo;
    @FXML
    private JFXTimePicker editHeureDep1;
    
    public Time T;
    @FXML
    private JFXTimePicker editHeureArr1;
    @FXML
    private Button btnMapArr;
    @FXML
    private TextField tfModifMapDep;
    @FXML
    private TextField tfModifMapArr;
    @FXML
    private Button btnMapDep;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @throws java.io.IOException
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceAvion savion = new ServiceAvion();
        List<Avion> listavion = new ArrayList<>();
        listavion = savion.getAll();
      
       for (int i = 0; i < listavion.size(); i++){
           editcombo.getItems().add(listavion.get(i).getNomAvion());
       }
        Avion avion = savion.getOneById(v.getidAvion());
        ServiceVol sv = new ServiceVol();
        Vol vol= sv.getOneById(v.getIdVol());
        editcombo.setValue(avion.getNomAvion());
        
        editDureeVol.setText(String.valueOf(v.getDureeVol()));
         editNunVol.setText(String.valueOf(v.getNumVol()));
        
       
       
        
       
       java.sql.Date d1= new java.sql.Date(v.getDateDep().getTime());

       
        editDateDep.setValue(d1.toLocalDate());
        
        java.sql.Date d2= new java.sql.Date(v.getDateArr().getTime());

     
        editDateArr.setValue(d2.toLocalDate());
        
         
       java.sql.Time t1= new java.sql.Time(v.getTimeDep().getTime());
         
        editHeureDep1.setValue(t1.toLocalTime());
        
        java.sql.Time t2= new java.sql.Time(v.getTimeArr().getTime());
         
        editHeureArr1.setValue(t2.toLocalTime());
       
       
    tfModifMapDep.setText(v.getAdrDep());
         tfModifMapArr.setText(v.getAdrArr());

        
        
    }    

    @FXML
    private void btnedit(ActionEvent event) throws IOException {
        
      int dureeVol =Integer.parseInt(editDureeVol.getText());
      int numVol =Integer.parseInt(editNunVol.getText());
        
        
         LocalTime t1 = editHeureDep1.getValue();
         Time timedep1= java.sql.Time.valueOf(t1);
         
         LocalTime t2 = editHeureArr1.getValue();
         Time timeArr1= java.sql.Time.valueOf(t2);
        
        LocalDate d1 =  editDateDep.getValue();
        Date dateRec1 = java.sql.Date.valueOf(d1);
        
        LocalDate d2 =  editDateArr.getValue();
        Date dateRec2 = java.sql.Date.valueOf(d2);
        ServiceVol se=new ServiceVol();
        ServiceAvion savion = new ServiceAvion();
        Avion avion = new Avion();
        avion = savion.getOneByName(editcombo.getValue());
        
        String MapDep = tfModifMapDep.getText();
        
         String MapArr = tfModifMapArr.getText();
        
         int Result =dateRec1.compareTo(dateRec2);
         int result = timedep1.compareTo(timeArr1);
        
        Vol vol=new Vol(v.getIdVol(),numVol,timedep1,timeArr1,dateRec1,dateRec2,dureeVol,avion.getIdAvion(),MapDep,MapArr);
        
        
          if((editDureeVol.getText().isEmpty()) || (editNunVol.getText().isEmpty())){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("Enter a valid title and content !");
                    alertType.show();}
           else if((Result > 0))
                            {
                            Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("DateDep is after DateArr !");
                    alertType.show();}
           else if((result > 0))
                            {
                            Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("TimeDep is after TimeArr !");
                    alertType.show();}
           
           else if((String.valueOf(Integer.parseInt(editNunVol.getText())).length()!=8))
                            {
                            Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("Entrez un numero de vol de 8 chiffres !");
                    alertType.show();}
                            
        
        else
             
         {
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment modifier ce Vol ?");
        
        alert.showAndWait();
            
             se.modifierVol(vol);
         }
       


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherVol.fxml"));
            Scene tabbleViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabbleViewScene);
            window.show();
    }

    @FXML
    private void btnLocDep(ActionEvent event) throws Exception {
        
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
                tfModifMapDep.setText(TestMapController.getMap_value());
                if (!"".equals(tfModifMapDep.getText())) {
                    btnMapDep.setDisable(true);
                    //System.out.println("done");
                }
            }
        });

        /*} catch (IOException ex) {
            Logger.getLogger(Version_3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @FXML
    private void btnLocArr(ActionEvent event) throws Exception {
        
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
                tfModifMapArr.setText(TestMapController.getMap_value());
                if (!"".equals(tfModifMapArr.getText())) {
                    btnMapArr.setDisable(true);
                    //System.out.println("done");
                }
            }
        });

        /*} catch (IOException ex) {
            Logger.getLogger(Version_3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
