/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import java.util.List;

/**
 *
 * @author ghassen
 * @param <T>
 */
public interface IServiceVol <T> {
     public void ajouterVol(T a);
    public void supprimerVol(T a);
    public void modifierVol(T a);
    public List<T> getAll();
    public T getOneById(int idRec);
    
}
