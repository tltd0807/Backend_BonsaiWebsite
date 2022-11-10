package com.example.bonsai_backend.service;

import com.example.bonsai_backend.model.User;
import com.example.bonsai_backend.model.dto.base.BaseDTO;


import java.util.List;

public interface UserService {
    User findById(BaseDTO baseDTO);
    User findByAccountName(BaseDTO baseDTO);
    List<User> findAll();
    User create(BaseDTO baseDTO);
    String delete(BaseDTO BaseDTO);
    User update(BaseDTO baseDTO);
    String checkUnique(BaseDTO baseDTO);
}
