/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.gui;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author 21629
 */

public class SmsController implements Initializable {
    
    public static final String ACCOUNT_SID = "AC65d880a070aa683ccee3187274cec743";
    public static final String AUTH_TOKEN = "152b78d69fb96183ca49cf51e2ff0f6d";
    public static final String TWILIO_NUMBER = "+15076290187";

    

    @FXML
    private TextField textfield;
    
    @FXML
    private Label statusLabel;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendSMS(ActionEvent event) {
        String toPhoneNumber = textfield.getText();
    if (toPhoneNumber == null || toPhoneNumber.trim().isEmpty()) {
       statusLabel.setText("Please enter a phone number:");
        return;
    
    }
        
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String messageText = "Des nouveaux Promos Sont Ajoutées le " + formatter.format(currentDate);
    System.out.println("aman");
    Message message = Message.creator(new PhoneNumber(toPhoneNumber),
            new PhoneNumber(TWILIO_NUMBER),
            messageText).create();

    if (message.getSid() != null) {
        statusLabel.setText("SMS sent successfully to " + toPhoneNumber + "!");
    } else {
        statusLabel.setText("Error sending SMS to " + toPhoneNumber + ".");
    }
    
}
}
