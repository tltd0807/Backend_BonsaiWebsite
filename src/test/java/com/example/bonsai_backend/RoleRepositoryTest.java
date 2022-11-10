package com.example.bonsai_backend;

import com.example.bonsai_backend.model.Role;
import com.example.bonsai_backend.repository.RoleRepository;
import com.mysql.cj.jdbc.SuspendableXAConnection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryTest{

    @Autowired
    private RoleRepository repo;

    @Test
    public void create(){

    }

    @Test
    public void findRoleByRoleName(){
        String roleName = "User";
        Role role = repo.findRoleByRoleName(roleName);
        if(role!=null){
            System.out.println("Founded role: " + role.toString());
        }else{
            System.out.println("Not Founded !");
        }
    }

    @Test
    public void findById(){
        Long id = 1L;
        Role role = repo.findById(id).get();
        if(role!=null){
            System.out.println("Founded role: " + role.toString());
        }else{
            System.out.println("Not Founded !");
        }
    }
}
