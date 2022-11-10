package com.example.bonsai_backend.controller;


import com.example.bonsai_backend.model.LineItem;
import com.example.bonsai_backend.model.dto.LineItemDTO;
import com.example.bonsai_backend.service.LineItemService;
import com.example.bonsai_backend.utils.PathsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathsApi.LINE_ITEM_DOMAIN)
@CrossOrigin(origins = "*")
public class LineItemController {

    @Autowired
    private LineItemService service;


    @GetMapping(PathsApi.MODEL_GET_BY_ID)
    public ResponseEntity<LineItem> findById(@RequestBody LineItemDTO request) {
        try {
            return new ResponseEntity<>(service.findById(request), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(PathsApi.MODEL_GET_ALL_DOMAIN)
    public ResponseEntity<List<LineItem>> findAll() {
        try {
            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(PathsApi.MODEL_GET_BY_ORDER)
    public ResponseEntity<List<LineItem>> findByOrder(@RequestBody LineItemDTO request) {
        try {
            return new ResponseEntity<>(service.findByOrder(request), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(PathsApi.MODEL_GET_BY_PRODUCT)
    public ResponseEntity<LineItem> findItemByProduct(@RequestBody LineItemDTO request) {
        try {
            return new ResponseEntity<>(service.findByProduct(request), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(PathsApi.MODEL_GET_BY_CART)
    public ResponseEntity<List<LineItem>> findItemByCart(@RequestBody LineItemDTO request) {
        try {
            return new ResponseEntity<>(service.findByCart(request), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(PathsApi.MODEL_CREATE_DOMAIN)
    public ResponseEntity<LineItem> create(@RequestBody LineItemDTO request) {
        try {
            return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(PathsApi.MODEL_UPDATE_DOMAIN)
    public ResponseEntity<LineItem> update(@RequestBody LineItemDTO request) {
        try {
            return new ResponseEntity<>(service.update(request), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(PathsApi.MODEL_DELETE_DOMAIN)
    public ResponseEntity<String> delete(@RequestBody LineItemDTO request) {
        try {
            return new ResponseEntity<>(service.delete(request), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
