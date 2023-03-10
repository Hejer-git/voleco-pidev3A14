/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ahmed
 * @param <User>
 */
public interface IUser<User> {
    public void insert(User u);
    public void delete(User u);
    public void update(User u);
    public List<User> readAll() ;
    public User readById(int id);
    public User readByEmailPass(String email,String pass);
}
