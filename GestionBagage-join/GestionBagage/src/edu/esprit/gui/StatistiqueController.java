/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Bagage;
import edu.esprit.services.ServiceBagage;
import edu.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class StatistiqueController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label labelstat;
    @FXML
    private PieChart piechart;
    
    private Statement st;
    private ResultSet rs;
    private Connection cnx;
    ObservableList<PieChart.Data>data=FXCollections.observableArrayList();
    int n;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         cnx = DataSource.getInstance().getCnx();
         stat();
     
    }  
    
     private void stat() {
          try{
           //String query ="select COUNT(*),`idStatBag` from bagage GROUP BY `idStatBag`;";
           String query ="SELECT statutbagage.statutB, COUNT(*) FROM bagage INNER JOIN statutbagage ON bagage.idStatBag = statutbagage.idStatBag GROUP BY statutbagage.statutB;";

           PreparedStatement PreparedStatement = cnx.prepareStatement(query);
             rs = PreparedStatement.executeQuery();
             while (rs.next()){               
               data.add(new PieChart.Data(rs.getString("statutB"),rs.getInt("COUNT(*)")));
            }  
             
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }        
     //   piechart.setTitle("Analyse des statistiques des bagages perdus");
        piechart.setLegendSide(Side.TOP);
        piechart.setData(data);
    }

    @FXML
    private void btnretour(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GestionBagage.fxml"));
        Scene tabbleViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tabbleViewScene);
        window.show();
    }

    @FXML
    private void btnnotif(MouseEvent event) {
          //notification bagage retrouvé
        ServiceBagage s1 = new ServiceBagage();
         int nbRetrouves = s1.countRetrouves();
        String message = " " + nbRetrouves + " bagages ont été retrouvés.";
         Notifications notificationBuilder = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder.show();
           
        //notification bagage perdu
         int nbPerdus = s1.countPerdus();
        String message1 = " " + nbPerdus + " bagages ont été perdus.";
        Notifications notificationBuilder1 = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message1)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder1.show();
           //notification bagage volé
         int nbVoles = s1.countVoles();
        String message2 = " " + nbVoles + " bagages ont été volés.";
        Notifications notificationBuilder2 = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message2)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder2.show();   
             //notification bagage suspect
         int nbSusps = s1.countSuspect();
        String message3 = " " + nbSusps + " bagages ont été suspectés.";
        Notifications notificationBuilder3 = Notifications.create()
            .title("Nouveau rapport de bagages")
            .text(message3)
            .hideAfter(Duration.seconds(10))
            .position(Pos.TOP_RIGHT);
           notificationBuilder3.show();   
    }
    
}
