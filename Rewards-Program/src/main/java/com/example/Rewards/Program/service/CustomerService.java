package com.example.Rewards.Program.service;

import com.example.Rewards.Program.payload.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    List<CustomerDto> findAllCustomer();
    CustomerDto getCustomerById(long id);
    CustomerDto updateCustomerById(long id, CustomerDto customerDto);
    void deleteCustomerById(long id);
}
