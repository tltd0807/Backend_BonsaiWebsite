/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.repository;

import bookweb.model.Orderdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PhucNguyen
 */
@Repository
public interface OrderdetailRepository extends JpaRepository<Orderdetail, Integer>{
    
}
