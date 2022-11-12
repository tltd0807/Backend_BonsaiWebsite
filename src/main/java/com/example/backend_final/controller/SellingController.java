/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.controller;


import java.util.List;

import com.example.backend_final.model.Selling;
import com.example.backend_final.service.SellingService;
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
@RequestMapping("/selling")
@CrossOrigin(origins="*")
public class SellingController {

    @Autowired
    private SellingService service;


    @GetMapping("/getAll")
    public List<Selling> getAll() {
        return service.getAll();
    }


    @GetMapping("/getSellingById/{id}")
    public Selling getSellingById(@PathVariable int id) {
        return service.getSellingById(id);
    }


    @PostMapping("/addSelling")
    public Selling addAccount(@RequestBody Selling selling) {
        return service.saveSelling(selling);
    }

    @PostMapping("/addListSelling")
    public List<Selling> addListSelling(@RequestBody List<Selling> listSelling) {
        return service.saveListSelling(listSelling);
    }


    @DeleteMapping("/deleteSelling/{id}")
    public String deleteSelling(@PathVariable int id) {
        service.deleteSelling(id);
        return "Đã xóa thành công !";
    }

    @PutMapping("/updateSelling")
    public Selling updateAccount(@RequestBody Selling selling) {
        return service.saveSelling(selling);
    }
}
