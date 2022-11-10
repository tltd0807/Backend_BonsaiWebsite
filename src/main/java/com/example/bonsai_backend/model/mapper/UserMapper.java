package com.example.bonsai_backend.model.mapper;

import com.example.bonsai_backend.model.User;
import com.example.bonsai_backend.model.dto.UserDTO;
import com.example.bonsai_backend.model.mapper.base.AbstractModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractModelMapper<User, UserDTO> {
}
