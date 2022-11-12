/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.service;

import com.example.backend_final.model.Role;

import java.util.List;

/**
 *
 * @author PhucNguyen
 */
public interface RoleService {
    public List<Role> getAll();
    public Role getRoleById(int id);
    public Role saveRole(Role role);
    public List<Role> saveListRole(List<Role> listRole);
    public String deleteRole(int id);
    public Role updateRole(Role role);
}
