package com.example.bonsai_backend.service.impl;

import com.example.bonsai_backend.model.Cart;
import com.example.bonsai_backend.model.LineItem;
import com.example.bonsai_backend.model.Orders;
import com.example.bonsai_backend.model.User;
import com.example.bonsai_backend.model.dto.OrderDTO;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import com.example.bonsai_backend.model.mapper.OrderMapper;
import com.example.bonsai_backend.model.mapper.UserMapper;
import com.example.bonsai_backend.repository.CartRepository;
import com.example.bonsai_backend.repository.LineItemRepository;
import com.example.bonsai_backend.repository.OrderRepository;
import com.example.bonsai_backend.repository.UserRepository;
import com.example.bonsai_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private LineItemRepository itemRepo;

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;


    @Override
    public Orders findById(BaseDTO baseDTO) {
        try {
            return repo.findById(((OrderDTO) baseDTO).getOrderId()).get();
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
            Orders orders = repo.findById(((OrderDTO) baseDTO).getOrderId()).get();
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
            Orders orders = repo.findById(((OrderDTO) baseDTO).getOrderId()).get();
            if (orders!= null) {
                orders.setOrderStatus(((OrderDTO) baseDTO).getOrderStatus());
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
    public Orders addProductFromCart(BaseDTO baseDTO) {
        try{
//            Orders order = repo.findById(((OrderDTO) baseDTO).getOrderID()).get();
            List<Orders> listOrder =  repo.findOrdersByOrderStatus(0);
            Date now = new Date();
            int index=0;
            Long timeMin = now.getTime() - listOrder.get(0).getCreateDate().getTime();
            for(int i=0;i<listOrder.size();i++){
                if(timeMin>now.getTime() - listOrder.get(i).getCreateDate().getTime()){
                    timeMin=now.getTime() - listOrder.get(i).getCreateDate().getTime();
                    index = i;
                }
            }
            Orders order = listOrder.get(index);
            if(order!=null){
                User user = userRepo.findUserByAccountName(((OrderDTO) baseDTO).getUsers().getAccountName());
                Cart cart = cartRepo.findCartByUser(user);
                List<LineItem> listItem = itemRepo.findLineItemByCart(cart);
                BigDecimal total = new BigDecimal(0);
                for(int i=0;i<listItem.size();i++){
                    listItem.get(i).setOrders(order);
                    total = total.add(listItem.get(i).getQuantityPrice());
                }
                order.setLineItems(listItem);
                order.setTotalPrice(total);
                return repo.save(order);
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
