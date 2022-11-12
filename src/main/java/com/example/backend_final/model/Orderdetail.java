/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend_final.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author PhucNguyen
 */
@Entity
@Table(name = "orderdetail")
public class Orderdetail implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderdetail_id")
    private Integer orderdetailID;


    @Column(name = "orderdetail_amount")
    private Integer orderdetailAmount;


    @Column(name = "orderdetail_totalorderdetail")
    private Double orderdetailTotalorderdetail;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @JoinColumn(name = "order_id")
    @ManyToOne
    @JsonBackReference
    private Orders order;


    public Orderdetail() {
    }


    public Orderdetail(Integer orderdetailID, Integer orderdetailAmount, Double orderdetailTotalorderdetail) {
        super();
        this.orderdetailID = orderdetailID;
        this.orderdetailAmount = orderdetailAmount;
        this.orderdetailTotalorderdetail = orderdetailTotalorderdetail;
    }


    public Integer getOrderdetailID() {
        return orderdetailID;
    }


    public void setOrderdetailID(Integer orderdetailID) {
        this.orderdetailID = orderdetailID;
    }


    public Integer getOrderdetailAmount() {
        return orderdetailAmount;
    }


    public void setOrderdetailAmount(Integer orderdetailAmount) {
        this.orderdetailAmount = orderdetailAmount;
    }


    public Double getOrderdetailTotalorderdetail() {
        return orderdetailTotalorderdetail;
    }


    public void setOrderdetailTotalorderdetail(Double orderdetailTotalorderdetail) {
        this.orderdetailTotalorderdetail = orderdetailTotalorderdetail;
    }


    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
    }


    public Orders getOrder() {
        return order;
    }


    public void setOrder(Orders order) {
        this.order = order;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderdetailID != null ? orderdetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetail)) {
            return false;
        }
        Orderdetail other = (Orderdetail) object;
        if ((this.orderdetailID == null && other.orderdetailID != null) || (this.orderdetailID != null && !this.orderdetailID.equals(other.orderdetailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.get.entites.Orderdetail[ orderdetailID=" + orderdetailID + " ]";
    }

}
