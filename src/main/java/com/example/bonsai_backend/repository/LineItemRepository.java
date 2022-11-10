package com.example.bonsai_backend.repository;

import com.example.bonsai_backend.model.Cart;
import com.example.bonsai_backend.model.LineItem;
import com.example.bonsai_backend.model.Orders;
import com.example.bonsai_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long> {

    public List<LineItem> findLineItemByCart(Cart cart);
    public List<LineItem> findLineItemByOrders(Orders order);
    public LineItem findLineItemByProducts(Product product);
}
