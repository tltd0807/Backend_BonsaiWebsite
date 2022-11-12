/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.controller;

import java.util.List;

import com.example.backend_final.model.Role;
import com.example.backend_final.service.RoleService;
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
@RequestMapping("/role")
@CrossOrigin(origins="*")
public class RoleController {

    @Autowired
    private RoleService service;


    @GetMapping("/getAll")
    public List<Role> getAll() {
        return service.getAll();
    }


    @GetMapping("/getRoleById/{id}")
    public Role getRoleById(@PathVariable int id) {
        return service.getRoleById(id);
    }


    @PostMapping("/addListRole")
    public List<Role> addListRole(@RequestBody List<Role> listRole) {
        return service.saveListRole(listRole);
    }


    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role role) {
        return service.saveRole(role);
    }


    @DeleteMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable int id) {
        return service.deleteRole(id);
    }


    @PutMapping("/updateRole")
    public Role updateRole(@RequestBody Role role) {
        return service.saveRole(role);
    }
}
