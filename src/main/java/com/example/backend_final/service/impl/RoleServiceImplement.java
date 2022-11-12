/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.service.impl;


import java.util.List;

import com.example.backend_final.model.Role;
import com.example.backend_final.repository.RoleRepository;
import com.example.backend_final.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PhucNguyen
 */
@Repository
public class RoleServiceImplement implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role saveRole(Role role) {
       return roleRepository.save(role);
    }

    @Override
    public String deleteRole(int id) {
        roleRepository.deleteById(id);
        return "Đã xóa thành công !";
    }

    @Override
    public Role updateRole(Role role) {
       return roleRepository.save(role);
    }

    @Override
    public List<Role> saveListRole(List<Role> listRole) {
       return roleRepository.saveAll(listRole);
    }
    
}
