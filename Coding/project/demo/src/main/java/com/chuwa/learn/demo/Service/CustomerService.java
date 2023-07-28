package com.chuwa.learn.demo.Service;

import com.chuwa.learn.demo.payload.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDto);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(long id);
    CustomerDTO updateCustomer(CustomerDTO customer, long id);
    void deleteCustomer(long id);
}
