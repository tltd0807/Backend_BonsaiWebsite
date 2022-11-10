package com.example.bonsai_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "lineitems")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(name = "quantity", nullable = false, length = 10)
    @NotNull(message = "Please enter your quantity of the product !")
    private Integer quantity;

    @Column(name = "quantity_price", columnDefinition = "DOUBLE PRECISION DEFAULT 0.0")
    private BigDecimal quantityPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Orders orders;


    @ManyToOne
    @JoinColumn(name ="product_id")
    @JsonBackReference
    private Product products;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
