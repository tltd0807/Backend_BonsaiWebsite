package com.example.bonsai_backend.model.mapper;

import com.example.bonsai_backend.model.Orders;
import com.example.bonsai_backend.model.dto.OrderDTO;
import com.example.bonsai_backend.model.mapper.base.AbstractModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper extends AbstractModelMapper<Orders, OrderDTO> {
}
