package com.example.bonsai_backend.service.impl;

import com.example.bonsai_backend.model.Role;
import com.example.bonsai_backend.model.User;
import com.example.bonsai_backend.model.dto.UserDTO;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import com.example.bonsai_backend.model.mapper.UserMapper;
import com.example.bonsai_backend.repository.RoleRepository;
import com.example.bonsai_backend.repository.UserRepository;
import com.example.bonsai_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    UserMapper mapper;

    @Override
    public User create(BaseDTO baseDTO) {
        try{
            Role role = roleRepo.findById(((UserDTO) baseDTO).getRole().getRoleId()).get();
            if (repo.findUserByAccountName(((UserDTO) baseDTO).getAccountName()) != null) {
                return null;
            } else {
                User user = mapper.mapToEntity((UserDTO) baseDTO, User.class);
                user.setRole(role);
                return repo.save(user);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String delete(BaseDTO baseDTO) {
        try{
            if (repo.findById(((UserDTO) baseDTO).getUserId()).get() != null) {
                repo.deleteById(((UserDTO) baseDTO).getUserId());
                return "OK";
            } else {
                return "Fail";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

    @Override
    public User update(BaseDTO baseDTO) {
        try{
            if (repo.findById(((UserDTO) baseDTO).getUserId()).get() == null) {
                return null;
            } else {
                User data = mapper.mapToEntity((UserDTO) baseDTO, User.class);
                return repo.save(data);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String checkUnique(BaseDTO baseDTO) {
        try{
            User data = repo.findUserByAccountName(((UserDTO) baseDTO).getAccountName());
            if (data == null) {
                return "OK";
            } else {
                return "Duplicate";
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findById(BaseDTO baseDTO) {
        try{
            User data = repo.findById(((UserDTO) baseDTO).getUserId()).get();
            if (data != null) {
                return data;
            } else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findByAccountName(BaseDTO baseDTO) {
        try{
            User data = repo.findUserByAccountName(((UserDTO) baseDTO).getAccountName());
            if (data != null) {
                return data;
            } else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        try{
            List<User> listData = repo.findAll();
            if (listData.isEmpty() == false) {
                return listData;
            } else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
