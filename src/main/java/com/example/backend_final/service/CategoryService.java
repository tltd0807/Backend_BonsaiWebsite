/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.service;


import com.example.backend_final.model.Category;

import java.util.List;

/**
 *
 * @author PhucNguyen
 */
public interface CategoryService {
    
    public List<Category> getAll();
    public Category getCategoryById(int id);
    public Category saveCategory(Category category);
    public List<Category> saveListCategory(List<Category> listCategory);
    public String deleteCategory(int id);
    public Category updateCategory(Category category);
    
}
