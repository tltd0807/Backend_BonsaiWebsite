package com.example.bonsai_backend.model.dto;


import com.example.bonsai_backend.model.dto.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderDTO extends BaseDTO implements Serializable {

    private Long orderId;

    private BigDecimal totalPrice;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    private Integer orderStatus;

    private UserDTO users;


}
