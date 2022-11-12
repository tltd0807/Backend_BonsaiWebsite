/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.controller;


import java.util.List;

import com.example.backend_final.model.Orderdetail;
import com.example.backend_final.service.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PhucNguyen
 */
@RestController
@RequestMapping("/orderdetail")
@CrossOrigin(origins="*")
public class OrderdetailController {

    @Autowired
    private OrderdetailService service;


    @GetMapping("/getAll")
    public List<Orderdetail> getAll() {
        return service.getAll();
    }

 
    @GetMapping("/getOrderdetailById/{id}")
    public Orderdetail getOrderdetailById(@PathVariable int id) {
        return service.getOrderdetailId(id);
    }

    @PostMapping("/addOrderdetail")
    public Orderdetail addOrderdetail(@RequestBody Orderdetail orderdetail) {
        return service.saveOrderdetail(orderdetail);
    }

 
    @PostMapping("/addListOrderdetail")
    public List<Orderdetail> addListOrderdetail(@RequestBody List<Orderdetail> listOrderdetail) {
        return service.saveListOrderdetail(listOrderdetail);
    }


    @DeleteMapping("/deleteOrderdetail/{id}")
    public String deleteOrderdetail(@PathVariable int id) {
        return service.deleteOrderdetail(id);
    }

    @PutMapping("/updateOrderdetail")
    public Orderdetail updateOrderdetail (@RequestBody Orderdetail orderdetail) {
        return service.saveOrderdetail(orderdetail);
    }

}
