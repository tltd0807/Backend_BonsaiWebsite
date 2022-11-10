package com.example.bonsai_backend.service;

import com.example.bonsai_backend.model.Orders;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    Orders findById(BaseDTO baseDTO);
    List<Orders> findByStatus(BaseDTO baseDTO);
    List<Orders> findAll();
    Orders create(BaseDTO baseDTO);
    String delete(BaseDTO baseDTO);
    Orders update(BaseDTO baseDTO);
}
