/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bagage.services;

import java.util.List;

public interface IService2 <T>{
    public void ajouterSB(T sb);
    public void supprimerSB(int idStatBag);
    public void modifierSB(T sb);
    public List<T> getAll();
    public T getOneById(int idStatBag);
    
}
