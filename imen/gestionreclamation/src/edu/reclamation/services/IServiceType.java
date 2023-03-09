/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.services;

import edu.reclamation.entities.TypeReclamation;
import java.util.List;
/**
 *
 * @author imen
 */
public interface IServiceType <T> {
    public void ajouterTypeRec(T t);
    public void supprimerTypeRec(T t);
    public void modifierTypeRec(T t);
    public List<T> getAll();
    public T getOneById(int idTR);
    //public int getIdt(String c);
     public T getOneByName(String nom);
     public T readBytype(String ty);
  
}


