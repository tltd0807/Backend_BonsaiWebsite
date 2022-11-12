/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.controller;

import bookweb.model.User;
import bookweb.service.UserServiceImplement;
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
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    private UserServiceImplement userServiceImplement;


    @GetMapping("/getAll")
    public List<User> getAll() {
        return userServiceImplement.getAll();
    }


    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return userServiceImplement.getUserById(id);
    }


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userServiceImplement.saveUser(user);
    }


    @PostMapping("/addListUser")
    public List<User> addListUser(@RequestBody List<User> listUser) {
        return userServiceImplement.saveListUser(listUser);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return userServiceImplement.deleteUser(id);
    }


    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return userServiceImplement.saveUser(user);
    }
    

    @PutMapping("/updateListUser")
    public List<User> updateListUser(@RequestBody List<User> listUser) {
        return userServiceImplement.saveListUser(listUser);
    }

}
