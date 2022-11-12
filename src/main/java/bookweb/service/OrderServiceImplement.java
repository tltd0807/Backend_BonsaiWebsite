/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.service;

import bookweb.model.Orders;
import bookweb.repository.OrdersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PhucNguyen
 */
@Service
public class OrderServiceImplement implements OrderService{

    @Autowired
    private OrdersRepository ordersRepository;
    
    
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
