/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.controller;

import java.util.List;

import com.example.backend_final.model.Category;
import com.example.backend_final.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/category")
@CrossOrigin(origins="*")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return service.getAll();
    }


    @GetMapping("/getCategoryById/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return service.getCategoryById(id);
    }


    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category) {
        return service.saveCategory(category);
    }

 
    @PostMapping("/addListCategory")
    public List<Category> addListCategory(@RequestBody List<Category> listCategory) {
        return service.saveListCategory(listCategory);
    }


    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id) {
        return service.deleteCategory(id);
    }

    @PutMapping("/updateCategory")
    public Category updateCategory(@RequestBody Category category) {
        return service.saveCategory(category);
    }
}
