package com.example.bonsai_backend.controller;


import com.example.bonsai_backend.model.Orders;
import com.example.bonsai_backend.model.dto.OrderDTO;
import com.example.bonsai_backend.service.OrderService;
import com.example.bonsai_backend.utils.PathsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathsApi.ORDER_DOMAIN)
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping(PathsApi.MODEL_GET_BY_ID)
    public ResponseEntity<Orders> findById(@RequestBody OrderDTO request){
        try{
            return new ResponseEntity<>(service.findById(request),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(PathsApi.MODEL_GET_ALL_DOMAIN)
    public ResponseEntity<List<Orders>> findAll(){
        try{
            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(PathsApi.MODEL_GET_BY_STATUS)
    public ResponseEntity<List<Orders>> findByStatus(@RequestBody OrderDTO requset){
        try{
            return new ResponseEntity<>(service.findByStatus(requset), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(PathsApi.MODEL_CREATE_DOMAIN)
    public ResponseEntity<Orders> create(@RequestBody OrderDTO request){
        try{
            return new ResponseEntity<>(service.create(request), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping(PathsApi.MODEL_UPDATE_DOMAIN)
    public ResponseEntity<Orders> update(@RequestBody OrderDTO request){
        try{
            return new ResponseEntity<>(service.update(request), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(PathsApi.MODEL_DELETE_DOMAIN)
    public ResponseEntity<String> delete(@RequestBody OrderDTO request){
        try{
            if(service.delete(request)=="OK"){
                return new ResponseEntity<>("Delete successfully !", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Delete Fail !", HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(PathsApi.MODEL_ADD_PRODUCT_FROM_CART)
    public ResponseEntity<Orders> addProductFromCart(@RequestBody OrderDTO request){
        try{
            return new ResponseEntity<>(service.addProductFromCart(request), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
