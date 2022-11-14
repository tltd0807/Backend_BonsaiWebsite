/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.service.impl;


import java.util.List;

import com.example.backend_final.model.Role;
import com.example.backend_final.model.User;
import com.example.backend_final.repository.RoleRepository;
import com.example.backend_final.repository.UserRepository;
import com.example.backend_final.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PhucNguyen
 */
@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    
    @Override
    public List<User> getAll() {
       return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
       return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
    	Role role = roleRepository.findById(user.getRole().getRoleID()).get();
    	user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "Đã xóa thành công";
    }

    @Override
    public User updateUser(User user) {
        try {
            User u = userRepository.findById(user.getUserID()).get();
            if (u != null) {
                Role role = roleRepository.findById(u.getRole().getRoleID()).get();
                u.setUserAge(user.getUserAge());
                u.setUserName(user.getUserName());
                u.setUserImage(user.getUserImage());
                u.setUserphoneNB(user.getUserphoneNB());
                u.setRole(role);
                return userRepository.save(u);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> saveListUser(List<User> listUser) {
        return userRepository.saveAll(listUser);
    }

    
}
