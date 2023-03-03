/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Bagage;
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
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

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
           // String query ="select COUNT(*),reservation_voyage.travel_class from voyage INNER JOIN reservation_voyage on reservation_voyage.voyage_id =voyage.id GROUP BY travel_class;";
           //String query ="select COUNT(*),`prix`  from voyage GROUP BY `destination`;";
           String query ="select COUNT(*),`idStatBag` from bagage GROUP BY `idStatBag`;";

           PreparedStatement PreparedStatement = cnx.prepareStatement(query);
             rs = PreparedStatement.executeQuery();
             while (rs.next()){               
               data.add(new PieChart.Data(rs.getString("idStatBag"),rs.getInt("COUNT(*)")));
            }  
             
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }        
     //   piechart.setTitle("Analyse des statistiques des bagages perdus");
        piechart.setLegendSide(Side.LEFT);
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
    
}
