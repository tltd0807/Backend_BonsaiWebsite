package com.example.bonsai_backend.controller;


import com.example.bonsai_backend.model.Cart;
import com.example.bonsai_backend.model.dto.CartDTO;
import com.example.bonsai_backend.service.CartService;
import com.example.bonsai_backend.utils.PathsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathsApi.CART_DOMAIN)
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService service;


    @PostMapping(PathsApi.MODEL_CREATE_DOMAIN)
    public ResponseEntity<Cart> create(@RequestBody CartDTO request){
        try{
            return new ResponseEntity<>(service.create(request), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(PathsApi.MODEL_DELETE_DOMAIN)
    public ResponseEntity<String> delete(@RequestBody CartDTO request){
        try{
            if(service.delete(request)=="OK"){
                return new ResponseEntity<>("Delete Successfully !", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Delete Fail !", HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
