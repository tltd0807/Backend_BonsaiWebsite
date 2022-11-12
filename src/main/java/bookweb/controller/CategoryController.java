/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.controller;

import bookweb.model.Category;
import bookweb.service.CategoryServiceImplement;
import java.util.List;
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
    private CategoryServiceImplement categoryServiceImplement;

    @CrossOrigin
    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryServiceImplement.getAll();
    }


    @GetMapping("/getCategoryById/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryServiceImplement.getCategoryById(id);
    }


    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category) {
        return categoryServiceImplement.saveCategory(category);
    }

 
    @PostMapping("/addListCategory")
    public List<Category> addListCategory(@RequestBody List<Category> listCategory) {
        return categoryServiceImplement.saveListCategory(listCategory);
    }


    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id) {
        return categoryServiceImplement.deleteCategory(id);
    }

    @PutMapping("/updateCategory")
    public Category updateCategory(@RequestBody Category category) {
        return categoryServiceImplement.saveCategory(category);
    }
}
