/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import java.util.List;

/**
 *
 * @author 21654
 */
public interface IServiceB <T>{
    
    public void ajouter(T b);
    public void supprimer(T b);
    public void modifier(T b);
    public List<T> getAllB();
    public T getBagById(int idBagage);
    
}
