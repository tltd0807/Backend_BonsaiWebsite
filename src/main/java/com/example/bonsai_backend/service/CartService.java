package com.example.bonsai_backend.service;

import com.example.bonsai_backend.model.Cart;
import com.example.bonsai_backend.model.LineItem;
import com.example.bonsai_backend.model.Product;
import com.example.bonsai_backend.model.dto.base.BaseDTO;

import java.math.BigDecimal;
import java.util.Map;

public interface CartService {
    Cart create(BaseDTO baseDTO);
    String delete(BaseDTO baseDTO);

}
