/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.repository;

import bookweb.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PhucNguyen
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
    @Query( "select p from Product p where p.productName like %?1%")
    public List<Product> findProductsByProductName(String keyword);
}
