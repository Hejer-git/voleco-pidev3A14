/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Avion;
import edu.esprit.entities.Vol;
import static edu.esprit.gui.ModifierAvController.a;
import edu.esprit.services.ServiceAvion;
import edu.esprit.services.ServiceVol;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ghassen
 */
public class ModifierVolController implements Initializable {

    @FXML
    private TextField editNomAvion1;
    @FXML
    private TextField editDureeVol;
    @FXML
    private TextField editHeureDep;
    @FXML
    private TextField editHeureArr;
    @FXML
    private DatePicker editDateDep;
    @FXML
    private DatePicker editDateArr;
    @FXML
    private TextField editNunVol;

    static Vol v;
    @FXML
    private ComboBox<String> editcombo;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
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
        editcombo.setValue(avion.getNomAvion());
         //editNomAvion1.setText(v.getNomAvion());
        editHeureDep.setText(v.getHeureDep());
        editDureeVol.setText(String.valueOf(v.getDureeVol()));
         editNunVol.setText(String.valueOf(v.getNumVol()));
        
       editHeureArr.setText(v.getHeureArr());
       
       java.sql.Date d1= new java.sql.Date(v.getDateDep().getTime());

       //java.sql.Date d1= java.sql.Date.valueOf(a.getDateEntServ());
        editDateDep.setValue(d1.toLocalDate());
        
        java.sql.Date d2= new java.sql.Date(v.getDateArr().getTime());

       //java.sql.Date d1= java.sql.Date.valueOf(a.getDateEntServ());
        editDateArr.setValue(d2.toLocalDate());
        
        
    }    

    @FXML
    private void btnedit(ActionEvent event) throws IOException {
         String heureDep =editHeureDep.getText();
      int dureeVol =Integer.parseInt(editDureeVol.getText());
      int numVol =Integer.parseInt(editNunVol.getText());
        String heureArr =editHeureArr.getText();
        
        LocalDate d1 =  editDateDep.getValue();
        Date dateRec1 = java.sql.Date.valueOf(d1);
        LocalDate d2 =  editDateArr.getValue();
        Date dateRec2 = java.sql.Date.valueOf(d2);
        ServiceVol se=new ServiceVol();
        ServiceAvion savion = new ServiceAvion();
        Avion avion = new Avion();
        avion = savion.getOneByName(editcombo.getValue());
        
        
        Vol vol=new Vol(v.getIdVol(),numVol,heureDep,heureArr,dateRec1,dateRec2,dureeVol,avion.getIdAvion());
        
        
          if((editHeureDep.getText().isEmpty()) || (editDureeVol.getText().isEmpty()) || (editNunVol.getText().isEmpty())|| (editHeureArr.getText().isEmpty())){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                    alertType.setHeaderText("Enter a valid title and content !");
                    alertType.show();}
         else if (editHeureDep.getText().matches("[0-9]+"))  {
		Alert alertType=new Alert(Alert.AlertType.ERROR);
		alertType.setTitle("Error");
                    alertType.setHeaderText("title must be string not number !");
                    alertType.show();
	 }
         else if (editHeureArr.getText().matches("[0-9]+"))  {
		Alert alertType=new Alert(Alert.AlertType.ERROR);
		alertType.setTitle("Error");
                    alertType.setHeaderText("title must be string  not number !");
                    alertType.show();
	 }
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
    
}
