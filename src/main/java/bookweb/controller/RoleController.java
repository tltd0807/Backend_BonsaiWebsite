/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.controller;

import bookweb.model.Role;
import bookweb.service.RoleServiceImplement;
import java.util.List;
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
    private RoleServiceImplement roleServiceImplement;


    @GetMapping("/getAll")
    public List<Role> getAll() {
        return roleServiceImplement.getAll();
    }


    @GetMapping("/getRoleById/{id}")
    public Role getRoleById(@PathVariable int id) {
        return roleServiceImplement.getRoleById(id);
    }


    @PostMapping("/addListRole")
    public List<Role> addListRole(@RequestBody List<Role> listRole) {
        return roleServiceImplement.saveListRole(listRole);
    }


    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role role) {
        return roleServiceImplement.saveRole(role);
    }


    @DeleteMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable int id) {
        return roleServiceImplement.deleteRole(id);
    }


    @PutMapping("/updateRole")
    public Role updateRole(@RequestBody Role role) {
        return roleServiceImplement.saveRole(role);
    }
}
