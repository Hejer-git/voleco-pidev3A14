/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.tests;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
 
/**
 *
 * @author 21629
 */

public class FXMain extends Application {
    
   @Override
    public void start(Stage primaryStage) throws IOException {
        try {
        
                Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterPromo.fxml"));
                
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Gestion des offre");
                primaryStage.show();
        }
        catch (IOException ex)
        {System.out.println(ex.getMessage());
        }
     
    }
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
