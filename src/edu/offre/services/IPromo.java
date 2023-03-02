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
public interface IPromo <S>{
    public void ajouterpromo(S p) throws Exception;
    public void supprimerpromo(S p);
    public void modifierpromo(S o);
    public List<S> getAll();
    public S getOneById(int idPromo,int idoffre);
}
