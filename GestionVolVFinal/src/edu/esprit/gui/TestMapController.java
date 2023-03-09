/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class TestMapController implements Initializable {

    public static double lon;
        public static double lat;
        
        static String map_value;

    @FXML
    private WebView webview;
    private WebEngine webengine;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        webengine = webview.getEngine();

        url = this.getClass().getResource("map.html");
        webengine.load(url.toString());

       
      
}
     public void showAlert(String message) {
        Dialog<Void> alert = new Dialog<>();
        alert.getDialogPane().setContentText(message);
        System.out.println(message);
        AjouterVolController ajc = new  AjouterVolController();
        map_value=message;
        alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
        alert.showAndWait();
    }
      public static String getMap_value() {
        return map_value;
    }

    @FXML
    private void tt(ActionEvent event) {
      
           
             lat = (Double) webview.getEngine().executeScript("lat");
             lon = (Double) webview.getEngine().executeScript("lon");


        System.out.println("Lat: " + lat);
                System.out.println("LOn " + lon);


    }

// JavaScript interface object
private class JavaApp {
  public void exit() {
    Platform.exit();
  }

    }
}
