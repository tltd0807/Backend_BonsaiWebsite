package com.example.bonsai_backend.service.impl;

import com.example.bonsai_backend.model.Orders;
import com.example.bonsai_backend.model.User;
import com.example.bonsai_backend.model.dto.OrderDTO;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import com.example.bonsai_backend.model.mapper.OrderMapper;
import com.example.bonsai_backend.model.mapper.UserMapper;
import com.example.bonsai_backend.repository.OrderRepository;
import com.example.bonsai_backend.repository.UserRepository;
import com.example.bonsai_backend.service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;


    @Override
    public Orders findById(BaseDTO baseDTO) {
        try {
            return repo.findById(((OrderDTO) baseDTO).getOrderID()).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Orders> findByStatus(BaseDTO baseDTO) {
        try{
            if(((OrderDTO) baseDTO).getOrderStatus()!=null){
                List<Orders> orders = repo.findOrdersByOrderStatus(((OrderDTO) baseDTO).getOrderStatus());
                return orders;
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Orders> findAll() {
        try{
            return repo.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Orders create(BaseDTO baseDTO) {
        try {
            if (((OrderDTO) baseDTO).getOrderStatus() != null) {
                User user = userRepo.findUserByAccountName(((OrderDTO) baseDTO).getUsers().getAccountName());
                Orders orders = mapper.mapToEntity(((OrderDTO) baseDTO), Orders.class);
                orders.setUsers(user);
                return repo.save(orders);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String delete(BaseDTO baseDTO) {
        try{
            Orders orders = repo.findById(((OrderDTO) baseDTO).getOrderID()).get();
            if(orders!=null){
                repo.delete(orders);
                return "OK";
            }else{
                return "Fail";
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Orders update(BaseDTO baseDTO) {
        try {
            Orders orders = repo.findById(((OrderDTO) baseDTO).getOrderID()).get();
            if (orders!= null) {
                Orders data = mapper.mapToEntity(((OrderDTO) baseDTO),Orders.class);
                orders.setOrderStatus(((OrderDTO) baseDTO).getOrderStatus());
                orders.setTotalPrice(((OrderDTO) baseDTO).getTotalPrice());
                return repo.save(orders);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
