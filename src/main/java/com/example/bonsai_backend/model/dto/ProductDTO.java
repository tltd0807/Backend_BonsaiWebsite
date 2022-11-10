package com.example.bonsai_backend.model.dto;

import com.example.bonsai_backend.model.dto.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDTO extends BaseDTO implements Serializable {

    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    private String productDescription;

    private String productImage;

    private List<LineItemDTO> lineItems;

}
