/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import edu.reclamation.entities.Reclamation;
import edu.reclamation.services.ServiceReclamation;
import edu.reclamation.utils.DataSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author imen
 */
public class Pdf {
     private Statement ste;
     private Connection con;
    
    public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
        //Image img = Image.getInstance("photo.png");
        Image img2 = Image.getInstance("build\\classes\\edu\\reclamation\\images\\voleco.png");
        img2.scaleAbsolute(100, 100);
        document.add(img2);
        ServiceReclamation us=new ServiceReclamation();
        con = DataSource.getInstance().getCnx();
                ste = con.createStatement();
       List<Reclamation> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT idRec, nomC,description,dateRec, type   from `reclamation`;");
     while (rs.next()) {                
          /*     int idCommande=rs.getInt(1);
               int idUser=rs.getInt(2);
               float total=rs.getFloat(3);
               String etat=rs.getString(4);*/
          int idRec = rs.getInt(1);
          String nomC = rs.getString(2);
          String description = rs.getString(3);
          java.util.Date dateRec = rs.getDate(4);
          int type = rs.getInt(5);
          
          Reclamation e=new Reclamation(idRec, nomC,description,dateRec,type);   
               
        arr.add(e);}
    // document.add(new Paragraph("-------------------------Rapport Reclamation------------------------------------------------------------- "));
        
        for(Reclamation h:arr)
        {
       // document.add(new Paragraph("numero salle :"+h.getIdRec()));
        document.add(new Paragraph("Nom Client :"+ h.getNomC()));
        document.add(new Paragraph("Description :"+h.getDescription()));
        document.add(new Paragraph("Date  :"+h.getDateRec()));
        document.add(new Paragraph("Type Reclamation :"+h.getType()));
           //document.add(img);
         //document.add(img2);
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        document.add(new Paragraph("                                                                        "));
        
        } 
        
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    }
    
}
