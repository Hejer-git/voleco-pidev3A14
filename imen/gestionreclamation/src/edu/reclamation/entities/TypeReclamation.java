/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.entities;
import java.util.Objects;
/**
 *
 * @author imen
 */
public class TypeReclamation {
    private int idTR;
    private String typeRec;
    
public TypeReclamation(){}

    public TypeReclamation(String typeRec) {
        this.typeRec = typeRec;
        
    }

    public TypeReclamation(int idTR, String typeRec) {
        this.idTR = idTR;
        this.typeRec = typeRec;
       
    }

 
    public int getIdTR() {
        return idTR;
    }

    public void setIdTR(int idTR) {
        this.idTR = idTR;
    }

    public String getTypeRec() {
        return typeRec;
    }

    public void setTypeRec(String typeRec) {
        this.typeRec = typeRec;
    }

   
    @Override
    public String toString() {
        return "Reclamation{" + "typeRec=" + '}';
    }

    
   


   


}
