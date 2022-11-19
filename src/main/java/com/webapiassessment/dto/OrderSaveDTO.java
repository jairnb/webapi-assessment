package com.webapiassessment.dto;

import com.webapiassessment.entity.Customer;
import com.webapiassessment.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderSaveDTO {
    private List<Product> products;
    private Customer customer;
}