package com.example.bonsai_backend.service;

import com.example.bonsai_backend.model.Role;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService  {
    Role findById(BaseDTO baseDTO);
    List<Role> findAll();
    Role create(BaseDTO baseDTO);
    String delete(BaseDTO baseDTO);
    Role update(BaseDTO baseDTO);

    Role findRoleByRoleName(BaseDTO baseDTO);

//    BaseDTO findRoleById(Long id);
//    List<BaseDTO> findAllRole();
//    BaseDTO create(BaseDTO baseDTO);
//    String delete(Long id);
//    BaseDTO update(BaseDTO baseDTO);
}
