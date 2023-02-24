/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.StatutBagage;

import java.util.List;

/**
 *
 * @author 21654
 */
public interface IServiceSB <T>{
    
    public void ajouterSB(T sb);
    public void supprimerSB(T sb);
    public void modifierSB(T sb);
    public List<T> getAllSB();
    public T getSBById(int idStatBag);
    public StatutBagage readByStat(String statutB);
}
