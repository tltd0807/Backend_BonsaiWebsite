package com.example.bonsai_backend.service;

import com.example.bonsai_backend.model.LineItem;
import com.example.bonsai_backend.model.dto.base.BaseDTO;

import java.math.BigDecimal;
import java.util.List;


public interface LineItemService {
    LineItem findById(BaseDTO baseDTO);
    List<LineItem> findAll();
    LineItem create(BaseDTO baseDTO);
    String delete(BaseDTO baseDTO);
    LineItem update(BaseDTO baseDTO);
    List<LineItem> findByCart(BaseDTO baseDTO);
    List<LineItem> findByOrder(BaseDTO baseDTO);
    LineItem findByProduct(BaseDTO baseDTO);
    BigDecimal getToalPriceInCart(BaseDTO baseDTO);
}
