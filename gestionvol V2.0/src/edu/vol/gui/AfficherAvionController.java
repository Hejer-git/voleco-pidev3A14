/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vol.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import edu.vol.entities.Avion;
import edu.vol.services.ServiceVol;
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
public class AfficherAvionController implements Initializable {

    @FXML
    private TableView<Avion> tableviewrec;
   
   //  private  ObservableList<Reclamation> data = FXCollections.observableArrayList();
    private Avion Av;
 @FXML
    private TableColumn<Avion, Integer> colidAvion;
    @FXML
    private TableColumn<Avion,Integer> coldnbPlace;
    @FXML
    private TableColumn<Avion, String> colNomAvion;
    @FXML
    private TableColumn<Avion, String> colModele;
    @FXML
    private TableColumn<Avion, String> colClasse;
    @FXML
    private TableColumn<Avion, String> coldateEntServ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
    }
   
    public void afficher(){
        ServiceVol sp = new ServiceVol();
       // ObservableList<Reclamation> list=sp.getAll();
       List<Avion> a = sp.getAll();
       colidAvion.setCellValueFactory(new PropertyValueFactory<>("idAvion"));
        coldnbPlace.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
        colNomAvion.setCellValueFactory(new PropertyValueFactory<>("nomAvion"));
        colModele.setCellValueFactory(new PropertyValueFactory<>("modele"));
       colClasse.setCellValueFactory(new PropertyValueFactory<>("classe"));
        coldateEntServ.setCellValueFactory(new PropertyValueFactory<>("dateEntServ"));
        tableviewrec.setItems(FXCollections.observableList(a)); 
       
    }    

   

  /*  @FXML
    private void modifierrec(ActionEvent event) throws IOException {
         Reclamation ta =new Reclamation();
        ta= tableviewrec.getSelectionModel().getSelectedItem();
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("modifrec.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
        
    }*/
    @FXML
    private void btnSuppAvion(ActionEvent event) {
         ServiceVol st = new ServiceVol();
        Avion a =new Avion();

        a=tableviewrec.getSelectionModel().getSelectedItem();

        st.supprimerAv(a);
       
    }

    @FXML
    private void btnRetour(ActionEvent event)throws IOException {
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouteAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    @FXML
    private void btnModifAvion(ActionEvent event) throws IOException {
         Avion a =new Avion();
        a= tableviewrec.getSelectionModel().getSelectedItem();
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ModiferAv.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

   
    
}
