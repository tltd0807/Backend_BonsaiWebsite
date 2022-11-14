/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend_final.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author PhucNguyen
 */
@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderID;


    @Column(name = "order_totalorder")
    private Double orderTotalorder;


    @Column(name = "order_date")
    @CreationTimestamp
    private Date orderDate;


    @Column(name = "order_status")
    private Integer orderStatus;


    @JoinColumn(name = "payment_id")
    @ManyToOne
    private Payment payment;


    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;


    @OneToMany(mappedBy = "order")
    @JsonBackReference
    private List<Orderdetail> orderdetails;


    public Orders() {
    }


    public Orders(Integer orderID, Double orderTotalorder, Date orderDate, Integer orderStatus) {
        super();
        this.orderID = orderID;
        this.orderTotalorder = orderTotalorder;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }


    public Integer getOrderID() {
        return orderID;
    }


    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }


    public Double getOrderTotalorder() {
        return orderTotalorder;
    }


    public void setOrderTotalorder(Double orderTotalorder) {
        this.orderTotalorder = orderTotalorder;
    }


    public Date getOrderDate() {
        return orderDate;
    }


    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


    public Integer getOrderStatus() {
        return orderStatus;
    }


    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }


    public Payment getPayment() {
        return payment;
    }


    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public List<Orderdetail> getOrderdetails() {
        return orderdetails;
    }


    public void setOrderdetails(List<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.get.entites.Orders[ orderID=" + orderID + " ]";
    }

}
