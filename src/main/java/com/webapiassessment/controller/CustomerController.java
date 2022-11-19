package com.webapiassessment.controller;

import com.webapiassessment.dto.customer.CustomerSaveDTO;
import com.webapiassessment.entity.Customer;
import com.webapiassessment.service.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        return new ResponseEntity<Customer>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CustomerSaveDTO c){
        return new ResponseEntity<Customer>(customerService.add(c), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }
}