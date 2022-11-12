/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.service;

import bookweb.model.User;
import bookweb.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PhucNguyen
 */
@Service
public class UserServiceImplement implements UserService{

    @Autowired
    private UserRepository userRepository;
    
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
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "Đã xóa thành công";
    }

    @Override
    public User updateUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public List<User> saveListUser(List<User> listUser) {
        return userRepository.saveAll(listUser);
    }

    
}
