package com.example.bonsai_backend.service.impl;

import com.example.bonsai_backend.model.Product;
import com.example.bonsai_backend.model.dto.ProductDTO;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import com.example.bonsai_backend.model.mapper.ProductMapper;
import com.example.bonsai_backend.repository.ProductRepository;
import com.example.bonsai_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private ProductMapper mapper;

    @Override
    public Product findById(BaseDTO baseDTO) {
        try{
            Product product = repo.findById(((ProductDTO) baseDTO).getProductId()).get();
            if (product != null) {
                return product;
            } else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product findByName(BaseDTO baseDTO) {
        try{
            if(repo.findProductByProductName(((ProductDTO) baseDTO).getProductName())!=null){
                return repo.findProductByProductName(((ProductDTO) baseDTO).getProductName());
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findAll() {
        try{
            return repo.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product create(BaseDTO baseDTO) {
        try{
            if (repo.findProductByProductName(((ProductDTO) baseDTO).getProductName()) == null) {
                Product product = mapper.mapToEntity((ProductDTO) baseDTO, Product.class);
                return repo.save(product);
            } else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String delete(BaseDTO baseDTO) {
        try{
            if (repo.findById(((ProductDTO) baseDTO).getProductId()).get() != null) {
                repo.deleteById(((ProductDTO) baseDTO).getProductId());
                return "OK";
            } else {
                return "False";
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product update(BaseDTO baseDTO) {
        try{
            if (repo.findById(((ProductDTO) baseDTO).getProductId()).get() != null) {
                Product product = mapper.mapToEntity((ProductDTO) baseDTO, Product.class);
                return repo.save(product);
            } else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
