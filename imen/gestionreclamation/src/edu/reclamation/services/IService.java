/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.services;

import java.util.List;
/**
 *
 * @author imen
 */
public interface IService <T> {
    public void ajouterRec(T r);
    public void supprimerRec(T r);
    public void modifierRec(T r);
    public List<T> getAll();
    public T getOneById(int idRec);
}


