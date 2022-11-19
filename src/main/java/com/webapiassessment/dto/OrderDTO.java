package com.webapiassessment.dto;

import com.webapiassessment.dto.customer.CustomerOrderDTO;
import com.webapiassessment.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer id;
    private double total;
    private LocalDate date;
    private List<Product> products;
    private CustomerOrderDTO customer;
}