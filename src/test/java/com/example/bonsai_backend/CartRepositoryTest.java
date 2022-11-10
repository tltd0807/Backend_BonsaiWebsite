package com.example.bonsai_backend;

import com.example.bonsai_backend.model.Cart;
import com.example.bonsai_backend.model.User;
import com.example.bonsai_backend.repository.CartRepository;
import com.example.bonsai_backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class CartRepositoryTest {


    @Autowired
    private CartRepository repo;
    @Autowired
    private UserRepository userrRepo;


    @Test
    public void findCartByUser(){
        User user = userrRepo.findUserByAccountName("phuc@gmail.com");
        Cart cart = repo.findCartByUser(user);

        if(cart!=null){
            System.out.println("Success !");
            System.out.println(cart.getCartId());
        }else{
            System.out.println("Fail");
        }
    }
}
