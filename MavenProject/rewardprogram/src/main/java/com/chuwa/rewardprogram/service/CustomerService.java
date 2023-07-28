package com.chuwa.rewardprogram.service;

import com.chuwa.rewardprogram.payload.CustomerDto;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto cto);

    CustomerDto getCustomerById(long id);
}
