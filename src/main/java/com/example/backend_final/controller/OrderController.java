/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.controller;


import java.util.List;

import com.example.backend_final.model.Orders;
import com.example.backend_final.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author PhucNguyen
 */
@RestController
@RequestMapping("/order")
@CrossOrigin(origins="*")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/getAll")
    public List<Orders> getAll() {
        return service.getAll();
    }


    @GetMapping("/getOrderById/{id}")
    public Orders getOrderById(@PathVariable int id) {
        return service.getOrdersById(id);
    }


    @PostMapping("/addOrder")
    public Orders addOrder(@RequestBody Orders order) {
        return service.saveOrders(order);
    }


    @PostMapping("/addListOrder")
    public List<Orders> addListOrder(@RequestBody List<Orders> listOrder) {
        return service.saveListOrders(listOrder);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id) {
        return service.deleteOrders(id);
    }


    @PutMapping("/updateOrder")
    public Orders updateOrder(@RequestBody Orders order) {
        return service.saveOrders(order);
    }
    
    
}
