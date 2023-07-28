package com.example.project.service;

import com.example.project.payload.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    List<CustomerDto> getAllCustomer();
    CustomerDto getCustomerById(Long id);
    CustomerDto updateCustomer(CustomerDto customerDto, Long id);
    void deleteCustomerById(Long id);
}
