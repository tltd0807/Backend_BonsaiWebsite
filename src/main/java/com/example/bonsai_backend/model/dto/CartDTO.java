package com.example.bonsai_backend.model.dto;


import com.example.bonsai_backend.model.Product;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CartDTO extends BaseDTO implements Serializable {

        private Long cartId;

        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date createDate;

        private UserDTO user;

        private List<LineItemDTO> lineItems;
}
