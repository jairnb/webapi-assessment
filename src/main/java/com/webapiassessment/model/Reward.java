package com.webapiassessment.model;

import com.webapiassessment.dto.customer.CustomerOrderDTO;
import lombok.Data;

@Data
public class Reward {
    private int points;
    private CustomerOrderDTO customer;
}