package com.example.bonsai_backend.service.impl;

import com.example.bonsai_backend.model.Role;
import com.example.bonsai_backend.model.dto.RoleDTO;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import com.example.bonsai_backend.model.mapper.RoleMapper;
import com.example.bonsai_backend.repository.RoleRepository;
import com.example.bonsai_backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleRepository repo;

    @Autowired
    private RoleMapper mapper;

    @Override
    public Role create(BaseDTO baseDTO) {
        Role data = repo.findRoleByRoleName(((RoleDTO) baseDTO).getRoleName());
        if (data != null) {
            return null;
        } else {
            Role role = mapper.mapToEntity((RoleDTO) baseDTO,Role.class);
            return repo.save(role);
        }
    }

    @Override
    public String delete(BaseDTO baseDTO) {
        Role data = repo.findRoleByRoleName(((RoleDTO) baseDTO).getRoleName());
        if (data != null) {
            repo.delete(data);
            return "OK";
        } else {
            return "Fail";
        }
    }

    @Override
    public Role update(BaseDTO baseDTO) {
        Role data = repo.findRoleByRoleName(((RoleDTO) baseDTO).getRoleName());
        if(data!=null){
            Role role = mapper.mapToEntity((RoleDTO) baseDTO, Role.class);
            return repo.save(role);
        }else{
            return null;
        }
    }

    @Override
    public Role findRoleByRoleName(BaseDTO baseDTO) {
        Role data = repo.findRoleByRoleName(((RoleDTO) baseDTO).getRoleName());
        if (data != null) {
            return data;
        } else {
            return null;
        }
    }

    @Override
    public Role findById(BaseDTO baseDTO) {
        Role data = repo.findById(((RoleDTO) baseDTO).getRoleId()).get();
        if (data != null) {
            return data;
        } else {
            return null;
        }
    }

    @Override
    public List<Role> findAll() {
        List<Role> listData = repo.findAll();
        if (listData.isEmpty() == false) {
            return listData;
        } else {
            return null;
        }
    }
}
