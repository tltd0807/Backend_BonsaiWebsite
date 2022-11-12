/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.controller;


import java.util.List;

import com.example.backend_final.model.Payment;
import com.example.backend_final.service.PaymentService;
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
@RequestMapping("/payment")
@CrossOrigin(origins="*")
public class PaymentController {

    @Autowired
    private PaymentService service;


    @GetMapping("/getAll")
    public List<Payment> getAll() {
        return service.getAll();
    }


    @GetMapping("/getPaymentById/{id}")
    public Payment getPaymentById(@PathVariable int id) {
        return service.getPaymentById(id);
    }


    @PostMapping("/addPayment")
    public Payment addPayment(@RequestBody Payment payment) {
        return service.savePayment(payment);
    }


    @PostMapping("/addListPayment")
    public List<Payment> addListPayment(@RequestBody List<Payment> listPayment) {
        return service.saveListPayment(listPayment);
    }


    @DeleteMapping("/deletePayment/{id}")
    public String deletePayment(@PathVariable int id) {
        return service.deletePayment(id);
    }


    @PutMapping("/updatePayment")
    public Payment updatePayment(@RequestBody Payment payment) {
        return service.savePayment(payment);
    }

    @PutMapping("/updateListPayment")
    public List<Payment> updateListPayment(@RequestBody List<Payment> listPayment){
        return service.saveListPayment(listPayment);
    }
}
