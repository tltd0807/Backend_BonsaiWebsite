package com.example.bonsai_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name",nullable = false)
    @NotNull(message = "Please enter the productName !")
    private String productName;

    @Column(columnDefinition = "DOUBLE PRECISION DEFAULT 0.0 NOT NULL",name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_image")
    private String productImage;


    @OneToMany(mappedBy = "products", cascade = {CascadeType.MERGE})
    @JsonBackReference
    private List<LineItem> lineItems;

}
