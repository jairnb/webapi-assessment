package com.webapiassessment.service;

import com.webapiassessment.dto.customer.CustomerListDTO;
import com.webapiassessment.dto.customer.CustomerSaveDTO;
import com.webapiassessment.entity.Customer;

public interface ICustomerService {

    Customer findById(Integer id);

    Customer add(CustomerSaveDTO c);

    CustomerListDTO findAll();
}