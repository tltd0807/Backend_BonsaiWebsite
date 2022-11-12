/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.controller;

import bookweb.model.Product;
import bookweb.service.ProductService;
import bookweb.service.ProductServiceImplement;
import java.util.List;
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
@RequestMapping("/book")
@CrossOrigin(origins="*")
public class ProductController {

    @Autowired
    private ProductService bookServiceImplement;

 
    @GetMapping("/getAll")
    public List<Product> getAll() {
        return bookServiceImplement.getAll();
    }

    @GetMapping("/getProductById/{id}")
    public Product getBookById(@PathVariable int id) {
        return bookServiceImplement.getProductById(id);
    }

    @PostMapping("/addProduct")
    public Product addBook(@RequestBody Product book) {
        return bookServiceImplement.saveProduct(book);
    }

    @PostMapping("/addListProduct")
    public List<Product> addListAccount(@RequestBody List<Product> listBook) {
        return bookServiceImplement.saveListProduct(listBook);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteBook(@PathVariable int id) {
        return bookServiceImplement.deleteProduct(id);
    }

    @PutMapping("/updateProduct")
    public Product updateBook(@RequestBody Product book) {
        return bookServiceImplement.saveProduct(book);
    }

    @RequestMapping("/searchProduct")
    public List<Product> searchBook(@Param("keyword") String keyword) {
        return bookServiceImplement.searchProduct(keyword);
    }
    
    @PutMapping("/updateListProduct")
    public List<Product> updateListBook(@RequestBody List<Product> listBook) {
        return bookServiceImplement.saveListProduct(listBook);
    }
}
