package com.example.bonsai_backend.service.impl;

import com.example.bonsai_backend.model.Cart;
import com.example.bonsai_backend.model.User;
import com.example.bonsai_backend.model.dto.CartDTO;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import com.example.bonsai_backend.model.mapper.CartMapper;
import com.example.bonsai_backend.repository.CartRepository;
import com.example.bonsai_backend.repository.UserRepository;
import com.example.bonsai_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository repo;


    @Autowired
    private CartMapper mapper;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Cart create(BaseDTO baseDTO) {
        try{
            User user = userRepo.findUserByAccountName(((CartDTO) baseDTO).getUser().getAccountName());
            Cart cart = mapper.mapToEntity((CartDTO) baseDTO,Cart.class);
            cart.setUser(user);
            return repo.save(cart);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String delete(BaseDTO baseDTO) {
        try{
            User user = userRepo.findUserByAccountName(((CartDTO)baseDTO).getUser().getAccountName());
            Cart cart = repo.findCartByUser(user);
            if(cart!=null){
                repo.delete(cart);
                return "OK";
            }else{
                return "Fail";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

}
