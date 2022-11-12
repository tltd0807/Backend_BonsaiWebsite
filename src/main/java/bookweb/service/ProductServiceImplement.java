/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.service;

import bookweb.model.Product;
import bookweb.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PhucNguyen
 */
@Service
public class ProductServiceImplement implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    
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
        return productRepository.findProductsByProductName(keyword);
    }

    @Override
    public List<Product> updateListProduct(List<Product> listProduct) {
        return productRepository.saveAll(listProduct);
    }
    
}
