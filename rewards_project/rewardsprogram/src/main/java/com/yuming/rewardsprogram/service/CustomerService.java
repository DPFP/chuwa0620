package com.yuming.rewardsprogram.service;

import com.yuming.rewardsprogram.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(Long id);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(Long id, CustomerDto customerDto);
    void deleteCustomer(Long id);


}
