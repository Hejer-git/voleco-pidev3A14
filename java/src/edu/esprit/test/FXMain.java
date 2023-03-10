/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.test;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import edu.esprit.entities.*;

/**
 *
 * @author ahmed
 */
public class FXMain extends Application {
    
   
   private Stage stage;
    private Parent parent;
    @Override
    public void start(Stage primaryStage) throws IOException, Exception {
        this.stage=primaryStage;
        parent=FXMLLoader.load(getClass().getResource("../gui/Login.fxml"));
        Scene scene=new Scene(parent);
        stage.setScene(scene);
        stage.show();       
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
