package com.example.coding1reward.service;

import com.example.coding1reward.payload.CustomerDto;
import com.example.coding1reward.payload.RewardResponse;

import java.util.List;

public interface CustomerService {
    RewardResponse getTotalRewardByCustomerId(long id);
    RewardResponse getRewardByCustomerIdByMonthsLimit(long id, long monthsLimit, boolean zeroRecordShow);
    CustomerDto createCustomer(CustomerDto customerDto);
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(long id);
    CustomerDto updateCustomerInfo(CustomerDto customerDto, long id);
    void deleteCustomerById(long id);
}
