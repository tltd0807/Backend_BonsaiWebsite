/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.service;

import bookweb.model.Orders;
import java.util.List;

/**
 *
 * @author PhucNguyen
 */
public interface OrderService {

    public List<Orders> getAll();

    public Orders getOrdersById(int id);

    public Orders saveOrders(Orders order);

    public List<Orders> saveListOrders(List<Orders> order);

    public String deleteOrders(int id);

    public Orders updateOrders(Orders order);
}
