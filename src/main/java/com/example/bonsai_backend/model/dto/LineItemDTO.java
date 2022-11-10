package com.example.bonsai_backend.model.dto;

import com.example.bonsai_backend.model.Orders;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LineItemDTO extends BaseDTO implements Serializable {

    private Long itemId;

    @NotNull(message = "Please enter your quantity !")
    private Integer quantity;

    private BigDecimal quantityPrice;


    private OrderDTO orders;


    private ProductDTO products;


    private CartDTO cart;
}
