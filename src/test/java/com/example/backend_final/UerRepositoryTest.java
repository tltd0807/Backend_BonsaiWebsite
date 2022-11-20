package com.example.backend_final;

import com.example.backend_final.model.User;
import com.example.backend_final.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UerRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Test
    public void get(){
        User u = repo.findUserByAccountName("datamin@gmail.com");
        u.setAccountPass("1234");
        repo.save(u);
        System.out.println(u.getRole().getRoleName());
    }

}
