/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.gui;

import static com.google.common.collect.Iterables.size;
import static com.google.common.collect.Iterators.size;
import edu.offre.entities.Promo;
import edu.offre.services.ServiceOffre;
import edu.offre.services.ServicePromo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.*;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.awt.Color;
import java.awt.Graphics2D;
import static java.awt.SystemColor.text;
import static java.nio.file.Files.size;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author 21629
 */
public class AfficherPromoController implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private Label label;
    private List<Promo> promos = new ArrayList<>();
Promo p ;
    @FXML
    private ImageView imgqrcode;
    /**
     * Initializes the controller class.
     */
    
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int row = 0;

        ServicePromo service = new ServicePromo();
        promos = service.getAll();

        


        for (int i = 0; i < promos.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("PromoItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                PromoItemController promoitemController = fxmlLoader.getController();
                

                promoitemController.setData(promos.get(i));
                
                grid.add(anchorPane,0 ,row++);
            } catch (IOException ex) {
                Logger.getLogger(AfficherOffreController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
            
        }
        
       
    }
    
        

}
   

    



