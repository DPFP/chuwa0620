package com.chuwa.codingassignment1.service.impl;

import com.chuwa.codingassignment1.entity.Customer;
import com.chuwa.codingassignment1.payload.CustomerDto;
import com.chuwa.codingassignment1.repository.CustomerRepository;
import com.chuwa.codingassignment1.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/26/23$
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);

        Customer savedCustomer = customerRepository.save(customer);

        return modelMapper.map(savedCustomer, CustomerDto.class);
    }
}
