package com.webapiassessment.service.impl;

import com.webapiassessment.dto.customer.CustomerListDTO;
import com.webapiassessment.dto.customer.CustomerSaveDTO;
import com.webapiassessment.entity.Customer;
import com.webapiassessment.repository.CustomerRepository;
import com.webapiassessment.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Override
    public Customer findById(Integer id) {
        Optional<Customer> c = this.customerRepository.findById(id);
        return c.isPresent() ? c.get() : null;
    }

    @Override
    public Customer add(CustomerSaveDTO c) {
        return this.customerRepository.save(modelMapper.map(c, Customer.class));
    }

    @Override
    public CustomerListDTO findAll() {
        CustomerListDTO customerListDTO = new CustomerListDTO();
        customerListDTO.setCustomers(customerRepository.findAll());
        return customerListDTO;
    }
}