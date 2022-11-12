/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.service.impl;


import java.util.List;

import com.example.backend_final.model.Orders;
import com.example.backend_final.model.Payment;
import com.example.backend_final.model.User;
import com.example.backend_final.repository.OrdersRepository;
import com.example.backend_final.repository.PaymentRepository;
import com.example.backend_final.repository.UserRepository;
import com.example.backend_final.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PhucNguyen
 */
@Service
public class OrderServiceImplement implements OrderService {

    @Autowired
    private OrdersRepository ordersRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders getOrdersById(int id) {
        return ordersRepository.findById(id).orElse(null);
    }

    @Override
    public Orders saveOrders(Orders order) {
        User user = userRepository.findUserByAccountName(order.getUser().getAccountName());
        Payment payment= paymentRepository.findPaymentByPaymentName(order.getPayment().getPaymentName());

        order.setUser(user);
        order.setPayment(payment);

        return ordersRepository.save(order);
    }

    @Override
    public List<Orders> saveListOrders(List<Orders> order) {
        return ordersRepository.saveAll(order);
    }

    @Override
    public String deleteOrders(int id) {
        ordersRepository.deleteById(id);
        return "Đã xóa thành công !";
    }

    @Override
    public Orders updateOrders(Orders order) {
        return ordersRepository.save(order);
    }
    
}
