package com.example.bonsai_backend.model.dto;

import com.example.bonsai_backend.model.dto.base.BaseDTO;
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
public class RoleDTO extends BaseDTO implements Serializable {

    private Long roleId;

    @NotNull(message ="Please enter the role name !")
    private String roleName;

    private String roleDescription;
}
