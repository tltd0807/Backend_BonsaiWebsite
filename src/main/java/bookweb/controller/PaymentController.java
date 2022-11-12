/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.controller;

import bookweb.model.Payment;
import bookweb.service.PaymentServiceImplement;
import java.util.List;
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
    private PaymentServiceImplement paymentServiceImplement;


    @GetMapping("/getAll")
    public List<Payment> getAll() {
        return paymentServiceImplement.getAll();
    }


    @GetMapping("/getPaymentById/{id}")
    public Payment getPaymentById(@PathVariable int id) {
        return paymentServiceImplement.getPaymentById(id);
    }


    @PostMapping("/addPayment")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentServiceImplement.savePayment(payment);
    }


    @PostMapping("/addListPayment")
    public List<Payment> addListPayment(@RequestBody List<Payment> listPayment) {
        return paymentServiceImplement.saveListPayment(listPayment);
    }


    @DeleteMapping("/deletePayment/{id}")
    public String deletePayment(@PathVariable int id) {
        return paymentServiceImplement.deletePayment(id);
    }


    @PutMapping("/updatePayment")
    public Payment updatePayment(@RequestBody Payment payment) {
        return paymentServiceImplement.savePayment(payment);
    }

    @PutMapping("/updateListPayment")
    public List<Payment> updateListPayment(@RequestBody List<Payment> listPayment){
        return paymentServiceImplement.saveListPayment(listPayment);
    }
}
