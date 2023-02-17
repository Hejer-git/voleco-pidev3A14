/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import java.util.List;

/**
 *
 * @author ahmed
 * @param <Reservation>
 */
public interface IReservation<Reservation> {
    public void insert(Reservation r);
    public void delete(Reservation r);
    public void update(Reservation r);
    public List<Reservation> readAll();
    public Reservation readById(int id);
}
