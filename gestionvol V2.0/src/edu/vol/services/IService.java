/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vol.services;

import java.io.IOException;
import java.util.List;
/**
 *
 * @author imen
 * @param <T>
 */
public interface IService <T> {
    public void ajouterAv(T a);
    public void supprimerAv(T a);
    public void modifierAv(T a);
    public List<T> getAll();
    public T getOneById(int idRec);
}


