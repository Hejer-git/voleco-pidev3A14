/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.offre.services;

import java.util.List;

/**
 *
 * @author 21629
 * @param <T>
 */
public interface IOffre <T>{
    public void ajouteroffre(T o) throws Exception;
    public void supprimerOffre(T o);
    public void modifieroffre(T o);
    public List<T> getAll();
    public T getOneById2(int idOffre);
     public T getOneById();
}
