/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend_final.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author PhucNguyen
 */
@Entity
@Table(name = "selling")
public class Selling implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sell_id")
    private Integer sellID;

    @Column(name = "sell_product_name")
    private String sellProductName;

    @Column(name = "sell_product_price")
    private Double sellProductPrice;

    @Column(name = "sell_product_image")
    private String sellProductImage;

    @Column(name = "sell_product_description")
    private String sellProductDescription;

    @Column(name = "sell_status")
    private Integer sellStatus;


    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;


    public Selling() {
    }


    public Selling(Integer sellID, String sellProductName, Double sellProductPrice, String sellProductImage,
                   String sellProductDescription, Integer sellStatus) {
        super();
        this.sellID = sellID;
        this.sellProductName = sellProductName;
        this.sellProductPrice = sellProductPrice;
        this.sellProductImage = sellProductImage;
        this.sellProductDescription = sellProductDescription;
        this.sellStatus = sellStatus;
    }


    public Selling(Integer sellID) {
        this.sellID = sellID;
    }

    public Integer getSellID() {
        return sellID;
    }

    public void setSellID(Integer sellID) {
        this.sellID = sellID;
    }


    public String getSellProductName() {
        return sellProductName;
    }

    public void setSellProductName(String sellProductName) {
        this.sellProductName = sellProductName;
    }

    public Double getSellProductPrice() {
        return sellProductPrice;
    }

    public void setSellProductPrice(Double sellProductPrice) {
        this.sellProductPrice = sellProductPrice;
    }

    public String getSellProductImage() {
        return sellProductImage;
    }

    public void setSellProductImage(String sellProductImage) {
        this.sellProductImage = sellProductImage;
    }

    public String getSellProductDescription() {
        return sellProductDescription;
    }

    public void setSellProductDescription(String sellProductDescription) {
        this.sellProductDescription = sellProductDescription;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellID != null ? sellID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Selling)) {
            return false;
        }
        Selling other = (Selling) object;
        if ((this.sellID == null && other.sellID != null) || (this.sellID != null && !this.sellID.equals(other.sellID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.get.entites.Selling[ sellID=" + sellID + " ]";
    }

}
