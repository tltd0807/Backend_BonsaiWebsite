package com.example.bonsai_backend.model.mapper;

import com.example.bonsai_backend.model.Product;
import com.example.bonsai_backend.model.dto.ProductDTO;
import com.example.bonsai_backend.model.mapper.base.AbstractModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends AbstractModelMapper<Product, ProductDTO> {
}
