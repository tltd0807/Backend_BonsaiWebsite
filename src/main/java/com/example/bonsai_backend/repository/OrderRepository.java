package com.example.bonsai_backend.repository;

import com.example.bonsai_backend.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {

    public List<Orders> findOrdersByOrderStatus(Integer status);
    public Orders findOrdersByCreateDate(Date createDate);
}
