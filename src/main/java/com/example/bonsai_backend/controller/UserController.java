package com.example.bonsai_backend.controller;


import com.example.bonsai_backend.model.Role;
import com.example.bonsai_backend.model.User;
import com.example.bonsai_backend.model.dto.UserDTO;
import com.example.bonsai_backend.repository.RoleRepository;
import com.example.bonsai_backend.service.RoleService;
import com.example.bonsai_backend.service.UserService;
import com.example.bonsai_backend.utils.PathsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(PathsApi.USER_DOMAIN)
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private RoleService roleService;


    @GetMapping(PathsApi.MODEL_GET_BY_ID)
    public ResponseEntity<User> getById(@RequestBody UserDTO request){
        User data = service.findById(request);
        if(data!=null){
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(PathsApi.MODEL_GET_ALL_DOMAIN)
    public ResponseEntity<List<User>> getAll(){
        List<User> listData = service.findAll();
        if(listData.isEmpty()==false){
            return new ResponseEntity<>(listData, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(PathsApi.MODEL_CREATE_DOMAIN)
    public ResponseEntity<User> create(@RequestBody UserDTO request){
        try{
            return new ResponseEntity<>(service.create(request), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(PathsApi.MODEL_UPDATE_DOMAIN)
    public ResponseEntity<User> update(@RequestBody UserDTO request){
        User data = service.update(request);
        if(data!=null){
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping(PathsApi.MODEL_DELETE_DOMAIN)
    public ResponseEntity<String> delete(@RequestBody UserDTO request){
        String data = service.delete(request);
        if(data=="OK"){
            return new ResponseEntity<>("Delete Successfully !", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Delete Fail !", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(PathsApi.MODEL_GET_BY_NAME)
    public ResponseEntity<User> getByName(@RequestBody UserDTO request){
        try{
            return new ResponseEntity<>(service.findByAccountName(request), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
