package com.example.bonsai_backend;


import com.example.bonsai_backend.model.Role;
import com.example.bonsai_backend.model.User;
import com.example.bonsai_backend.repository.RoleRepository;
import com.example.bonsai_backend.repository.UserRepository;
import com.example.bonsai_backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository service;

    @Autowired
    private RoleRepository roleRepo;


    @Test
    public void create() {
//        Role role = roleRepo.findRoleByRoleName("User");
//        User user = new User("phuc@gmail.com",
//                "phuc223", "Nguyễn Hồng Phúc");
//        User data = service.save(user);
//        if(data!=null){
//            System.out.println("Sucess!");
//        }else{
//            System.out.println("Fail !");
//        }
    }
}
