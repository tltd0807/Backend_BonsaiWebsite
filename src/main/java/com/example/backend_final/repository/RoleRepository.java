/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.repository;

import com.example.backend_final.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PhucNguyen
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	@Query("select r from Role r where r.roleName =: roleName")
	public Role findRoleByRoleName(String roleName);
    
}