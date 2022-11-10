package com.example.bonsai_backend.repository;

import com.example.bonsai_backend.model.Cart;
import com.example.bonsai_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    public Cart findCartByUser(User user);
}
