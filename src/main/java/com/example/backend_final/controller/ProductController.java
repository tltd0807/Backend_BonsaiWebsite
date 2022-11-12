/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.controller;

import java.util.List;

import com.example.backend_final.model.Product;
import com.example.backend_final.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PhucNguyen
 */
@RestController
@RequestMapping("/product")
@CrossOrigin(origins="*")
public class ProductController {

    @Autowired
    private ProductService service;

 
    @GetMapping("/getAll")
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/getProductById/{id}")
    public Product getBookById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping("/addProduct")
    public Product addBook(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addListProduct")
    public List<Product> addListAccount(@RequestBody List<Product> listproduct) {
        return service.saveListProduct(listproduct);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteBook(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @PutMapping("/updateProduct")
    public Product updateBook(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @RequestMapping("/searchProduct")
    public List<Product> searchBook(@Param("keyword") String keyword) {
        return service.searchProduct(keyword);
    }
    
    @PutMapping("/updateListProduct")
    public List<Product> updateListBook(@RequestBody List<Product> listproduct) {
        return service.saveListProduct(listproduct);
    }
}
