/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.service.impl;


import java.util.List;

import com.example.backend_final.model.Selling;
import com.example.backend_final.repository.SellingRepository;
import com.example.backend_final.service.SellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PhucNguyen
 */
@Service
public class SellingServiceImplement implements SellingService {

    @Autowired
    private SellingRepository sellingRepository;
    
    @Override
    public List<Selling> getAll() {
        return sellingRepository.findAll();
    }

    @Override
    public Selling getSellingById(int id) {
        return sellingRepository.findById(id).orElse(null);
    }

    @Override
    public Selling saveSelling(Selling selling) {
       return sellingRepository.save(selling);
    }

    @Override
    public String deleteSelling(int id) {
        sellingRepository.deleteById(id);
       return "Đã xóa thành công !";
    }

    @Override
    public Selling updateSelling(Selling selling) {
        return sellingRepository.save(selling);
    }

    @Override
    public List<Selling> saveListSelling(List<Selling> listSelling) {
        return sellingRepository.saveAll(listSelling);
    }
    
}
