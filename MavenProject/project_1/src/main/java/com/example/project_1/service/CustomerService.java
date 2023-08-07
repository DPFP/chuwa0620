package com.example.project_1.service;

import com.example.project_1.payload.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDto);

    List<CustomerDTO> findAllCustomer();

    CustomerDTO getCustomerById(long id);

    CustomerDTO updateCustomerById(long id, CustomerDTO customerDto);

    void deleteCustomerById(long id);
}