package com.chuwa.customer_rewarding_project.service;

import com.chuwa.customer_rewarding_project.payload.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(long id);

    CustomerDto updateCustomerInfo(CustomerDto customerDto, long id);

    void deleteCustomerById(long id);
}
