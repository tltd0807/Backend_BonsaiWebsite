/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.service.impl;


import java.util.List;

import com.example.backend_final.model.Category;
import com.example.backend_final.repository.CategoryRepository;
import com.example.backend_final.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PhucNguyen
 */
@Service
public class CategoryServiceImplement implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
       return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(int id) {
        categoryRepository.deleteById(id);
        return "Đã xóa thành công !";
    }

    @Override
    public Category updateCategory(Category category) {
        Category cate =categoryRepository.findById(category.getCategoryID()).get();
        if(cate!=null){
           cate.setAmountProduct(category.getAmountProduct());
//           cate.setCategoryName(category.getCategoryName());
            return categoryRepository.save(cate);
        }else{
            return null;
        }

    }

    @Override
    public List<Category> saveListCategory(List<Category> listCategory) {
       return categoryRepository.saveAll(listCategory);
    }
    
}
