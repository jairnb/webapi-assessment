package com.webapiassessment.controller;

import com.webapiassessment.entity.Product;
import com.webapiassessment.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private IProductService productService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product p){
        return new ResponseEntity<Product>(productService.save(p), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
}