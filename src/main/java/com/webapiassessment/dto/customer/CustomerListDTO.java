package com.webapiassessment.dto.customer;

import com.webapiassessment.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerListDTO {
    private List<Customer> customers = new ArrayList<>();
}