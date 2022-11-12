/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.service;


import com.example.backend_final.model.Product;

import java.util.List;

/**
 *
 * @author PhucNguyen
 */
public interface ProductService {
    public List<Product> getAll();
    public Product getProductById(int id);
    public Product saveProduct(Product product);
    public List<Product> saveListProduct(List<Product> listProduct);
    public String deleteProduct(int id);
    public Product updateProduct(Product product);
    public List<Product> updateListProduct(List<Product> listProduct);
    public List<Product> searchProduct(String keyword);
}
