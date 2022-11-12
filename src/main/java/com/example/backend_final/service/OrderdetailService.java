/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend_final.service;


import com.example.backend_final.model.Orderdetail;

import java.util.List;

/**
 *
 * @author PhucNguyen
 */
public interface OrderdetailService {

    public List<Orderdetail> getAll();

    public Orderdetail getOrderdetailId(int id);

    public Orderdetail saveOrderdetail(Orderdetail orderdetail);

    public List<Orderdetail> saveListOrderdetail(List<Orderdetail> listOrderdetail);

    public String deleteOrderdetail(int id);

    public Orderdetail updateOrderdetail(Orderdetail orderdetail);
}
