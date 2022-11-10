package com.example.bonsai_backend.controller;

import com.example.bonsai_backend.model.Product;
import com.example.bonsai_backend.model.dto.ProductDTO;
import com.example.bonsai_backend.service.ProductService;
import com.example.bonsai_backend.utils.PathsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(PathsApi.PRODUCT_DOMAIN)
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping(PathsApi.MODEL_GET_BY_ID)
    public ResponseEntity<Product> getById(@RequestBody ProductDTO request){
        try{
            return new ResponseEntity<>(service.findById(request), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(PathsApi.MODEL_GET_ALL_DOMAIN)
    public ResponseEntity<List<Product>> getAll(){
        try{
            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(PathsApi.MODEL_CREATE_DOMAIN)
    public ResponseEntity<Product> create(@RequestBody ProductDTO request){
        try{
            return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping(PathsApi.MODEL_UPDATE_DOMAIN)
    public ResponseEntity<Product> update(@RequestBody ProductDTO request){
        try{
            return new ResponseEntity<>(service.update(request), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping(PathsApi.MODEL_DELETE_DOMAIN)
    public ResponseEntity<String> delete(@RequestBody ProductDTO request){
        try{
            if(service.delete(request)=="OK"){
                return new ResponseEntity<>("Delete Success !", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Delete Fail !",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error !",HttpStatus.BAD_REQUEST);
        }
    }

}
