package com.example.bonsai_backend.model.dto;

import com.example.bonsai_backend.model.dto.RoleDTO;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO implements Serializable {

    private Long userId;
    @NotNull(message = "Please enter your account name !")
    private String accountName;
    private String accountPassword;
    private String userName;
    private String userImage;
    private Integer userAge;
    private String userPhone;

    @JsonBackReference
    private RoleDTO role;
}
