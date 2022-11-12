/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend_final.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * @author PhucNguyen
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryID;

    @Column(name = "category_name", nullable = false)
    private String categoryName;


    @Column(name = "amount_product")
    private Integer amountProduct;


    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Product> products;

    public Category() {
    }


    public Category(Integer categoryID, String categoryName, Integer amountProduct) {
        super();
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.amountProduct = amountProduct;
    }


    public Integer getCategoryID() {
        return categoryID;
    }


    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }


    public String getCategoryName() {
        return categoryName;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public Integer getAmountProduct() {
        return amountProduct;
    }


    public void setAmountProduct(Integer amountProduct) {
        this.amountProduct = amountProduct;
    }


    public List<Product> getProducts() {
        return products;
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryID != null ? categoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryID == null && other.categoryID != null) || (this.categoryID != null && !this.categoryID.equals(other.categoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.get.entites.Category[ categoryID=" + categoryID + " ]";
    }

}
