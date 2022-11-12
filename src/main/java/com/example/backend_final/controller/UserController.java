/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.controller;


import java.util.List;

import com.example.backend_final.model.User;
import com.example.backend_final.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PhucNguyen
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/getAll")
    public List<User> getAll() {
        return service.getAll();
    }


    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }


    @PostMapping("/addListUser")
    public List<User> addListUser(@RequestBody List<User> listUser) {
        return service.saveListUser(listUser);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }


    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return service.saveUser(user);
    }
    

    @PutMapping("/updateListUser")
    public List<User> updateListUser(@RequestBody List<User> listUser) {
        return service.saveListUser(listUser);
    }

}
