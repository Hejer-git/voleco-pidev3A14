/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author 21629
 */
public class ReatingController implements Initializable {

    @FXML
    private Label notreat;
    @FXML
    private RadioButton gr1;
    @FXML
    private ToggleGroup grating;
    @FXML
    private RadioButton gr3;
    @FXML
    private RadioButton gr2;
    @FXML
    private RadioButton gr4;
    @FXML
    private RadioButton gr5;
    @FXML
    private TextArea idc;
    @FXML
    private ListView<?> listcom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickbtn(ActionEvent event) {
    }
    
}
