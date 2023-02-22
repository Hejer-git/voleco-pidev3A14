/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import edu.reclamation.entities.Reclamation;
import edu.reclamation.services.ServiceReclamation;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class ShowrecController implements Initializable {

    @FXML
    private TableView<Reclamation> tableviewrec;
    @FXML
    private TableColumn<Reclamation, String> colnom;
    @FXML
    private TableColumn<Reclamation, String> coldesc;
    @FXML
    private TableColumn<Reclamation, Date> coldate;
   //  private  ObservableList<Reclamation> data = FXCollections.observableArrayList();
    private Reclamation Re;
 @FXML
    private Button supprec;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
    }
   
    public void afficher(){
        ServiceReclamation sp = new ServiceReclamation();
       // ObservableList<Reclamation> list=sp.getAll();
       List<Reclamation> a = sp.getAll();
        colnom.setCellValueFactory(new PropertyValueFactory<>("nomC"));
        coldesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("dateRec"));
        tableviewrec.setItems(FXCollections.observableList(a)); 
       
    }    

    @FXML
    private void ajouterrec(ActionEvent event) {
    }
 @FXML
    void onTableItemSelect(MouseEvent event) {
        System.out.println(";ws;eoirhjugfo;i");
        Reclamation rec = tableviewrec.getSelectionModel().getSelectedItem();
         this.Re = rec;
        System.out.println("ttt " + rec.toString());
      /* this..setText(rec.getNomC());
       this.TypeRe.setValue(rec.getEtatReclamation());
       this.dateT.setValue(rec.getDateReclamation().toLocalDate());
       this.descRe.setText(rec.getDescription());*/
     
    }
    @FXML
    private void modifierrec(ActionEvent event) throws IOException {
         Reclamation ta =new Reclamation();
        ta= tableviewrec.getSelectionModel().getSelectedItem();
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("modifrec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }
    @FXML
    private void supprec(ActionEvent event) {
         ServiceReclamation st = new ServiceReclamation();
        Reclamation r=new Reclamation();

        r=tableviewrec.getSelectionModel().getSelectedItem();

        st.supprimerRec(r);
       
    }
    
}
