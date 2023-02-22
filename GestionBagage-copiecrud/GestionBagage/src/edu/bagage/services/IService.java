/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bagage.services;

import java.util.List;

public interface IService <T>{
    public void ajouter(T b);
    public void supprimer(int idBagage);
    public void modifier(T b);
    public List<T> getAll();
    public T getOneById(int idBagage);
}
