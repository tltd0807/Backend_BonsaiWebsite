package com.example.bonsai_backend;

import com.example.bonsai_backend.model.LineItem;
import com.example.bonsai_backend.model.Product;
import com.example.bonsai_backend.repository.LineItemRepository;
import com.example.bonsai_backend.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class LineItemRepositoryTest {


    @Autowired
    private LineItemRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findByProduct(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        LineItem lineItem = repository.findLineItemByProducts(product);
        if(lineItem!=null){
            System.out.println("Success!");
        }else{
            System.out.println("Line item is null !");
        }
    }
}
