package com.webapiassessment.controller;

import com.webapiassessment.dto.OrderSaveDTO;
import com.webapiassessment.entity.Order;
import com.webapiassessment.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private IOrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer id){
        Order o = orderService.findById(id);
        if(o == null) return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Order>(o, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody OrderSaveDTO o){
        return new ResponseEntity<Order>(orderService.save(o), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Order o){
        return new ResponseEntity<Order>(orderService.update(id, o), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<?> create(){
        orderService.createDummyOrder();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}