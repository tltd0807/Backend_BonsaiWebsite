package com.example.bonsai_backend.service;

import com.example.bonsai_backend.model.Product;
import com.example.bonsai_backend.model.Role;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Product findById(BaseDTO baseDTO);
    Product findByName(BaseDTO baseDTO);
    List<Product> findAll();
    Product create(BaseDTO baseDTO);
    String delete(BaseDTO baseDTO);
    Product update(BaseDTO baseDTO);
}
