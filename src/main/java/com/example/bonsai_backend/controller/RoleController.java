package com.example.bonsai_backend.controller;

import com.example.bonsai_backend.model.Role;
import com.example.bonsai_backend.model.dto.RoleDTO;
import com.example.bonsai_backend.service.RoleService;
import com.example.bonsai_backend.utils.PathsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(PathsApi.ROLE_DOMAIN)
@CrossOrigin(origins = "*")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping(PathsApi.MODEL_GET_BY_NAME)
    public ResponseEntity<Role> getByName(@RequestBody RoleDTO request) {
        try {
            return new ResponseEntity<>(service.findRoleByRoleName(request), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(PathsApi.MODEL_GET_ALL_DOMAIN)
    public ResponseEntity<List<Role>> getAll() {
        try {
            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(PathsApi.MODEL_CREATE_DOMAIN)
    public ResponseEntity<Role> create(@RequestBody RoleDTO request) {
        try {
            return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
