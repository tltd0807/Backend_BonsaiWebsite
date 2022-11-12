/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.service.impl;

import java.util.List;

import com.example.backend_final.model.Category;
import com.example.backend_final.model.Product;
import com.example.backend_final.repository.CategoryRepository;
import com.example.backend_final.repository.ProductRepository;
import com.example.backend_final.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PhucNguyen
 */
@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    
    @Autowired
    private CategoryRepository cateRepository;
    
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
       return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
    	Category cate = cateRepository.findById(product.getCategory().getCategoryID()).get();
    	product.setCategory(cate);
       return productRepository.save(product);
    }

    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Đã xóa thành công !";
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveListProduct(List<Product> listProduct) {
        return productRepository.saveAll(listProduct);
    }

    @Override
    public List<Product> searchProduct(String keyword) {    
        return productRepository.findProductByProductName(keyword);
    }

    @Override
    public List<Product> updateListProduct(List<Product> listProduct) {
        return productRepository.saveAll(listProduct);
    }
    
}
