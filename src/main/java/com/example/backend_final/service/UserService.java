/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.service;
import com.example.backend_final.model.User;

import java.util.List;

/**
 *
 * @author PhucNguyen
 */
public interface UserService {

    public List<User> getAll();

    public User getUserById(int id);

    public User saveUser(User user);

    public List<User> saveListUser(List<User> listUser);

    public String deleteUser(int id);

    public User updateUser(User user);


}
