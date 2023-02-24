/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import java.util.List;

/**
 *
 * @author ismail
 * @param <Siege>
 */
public interface ISiege<Siege> {
    public void insert(Siege s);
    public void delete(Siege s);
    public void update(Siege s);
    public List<Siege> readAll();
    public Siege readById(int id);
    public Siege readByEtat(String etat1);
}

