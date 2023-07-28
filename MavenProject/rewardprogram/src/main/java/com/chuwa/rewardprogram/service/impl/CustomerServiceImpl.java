package com.chuwa.rewardprogram.service.impl;

import com.chuwa.rewardprogram.dao.CustomerRepository;
import com.chuwa.rewardprogram.entity.Customer;
import com.chuwa.rewardprogram.exception.ResourceNotFoundException;
import com.chuwa.rewardprogram.payload.CustomerDto;
import com.chuwa.rewardprogram.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto cto) {
        Customer newCustomer = ctoToCustomer(cto);
        Customer savedCustomer = this.customerRepository.save(newCustomer);
        return customerToCto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        Customer c = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return customerToCto(c);
    }

    public static CustomerDto customerToCto(Customer c) {
        CustomerDto response = new CustomerDto();
        response.setId(c.getId());
        response.setUserName(c.getUserName());
        return response;
    }

    public static Customer ctoToCustomer(CustomerDto cto) {
        Customer c = new Customer();
        c.setId(cto.getId());
        c.setUserName(cto.getUserName());
        return c;
    }
}
